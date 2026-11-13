# UD4 · Expresiones regulares

Lo básico que hay que saber de las expresiones regulares, la última parte de la UD4. Continúa los [apuntes de la UD4 de la semana del 9 al 13](../../2026_11_09-13/apuntes/UD4-arrays-y-cadenas.md). Los ejemplos son de «CSV notas». Las preguntas para comprobar que lo entiendes están en el [cuestionario](../cuestionario.md) de la semana, en «Cuestiones sobre los apuntes».

---

## 1. Qué es una expresión regular

**En una frase:** una expresión regular (*regex*) es un **patrón** que describe cómo tiene que ser un texto: qué caracteres lleva, cuántos y en qué orden.

**Lo que tienes que saber**

- Sirve para **comprobar** si un texto tiene el formato correcto (un DNI, un código postal, una línea del CSV), para **partir** un texto y para **sustituir** trozos.
- En Java se usan con cuatro métodos de `String`:

| Método | Qué hace | Ejemplo |
|---|---|---|
| `matches(regex)` | `true` si **todo** el texto encaja con el patrón | `"28013".matches("\\d{5}")` → `true` |
| `split(regex)` | Parte el texto por donde encaja el patrón | `"Ana ; 7;8".split("\\s*;\\s*")` → `{"Ana","7","8"}` |
| `replaceAll(regex, nuevo)` | Cambia todo lo que encaja por `nuevo` | `"Nombre 07".replaceAll("\\s+", "")` → `"Nombre07"` |
| `replaceFirst(regex, nuevo)` | Cambia solo lo primero que encaja | `"a-b-c".replaceFirst("-", "+")` → `"a+b-c"` |

- `matches` compara **el texto entero**: `"Nombre07x".matches("Nombre\\d{2}")` da `false`, porque sobra la `x`.
- `split(";")`, que ya se usa en «CSV notas», también recibe una expresión regular: `;` es un patrón que solo encaja con el punto y coma.

---

## 2. La sintaxis básica

**En una frase:** un patrón se escribe con caracteres normales, que encajan consigo mismos, y con símbolos que significan «un dígito», «una letra», «varias veces»…

**Lo que tienes que saber**

**Qué carácter**

| Símbolo | Encaja con | Ejemplo |
|---|---|---|
| `a`, `7`, `;` | Ese carácter | `Nombre` solo encaja con «Nombre» |
| `.` | Cualquier carácter | `a.c` encaja con «abc», «a7c»… |
| `\d` | Un dígito, del 0 al 9 | `\d\d` encaja con «07» |
| `\s` | Un espacio en blanco (espacio, tabulador…) | |
| `\w` | Una letra sin tilde, un dígito o `_` | |
| `[abc]` | Uno de esos caracteres | `[AEIOU]` encaja con una vocal mayúscula |
| `[a-z]`, `[0-9]` | Uno del rango | `[A-Z]` encaja con una mayúscula |
| `[^0-9]` | Cualquiera **menos** esos | |

**Cuántas veces** (se aplica a lo que va justo delante)

| Símbolo | Cuántas veces | Ejemplo |
|---|---|---|
| `?` | 0 o 1 (opcional) | `-?\d+` encaja con «7» y con «-7» |
| `*` | 0 o más | |
| `+` | 1 o más | `\d+` encaja con «7», «42», «100»… |
| `{n}` | Exactamente `n` | `\d{5}` es un código postal |
| `{n,m}` | De `n` a `m` | `\d{1,3}` es un número de 1 a 3 cifras |

**Agrupar y elegir**

| Símbolo | Qué hace | Ejemplo |
|---|---|---|
| `( )` | Agrupa: lo que va detrás se aplica al grupo | `(ab)+` encaja con «ab», «abab»… |
| `\|` | Una opción u otra | `si\|no` encaja con «si» y con «no» |

