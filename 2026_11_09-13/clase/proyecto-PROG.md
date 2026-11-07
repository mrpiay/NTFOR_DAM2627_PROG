# PROG · Proyecto guiado «Notas de clase»

## Punto de partida

Un caso real: un archivo `notas.csv` con las notas de una clase de 25 alumnos en los tres trimestres, y un programa que lo abre y responde a las preguntas típicas sobre esas notas:

- ¿Está este nombre en la lista?
- ¿Qué notas tiene este alumno y cuál es su media?
- ¿Quién tiene la mejor nota de un trimestre?
- ¿Quién es el mejor de cada trimestre y del curso?

Es la continuación de «Java 0»: el mismo paquete `dam`, con `Principal` y `Auxiliar`, y un paquete nuevo, `dam.notas`, con una clase `Notas`. Cada paso añade a `Notas` un **método auxiliar** que hace una sola cosa, y `Principal` lo usa. Al final, la lógica del programa se lee casi como las preguntas de arriba.

Es la **UD4 · Arrays, cadenas y regex**: arrays, una matriz (un array de dos dimensiones) y métodos de `String`. De paso, adelanta cómo se lee un archivo y qué es una excepción, que se ven con más detalle más adelante.

**Usa la IA como guía, no para que lo haga por ti.** Pídele que te explique lo que no entiendas; **el código lo pones tú en tu proyecto**, aunque sea copiando y pegando, sabiendo **dónde** lo pones y **para qué**. El objetivo es que lo que hagas **funcione y cumpla los requisitos** de cada paso («Comprueba que…») y que sepas **dónde está cada cosa y qué habría que tocar para cambiar o añadir algo**.

**El objetivo es entender cada paso:** es lo que necesitas para responder el cuestionario de autoevaluación y preparar el examen de la UD4.

**Entrega.** Este proyecto es la entrega de la UD4: el proyecto comprimido, el **miércoles 18 de noviembre** (ver [`entrega.md`](entrega.md)).

## Las herramientas

Las de «Java 0», en el terminal de Linux (en Windows, **Ubuntu** desde el menú Inicio; si tu ordenador tiene Linux, su terminal).

| Herramienta | Qué es | Cómo se usa | Pasos |
|---|---|---|---|
| **git** | Descarga el repositorio del módulo y lo actualiza | `git clone` la primera vez; `git pull` para traer lo nuevo | 0 |
| **VS Code** | El editor | `code .` lo abre en la carpeta en que estás. Su terminal: **Ctrl+ñ** | Todos |
| **`javac`** | El compilador: de `.java` a `.class` | `javac -d bin src/dam/*.java src/dam/notas/*.java` | Todos |
| **`java`** | Ejecuta el programa | `java -cp bin dam.Principal`, desde la carpeta del proyecto | Todos |
| **`zip`** | Comprime el proyecto para entregarlo | `zip -r …` | 8 |

## Con qué trabajas

La plantilla, `2026_11_09-13/clase/plantilla` del repositorio, que en el paso 0 copias como `notas-csv`:

| Archivo | Qué es | Pasos |
|---|---|---|
| `notas.csv` | Los datos: una cabecera y una línea por alumno, con los campos separados por `;` | ninguno: no se cambia |
| `src/dam/Auxiliar.java` | `print`, `getInt` y `getString` (lee una línea de texto), como en «Java 0». Ya está hecho | ninguno |
| `src/dam/Principal.java` | El `main` y los métodos de cada opción | todos |
| `src/dam/notas/Notas.java` | Los métodos auxiliares; los comentarios `// TODO Paso N` marcan dónde va cada uno | 1 a 6 |

Así empieza `notas.csv`:

```
nombre;t1;t2;t3
Nombre01;42;97;33
Nombre02;57;40;88
Nombre03;82;85;73
```

`t1`, `t2` y `t3` son las notas de los tres trimestres, en porcentaje (de 0 a 100). Puedes abrirlo con VS Code para verlo entero.

