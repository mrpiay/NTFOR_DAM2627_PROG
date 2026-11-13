# PROG · Proyecto guiado «CSV notas»

## Punto de partida

Un caso real: las notas de una clase de 25 alumnos en los tres trimestres, en formato CSV, y un programa que las carga y responde a las preguntas típicas sobre esas notas:

- ¿Está este nombre en la lista?
- ¿Qué notas tiene este alumno y cuál es su media?
- ¿Quién tiene la mejor nota de un trimestre?
- ¿Quién es el mejor de cada trimestre y del curso?
- ¿Quién ha aprobado un trimestre?

Es la continuación de «Java 0»: el mismo paquete `dam`, con `Principal` y `Auxiliar`, y un paquete nuevo, `dam.notas`, con una clase `Notas`. Cada paso añade a `Notas` un **método auxiliar** que hace una sola cosa, y `Principal` lo usa. Al final, la lógica del programa se lee casi como las preguntas de arriba.

Son la **UD3 · Funciones** (un método auxiliar para cada cosa) y la **UD4 · Arrays y cadenas**: arrays, una matriz (un array de dos dimensiones) y métodos de `String`. Además, usa las excepciones de la UD2 (`try-catch`) y `break` y `continue`.

**Usa la IA como guía, no para que lo haga por ti.** Pídele que te explique lo que no entiendas; **el código lo pones tú en tu proyecto**, aunque sea copiando y pegando, sabiendo **dónde** lo pones y **para qué**. El objetivo es que lo que hagas **funcione y cumpla los requisitos** de cada paso («Comprueba que…») y que sepas **dónde está cada cosa y qué habría que tocar para cambiar o añadir algo**.

**El objetivo es entender cada paso:** es lo que necesitas para responder el cuestionario y preparar los exámenes.

**Evaluación.** Esta actividad guiada (**A2**) se evalúa con su lista de cotejo: cada «Comprueba que…» se cumple o no. El cuestionario de la semana (**C2**) se entrega hasta el lunes 16 de noviembre, junto con el de la otra semana. El **miércoles 2 de diciembre** hay un examen parcial, **P2**, en papel, con todo lo de la 1ª evaluación que no evaluó Julia, también «Java 0» y esta actividad: cómo se organiza un programa en Java (clases, paquetes y métodos estáticos), arrays y matrices, los métodos de `String` y de `Arrays`, las excepciones con `try-catch`; y los apuntes de la UD1 a la UD4. Qué entra y cuánto vale cada parte: [1ª evaluación](../../programacion/1a-evaluacion.md).

## Las herramientas

Las de «Java 0», en el terminal de Linux (en Windows, **Ubuntu** desde el menú Inicio; si tu ordenador tiene Linux, su terminal).

| Herramienta | Qué es | Cómo se usa | Pasos |
|---|---|---|---|
| **El navegador y el Explorador de archivos** | Descargar la plantilla y arrastrar su carpeta a la carpeta de Linux | **Linux → Ubuntu-24.04** en el panel izquierdo del Explorador | 0 |
| **`wget`** | Descarga un archivo de Internet desde el terminal: otra forma de bajar la plantilla | `wget` y la dirección del archivo | 0 |
| **VS Code** | El editor | `code .` lo abre en la carpeta en que estás. Su terminal: **Ctrl+ñ** | Todos |
| **`javac`** | El compilador: de `.java` a `.class` | `javac -d bin src/dam/*.java src/dam/notas/*.java` | Todos |
| **`java`** | Ejecuta el programa | `java -cp bin dam.Principal`, desde la carpeta del proyecto | Todos |
| **`zip`** y **`unzip`** | Comprimen el proyecto en un solo archivo y lo extraen | `zip -r …` · `unzip …` | 0 y 10 |

## Con qué trabajas

La plantilla, que en el paso 0 descargas (`plantilla.zip`) y queda en la carpeta `csv-notas`:

| Archivo | Qué es | Pasos |
|---|---|---|
| `src/dam/Auxiliar.java` | `print`, `getInt` y `getString` (lee una línea de texto), como en «Java 0». Ya está hecho | ninguno |
| `src/dam/Principal.java` | El `main`, que elige qué se ejecuta; `actividad()`, con el proyecto guiado, y los métodos de cada opción | todos |
| `src/dam/notas/Notas.java` | Los métodos auxiliares; los comentarios `// TODO Paso N` marcan dónde va cada uno | 1 a 6 |

