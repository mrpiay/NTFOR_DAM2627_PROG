# Autoevaluación · semana del 16 al 20 de noviembre · soluciones

Entre paréntesis, dónde está la respuesta para repasarla. El proyecto «CSV notas» con los dos pasos de esta semana está en la carpeta `csv-notas`.

## Cuestiones sobre la actividad

**1.** Explica, símbolo a símbolo, qué comprueba el patrón de `lineaValida`: `"Nombre\\d{2};\\d{1,3};\\d{1,3};\\d{1,3}"`. ¿Qué pasaría en `cargarNotas` si una línea trajera `8a` como nota y no se comprobara antes? ¿Por qué el bucle que comprueba las líneas empieza en `i = 1`?

**Respuesta.** *(apuntes, apartado 2; actividad, paso 1)* La línea tiene que ser **toda** así: el texto `Nombre`, dos dígitos (`\d{2}`), un punto y coma, y tres veces un número de 1 a 3 dígitos (`\d{1,3}`) separados por punto y coma. Sin comprobarla, `cargarNotas` haría `Integer.parseInt("8a")` y el programa se rompería con `NumberFormatException`. El bucle empieza en `i = 1` porque `lineas[0]` es la cabecera (`nombre;t1;t2;t3`), que no tiene esa forma.

**2.** En el paso 1, ¿para qué sirve el `return` que hay después de avisar de las líneas no válidas? ¿Qué pasaría sin él?

**Respuesta.** *(actividad, paso 1)* `return` termina `actividad()` **sin cargar los datos**. Sin él, después de avisar, el programa seguiría, llegaría a `cargarNotas` con la línea mala y se rompería con `NumberFormatException`: el aviso no serviría de nada.

**3.** ¿Qué devuelve `normalizarNombre` con cada uno de estos textos, y por qué? `"nombre 7"`, `" NOMBRE07 "`, `"Pepe"`, `"nombre 123"`. ¿Por qué se usa `replaceAll("\\s+", "")` y no `trim()`?

**Respuesta.** *(apuntes, apartado 4; actividad, paso 2)* `"nombre 7"` → `"Nombre07"`; `" NOMBRE07 "` → `"Nombre07"`; `"Pepe"` → `""` (no encaja con `nombre\d{1,2}`); `"nombre 123"` → `""` (tres cifras: el patrón admite una o dos). `replaceAll("\\s+", "")` quita **todos** los espacios, también los de en medio («nombre 7»); `trim()` solo quita los del principio y el final.

**4.** ¿Por qué en el código Java las expresiones regulares llevan la barra doble, `"\\d"`, y no `"\d"`? ¿Qué pasa si se escribe con una sola?

**Respuesta.** *(apuntes, apartado 2)* Porque dentro de las comillas de un `String` la barra `\` sirve para escribir caracteres especiales (`\n`, `\t`). Para que la expresión regular reciba `\d`, en Java hay que escribir `"\\d"`: la primera barra indica que la segunda es una barra normal. Con una sola, `"\d"`, el programa **no compila** (`illegal escape character`).

## Cuestiones sobre los apuntes

**5.** Escribe, como se escribirían en Java, los patrones de: un código postal (5 cifras), un DNI (8 cifras y una letra mayúscula), una hora como `09:45` y una matrícula de coche como `1234BCD` (4 cifras y 3 letras mayúsculas).

**Respuesta.** *(apuntes, apartado 2)* Código postal: `"\\d{5}"`. DNI: `"\\d{8}[A-Z]"`. Hora: `"\\d{2}:\\d{2}"`. Matrícula: `"\\d{4}[A-Z]{3}"`.

**6.** ¿Cuáles de estos textos encajan con `"\\d{2,3}[a-z]+"` usando `matches`, y por qué los demás no? `"12a"`, `"1a"`, `"123abc"`, `"1234a"`, `"12A"`.

**Respuesta.** *(apuntes, apartado 2)* Encajan `"12a"` y `"123abc"`: de 2 a 3 dígitos y después una o más minúsculas. No encajan `"1a"` (solo un dígito), `"1234a"` (tras tres dígitos queda `4a`, que no son minúsculas: `matches` exige que encaje el texto entero) ni `"12A"` (la `A` es mayúscula y `[a-z]` solo admite minúsculas).

**7.** ¿Qué diferencia hay entre `texto.matches(regex)` y buscar con `Pattern` y `Matcher` usando `find()`? ¿Qué muestra este código?

```java
Pattern patron = Pattern.compile("\\d+");
Matcher m = patron.matcher("Tengo 3 gatos y 12 peces");
while (m.find()) {
    System.out.println(m.group());
}
```

**Respuesta.** *(apuntes, apartado 3)* `matches` dice si el texto **entero** tiene el formato (`true` o `false`); `find()` **busca trozos** dentro del texto que tengan el formato, uno detrás de otro, y `group()` devuelve cada uno. El código muestra:

```
3
12
```

**8.** ¿Qué devuelve cada una de estas expresiones? `"Ana ; 7 ;8".split("\\s*;\\s*")` y `"Nombre07".replaceAll("\\d", "#")`.

**Respuesta.** *(apuntes, apartado 1)* `{"Ana", "7", "8"}`: parte por el punto y coma con los espacios que tenga alrededor (`\s*`, cero o más espacios). `"Nombre##"`: cambia cada dígito por `#`.