## Qué se trabaja

| Qué | Pasos |
|---|---|
| Leer un archivo y tratar el error si no se puede (`try-catch`) | 1 |
| Partir texto (`split`, `trim`) y convertirlo en número (`Integer.parseInt`) | 2 |
| Arrays y una matriz: crearlos, rellenarlos y recorrerlos | 2, 4, 5 y 6 |
| Comparar textos (`equalsIgnoreCase`) y buscar en un array | 3 |
| `Arrays.toString` y `String.format` para mostrar | 2 y 4 |
| Métodos que reciben arrays y devuelven un valor o una posición | 3 a 6 |
| Un menú con `do-while` y `switch` | 7 |

## Plan de la semana

Cada sesión dura 50 minutos.

| Día | Sesión | Qué hacemos |
|---|---|---|
| Miércoles 11 | 13:00 | Leer «Punto de partida», «Las herramientas» y «Con qué trabajas» (15 min). **Paso 0** (preparar el proyecto) y **paso 1** (leer el archivo). |
| Miércoles 11 | 13:50 | **Paso 2** (partir las líneas y cargar los arrays). |
| Miércoles 11 | 14:40 | **Paso 3** (¿está en la lista?). |
| Jueves 12 | 12:10 | **Paso 4** (las notas y la media de un alumno). |
| Jueves 12 | 13:00 | **Paso 5** (el mejor de un trimestre). |
| Jueves 12 | 13:50 | **Paso 6** (los mejores de cada trimestre y del curso). |
| Viernes 13 | 10:10 | **Paso 7** (el menú). |
| Viernes 13 | 11:00 | **Paso 8** (comprobar todo y comprimir). |
| Viernes 13 | 12:10 | Terminar los pasos que falten y repasar el proyecto con la lista final («Cómo comprobarlo»). |

**Los pasos se hacen en orden**, cada uno en la sesión que le toca según el plan de la semana: cada paso usa lo del anterior. Al terminar cada paso, el programa tiene que compilar y funcionar.

Cada paso tiene **Objetivo**, **Pista** (el código y lo justo para entenderlo), **Comprueba que…** y **Si te falla…** (errores típicos y cómo resolverlos).

**Compilar y ejecutar.** En todos los pasos, desde la carpeta `notas-csv`:

```bash
javac -d bin src/dam/*.java src/dam/notas/*.java
java -cp bin dam.Principal
```

Es lo mismo que en «Java 0», con una carpeta más: `src/dam/notas/*.java`, el paquete nuevo. Si `javac` no dice nada, ha compilado bien.

---

## Paso 0 · Preparar el proyecto

**Objetivo.** Tener la plantilla en `~/dam2627/prog/notas-csv` y ejecutarla.

**Pista.**

1. En el terminal de Linux, descarga el repositorio del módulo dentro de `~/dam2627/prog` y copia la plantilla con el nombre `notas-csv`:

   ```bash
   mkdir -p ~/dam2627/prog
   cd ~/dam2627/prog
   git clone https://github.com/mrpiay/NTFOR_DAM2627_PROG.git
   cp -r NTFOR_DAM2627_PROG/2026_11_09-13/clase/plantilla notas-csv
   cd notas-csv
   ```

   `git clone` crea la carpeta `NTFOR_DAM2627_PROG` con todo el repositorio. Las semanas siguientes no hace falta volver a descargarlo: dentro de esa carpeta, `git pull` trae lo nuevo.
2. Ábrelo en VS Code con `code .` y abre su terminal con **Ctrl+ñ**: los comandos siguientes se escriben ahí.
3. Compila y ejecuta:

   ```bash
   javac -d bin src/dam/*.java src/dam/notas/*.java
   java -cp bin dam.Principal
   ```

**Comprueba que…** sale `=== Notas de clase ===` y en el Explorador de VS Code ves `notas.csv`, `src` y, después de compilar, `bin`.

**Si te falla…**