Los datos van en formato **CSV** ([UD4, apartado 5](../apuntes/UD4-arrays-y-cadenas.md#5-datos-en-formato-csv)): una línea de cabecera y una línea por alumno, con los campos separados por `;`. No hay archivo: el programa genera las líneas en el paso 1, con notas al azar, y empiezan así:

```
nombre;t1;t2;t3
Nombre01;11;60;16
Nombre02;9;46;19
Nombre03;6;64;43
```

`t1`, `t2` y `t3` son las notas de los tres trimestres, en porcentaje (de 0 a 100).

## Qué se trabaja

| Qué | Pasos |
|---|---|
| Generar datos al azar, siempre los mismos (`Random` con semilla), y montar texto con `String.format` | 1 |
| Partir texto (`split`, `trim`) y convertirlo en número (`Integer.parseInt`) | 2 |
| Arrays y una matriz: crearlos, rellenarlos y recorrerlos | 2, 4, 5 y 6 |
| Comparar textos (`equalsIgnoreCase`) y buscar en un array | 3 |
| `Arrays.toString` y `String.format` para mostrar | 2 y 4 |
| Métodos que reciben arrays y devuelven un valor o una posición | 3 a 6 |
| Un menú con `do-while` y `switch` | 7 |
| Repetir una pregunta hasta que el dato sea válido (`try-catch` y `break`) | 8 |
| Saltarse elementos al recorrer un array (`continue`) | 9 |

## Plan de la semana

Cada sesión dura 50 minutos.

| Día | Sesión | Qué se hace |
|---|---|---|
| Miércoles 11 | 13:00 | Leer «Punto de partida», «Las herramientas» y «Con qué trabajas» (15 min). **Paso 0** (preparar el proyecto) y **paso 1** (generar el CSV). |
| Miércoles 11 | 13:50 | **Paso 2** (partir las líneas y cargar los arrays). |
| Miércoles 11 | 14:40 | **Paso 3** (¿está en la lista?). |
| Jueves 12 | 12:10 | **Paso 4** (las notas y la media de un alumno). |
| Jueves 12 | 13:00 | **Paso 5** (el mejor de un trimestre). |
| Jueves 12 | 13:50 | **Paso 6** (los mejores de cada trimestre y del curso). |
| Viernes 13 | 10:10 | **Paso 7** (el menú). |
| Viernes 13 | 11:00 | **Paso 8** (leer números sin romperse) y **paso 9** (aprobados de un trimestre). |
| Viernes 13 | 12:10 | **Paso 10** (comprobar todo y comprimir) y repasar el proyecto con la lista final («Cómo comprobarlo»). |

**Los pasos se hacen en orden**, cada uno en la sesión que le toca según el plan de la semana: cada paso usa lo del anterior. Al terminar cada paso, el programa tiene que compilar y funcionar.

Cada paso tiene **Objetivo**, **Pista** (el código y lo justo para entenderlo), **Comprueba que…** y **Si te falla…** (errores típicos y cómo resolverlos).

**Compilar y ejecutar.** En todos los pasos, desde la carpeta `csv-notas`:

```bash
javac -d bin src/dam/*.java src/dam/notas/*.java
java -cp bin dam.Principal
```

Es lo mismo que en «Java 0», con una carpeta más: `src/dam/notas/*.java`, el paquete nuevo. Si `javac` no dice nada, ha compilado bien.

---

## Paso 0 · Preparar el proyecto

**Objetivo.** Tener la plantilla en `~/dam2627/prog/csv-notas` y ejecutarla.

**Pista.**

1. En el terminal de Linux, crea la carpeta del módulo:

   ```bash
   mkdir -p ~/dam2627/prog
   ```

2. Descarga la plantilla con el navegador: [`plantilla.zip`](https://github.com/mrpiay/NTFOR_DAM2627_PROG/raw/main/2026_11_09-13/actividades/plantilla.zip).
3. Haz doble clic en el zip: dentro está la carpeta `csv-notas`. Arrástrala a la carpeta del módulo, que en el Explorador de archivos está en el panel de la izquierda, abajo: **Linux → Ubuntu-24.04 → home →** tu usuario **→ dam2627 → prog**.

   También se puede hacer sin salir del terminal: `wget` descarga el archivo de la dirección que le das y `unzip` lo descomprime.

   ```bash
   cd ~/dam2627/prog
   wget https://github.com/mrpiay/NTFOR_DAM2627_PROG/raw/main/2026_11_09-13/actividades/plantilla.zip
   unzip plantilla.zip
   rm plantilla.zip
   ```

4. Entra en la carpeta del proyecto:

   ```bash
   cd ~/dam2627/prog/csv-notas
   ```

5. Ábrelo en VS Code con `code .` y abre su terminal con **Ctrl+ñ**: los comandos siguientes se escriben ahí.
6. Compila y ejecuta:

   ```bash
   javac -d bin src/dam/*.java src/dam/notas/*.java
   java -cp bin dam.Principal
   ```

**Comprueba que…** sale `=== CSV notas ===` y en el Explorador de VS Code ves `src` y, después de compilar, `bin`.

**Si te falla…**

- *`cd: … csv-notas: No such file or directory`*: la carpeta `csv-notas` está en otro sitio, por ejemplo en *Descargas* de Windows. Arrástrala a **Linux → Ubuntu-24.04 → home →** tu usuario **→ dam2627 → prog**.
- *En el Explorador no aparece **Linux***: abre antes el terminal de Ubuntu; con Ubuntu cerrado, a veces no sale.
- *`wget: command not found`* o *`unzip: command not found`*: instálalos con `sudo apt install wget unzip` y repite.
- *`unzip` pregunta `replace csv-notas/…?`*: ya tenías una carpeta `csv-notas`. Responde `N` (no), cámbiale el nombre con `mv csv-notas csv-notas-anterior` y repite `unzip plantilla.zip`.
- *`code: command not found`*: VS Code no está conectado a Linux; repasa la guía de SI [«Ubuntu Linux, WSL, Java y VS Code»](https://github.com/mrpiay/NTFOR_DAM2627_SI/blob/main/2026_11_02-06/actividades/Ubuntu%20Linux%20WSL%20Java%20y%20VS%20Code.md).

---

## Paso 1 · Generar el CSV

**Objetivo.** Tener las líneas del CSV en un array: la cabecera y una línea por alumno, con sus tres notas.

**Pista.** Las notas se inventan al azar con `Random`. En `Notas.java`, en lugar de `// TODO Paso 1: generarLineas`:

```java
    // Las líneas del CSV: la cabecera y una línea por alumno, con tres notas al azar de 0 a 100
    public static String[] generarLineas(int alumnos, long semilla) {
        Random azar = new Random(semilla);
        String[] lineas = new String[alumnos + 1];
        lineas[0] = "nombre;t1;t2;t3";
        for (int i = 1; i <= alumnos; i++) {
            int t1 = azar.nextInt(101);
            int t2 = azar.nextInt(101);
            int t3 = azar.nextInt(101);
            lineas[i] = String.format("Nombre%02d;%d;%d;%d", i, t1, t2, t3);
        }
        return lineas;
    }
```

Y el import que usa, debajo de `package dam.notas;`:

```java
import java.util.Random;
```

- `azar.nextInt(101)` da un entero de 0 a 100. La semilla hace que en todos los ordenadores salgan las mismas notas, las de esta guía ([UD4, apartado 5](../apuntes/UD4-arrays-y-cadenas.md#5-datos-en-formato-csv)).
- El array tiene `alumnos + 1` posiciones: la 0 es la cabecera y cada una de las demás, un alumno.
- `String.format` monta cada línea: `%02d` escribe el número con dos cifras, `01` ([UD4, apartado 4](../apuntes/UD4-arrays-y-cadenas.md#4-cadenas-string)).

En `Principal.java`, debajo de `import static dam.Auxiliar.*;`, importa los métodos de `Notas`:

```java
import static dam.notas.Notas.*;
```

Y en `actividad()`, en lugar de `// TODO Paso 1: generar las líneas del CSV`:

```java
        String[] lineas = generarLineas(25, 2627);
        print("Líneas: " + lineas.length);
        print("Primera: " + lineas[0]);
        print("Segunda: " + lineas[1]);
```

`generarLineas(25, 2627)` genera 25 alumnos con la semilla 2627. `lineas[0]` es la primera posición ([UD4, apartado 1](../apuntes/UD4-arrays-y-cadenas.md#1-arrays)).

**Comprueba que…**

```
=== CSV notas ===
Líneas: 26
Primera: nombre;t1;t2;t3
Segunda: Nombre01;11;60;16
```

Y que, si cambias la semilla `2627` por otro número, la segunda línea sale con otras notas, y si vuelves a ejecutar sin cambiarla, salen las mismas. Después déjala en `2627`.

**Si te falla…**

- *`cannot find symbol` en `Random`*: falta `import java.util.Random;` en `Notas.java`.
- *`cannot find symbol` en `generarLineas`*: falta `import static dam.notas.Notas.*;` en `Principal.java`, o no has compilado `src/dam/notas/*.java`.
- *Salen otras notas*: la semilla no es `2627`, o has cambiado el `101` o el orden de `t1`, `t2` y `t3`.
- *Sale `Nombre1` en lugar de `Nombre01`*: has escrito `%d` en lugar de `%02d`.

---

## Paso 2 · Partir las líneas y cargar los arrays

**Objetivo.** Pasar las líneas a dos estructuras con las que se pueda trabajar: un array con los nombres y una matriz con las notas.

**Pista.** Cada línea se parte por los `;` con `split`:

```java
String[] campos = "Nombre01;11;60;16".split(";");
// campos[0] es "Nombre01", campos[1] es "11", campos[2] es "60" y campos[3] es "16"
```

Los campos son texto: se limpian con `trim()` y se convierten en número con `Integer.parseInt` ([UD4, apartado 4](../apuntes/UD4-arrays-y-cadenas.md#4-cadenas-string)).

Las notas van en una **matriz** ([UD4, apartado 2](../apuntes/UD4-arrays-y-cadenas.md#2-matrices-arrays-de-dos-dimensiones)): una fila por alumno y una columna por trimestre, en el mismo orden que `nombres`. `notas[0][1]` es la nota del 2.º trimestre del primer alumno, 60.

En `Notas.java`, en lugar de `// TODO Paso 2: cargarNombres y cargarNotas`:

```java
    // Los nombres: el primer campo de cada línea, sin la cabecera
    public static String[] cargarNombres(String[] lineas) {
        String[] nombres = new String[lineas.length - 1];
        for (int i = 1; i < lineas.length; i++) {
            String[] campos = lineas[i].split(";");
            nombres[i - 1] = campos[0].trim();
        }
        return nombres;
    }

    // Las notas: una fila por alumno y una columna por trimestre
    public static int[][] cargarNotas(String[] lineas) {
        int[][] notas = new int[lineas.length - 1][3];
        for (int i = 1; i < lineas.length; i++) {
            String[] campos = lineas[i].split(";");
            for (int t = 0; t < 3; t++) {
                notas[i - 1][t] = Integer.parseInt(campos[t + 1].trim());
            }
        }
        return notas;
    }
```

- Los dos bucles empiezan en `i = 1` para saltarse la cabecera (`lineas[0]`). Por eso los arrays tienen `lineas.length - 1` posiciones y se rellenan en `i - 1`.
- El `for` de dentro rellena las tres columnas de cada fila.

En `actividad()`, en `Principal`, cambia las líneas `print("Primera: …")` y `print("Segunda: …")` por estas:

```java
        String[] nombres = cargarNombres(lineas);
        int[][] notas = cargarNotas(lineas);
        print("Alumnos: " + nombres.length);
        print(nombres[0] + " " + Arrays.toString(notas[0]));
        print(nombres[24] + " " + Arrays.toString(notas[24]));
```

Y añade `import java.util.Arrays;` debajo de los otros imports. `Arrays.toString` convierte un array en texto ([UD4, apartado 3](../apuntes/UD4-arrays-y-cadenas.md#3-la-clase-arrays)).

**Comprueba que…**

```
=== CSV notas ===
Líneas: 26
Alumnos: 25
Nombre01 [11, 60, 16]
Nombre25 [19, 8, 71]
```

**Si te falla…**

- *`NumberFormatException: For input string: "t1"`*: el bucle empieza en `i = 0` y está convirtiendo la cabecera.
- *`ArrayIndexOutOfBoundsException`*: una posición se sale del array. Revisa `i - 1` y `t + 1`, y que los arrays tengan `lineas.length - 1` posiciones.
- *Sale algo como `[I@1b6d3586`*: has escrito `notas[0]` sin `Arrays.toString`.

## Antes del paso 3 · `main`, `actividad()` y el ejercicio de tablas

**Objetivo.** Que el `main` solo elija qué se ejecuta: el proyecto guiado, que va en un método privado `actividad()`, o el ejercicio de tablas, que va en `Auxiliar`.

**Pista.**

1. **El proyecto, en `actividad()`.** La plantilla ya trae el método `actividad()`. Si en tu `Principal` el código de los pasos 1 y 2 está dentro del `main`, crea debajo del `main` el método `actividad()` y **mueve a él todo lo que hay dentro del `main`**. El `main` queda así:

   ```java
       public static void main(String[] args) {
           actividad();      // el proyecto guiado «CSV notas»
           // autoEval();    // el ejercicio de tablas, en Auxiliar
       }

       // El proyecto guiado «CSV notas»: cada paso añade aquí su código
       private static void actividad() {
           print("=== CSV notas ===");
           // … lo de los pasos 1 y 2
       }
   ```

   - `actividad()` es `private`: solo se usa desde `Principal` ([UD3, apartado 1](../apuntes/UD3-funciones.md#1-qué-es-una-función-método)). Es `static` porque la llama el `main`, que también lo es.
   - El `main` se convierte en un selector: para ejecutar otra cosa, se pone `//` delante de una línea y se quita de la otra. **Desde aquí, todo lo que los pasos dicen que va «en `actividad()`» va dentro de ese método.**

2. **Leer números con decimales.** En `Auxiliar.java`, debajo de `getInt`, añade `getFloat`, que lee un número con decimales (un `double`):

   ```java
       public static double getFloat() {
           return Double.parseDouble(teclado.nextLine().trim());
       }
   ```

   Es igual que `getInt`, con `Double.parseDouble` en lugar de `Integer.parseInt`. El número se escribe con punto: `2.5`.

3. **El ejercicio de tablas.** En `Auxiliar.java`, debajo de `getString`, añade este método y completa cada comentario con su código:

   ```java
       public static void autoEval() {
           print("Autoevaluación: tablas");

           // 1. Crea una tabla de números decimales (double) con 3 filas y 2 columnas

           // 2. Pon todos los valores de la tabla a -1

           // 3. Pide al usuario un número (con print("Dame número:")) y guárdalo
           //    en la primera columna de la última fila

           // 4. Muestra el valor guardado, leyéndolo de la tabla

           // 5. Calcula y muestra la suma de todos los valores de la primera fila

           // 6. Calcula y muestra la suma de todos los valores de la segunda columna

       }
   ```

   Para ejecutarlo, en el `main` pon `//` delante de `actividad();` y quítalo de `autoEval();`. Al terminar, déjalo como estaba: el proyecto sigue en el paso 3.

**Comprueba que…**

- con `actividad();` activa, sale lo mismo que al final del paso 2;
- con `autoEval();` activa, si escribes `5`, sale:

  ```
  Autoevaluación: tablas
  Dame número:
  5
  5.0
  -2.0
  -3.0
  ```

  `5` es lo que escribes; `5.0`, el valor leído de la tabla (un `double` se muestra con decimal). `-2.0` es la suma de la primera fila (dos `-1`), y `-3.0`, la de la segunda columna (tres `-1`, porque el 5 está en la primera columna). Para leer el número, usa `getFloat()`; para mostrar un número con `print`, conviértelo en texto con `String.valueOf(…)` o sumándolo a un texto: `print("" + suma)`.

**Si te falla…**

- *`cannot find symbol: method autoEval()` o `getFloat()`*: el método no está en `Auxiliar`, o no es `public static`.
- *`NumberFormatException` al escribir el número*: los decimales van con punto (`2.5`), no con coma.
- *`ArrayIndexOutOfBoundsException`*: un bucle se sale de la tabla. Las filas van de 0 a 2 y las columnas, de 0 a 1: recorre con `< tabla.length` (filas) y `< tabla[0].length` (columnas) ([UD4, apartado 2](../apuntes/UD4-arrays-y-cadenas.md#2-matrices-arrays-de-dos-dimensiones)).
- *`non-static method actividad() cannot be referenced from a static context`*: falta `static` en `private static void actividad()`.

---

## Paso 3 · ¿Está en la lista?

**Objetivo.** Pedir un nombre y decir si está en la lista y en qué número.

**Pista.** En `Notas.java`, en lugar de `// TODO Paso 3: buscar`:

```java
    // La posición del nombre en la lista, o -1 si no está
    public static int buscar(String[] nombres, String nombre) {
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombre.trim())) {
                return i;
            }
        }
        return -1;
    }
```

- `equalsIgnoreCase` compara sin distinguir mayúsculas: `nombre07` es igual que `Nombre07` ([UD4, apartado 4](../apuntes/UD4-arrays-y-cadenas.md#4-cadenas-string)).
- Devuelve la posición en cuanto lo encuentra, o `-1` si no está ([UD3, apartado 2](../apuntes/UD3-funciones.md#2-parámetros-y-valor-de-retorno)).

En `Principal.java`, debajo de `actividad()` (después de su `}` y antes de la última `}` de la clase), añade el método de esta opción:

```java
    static void opcionEstaEnLaLista(String[] nombres) {
        print("Nombre:");
        String nombre = getString();
        int posicion = buscar(nombres, nombre);
        if (posicion == -1) {
            print(nombre + " no está en la lista");
        } else {
            print(nombres[posicion] + " está en la lista: es el número " + (posicion + 1));
        }
    }
```

Los métodos de las opciones van sin `public`: no hace falta usarlos fuera de su paquete ([UD3, apartado 1](../apuntes/UD3-funciones.md#1-qué-es-una-función-método)). Y llámalo al final del `main`: `opcionEstaEnLaLista(nombres);`. Se muestra `posicion + 1` porque para una persona el primero es el número 1, no el 0.

**Comprueba que…** al ejecutar y escribir el nombre:

| Escribes | Sale |
|---|---|
| `Nombre07` | `Nombre07 está en la lista: es el número 7` |
| `nombre07` | `Nombre07 está en la lista: es el número 7` |
| `  Nombre12 ` (con espacios) | `Nombre12 está en la lista: es el número 12` |
| `Pepe` | `Pepe no está en la lista` |

**Si te falla…**

- *Con `nombre07` dice que no está*: usas `equals` en lugar de `equalsIgnoreCase`.
- *Con espacios dice que no está*: falta `trim()`.
- *Dice el número 6 para `Nombre07`*: falta el `+ 1`.

---

## Paso 4 · Las notas y la media de un alumno

**Objetivo.** Pedir un nombre y, si está, mostrar sus tres notas y su media.

**Pista.** En `Notas.java`, en lugar de `// TODO Paso 4: media`:

```java
    // La media de las notas de un alumno
    public static double media(int[] notasAlumno) {
        int suma = 0;
        for (int nota : notasAlumno) {
            suma += nota;
        }
        return (double) suma / notasAlumno.length;
    }
```

- `media` recibe **una fila** de la matriz: las notas de un alumno, como `notas[11]`.
- `for (int nota : notasAlumno)` recorre la fila dando cada valor en `nota`: es el for-each ([UD4, apartado 1](../apuntes/UD4-arrays-y-cadenas.md#1-arrays)).
- `(double)` convierte la suma en decimal antes de dividir: sin él, `int / int` da una división entera y se pierden los decimales.

En `Principal.java`, añade este método debajo del anterior:

```java
    static void opcionNotasDeUnAlumno(String[] nombres, int[][] notas) {
        print("Nombre:");
        String nombre = getString();
        int posicion = buscar(nombres, nombre);
        if (posicion == -1) {
            print(nombre + " no está en la lista");
        } else {
            print(nombres[posicion] + " " + Arrays.toString(notas[posicion])
                    + " media " + String.format("%.2f", media(notas[posicion])));
        }
    }
```

`buscar` sirve también aquí: la posición del nombre es la de su fila de notas. `String.format("%.2f", …)` da el número con dos decimales.

En `actividad()`, cambia la llamada `opcionEstaEnLaLista(nombres);` por `opcionNotasDeUnAlumno(nombres, notas);`. El método del paso 3 no se borra: se usa en el menú del paso 7.

**Comprueba que…**

| Escribes | Sale |
|---|---|
| `Nombre22` | `Nombre22 [76, 49, 87] media 70.67` |
| `Nombre14` | `Nombre14 [97, 34, 51] media 60.67` |
| `Pepe` | `Pepe no está en la lista` |

Según el idioma del sistema, los decimales pueden salir con coma (`70,67`): las dos formas están bien.

**Si te falla…**

- *La media sale `70.00` en lugar de `70.67`*: falta el `(double)`.
- *`cannot find symbol` en `Arrays`*: falta `import java.util.Arrays;` en `Principal.java`.

---

## Paso 5 · El mejor de un trimestre

**Objetivo.** Pedir un trimestre y decir quién tiene la mejor nota en él.

**Pista.** Se busca el máximo de una **columna** de la matriz ([UD4, apartado 2](../apuntes/UD4-arrays-y-cadenas.md#2-matrices-arrays-de-dos-dimensiones)): el trimestre 1 es la columna 0.

En `Notas.java`, en lugar de `// TODO Paso 5: mejorDelTrimestre`:

```java
    // La posición del alumno con la mejor nota de un trimestre (1, 2 o 3)
    public static int mejorDelTrimestre(int[][] notas, int trimestre) {
        int columna = trimestre - 1;
        int mejor = 0;
        for (int i = 1; i < notas.length; i++) {
            if (notas[i][columna] > notas[mejor][columna]) {
                mejor = i;
            }
        }
        return mejor;
    }
```

Se guarda la **posición** del mejor: con ella se saben el nombre (`nombres[mejor]`) y la nota (`notas[mejor][columna]`). Se empieza suponiendo que el mejor es el primero ([UD4, apartado 1](../apuntes/UD4-arrays-y-cadenas.md#1-arrays)).

En `Principal.java`, añade este método:

```java
    static void opcionMejorDeUnTrimestre(String[] nombres, int[][] notas) {
        print("Trimestre (1, 2 o 3):");
        int trimestre = getInt();
        if (trimestre < 1 || trimestre > 3) {
            print("No hay trimestre " + trimestre);
        } else {
            int mejor = mejorDelTrimestre(notas, trimestre);
            print("Trimestre " + trimestre + ": " + nombres[mejor] + " (" + notas[mejor][trimestre - 1] + ")");
        }
    }
```

Y en `actividad()`, cambia la llamada del paso anterior por `opcionMejorDeUnTrimestre(nombres, notas);`.

**Comprueba que…**

| Escribes | Sale |
|---|---|
| `1` | `Trimestre 1: Nombre14 (97)` |
| `2` | `Trimestre 2: Nombre06 (98)` |
| `3` | `Trimestre 3: Nombre07 (95)` |
| `5` | `No hay trimestre 5` |

**Si te falla…**

- *`ArrayIndexOutOfBoundsException: Index 3`*: usas `trimestre` como columna sin restarle 1.
- *Con `1` sale el mejor del 2.º trimestre*: lo mismo; la columna es `trimestre - 1`.

---

## Paso 6 · Los mejores de cada trimestre y del curso

**Objetivo.** Mostrar de una vez el mejor de cada trimestre y el de mejor media del curso.

**Pista.** El mejor del curso es el de mejor media: un método nuevo que **reutiliza** `media`, del paso 4. En `Notas.java`, en lugar de `// TODO Paso 6: mejorDelCurso`:

```java
    // La posición del alumno con la mejor media del curso
    public static int mejorDelCurso(int[][] notas) {
        int mejor = 0;
        for (int i = 1; i < notas.length; i++) {
            if (media(notas[i]) > media(notas[mejor])) {
                mejor = i;
            }
        }
        return mejor;
    }
```

En `Principal.java`, este método reutiliza `mejorDelTrimestre` en un bucle, para los tres trimestres:

```java
    static void opcionMejores(String[] nombres, int[][] notas) {
        for (int trimestre = 1; trimestre <= 3; trimestre++) {
            int mejor = mejorDelTrimestre(notas, trimestre);
            print("Trimestre " + trimestre + ": " + nombres[mejor] + " (" + notas[mejor][trimestre - 1] + ")");
        }
        int mejor = mejorDelCurso(notas);
        print("Curso: " + nombres[mejor] + " (media " + String.format("%.2f", media(notas[mejor])) + ")");
    }
```

Y en `actividad()`, cambia la llamada del paso anterior por `opcionMejores(nombres, notas);`.

**Comprueba que…**

```
Trimestre 1: Nombre14 (97)
Trimestre 2: Nombre06 (98)
Trimestre 3: Nombre07 (95)
Curso: Nombre22 (media 70.67)
```

**Si te falla…**

- *`variable mejor is already defined`*: el primer `int mejor` está fuera de las llaves del `for`. Tiene que ir dentro: así solo existe en el bucle y no choca con el `int mejor` de después.
- *Las tres primeras líneas dicen el mismo trimestre*: en el `for` llamas a `mejorDelTrimestre` con un número fijo en lugar de con `trimestre`.

---

## Paso 7 · El menú

**Objetivo.** Que el programa muestre un menú, haga la opción elegida y repita hasta elegir «Salir».

**Pista.** Sustituye el método `actividad()` entero por este (el `main` no se toca). Los métodos de las opciones (pasos 3 a 6) se quedan como están:

```java
    private static void actividad() {
        print("=== CSV notas ===");

        String[] lineas = generarLineas(25, 2627);
        String[] nombres = cargarNombres(lineas);
        int[][] notas = cargarNotas(lineas);
        print("Alumnos: " + nombres.length);

        int opcion;
        do {
            print("");
            print("1. ¿Está en la lista?");
            print("2. Notas de un alumno");
            print("3. Mejor de un trimestre");
            print("4. Mejores de cada trimestre y del curso");
            print("0. Salir");
            print("Opción:");
            opcion = getInt();
            switch (opcion) {
                case 1:
                    opcionEstaEnLaLista(nombres);
                    break;
                case 2:
                    opcionNotasDeUnAlumno(nombres, notas);
                    break;
                case 3:
                    opcionMejorDeUnTrimestre(nombres, notas);
                    break;
                case 4:
                    opcionMejores(nombres, notas);
                    break;
                case 0:
                    print("Hasta luego");
                    break;
                default:
                    print("Opción no válida");
            }
        } while (opcion != 0);
    }
```

- Los datos se generan y se cargan **una sola vez**, al principio; el menú solo los consulta.
- `do-while` repite el menú mientras la opción no sea 0; como la condición va al final, el menú sale al menos una vez.
- Cada `case` llama al método de su opción: `actividad()` se lee como una lista de lo que hace el programa ([UD3, apartado 1](../apuntes/UD3-funciones.md#1-qué-es-una-función-método)).

**Comprueba que…**

| Eliges | Y escribes | Sale |
|---|---|---|
| `1` | `nombre07` | `Nombre07 está en la lista: es el número 7` |
| `2` | `Nombre22` | `Nombre22 [76, 49, 87] media 70.67` |
| `3` | `2` | `Trimestre 2: Nombre06 (98)` |
| `4` | | las cuatro líneas del paso 6 |
| `9` | | `Opción no válida` |
| `0` | | `Hasta luego` y termina |

Y que, después de cada opción, vuelve a salir el menú.

**Si te falla…**

- *Al elegir una opción sale también lo de la siguiente*: falta un `break`.
- *`NumberFormatException` al elegir*: has escrito algo que no es un número; de momento `getInt` solo acepta números enteros. Lo arregla el paso 8.

---

## Paso 8 · Leer números sin que el programa se rompa

**Objetivo.** Que, si en el menú o al pedir el trimestre se escribe algo que no es un número, el programa avise y vuelva a preguntar, en lugar de terminar con un error.

**Pista.** `Integer.parseInt("hola")` lanza una excepción, `NumberFormatException`, y como nadie la recoge el programa termina. `try-catch` la recoge: si se lanza dentro del `try`, se ejecuta el `catch` y el programa sigue. Para volver a preguntar hasta que el dato sea bueno, se usa un bucle sin fin, `while (true)`, del que se sale con `break` en cuanto el número es válido.

En `Auxiliar.java`, sustituye el método `getInt` entero por este:

```java
    public static int getInt() {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(teclado.nextLine().trim());
                break;                      // es un número: sale del bucle
            } catch (NumberFormatException e) {
                print("Eso no es un número. Prueba otra vez:");
            }
        }
        return numero;
    }
```

- `while (true)` repite siempre: la única salida es el `break`.
- Si `parseInt` funciona, se guarda el número y `break` sale del bucle en ese momento. Después, `return numero` lo devuelve.
- Si `parseInt` falla, el resto del `try` no se ejecuta (tampoco el `break`): salta al `catch`, que avisa, y el bucle vuelve a empezar.

Como todas las opciones leen los números con `getInt`, el arreglo sirve para todo el programa sin tocar nada más.

**Comprueba que…**

| Eliges | Y escribes | Sale |
|---|---|---|
| `hola` | | `Eso no es un número. Prueba otra vez:` y espera otra respuesta |
| `3` | `x` y después `2` | `Eso no es un número. Prueba otra vez:` y después `Trimestre 2: Nombre06 (98)` |

**Si te falla…**

- *`unreachable statement`*: el `break` está antes de `numero = …`; tiene que ir después.
- *`variable numero might not have been initialized`*: el `break` está fuera del `try`.
- *Sigue preguntando aunque escribas un número*: falta el `break`.

---

## Paso 9 · Aprobados de un trimestre

**Objetivo.** Una opción nueva en el menú, «5. Aprobados de un trimestre»: quién tiene 50 o más en el trimestre elegido y cuántos son.

**Pista.** Se recorre la columna del trimestre y se saltan los suspensos con `continue`. `continue` pasa a la siguiente vuelta del bucle sin hacer lo que queda de esta (`break`, en cambio, termina el bucle entero).

En `Principal.java`, añade este método debajo de los demás:

```java
    static void opcionAprobados(String[] nombres, int[][] notas) {
        print("Trimestre (1, 2 o 3):");
        int trimestre = getInt();
        if (trimestre < 1 || trimestre > 3) {
            print("No hay trimestre " + trimestre);
            return;
        }
        int columna = trimestre - 1;
        int aprobados = 0;
        for (int i = 0; i < nombres.length; i++) {
            if (notas[i][columna] < 50) {
                continue;                   // suspenso: pasa al siguiente
            }
            print(nombres[i] + " (" + notas[i][columna] + ")");
            aprobados++;
        }
        print("Aprobados: " + aprobados + " de " + nombres.length);
    }
```

- `return` termina el método en ese momento: si el trimestre no existe, no se hace nada más ([UD3, apartado 1](../apuntes/UD3-funciones.md#1-qué-es-una-función-método)).
- Con un suspenso, `continue` se salta el `print` y el `aprobados++`: solo se muestran y se cuentan los aprobados.

En `actividad()`, añade la opción al menú, debajo de `print("4. Mejores de cada trimestre y del curso");`:

```java
            print("5. Aprobados de un trimestre");
```

Y en el `switch`, antes de `case 0:`:

```java
                case 5:
                    opcionAprobados(nombres, notas);
                    break;
```

**Comprueba que…** con la opción `5` y el trimestre `1` salen 11 líneas, de `Nombre06 (64)` a `Nombre23 (95)`, y al final:

```
Aprobados: 11 de 25
```

Con el trimestre `3` dice `Aprobados: 14 de 25`, y con el `7`, `No hay trimestre 7`.

**Si te falla…**

- *Dice `Aprobados: 25 de 25`*: el `aprobados++` está antes del `if`. Tiene que ir después, para que el `continue` se lo salte.
- *Salen solo los suspensos*: la condición del `if` está al revés; es `< 50`.
- *La opción 5 dice `Opción no válida`*: falta el `case 5` en el `switch`.

---

## Paso 10 · Comprobar todo y comprimir

**Objetivo.** Repasar que todo funciona y guardar el proyecto en un zip, como en «Java 0».

**Pista.**

1. Compila y pasa otra vez las tablas de los pasos 7, 8 y 9.
2. Comprime el proyecto. `$USER` es tu nombre de usuario de Linux, así el zip lleva tu nombre:

   ```bash
   zip -r $USER-csv-notas.zip src/ bin/
   ```

   Lleva el código (`src`) y el bytecode (`bin`), que es lo que hace falta para ejecutarlo.
3. Comprueba que el zip funciona: extráelo en otra carpeta y ejecútalo desde allí.

   ```bash
   unzip $USER-csv-notas.zip -d prueba
   cd prueba
   java -cp bin dam.Principal
   cd ..
   rm -r prueba
   ```

**Comprueba que…** desde `prueba` el programa arranca y dice `Alumnos: 25`.

**Si te falla…**

- *Desde `prueba` sale `ClassNotFoundException`*: el zip no lleva `bin`. Compila, borra el zip (`rm $USER-csv-notas.zip`) y vuelve a crearlo con el comando del punto 2.

---

## Entrega

Qué se entrega y cuándo: [`entrega.md`](entrega.md).

## Cómo comprobarlo (lista final)

| Comprobación | Hecho |
|---|---|
| Compila sin errores y arranca con `Alumnos: 25` |  |
| `Notas` tiene los siete métodos auxiliares y `Principal` los usa |  |
| Encuentra un nombre aunque cambien las mayúsculas o haya espacios, y dice si no está |  |
| Muestra las notas y la media de un alumno |  |
| Dice el mejor de un trimestre y avisa si el trimestre no existe |  |
| Muestra los mejores de cada trimestre y del curso |  |
| El menú repite hasta elegir 0 |  |
| Si se escribe algo que no es un número, avisa y vuelve a preguntar |  |
| Lista los aprobados de un trimestre y dice cuántos son |  |
| El zip lleva `src` y `bin`, y funciona extraído en otra carpeta |  |
