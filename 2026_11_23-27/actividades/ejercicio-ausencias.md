# Programa Java - Ausencias de la semana

## Introducción

En esta guía se desarrolla **Ausencias**, un programa en Java que apunta las ausencias de un grupo de 10 estudiantes de lunes a viernes y muestra quién faltó cada día.

El objetivo no es solo que el programa funcione, sino repasar los **arrays de una y dos dimensiones** y los **métodos**, y entender por qué cada parte va donde va. Los datos van en una clase y las operaciones en otra.

Se compila y se ejecuta en la terminal de **Ubuntu**, como ValoraPROG, y el código se escribe en **VS Code**.

El desarrollo se divide en dos partes:

- **Parte 1. Diseño:** qué hace el programa, dónde se guardan los datos y cómo se reparte el código.
- **Parte 2. Implementación paso a paso:** se crea el proyecto y se escribe cada parte. Después de cada paso se compila y se comprueba la salida.

El proyecto terminado está en [`ausencias.zip`](ausencias.zip), para compararlo con el propio.

## Índice

- [Parte 1 · Diseño](#parte-1--diseño)
  - [1. Qué hace el programa](#1-qué-hace-el-programa)
  - [2. Dónde se guardan los datos](#2-dónde-se-guardan-los-datos)
  - [3. Cómo se organiza el código](#3-cómo-se-organiza-el-código)
- [Parte 2 · Implementación](#parte-2--implementación)
  - [Paso 1 · Crear el proyecto](#paso-1--crear-el-proyecto)
  - [Paso 2 · Los datos](#paso-2--los-datos)
  - [Paso 3 · Buscar un estudiante y un día](#paso-3--buscar-un-estudiante-y-un-día)
  - [Paso 4 · Poner una ausencia](#paso-4--poner-una-ausencia)
  - [Paso 5 · Imprimir los ausentes de un día](#paso-5--imprimir-los-ausentes-de-un-día)
- [Si algo falla](#si-algo-falla)
- [El proyecto terminado](#el-proyecto-terminado)

---

# Parte 1 · Diseño

## 1. Qué hace el programa

El programa tiene tres operaciones:

| Operación | Ejemplo | Resultado |
|---|---|---|
| Buscar un estudiante | `"Brais"` | Su posición en la lista: `1` |
| Poner una ausencia | Ana falta el lunes | Queda apuntado. Si el estudiante o el día no existen, avisa con `false` |
| Imprimir los ausentes de un día | El lunes | `Ana` e `Iria`, o `Nadie` si no faltó nadie |

Los días se escriben con su letra: `L`, `M`, `X`, `J` y `V`.

No hay menú: el `main` llama a las operaciones con datos de prueba e imprime lo que devuelven. Así se comprueba cada operación en cuanto se escribe.

## 2. Dónde se guardan los datos

Hay tres arrays:

| Array | Tipo | Contenido |
|---|---|---|
| `estudiantes` | `String[]`, de una dimensión | Los 10 nombres |
| `dias` | `String[]`, de una dimensión | `"L"`, `"M"`, `"X"`, `"J"` y `"V"` |
| `ausencias` | `boolean[][]`, de dos dimensiones | Una fila por estudiante y una columna por día |

`ausencias[e][d]` es `true` si el estudiante de la posición `e` de `estudiantes` faltó el día de la posición `d` de `dias`. Las **posiciones** unen los tres arrays: la fila 6 de `ausencias` es Iria porque `estudiantes[6]` es `"Iria"`, y la columna 0 es el lunes porque `dias[0]` es `"L"`.

Así queda `ausencias` cuando Ana e Iria faltan el lunes y Brais el miércoles:

| | 0 · L | 1 · M | 2 · X | 3 · J | 4 · V |
|---|---|---|---|---|---|
| 0 · Ana | `true` | `false` | `false` | `false` | `false` |
| 1 · Brais | `false` | `false` | `true` | `false` | `false` |
| 2 · Carla | `false` | `false` | `false` | `false` | `false` |
| … | | | | | |
| 6 · Iria | `true` | `false` | `false` | `false` | `false` |
| … | | | | | |

Al crear un array de `boolean`, todas las casillas valen `false`: al principio, nadie ha faltado.

## 3. Cómo se organiza el código

El código va en dos clases del paquete `ausencias`:

```
ausencias/
└── src/
    └── ausencias/
        ├── Datos.java         la clase de datos: los tres arrays
        └── Operaciones.java   la clase de operaciones: los métodos y el main
```

| Clase | Qué hace |
|---|---|
| `Datos` | Solo **guarda** la información. No tiene métodos |
| `Operaciones` | **Trabaja** con esa información: buscar, poner una ausencia e imprimir. Tiene el `main` |

- Desde `Operaciones`, los arrays se usan con el nombre de la clase delante: `Datos.estudiantes`, `Datos.dias` y `Datos.ausencias`. No hace falta `import` porque las dos clases están en el mismo paquete.
- Los arrays y los métodos son `static`: se usan sin crear objetos, como en ValoraPROG.

| Método | Qué recibe | Qué devuelve |
|---|---|---|
| `buscarEstudiante` | Un nombre | Su posición en `Datos.estudiantes`, o `-1` si no está |
| `buscarDia` | Un día | Su posición en `Datos.dias`, o `-1` si no está |
| `ponerAusencia` | Un nombre y un día | `true` si pone la ausencia, `false` si el estudiante o el día no existen |
| `imprimirAusentes` | Un día | Nada (`void`): imprime los ausentes |

`ponerAusencia` e `imprimirAusentes` reciben el nombre y el día como texto, y usan `buscarEstudiante` y `buscarDia` para convertirlos en una fila y una columna de `ausencias`.

---

# Parte 2 · Implementación

## Paso 1 · Crear el proyecto

En la terminal de Ubuntu, crea las carpetas y abre el proyecto en VS Code:

```bash
mkdir -p ausencias/src/ausencias
cd ausencias
code .
```

`mkdir -p` crea `ausencias`, `src` y la carpeta del paquete de una vez.

Desde la carpeta `ausencias/`, el proyecto se compila y se ejecuta siempre con:

```bash
javac -d out src/ausencias/*.java
java -cp out ausencias.Operaciones
```

- `src/ausencias/*.java` compila las dos clases a la vez.
- La clase que se ejecuta es `Operaciones`, porque es la que tiene el `main`.

---

## Paso 2 · Los datos

Crea `src/ausencias/Datos.java`:

```java
package ausencias;

// Clase de datos: solo guarda la información, sin operaciones
public class Datos {

    // Los 10 estudiantes del grupo
    static String[] estudiantes = {"Ana", "Brais", "Carla", "Daniel", "Elena",
                                   "Fran", "Iria", "Lucas", "Noa", "Xoán"};

    // Los días de la semana, de lunes a viernes
    static String[] dias = {"L", "M", "X", "J", "V"};

    // Las ausencias de la semana: una fila por estudiante y una columna por día.
    // ausencias[e][d] es true si el estudiante de la posición e faltó el día d.
    // Al crearlo, todas las casillas valen false: nadie ha faltado.
    static boolean[][] ausencias = new boolean[estudiantes.length][dias.length];
}
```

- `estudiantes` y `dias` se declaran y se inicializan a la vez, con los valores entre llaves.
- `ausencias` se crea con `new`, y su tamaño sale de los otros dos arrays: `estudiantes.length` filas (10) y `dias.length` columnas (5). Si se añade un estudiante, la tabla crece sola, sin cambiar ningún número.

Para comprobar los datos, crea `src/ausencias/Operaciones.java` con un `main` de prueba:

```java
package ausencias;

// Clase de operaciones: trabaja con los arrays de la clase Datos
public class Operaciones {

    public static void main(String[] args) {
        System.out.println(Datos.estudiantes.length); // 10
        System.out.println(Datos.dias.length);        // 5
        System.out.println(Datos.ausencias.length);   // 10: las filas
        System.out.println(Datos.ausencias[0].length); // 5: las columnas
        System.out.println(Datos.ausencias[0][0]);    // false
    }
}
```

**Comprueba que**, al compilar y ejecutar, sale:

```
10
5
10
5
false
```

`Datos.ausencias.length` es el número de filas, y `Datos.ausencias[0].length`, lo que mide la fila 0, es decir, el número de columnas.

---

## Paso 3 · Buscar un estudiante y un día

En `Operaciones.java`, encima del `main`, añade los dos métodos de búsqueda:

```java
    // Devuelve la posición del estudiante en Datos.estudiantes, o -1 si no está.
    // No distingue mayúsculas de minúsculas: "ana" encuentra a "Ana".
    static int buscarEstudiante(String nombre) {
        for (int e = 0; e < Datos.estudiantes.length; e++) {
            if (Datos.estudiantes[e].equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return -1;
    }

    // Devuelve la posición del día ("L", "M", "X", "J" o "V") en Datos.dias, o -1 si no está.
    static int buscarDia(String dia) {
        for (int d = 0; d < Datos.dias.length; d++) {
            if (Datos.dias[d].equalsIgnoreCase(dia)) {
                return d;
            }
        }
        return -1;
    }
```

- Los dos hacen lo mismo con arrays distintos: recorrer el array con un índice y comparar cada elemento con el que se busca.
- En cuanto lo encuentra, `return e;` devuelve la posición y **sale del método**: no sigue mirando el resto.
- El `return -1;` del final solo se alcanza si el bucle termina sin encontrarlo. `-1` no puede ser una posición, así que sirve para decir «no está».
- Los textos se comparan con `equalsIgnoreCase`, nunca con `==`. `equalsIgnoreCase` no distingue mayúsculas de minúsculas: `"noa"` encuentra a `"Noa"`.

Cambia las líneas del `main` por estas:

```java
    // Prueba las operaciones. A la derecha, lo que debe salir.
    public static void main(String[] args) {
        // Buscar estudiantes y días
        System.out.println("Brais está en la posición " + buscarEstudiante("Brais")); // 1
        System.out.println("noa está en la posición " + buscarEstudiante("noa"));     // 8
        System.out.println("Pepe está en la posición " + buscarEstudiante("Pepe"));   // -1
        System.out.println("X es el día " + buscarDia("X"));                          // 2
        System.out.println("S es el día " + buscarDia("S"));                          // -1
    }
```

**Comprueba que** sale:

```
Brais está en la posición 1
noa está en la posición 8
Pepe está en la posición -1
X es el día 2
S es el día -1
```

---

## Paso 4 · Poner una ausencia

Debajo de `buscarDia`, añade:

```java
    // Pone una ausencia al estudiante en ese día.
    // Devuelve true si la pone, y false si el estudiante o el día no existen.
    static boolean ponerAusencia(String nombre, String dia) {
        int e = buscarEstudiante(nombre);
        int d = buscarDia(dia);
        if (e == -1 || d == -1) {
            return false;
        }
        Datos.ausencias[e][d] = true;
        return true;
    }
```

- Primero convierte el nombre en una fila (`e`) y el día en una columna (`d`), con los métodos del paso 3.
- Si cualquiera de los dos es `-1` (`||` es «o»), no hay casilla que marcar: devuelve `false` sin tocar la tabla. Sin esa comprobación, `Datos.ausencias[-1][0]` daría el error `ArrayIndexOutOfBoundsException`.
- Si los dos existen, pone `true` en la casilla de esa fila y esa columna.

Al final del `main`, añade:

```java
        // Poner ausencias
        System.out.println(ponerAusencia("Ana", "L"));   // true
        System.out.println(ponerAusencia("Iria", "L"));  // true
        System.out.println(ponerAusencia("Brais", "X")); // true
        System.out.println(ponerAusencia("Pepe", "L"));  // false: Pepe no está
        System.out.println(ponerAusencia("Ana", "S"));   // false: S no es un día
```

**Comprueba que**, debajo de lo del paso 3, sale:

```
true
true
true
false
false
```

---

## Paso 5 · Imprimir los ausentes de un día

Debajo de `ponerAusencia`, añade:

```java
    // Imprime los estudiantes ausentes en ese día, uno por línea,
    // o «Nadie» si no falta nadie. Si el día no existe, lo dice.
    static void imprimirAusentes(String dia) {
        int d = buscarDia(dia);
        if (d == -1) {
            System.out.println("El día " + dia + " no existe");
            return;
        }
        System.out.println("Ausentes el " + Datos.dias[d] + ":");
        int cuantos = 0;
        for (int e = 0; e < Datos.estudiantes.length; e++) {
            if (Datos.ausencias[e][d]) {
                System.out.println("  " + Datos.estudiantes[e]);
                cuantos++;
            }
        }
        if (cuantos == 0) {
            System.out.println("  Nadie");
        }
    }
```

- Si el día no existe, lo dice y sale con `return;`: en un método `void`, `return` sin valor termina el método.
- La **columna queda fija** (`d`) y se recorren las **filas**, una por estudiante: es como sumar una columna en [`repaso-arrays.md`](repaso-arrays.md), pero en lugar de sumar se imprime.
- `if (Datos.ausencias[e][d])` ya pregunta si es `true`: no hace falta escribir `== true`.
- La fila `e` de `ausencias` y la posición `e` de `estudiantes` son la misma persona, así que el nombre sale de `Datos.estudiantes[e]`.
- `cuantos` cuenta los ausentes. Si al acabar el bucle sigue en 0, no faltó nadie.

Al final del `main`, añade:

```java
        // Imprimir ausentes
        imprimirAusentes("L"); // Ausentes el L:   Ana   Iria
        imprimirAusentes("X"); // Ausentes el X:   Brais
        imprimirAusentes("V"); // Ausentes el V:   Nadie
        imprimirAusentes("S"); // El día S no existe
```

**Comprueba que** la salida completa es:

```
Brais está en la posición 1
noa está en la posición 8
Pepe está en la posición -1
X es el día 2
S es el día -1
true
true
true
false
false
Ausentes el L:
  Ana
  Iria
Ausentes el X:
  Brais
Ausentes el V:
  Nadie
El día S no existe
```

| Líneas | Qué se comprueba |
|---|---|
| 1 a 5 | `buscarEstudiante` y `buscarDia`: uno que está, uno en minúsculas y uno que no está |
| 6 a 10 | `ponerAusencia`: tres ausencias correctas, un estudiante que no existe y un día que no existe |
| 11 en adelante | `imprimirAusentes`: un día con dos ausentes, uno con uno, uno sin nadie y un día que no existe |

---

## Si algo falla

| Qué pasa | Qué mirar |
|---|---|
| `cannot find symbol` con `estudiantes`, `dias` o `ausencias` | Que en `Operaciones` lleven delante `Datos.`, y que las dos clases empiecen por `package ausencias;` |
| `missing return statement` | Que el método que devuelve algo tenga un `return` también después del bucle (`return -1;` o `return false;`) |
| `ArrayIndexOutOfBoundsException` | Que se compruebe `-1` antes de usar la posición en la tabla, y que los bucles lleguen hasta `< length`, no `<= length` |
| Busca bien `"Brais"`, pero `"noa"` da `-1` | Que se compare con `equalsIgnoreCase`, no con `equals` ni con `==` |
| `Could not find or load main class` | Que se ejecute desde la carpeta `ausencias/` y con el nombre completo: `ausencias.Operaciones` |
| Las tildes salen mal en la terminal de Windows («est� en la posici�n») | El programa está bien: es la consola, que no usa UTF-8. Se ejecuta con `java -Dstdout.encoding=UTF-8 -cp out ausencias.Operaciones`. En la terminal de Linux salen bien |

---

## El proyecto terminado

Está en [`ausencias.zip`](ausencias.zip), con `Datos.java` y `Operaciones.java` completos. Se descomprime y, desde la carpeta `ausencias/`, se compila y se ejecuta con los comandos del paso 1.

## Dónde consultar

- **Arrays y matrices:** los [apuntes de arrays y cadenas](../../2026_11_09-13/apuntes/UD4-arrays-y-cadenas.md), apartados 1 a 3. Comparar cadenas sin distinguir mayúsculas (`equalsIgnoreCase`), en el apartado 4.
- **Recorrer una tabla y sumar una fila o una columna:** [`repaso-arrays.md`](repaso-arrays.md).