- *`git: command not found`*: instálalo con `sudo apt install git` y repite `git clone`.
- *`fatal: destination path 'NTFOR_DAM2627_PROG' already exists`*: ya lo descargaste. Entra (`cd NTFOR_DAM2627_PROG`), actualízalo con `git pull`, vuelve con `cd ..` y sigue con `cp -r`.
- *`code: command not found`*: VS Code no está conectado a Linux; repasa «Ubuntu Linux, WSL, Java y VS Code», de SI.

---

## Paso 1 · Leer el archivo

**Objetivo.** Leer `notas.csv` y ver cuántas líneas tiene.

**Pista.** En `Notas.java`, en lugar de `// TODO Paso 1: leerLineas`:

```java
    // Las líneas del archivo, en un array (vacío si no se puede leer)
    public static String[] leerLineas(String ruta) {
        try {
            return Files.readAllLines(Path.of(ruta)).toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("No se puede leer " + ruta);
            return new String[0];
        }
    }
```

Y los imports que usa, debajo de `package dam.notas;`:

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
```

- `Path.of(ruta)` es la ruta del archivo; `Files.readAllLines` lo lee entero y da sus líneas; `.toArray(new String[0])` las pasa a un array de `String`, una línea en cada posición.
- Leer un archivo puede fallar: que no exista, que no haya permiso… Entonces Java lanza una **excepción**, `IOException`. `try-catch` la recoge: si todo va bien se ejecuta el `try`; si falla, el `catch`, que avisa y devuelve un array vacío. Sin `try-catch`, el programa no compila: Java obliga a decidir qué hacer si el archivo no se puede leer.

En `Principal.java`, debajo de `import static dam.Auxiliar.*;`, importa los métodos de `Notas`:

```java
import static dam.notas.Notas.*;
```

Y en el `main`, en lugar de `// TODO Paso 1: leer notas.csv`:

```java
        String[] lineas = leerLineas("notas.csv");
        if (lineas.length == 0) {
            return;     // no se ha podido leer: termina
        }
        print("Líneas leídas: " + lineas.length);
        print("Primera: " + lineas[0]);
        print("Segunda: " + lineas[1]);
```

`lineas.length` es el número de posiciones del array; `lineas[0]` es la primera, porque las posiciones empiezan en 0.

**Comprueba que…**

```
=== Notas de clase ===
Líneas leídas: 26
Primera: nombre;t1;t2;t3
Segunda: Nombre01;42;97;33
```

Y que, si cambias el nombre del archivo (`mv notas.csv notas2.csv`) y vuelves a ejecutar, sale `No se puede leer notas.csv` y el programa termina sin errores. Después déjalo como estaba: `mv notas2.csv notas.csv`.

**Si te falla…**

- *`cannot find symbol` en `Files`, `Path` o `IOException`*: faltan los tres imports de `Notas.java`.
- *`cannot find symbol` en `leerLineas`*: falta `import static dam.notas.Notas.*;` en `Principal.java`, o no has compilado `src/dam/notas/*.java`.
- *`unreported exception java.io.IOException`*: falta el `try-catch`.
- *Sale `No se puede leer notas.csv` sin haber cambiado nada*: ejecutas desde otra carpeta. `java` busca `notas.csv` en la carpeta en que estás: tiene que ser `notas-csv`.

---

## Paso 2 · Partir las líneas y cargar los arrays

**Objetivo.** Pasar las líneas a dos estructuras con las que se pueda trabajar: un array con los nombres y una matriz con las notas.

**Pista.** Cada línea se parte por los `;` con `split`:

```java
String[] campos = "Nombre01;42;97;33".split(";");
// campos[0] es "Nombre01", campos[1] es "42", campos[2] es "97" y campos[3] es "33"
```

Los campos son texto: `"42"` no es el número 42. `Integer.parseInt("42")` lo convierte. `trim()` quita los espacios del principio y del final, por si los hubiera.