**En Java, la barra se escribe dos veces.** Dentro de las comillas de un `String`, `\` sirve para escribir caracteres especiales (`\n`, `\t`), así que `\d` se escribe **`"\\d"`** y `\s`, **`"\\s"`**. Si se escribe `"\d"`, el programa no compila.

**Compara: ejemplos de patrones**

| Qué se comprueba | Patrón (como se escribe en Java) | Encaja | No encaja |
|---|---|---|---|
| Un código postal | `"\\d{5}"` | `28013` | `2801`, `28O13` (con letra O) |
| Un DNI | `"\\d{8}[A-Z]"` | `12345678Z` | `1234567Z`, `12345678z` |
| Un nombre de «CSV notas» | `"Nombre\\d{2}"` | `Nombre07` | `Nombre7`, `nombre07` |
| Una línea de «CSV notas» | `"Nombre\\d{2};\\d{1,3};\\d{1,3};\\d{1,3}"` | `Nombre01;11;60;16` | `Nombre01;8a;60;16` |

> **Para saber más.** `\d{1,3}` acepta de 0 a 999, no solo de 0 a 100. Una nota de 0 a 100 exacta es `(100|[1-9]?\d)`: o «100», o una cifra opcional del 1 al 9 seguida de otra cifra. `\b` marca el límite de una palabra: `\bsi\b` encaja con «si» suelto, pero no dentro de «sitio».

---

## 3. Buscar dentro de un texto: `Pattern` y `Matcher`

**En una frase:** `matches` dice si un texto **entero** tiene un formato; para **encontrar trozos** dentro de un texto (todas las fechas de un párrafo, por ejemplo) se usan las clases `Pattern` y `Matcher`, del paquete `java.util.regex`.

**Lo que tienes que saber**

- `Pattern.compile(regex)` prepara el patrón; `patron.matcher(texto)` lo aplica a un texto y devuelve un `Matcher`.
- Con el `Matcher`: **`find()`** busca la siguiente coincidencia dentro del texto (devuelve `true` mientras encuentre alguna), **`group()`** devuelve el trozo encontrado y **`matches()`** comprueba si el texto entero encaja, como el de `String`.
- `Pattern.compile(regex, Pattern.CASE_INSENSITIVE)` no distingue mayúsculas y minúsculas.

El ejemplo del libro de Síntesis, simplificado: encontrar las fechas de un texto.

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

String texto = "El curso empezó el 09/09/2026 y la evaluación acaba el 17/12/2026.";
Pattern patron = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
Matcher m = patron.matcher(texto);
while (m.find()) {
    System.out.println("Fecha encontrada: " + m.group());
}
```

```
Fecha encontrada: 09/09/2026
Fecha encontrada: 17/12/2026
```

**Compara**

| | `texto.matches(regex)` | `Pattern` y `Matcher` con `find()` |
|---|---|---|
| Para qué | Validar: ¿todo el texto tiene el formato? | Buscar: ¿qué trozos del texto tienen el formato? |
| Devuelve | `true` o `false` | Cada trozo encontrado, con `group()` |
| Ejemplo | ¿Es un teléfono válido? | Las fechas de un párrafo |

---

## 4. Los dos usos de «CSV notas»

*Para la práctica: pasos 1 y 2 de la actividad de la semana.*

**En una frase:** con una expresión regular se comprueba que los datos tienen el formato correcto **antes** de usarlos, y se limpia lo que escribe el usuario para que el programa lo entienda.

**Lo que tienes que saber**

1. **Comprobar los datos antes de cargarlos.** Si una línea del CSV trae `8a` en lugar de una nota, `Integer.parseInt` lanza `NumberFormatException` y el programa se rompe. Comprobando cada línea con `matches` antes de cargarla, el programa puede avisar de qué línea está mal y no seguir.
2. **Limpiar lo que escribe el usuario.** Quien usa el programa puede escribir «nombre 7», «NOMBRE07» o « Nombre07 ». Con `replaceAll("\\s+", "")` se quitan todos los espacios, con `toLowerCase()` se pasan a minúsculas y con `matches` se comprueba que lo que queda tiene la forma de un nombre. Si la tiene, se reescribe en la forma de la lista («Nombre07»); si no, se avisa.

| | Sin expresiones regulares | Con expresiones regulares |
|---|---|---|
| Una línea mal escrita en el CSV | `NumberFormatException` al cargarla | Aviso de qué línea está mal, antes de cargar |
| El usuario escribe «nombre 7» | «no está en la lista» | Se entiende como Nombre07 |

---

## Dónde consultar

La documentación oficial de Java 21, en inglés:

- **Los símbolos de las expresiones regulares:** la tabla del principio de [Pattern](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html), en «Summary of regular-expression constructs».
- **`matches`, `split`, `replaceAll` y `replaceFirst`:** [String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html).
- **Para entenderlo desde el principio,** el tutorial oficial: [Regular Expressions](https://docs.oracle.com/javase/tutorial/essential/regex/index.html).
- **Libro:** Síntesis, *Programación*, cap. 8, apartado 8.4 «Cadenas de caracteres»: los métodos de `String` (cuadro 8.1) y 8.4.4 «Expresiones regulares» (`Pattern` y `Matcher`).
- **Probar un patrón** antes de ponerlo en el programa: [RegexPlanet](https://www.regexplanet.com/advanced/java/index.html), que usa las expresiones regulares de Java.
