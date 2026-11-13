# PROG · Expresiones regulares en «CSV notas»

## Punto de partida

Esta semana tiene dos partes:

1. **Terminar «CSV notas»**, la actividad de la semana del 9 al 13: el apartado «Antes del paso 3» y los pasos 3 a 10, según su [plan de las semanas](../../2026_11_09-13/actividades/proyecto-PROG.md#plan-de-las-semanas). Es lo primero: esta actividad parte del proyecto terminado.
2. **Esta actividad**, corta: dos usos de las **expresiones regulares** en el mismo proyecto. El primero comprueba que cada línea del CSV tiene el formato correcto antes de cargarla. El segundo entiende un nombre aunque se escriba de otra forma («nombre 7», «NOMBRE07»).

Es la última parte de la **UD4 · Arrays, cadenas y regex**. La teoría está en los [apuntes de esta semana](../apuntes/UD4-expresiones-regulares.md).

**Usa la IA como guía, no para que lo haga por ti.** Pídele que te explique lo que no entiendas; **el código lo pones tú en tu proyecto**, aunque sea copiando y pegando, sabiendo **dónde** lo pones y **para qué**. El objetivo es que lo que hagas **funcione y cumpla los requisitos** de cada paso («Comprueba que…»).

**El objetivo es entender cada paso:** es lo que necesitas para responder el cuestionario y preparar los exámenes.

**Evaluación.** Esta actividad guiada (**A3**) se evalúa con su lista de cotejo: cada «Comprueba que…» se cumple o no. El cuestionario de la semana (**C3**) se entrega hasta el lunes 23 de noviembre, junto con el de la semana del 9 al 13 (**C2**). El **miércoles 2 de diciembre** hay un examen parcial, **P2**, en papel, con todo lo de la 1ª evaluación que no evaluó Julia, también esta actividad y sus apuntes. Qué entra y cuánto vale cada parte: [1ª evaluación](../../programacion/1a-evaluacion.md).

## Con qué trabajas

Con tu proyecto `~/dam2627/prog/csv-notas`, terminado hasta el paso 10. Se compila y se ejecuta igual que siempre, desde la carpeta `csv-notas`:

```bash
javac -d bin src/dam/*.java src/dam/notas/*.java
java -cp bin dam.Principal
```

| Archivo | Qué tocas | Paso |
|---|---|---|
| `src/dam/notas/Notas.java` | Dos métodos nuevos: `lineaValida` y `normalizarNombre` | 1 y 2 |
| `src/dam/Principal.java` | En `actividad()`, comprobar las líneas; en las opciones 1 y 2, limpiar el nombre | 1 y 2 |

**En Java, la barra de las expresiones regulares se escribe dos veces:** `\d` se escribe `"\\d"` ([apuntes, apartado 2](../apuntes/UD4-expresiones-regulares.md#2-la-sintaxis-básica)).

## Plan de la semana

| Día | Sesión | Qué se hace |
|---|---|---|
| Miércoles 18 y jueves 19 | Todas | Terminar «CSV notas» (apartado «Antes del paso 3» y pasos 3 a 9), según su plan. |
| Viernes 20 | 10:10 | Paso 10 de «CSV notas» y su lista final. |
| Viernes 20 | 11:00 | Leer los apuntes de esta semana (15 min). **Paso 1** (comprobar las líneas del CSV). |
| Viernes 20 | 12:10 | **Paso 2** (entender el nombre aunque se escriba de otra forma). Repasar con la lista final («Cómo comprobarlo»). |

---

## Paso 1 · Comprobar las líneas del CSV antes de cargarlas

**Objetivo.** Que el programa compruebe que cada línea del CSV tiene la forma `NombreNN;nota;nota;nota` y, si alguna no la tiene, avise y no siga, en lugar de romperse.

**Pista.** En `Notas.java`, al final de la clase (antes de la última `}`), añade:

```java
    // ¿La línea tiene la forma «NombreNN;nota;nota;nota»?
    public static boolean lineaValida(String linea) {
        return linea.matches("Nombre\\d{2};\\d{1,3};\\d{1,3};\\d{1,3}");
    }
```

- `matches` devuelve `true` si **toda** la línea encaja con el patrón.
- El patrón se lee así: «Nombre», dos dígitos, punto y coma, y tres veces de 1 a 3 dígitos separados por punto y coma ([apuntes, apartado 2](../apuntes/UD4-expresiones-regulares.md#2-la-sintaxis-básica)).

En `Principal.java`, en `actividad()`, justo debajo de `String[] lineas = generarLineas(25, 2627);`, añade:

```java
        // Comprobar las líneas antes de cargarlas
        int malas = 0;
        for (int i = 1; i < lineas.length; i++) {
            if (!lineaValida(lineas[i])) {
                print("Línea no válida: " + lineas[i]);
                malas++;
            }
        }
        if (malas > 0) {
            print("Líneas no válidas: " + malas + ". Corrige el CSV antes de seguir");
            return;
        }
```

- El bucle empieza en `i = 1` para saltarse la cabecera, como en `cargarNombres`.
- `return` termina `actividad()` sin cargar nada: así no llega a `Integer.parseInt` con una nota que no es un número.

**Comprueba que…**

- el programa funciona como antes: sale el menú, porque las 25 líneas generadas son válidas;
- si estropeas a propósito una línea, añadiendo debajo de `generarLineas` la línea `lineas[3] = "Nombre03;8a;50;20";`, sale esto y el programa termina sin romperse:

  ```
  === CSV notas ===
  Línea no válida: Nombre03;8a;50;20
  Líneas no válidas: 1. Corrige el CSV antes de seguir
  ```

  Después, **borra esa línea de prueba**.

**Si te falla…**

- *`illegal escape character`*: has escrito `\d` con una sola barra. En Java va `\\d`.
- *Todas las líneas salen como no válidas*: revisa el patrón carácter a carácter. Un espacio de más, o `nombre` con minúscula, hace que no encaje ninguna.

---

## Paso 2 · Entender el nombre aunque se escriba de otra forma

**Objetivo.** Que las opciones 1 y 2 del menú encuentren al alumno aunque se escriba «nombre 7», «NOMBRE07» o « Nombre07 », y que avisen si lo escrito no tiene la forma de un nombre.

**Pista.** En `Notas.java`, debajo de `lineaValida`, añade:

```java
    // «nombre 7», «NOMBRE07»… se escriben como «Nombre07»;
    // si lo escrito no tiene la forma de un nombre, devuelve "".
    public static String normalizarNombre(String texto) {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        if (!limpio.matches("nombre\\d{1,2}")) {
            return "";
        }
        int numero = Integer.parseInt(limpio.substring(6));
        return String.format("Nombre%02d", numero);
    }
```

- `replaceAll("\\s+", "")` quita **todos** los espacios, también los de en medio (`trim` solo quita los de los extremos). `toLowerCase()` lo pasa a minúsculas.
- `matches("nombre\\d{1,2}")`: «nombre» seguido de uno o dos dígitos.
- `substring(6)` son las cifras que van detrás de «nombre» (6 letras), y `String.format("Nombre%02d", numero)` lo vuelve a escribir como en la lista, con dos cifras: 7 → `Nombre07`.

En `Principal.java`, en **los dos** métodos que piden un nombre, `opcionEstaEnLaLista` y `opcionNotasDeUnAlumno`, cambia la línea `String nombre = getString();` por estas:

```java
        String nombre = normalizarNombre(getString());
        if (nombre.isEmpty()) {
            print("Escribe un nombre como Nombre07");
            return;
        }
```

**Comprueba que…**

| Opción | Escribes | Sale |
|---|---|---|
| 1 | `nombre 7` | `Nombre07 está en la lista: es el número 7` |
| 1 | ` NOMBRE07 ` | `Nombre07 está en la lista: es el número 7` |
| 2 | `Nombre 7` | `Nombre07 [25, 24, 95] media 48.00` |
| 1 | `Pepe` | `Escribe un nombre como Nombre07` |
| 1 | `nombre 99` | `Nombre99 no está en la lista` |

**Si te falla…**

- *Con «nombre 7» sale «no está en la lista»*: no has cambiado la línea de `getString()` en esa opción, o `normalizarNombre` no pasa a minúsculas antes de `matches`.
- *`StringIndexOutOfBoundsException`*: el `substring(6)` está antes de comprobar el patrón con `matches`. El `if` va primero.

---

## Entrega

Qué se entrega y cuándo: [`entrega.md`](entrega.md).

## Cómo comprobarlo (lista final)

| Comprobación | Hecho |
|---|---|
| «CSV notas» está terminado hasta el paso 10 y cumple su lista final |  |
| Con las líneas generadas, el programa funciona como antes |  |
| Con una línea estropeada, avisa de cuál es y termina sin romperse |  |
| Las opciones 1 y 2 entienden «nombre 7», «NOMBRE07» y « Nombre07 » |  |
| Con un texto que no es un nombre, avisa en lugar de buscar |  |
| Sé leer los dos patrones de esta actividad y por qué en Java la barra va doble |  |