Las notas van en una **matriz**, un array de dos dimensiones: `int[][] notas` tiene una fila por alumno y una columna por trimestre. `notas[0]` es la fila del primer alumno, `{42, 97, 33}`, y `notas[0][1]` es su nota del 2.º trimestre, 97. La fila del alumno `i` está en la misma posición que su nombre en `nombres`.

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
- `new int[25][3]` crea la matriz llena de ceros; el `for` de dentro rellena las tres columnas de cada fila.

En el `main` de `Principal`, cambia las líneas `print("Primera: …")` y `print("Segunda: …")` por estas:

```java
        String[] nombres = cargarNombres(lineas);
        int[][] notas = cargarNotas(lineas);
        print("Alumnos: " + nombres.length);
        print(nombres[0] + " " + Arrays.toString(notas[0]));
        print(nombres[24] + " " + Arrays.toString(notas[24]));
```

Y añade `import java.util.Arrays;` debajo de los otros imports. `Arrays.toString` convierte un array en texto, como `[42, 97, 33]`.

**Comprueba que…**

```
=== Notas de clase ===
Líneas leídas: 26
Alumnos: 25
Nombre01 [42, 97, 33]
Nombre25 [90, 38, 45]
```

**Si te falla…**

- *`NumberFormatException: For input string: "t1"`*: el bucle empieza en `i = 0` y está convirtiendo la cabecera.
- *`ArrayIndexOutOfBoundsException`*: una posición se sale del array. Revisa `i - 1` y `t + 1`, y que los arrays tengan `lineas.length - 1` posiciones.
- *Sale algo como `[I@1b6d3586`*: has escrito `notas[0]` sin `Arrays.toString`.

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

- Los textos se comparan con `equals`, nunca con `==`. `equalsIgnoreCase` compara sin distinguir mayúsculas: `nombre07` es igual que `Nombre07`.
- `return i` sale del método en cuanto lo encuentra. Si el bucle termina sin encontrarlo, devuelve `-1`, que no es ninguna posición: así quien lo llama sabe que no está.

En `Principal.java`, debajo del `main` (después de su `}` y antes de la última `}` de la clase), añade el método de esta opción:

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

Y llámalo al final del `main`: `opcionEstaEnLaLista(nombres);`. Se muestra `posicion + 1` porque para una persona el primero es el número 1, no el 0.

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
- `for (int nota : notasAlumno)` es el **for-each**: recorre el array dando cada valor en `nota`, sin usar posiciones. Sirve cuando solo hace falta el valor.
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

En el `main`, cambia la llamada `opcionEstaEnLaLista(nombres);` por `opcionNotasDeUnAlumno(nombres, notas);`. El método del paso 3 no se borra: se usa en el menú del paso 7.

**Comprueba que…**

| Escribes | Sale |
|---|---|
| `Nombre12` | `Nombre12 [81, 88, 95] media 88.00` |
| `Nombre01` | `Nombre01 [42, 97, 33] media 57.33` |
| `Pepe` | `Pepe no está en la lista` |

Según el idioma del sistema, los decimales pueden salir con coma (`88,00`): las dos formas están bien.

**Si te falla…**

- *La media sale `57.00` en lugar de `57.33`*: falta el `(double)`.
- *`cannot find symbol` en `Arrays`*: falta `import java.util.Arrays;` en `Principal.java`.

---

## Paso 5 · El mejor de un trimestre

**Objetivo.** Pedir un trimestre y decir quién tiene la mejor nota en él.

**Pista.** Es buscar el máximo de una **columna** de la matriz: se recorren las filas y se mira siempre la misma columna. El trimestre 1 es la columna 0.

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

Se guarda la **posición** del mejor, no su nota: con la posición se saben el nombre (`nombres[mejor]`) y la nota (`notas[mejor][columna]`). Se empieza suponiendo que el mejor es el primero (`mejor = 0`) y se compara con los demás.

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

Y en el `main`, cambia la llamada del paso anterior por `opcionMejorDeUnTrimestre(nombres, notas);`.

**Comprueba que…**

| Escribes | Sale |
|---|---|
| `1` | `Trimestre 1: Nombre21 (100)` |
| `2` | `Trimestre 2: Nombre07 (100)` |
| `3` | `Trimestre 3: Nombre19 (100)` |
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

Y en el `main`, cambia la llamada del paso anterior por `opcionMejores(nombres, notas);`.

**Comprueba que…**

```
Trimestre 1: Nombre21 (100)
Trimestre 2: Nombre07 (100)
Trimestre 3: Nombre19 (100)
Curso: Nombre12 (media 88.00)
```

**Si te falla…**

- *`variable mejor is already defined`*: el primer `int mejor` está fuera de las llaves del `for`. Tiene que ir dentro: así solo existe en el bucle y no choca con el `int mejor` de después.
- *Las tres primeras líneas dicen el mismo trimestre*: en el `for` llamas a `mejorDelTrimestre` con un número fijo en lugar de con `trimestre`.

---

## Paso 7 · El menú

**Objetivo.** Que el programa muestre un menú, haga la opción elegida y repita hasta elegir «Salir».

**Pista.** Sustituye el `main` entero por este. Los métodos de las opciones (pasos 3 a 6) se quedan como están:

```java
    public static void main(String[] args) {
        print("=== Notas de clase ===");

        String[] lineas = leerLineas("notas.csv");
        if (lineas.length == 0) {
            return;
        }
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

- Los datos se cargan **una sola vez**, al principio; el menú solo los consulta.
- `do-while` repite el menú mientras la opción no sea 0; como la condición va al final, el menú sale al menos una vez.
- Cada `case` llama al método de su opción. Así el `main` se lee como una lista de lo que hace el programa, y cada método se puede entender y cambiar por separado.

**Comprueba que…**

| Eliges | Y escribes | Sale |
|---|---|---|
| `1` | `nombre07` | `Nombre07 está en la lista: es el número 7` |
| `2` | `Nombre12` | `Nombre12 [81, 88, 95] media 88.00` |
| `3` | `2` | `Trimestre 2: Nombre07 (100)` |
| `4` | | las cuatro líneas del paso 6 |
| `9` | | `Opción no válida` |
| `0` | | `Hasta luego` y termina |

Y que, después de cada opción, vuelve a salir el menú.

**Si te falla…**

- *Al elegir una opción sale también lo de la siguiente*: falta un `break`.
- *`NumberFormatException` al elegir*: has escrito algo que no es un número; `getInt` solo acepta números enteros.

---

## Paso 8 · Comprobar todo y comprimir

**Objetivo.** Repasar que todo funciona y crear el zip para la entrega.

**Pista.**

1. Compila y pasa otra vez la tabla del paso 7.
2. Comprime el proyecto. `$USER` es tu nombre de usuario de Linux, así el zip lleva tu nombre:

   ```bash
   zip -r $USER-notas-csv.zip src/ bin/ notas.csv
   ```

   Lleva el código (`src`), el bytecode (`bin`) y los datos (`notas.csv`), que el programa necesita para funcionar.
3. Comprueba que el zip funciona: extráelo en otra carpeta y ejecútalo desde allí.

   ```bash
   unzip $USER-notas-csv.zip -d prueba
   cd prueba
   java -cp bin dam.Principal
   cd ..
   rm -r prueba
   ```

**Comprueba que…** desde `prueba` el programa arranca y dice `Alumnos: 25`.

**Si te falla…**

- *Desde `prueba` sale `No se puede leer notas.csv`*: el zip no lleva `notas.csv`. Bórralo (`rm $USER-notas-csv.zip`) y vuelve a crearlo con el comando del punto 2.
- *Desde `prueba` sale `ClassNotFoundException`*: el zip no lleva `bin`. Compila, borra el zip y vuelve a crearlo.

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
| El zip lleva `src`, `bin` y `notas.csv`, y funciona extraído en otra carpeta |  |
