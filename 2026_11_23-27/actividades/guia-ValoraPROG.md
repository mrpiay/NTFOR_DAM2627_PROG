# Programa Java - ValoraPROG

## Introducción

En esta guía aprenderás a diseñar y desarrollar **ValoraPROG**, un programa en Java, con un menú en la terminal, para recoger valoraciones anónimas del módulo de PROG (Programación).

Cada persona valora del 1 al 5 tres aspectos del módulo: el **docente**, los **materiales** y las **clases**. El programa guarda las valoraciones mientras está abierto y muestra, para cada aspecto, todas sus notas separadas por comas y su media, y una **valoración global**: la media de los tres aspectos, en la que cada uno cuenta según su **peso**. Al empezar todos pesan lo mismo, y los pesos se pueden cambiar desde el menú. Cada media se ve también con **estrellas** de asteriscos, como en las tiendas de aplicaciones: `****-` son 4 de 5. Además, el programa muestra la **mejor valoración**, permite **modificar** cualquier valoración ya guardada y puede **crear 10 valoraciones al azar** para probarlo con muchos datos sin escribirlos.

El objetivo de esta guía no es únicamente conseguir que el programa funcione, sino también comprender cómo se organiza un programa en Java y por qué cada parte va donde va. Para ello, se usa la terminal de **Ubuntu** para compilar y ejecutar y **VS Code** para escribir el código. Además, se usan **`Scanner`** para leer del teclado, **`switch`** y bucles para el menú, **`try-catch`** para que el programa no se rompa con lo que se escriba, **funciones** para repartir el trabajo, una **matriz** para guardar las notas, un **array** para los pesos y **`Random`** para los números al azar.

El desarrollo se divide en dos partes:

- **Parte 1. Diseño y funcionamiento:** qué hace el programa, cómo se guardan los datos y cómo se reparte el código, antes de empezar a programar.
- **Parte 2. Implementación paso a paso:** se prepara el entorno, se crea el proyecto, se escribe el código de cada archivo, se compila, se ejecuta y se prueba con casos de prueba preparados.

No es necesario tener experiencia previa con Java en la terminal. La guía explica desde la preparación del entorno hasta el programa terminado, incluyendo comprobaciones y ejemplos para facilitar el seguimiento.

Al finalizar, tendrás un programa funcional y una visión general de cómo se reparten un programa en funciones y los cálculos en una clase aparte.

## Índice

- [Parte 1 · Diseño](#parte-1--diseño)
  - [1. Qué hace el programa](#1-qué-hace-el-programa)
  - [2. Dónde se guardan los datos](#2-dónde-se-guardan-los-datos)
  - [3. Cómo se organiza el código](#3-cómo-se-organiza-el-código)
  - [4. Cómo se mueve la información](#4-cómo-se-mueve-la-información)
  - [5. Decisiones de diseño](#5-decisiones-de-diseño)
  - [6. Configuración de librerías y dependencias](#6-configuración-de-librerías-y-dependencias)
- [Parte 2 · Implementación](#parte-2--implementación)
  - [Paso 0 · Preparar Ubuntu, Java y VS Code](#paso-0--preparar-ubuntu-java-y-vs-code)
  - [Paso 1 · Crear el proyecto](#paso-1--crear-el-proyecto)
  - [Paso 2 · Los cálculos](#paso-2--los-cálculos)
  - [Paso 3 · El programa principal](#paso-3--el-programa-principal)
  - [Paso 4 · Compilar y ejecutar](#paso-4--compilar-y-ejecutar)
  - [Paso 5 · Probar el programa](#paso-5--probar-el-programa)
- [Si algo falla](#si-algo-falla)
- [El proyecto terminado](#el-proyecto-terminado)

---

# Parte 1 · Diseño

## 1. Qué hace el programa

Así se usa, en la terminal. Lo que escribe la persona va detrás de cada `:` y termina con **Intro**:

```
=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 1

Docente (1-5): 4
Materiales (1-5): siete
  Escribe un número del 1 al 5.
Materiales (1-5): 3
Clases (1-5): 5
Valoración guardada (1 en total).

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 2

Valoraciones: 1

  Categoría      Peso  Estrellas  Media  Notas
  ============================================
  Docente       33.3%  ****-        4.0  4
  Materiales    33.3%  ***--        3.0  3
  Clases        33.3%  *****        5.0  5
  Global               ****-        4.0

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 3

Cuánto cuenta cada categoría en la valoración global. Pesos de ahora:
  Docente: 1
  Materiales: 1
  Clases: 1
Peso de Docente (1-10): 2
Peso de Materiales (1-10): 1
Peso de Clases (1-10): 1
Pesos guardados.

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 2

Valoraciones: 1

  Categoría      Peso  Estrellas  Media  Notas
  ============================================
  Docente       50.0%  ****-        4.0  4
  Materiales    25.0%  ***--        3.0  3
  Clases        25.0%  *****        5.0  5
  Global               ****-        4.0

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 5

10 valoraciones creadas al azar (11 en total).

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 6

Número de la valoración (1-11): 1
Notas de ahora de la n.º 1:
  Docente: 4
  Materiales: 3
  Clases: 5
Docente (1-5): 5
Materiales (1-5): 5
Clases (1-5): 5
Valoración n.º 1 modificada.

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 4

Mejor valoración: n.º 1 de 11

  Categoría      Peso  Estrellas   Nota
  =====================================
  Docente       50.0%  *****          5
  Materiales    25.0%  *****          5
  Clases        25.0%  *****          5
  Global               *****        5.0

=== ValoraPROG ===
1. Nueva valoración
2. Ver valoración global
3. Cambiar pesos
4. Ver la mejor valoración
5. Crear 10 valoraciones al azar
6. Modificar una valoración
0. Salir
Opción: 0

Hasta pronto. Las valoraciones y los pesos no se guardan al salir.
```

| N.º | Requisito |
|---|---|
| R1 | El programa muestra un **menú** con siete opciones: 1, nueva valoración; 2, ver la valoración global; 3, cambiar los pesos; 4, ver la mejor valoración; 5, crear 10 valoraciones al azar; 6, modificar una valoración; 0, salir. Después de cada opción, el menú vuelve a salir, hasta elegir 0. |
| R2 | **Nueva valoración:** pide una nota del 1 al 5 para docente, materiales y clases. Si lo escrito no es un número del 1 al 5 (letras, un 0, un 6…), avisa y vuelve a preguntar. El programa no se cierra. |
| R3 | Al terminar una valoración, dice cuántas hay en total. |
| R4 | **Ver la valoración global:** el número de valoraciones y una **tabla** con las columnas alineadas y una línea de `=` debajo de la cabecera, tan larga como ella: para cada categoría, su **peso** en porcentaje, sus **estrellas**, su **media**, con un decimal, y todas sus notas **separadas por comas**; y en la última fila, la **valoración global** («Global»), con sus estrellas: la media **ponderada** de las tres medias, en la que cada una cuenta según su peso. Las estrellas son 5 caracteres: un `*` por cada estrella y un `-` por cada una que falta. Las estrellas son la media redondeada a un entero: 4.5 da `*****` y 3.8, `****-`. |
| R5 | Si aún no hay valoraciones, las opciones 2, 4 y 6 dicen «Aún no hay valoraciones.». |
| R6 | Si se elige una opción que no existe, dice «Opción no válida: elige una del menú.» y vuelve a mostrar el menú. |
| R7 | Caben como máximo **30 valoraciones**. Si se intenta una más, con la opción 1 o con la 5, avisa. |
| R8 | Las valoraciones son **anónimas** (solo tres notas) y se guardan **en memoria**, igual que los pesos: al salir del programa, se pierden, y el programa lo dice al salir. |
| R9 | **Cambiar los pesos:** muestra el peso de ahora de cada categoría y pide uno nuevo, del 1 al 10, para cada una. Si lo escrito no es un número del 1 al 10, avisa y vuelve a preguntar. Al empezar, los tres pesos valen 1: todas las categorías cuentan lo mismo. |
| R10 | **Ver la mejor valoración:** la de nota global más alta, calculada con sus tres notas y los pesos de ahora. Dice su número y, en una tabla como la de R4, el peso, las estrellas y la nota de cada categoría, y su global. Si hay empate, la primera. |
| R11 | **Crear 10 valoraciones al azar:** añade 10 valoraciones con notas del 1 al 5 elegidas al azar y dice cuántas hay en total. Si no caben las 10, crea las que caben hasta llegar a 30. |
| R12 | **Modificar una valoración:** pide su número, del 1 al número de valoraciones que haya, así que solo se puede elegir una que ya existe. Muestra sus notas de ahora y pide las tres nuevas, como en una nueva valoración. No cambia el número de valoraciones. |

Cada respuesta del programa queda separada del menú por una línea en blanco, por arriba y por abajo, para que se lea bien.

## 2. Dónde se guardan los datos

Las notas se guardan en una **matriz**: una tabla de números con filas y columnas. Hay **una fila por valoración** y **una columna por categoría**. Así, cada nota tiene su sitio: `notas[fila][columna]`.

Con dos valoraciones guardadas, la matriz está así:

```
                 columna 0   columna 1    columna 2
                 Docente     Materiales   Clases
   fila 0            4           3            5       ← 1.ª valoración
   fila 1            5           4            2       ← 2.ª valoración
   fila 2            0           0            0       ← aún vacía
   …
   fila 29           0           0            0       ← la última que cabe

   total = 2: solo cuentan las filas 0 y 1
```

- La matriz se crea con **30 filas**, todas a 0, y no crece: por eso caben como máximo 30 valoraciones (R7).
- La variable **`total`** dice cuántas filas están ya rellenas. La siguiente valoración va en la fila `total`, y después `total` aumenta en 1.
- Las notas de **una categoría** son una **columna**: las de docente son `notas[0][0]`, `notas[1][0]`… hasta la fila `total - 1`.

**Los pesos.** Se guardan en un **array** de tres enteros, `pesos`, uno por categoría y en el mismo orden que las columnas: `pesos[0]` es el de docente. Al empezar vale `{1, 1, 1}`.

**Las medias.** La media de una categoría es la suma de su columna entre el número de valoraciones. La valoración global es la **media ponderada**: cada media se multiplica por su peso, se suma todo y se divide entre la suma de los pesos. Con los pesos iguales, es la media de las tres medias:

```
Docente:     (4 + 5) / 2 = 4.5
Materiales:  (3 + 4) / 2 = 3.5
Clases:      (5 + 2) / 2 = 3.5
Global:      (4.5 · 1 + 3.5 · 1 + 3.5 · 1) / (1 + 1 + 1) = 3.83…  →  se muestra 3.8
```

Con los pesos 2, 1 y 1, docente cuenta el doble que cada una de las otras: 2 de 4, el 50 %, y cada una de las otras, el 25 %:

```
Global:      (4.5 · 2 + 3.5 · 1 + 3.5 · 1) / (2 + 1 + 1) = 16 / 4 = 4.0
```

**La mejor valoración.** La nota global de una sola valoración es la media ponderada de sus tres notas: con los pesos 2, 1 y 1, la de la fila 0 (4, 3 y 5) es (4 · 2 + 3 + 5) / 4 = 4.0. La mejor es la fila con la nota global más alta. Las filas empiezan en 0 y las valoraciones se cuentan desde 1: la fila 0 es la valoración n.º 1.

**Las estrellas.** Se redondea la media a un entero y se escriben 5 caracteres: un `*` por cada estrella y un `-` por cada una que falta. La media de docente, 4.5, da 5 estrellas (`*****`); la de materiales, 3.5, da 4 (`****-`), y la global, 3.8, también 4 (`****-`).

**En memoria.** La matriz y los pesos existen mientras el programa está abierto. Al salir, Java libera la memoria y se pierden (R8).

## 3. Cómo se organiza el código

### 3.1 · Las palabras que hay que conocer

El programa se escribe en **Java**. El código se guarda en archivos con la extensión **`.java`**; al **compilarlo**, se convierte en archivos **`.class`**, que son los que se ejecutan.

Dentro de esos archivos hay, sobre todo, dos cosas:

- **Clases.** En Java, todo el código va dentro de una clase. El archivo se llama como la clase: `Principal` va en `Principal.java`. Este programa tiene dos clases, `Principal` y `Calculos`.
- **Funciones** (en Java se llaman **métodos**). Una función es una acción con nombre. Se escribe con paréntesis: `leerEntero(teclado, "Docente", 1, 5)` pide una nota del 1 al 5; `media(notas, total, 0)` calcula la media de docente. Lo que va entre los paréntesis son los **parámetros**, los datos que necesita, y lo que devuelve con `return` es su **resultado**.

Estas son las piezas que usa el programa:

| Palabra | Qué es | En este programa |
|---|---|---|
| **JDK** | El *Java Development Kit*: lo necesario para programar en Java. Trae el compilador (`javac`) y la máquina virtual (`java`) | Java 21, en Ubuntu |
| **`javac`** | El **compilador**: traduce los `.java` a **bytecode**, los `.class` | `javac -d bin src/dam/*.java` |
| **`java`** | Ejecuta el bytecode en la **máquina virtual de Java** (JVM) | `java -cp bin dam.Principal` |
| **Paquete** | Una carpeta con nombre para agrupar clases. Se declara en la primera línea: `package dam;` | `dam`, en la carpeta `src/dam` |
| **`main`** | La función por la que empieza el programa | En `Principal` |
| **`static`** | Una función o un dato que pertenece a la clase y se usa sin crear objetos: `Calculos.media(…)` | Todas las funciones del programa |
| **Constante** (`static final`) | Un dato que no cambia. Por costumbre, su nombre va en mayúsculas | `CATEGORIAS`, `MAX_VALORACIONES`, `AL_AZAR`, `FILA`, `NOTA_MINIMA` |
| **`Scanner`** | La clase de Java que lee del teclado: `teclado.nextLine()` lee una línea | `teclado` |
| **`Random`** | La clase de Java que da números al azar: `azar.nextInt(1, 6)` da un entero del 1 al 5 | `azar` |
| **`String`** | Un texto, entre comillas dobles | Las opciones del menú, los nombres de las categorías |
| **Array** | Una lista de valores del mismo tipo, con un tamaño fijo. Cada valor tiene una **posición**, empezando en 0 | `CATEGORIAS`, `pesos` y cada fila de la matriz |
| **Matriz** | Un array de arrays: una tabla con filas y columnas | `notas`, con 30 filas y 3 columnas |
| **Excepción** | Un error que salta al ejecutar. `try-catch` lo recoge para que el programa no se cierre | `NumberFormatException`, si se escribe «siete» donde va un número |
| **Paso por valor** | Al llamar a una función, se le pasa una **copia** del valor. Con un `int`, la función no puede cambiar la variable de quien llama. Con un array, la copia es de la **referencia**: los dos apuntan al mismo array, y lo que la función cambie dentro se ve fuera | `nuevaValoracion` rellena una fila de la matriz y `cambiarPesos`, el array de pesos; `total` lo cambia `main` |

### 3.2 · Las dos partes

Un programa pequeño se podría escribir entero dentro de `main`, pero sería difícil de leer y de cambiar. Por eso el código se reparte:

- **`Principal`**: el programa que se ve. Muestra el menú, lee lo que se escribe con `Scanner` y escribe las respuestas con `println`. Cada trabajo está en su propia función: `mostrarMenu`, `leerEntero`, una por cada opción del menú y dos de ayuda para las tablas, `escribirCabecera` y `peso`. Así `main` queda corto y se lee como el menú.
- **`Calculos`**: solo cuentas. No lee del teclado ni escribe nada: recibe datos y devuelve resultados. Comprueba si un número está entre dos límites, junta las notas de una categoría con comas, calcula las medias, los porcentajes de los pesos y la global ponderada, busca la mejor valoración, redondea y convierte una media en estrellas.

En resumen: **`Principal` habla con la persona y `Calculos` hace las cuentas**.

**Cómo se lee el esquema.** Cada caja es una clase, con sus funciones y lo que hace cada una; a la derecha, el paso de la Parte 2 en el que se escribe. La flecha que baja dice qué funciones de `Calculos` usa `Principal`, y la que sube, qué le devuelven.

```
┌──────────────────────────────────────────────────────────────┐
│ Principal.java                                   paso 3      │
│   main               el menú: do-while y switch              │
│   mostrarMenu        escribe el menú                         │
│   leerEntero         pide un número hasta que es válido      │
│   escribirCabecera   la cabecera de una tabla y su línea     │
│   peso               el peso en porcentaje: "33.3%"          │
│   nuevaValoracion    1: rellena una fila de la matriz        │
│   mostrarResumen     2: la tabla de medias                   │
│   cambiarPesos       3: rellena el array de pesos            │
│   mostrarMejor       4: la tabla de la mejor valoración      │
│   crearAlAzar        5: rellena filas con Random             │
│   modificarValoracion 6: vuelve a rellenar una fila          │
│   habla con la persona: Scanner y println                    │
└─────────────┬──────────────────────────────────▲─────────────┘
              │ estaEntre(n, min, max)           │ true o false
              │ unir(notas, total, c)            │ "4, 5"
              │ media(notas, total, c)           │ 4.5
              │ porcentaje(pesos, c)             │ 33.33…
              │ global(notas, total, pesos)      │ 3.833…
              │ globalDe(fila, pesos)            │ 4.0
              │ mejor(notas, total, pesos)       │ 0 (la fila)
              │ redondear(x)                     │ 3.8
              │ estrellas(x)                     │ "****-"
┌─────────────▼──────────────────────────────────┴─────────────┐
│ Calculos.java                                    paso 2      │
│   solo cuentas: recibe datos y devuelve resultados,          │
│   sin Scanner ni println                                     │
└──────────────────────────────────────────────────────────────┘
```

| Paso | Archivo | Qué contiene |
|---|---|---|
| 2 | `src/dam/Calculos.java` | Las cuentas: `estaEntre`, `unir`, `media`, `sumaPesos`, `porcentaje`, `global`, `globalDe`, `mejor`, `redondear` y `estrellas` |
| 3 | `src/dam/Principal.java` | El menú (`main`) y las funciones que hablan con la persona: `mostrarMenu`, `leerEntero`, `escribirCabecera`, `peso`, `nuevaValoracion`, `mostrarResumen`, `cambiarPesos`, `mostrarMejor`, `crearAlAzar` y `modificarValoracion` |

## 4. Cómo se mueve la información

Esto es lo que pasa por dentro en cada situación, siguiendo el esquema del punto 3. Entre paréntesis va el nombre que tiene en el código.

**Al arrancar (R1)**

1. `main` crea el `Scanner` (`teclado`), la matriz de notas (`notas`), con 30 filas a 0, `total`, que vale 0, los pesos (`pesos`), que valen `{1, 1, 1}`, y el generador de números al azar (`azar`).
2. Empieza el bucle `do-while`: muestra el menú (`mostrarMenu`), lee la opción y deja una línea en blanco.
3. El `switch` elige qué hacer según la opción. Al terminar, si la opción no era 0, el bucle vuelve a empezar.

**Opción 1: nueva valoración (R2, R3, R7)**

1. Si `total` ya vale 30, la matriz está llena: avisa y vuelve al menú.
2. Si no, llama a `nuevaValoracion` y le pasa la primera fila libre, `notas[total]`.
3. `nuevaValoracion` llama a `leerEntero` una vez por categoría, con los límites de las notas (1 y 5), y guarda cada nota en su columna de la fila.
4. `leerEntero` pregunta hasta que el número está entre los límites. Si lo escrito no es un número, `Integer.parseInt` lanza una `NumberFormatException`, el `catch` la recoge y se trata como uno fuera de los límites. Para saberlo, pregunta a `Calculos.estaEntre`.
5. De vuelta en `main`, `total` aumenta en 1 y se dice cuántas valoraciones hay. La fila se ha rellenado dentro de `nuevaValoracion`, pero `total` se suma en `main`: es un `int`, y una función no puede cambiar un `int` de quien la llama.

**Opción 2: ver la valoración global (R4, R5)**

1. `main` llama a `mostrarResumen` con la matriz, `total` y los pesos.
2. Si `total` es 0, dice «Aún no hay valoraciones.» y termina (`return`).
3. Si no, escribe la cabecera de la tabla (`escribirCabecera`) y, para cada categoría, una fila: pide su peso en porcentaje (`peso`, que usa `Calculos.porcentaje`), su media (`media`), sus estrellas (`estrellas`) y sus notas con comas (`unir`). La última fila es la valoración global ponderada (`global`), con sus estrellas. Antes de escribir cada número, lo redondea a un decimal (`redondear`). Todas las filas se escriben con `printf` y el mismo formato (`FILA`), y por eso las columnas quedan alineadas.

**Opción 3: cambiar los pesos (R9)**

1. `main` llama a `cambiarPesos` con el `Scanner` y el array de pesos.
2. `cambiarPesos` escribe los pesos de ahora y llama a `leerEntero` una vez por categoría, con los límites de los pesos (1 y 10), y guarda cada peso en su posición del array.
3. Como el array es el mismo que el de `main`, los pesos nuevos quedan allí, y la próxima vez que se elija la opción 2 la global se calcula con ellos.

**Opción 4: ver la mejor valoración (R10)**

1. `main` llama a `mostrarMejor` con la matriz, `total` y los pesos. Si `total` es 0, avisa y termina.
2. `Calculos.mejor` recorre las filas: empieza suponiendo que la mejor es la fila 0 y la compara con cada una de las demás con `globalDe`. Solo cambia de fila si encuentra una global **mayor** (`>`), así que en un empate se queda con la primera.
3. `mostrarMejor` escribe su número (la fila + 1) y la tabla: para cada categoría, el peso, las estrellas y la nota; y en la última fila, su global.

**Opción 5: crear valoraciones al azar (R7, R11)**

1. `main` llama a `crearAlAzar` con la matriz, `total` y `azar`.
2. `crearAlAzar` calcula cuántas filas quedan libres y crea 10, o las que quepan si son menos (`Math.min`). Rellena cada fila con tres notas al azar (`azar.nextInt`) y **devuelve** cuántas ha creado.
3. De vuelta en `main`, se suman a `total` (como en la opción 1, `total` solo lo cambia `main`). Si no se ha creado ninguna, avisa de que no caben más; si no, dice cuántas se han creado y cuántas hay.

**Opción 6: modificar una valoración (R12)**

1. `main` llama a `modificarValoracion` con el `Scanner`, la matriz y `total`. Si `total` es 0, avisa y termina.
2. Pide el número con `leerEntero`, con los límites 1 y `total`: así solo acepta una valoración que existe.
3. Escribe sus notas de ahora y llama a `nuevaValoracion` con su fila, `notas[numero - 1]`: la misma función que rellena una fila nueva vuelve a rellenar esta. `total` no cambia.

**Cualquier otra opción (R6):** el caso `default` del `switch` avisa, y el bucle vuelve a mostrar el menú.

**Opción 0: salir (R8):** dice que las valoraciones y los pesos no se guardan, el bucle termina porque la opción es `"0"` y `main` cierra el `Scanner`.

## 5. Decisiones de diseño

| Decisión | Por qué |
|---|---|
| Una **matriz** para las notas | Hace falta cada nota, no solo la suma, para mostrarlas separadas por comas (R4). La matriz guarda todas, cada una en su fila y su columna. |
| Un **máximo** de 30 valoraciones | Un array tiene tamaño fijo: se elige al crearlo. 30 es de sobra para una clase. |
| Una **función por trabajo** en `Principal` | `main` se lee como el menú, y cada función se entiende sola: mostrar el menú, pedir un número, y una por cada opción del menú. |
| Las cuentas, en **`Calculos`**, sin `Scanner` ni `println` | Las cuentas se pueden comprobar y cambiar sin tocar lo que se ve. Si cambia el cálculo, `Principal` no se toca. |
| Leer con **`nextLine` y `Integer.parseInt`** | Se lee siempre una línea entera. Si no es un número, la excepción se recoge y el programa vuelve a preguntar, en lugar de cerrarse (R2). |
| Las opciones del menú, como **texto** (`"1"`, `"2"`, `"0"`) | Así cualquier cosa que se escriba es una opción, válida o no, y nunca hay que convertirla a número: no hay excepciones en el menú. |
| **Redondear** con `Math.round` | El número sale siempre con un decimal y con punto (3.8), sea cual sea el idioma del sistema. |
| El resumen, como **tabla** con `printf` | Con todas las filas en el mismo formato, cada columna empieza siempre en el mismo sitio y se comparan las categorías de un vistazo. Las notas van en la última columna porque su largo cambia con el número de valoraciones. |
| La media con **`%5s`**, no con `%.1f` | `%.1f` usa el idioma del sistema: en español escribiría `4,5`. Con `%5s`, el número redondeado sale como con `println`, `4.5`. |
| Una sola función, **`leerEntero`**, para notas y pesos | Las dos preguntan lo mismo, un número entre dos límites; solo cambian los límites y la pregunta, que se le pasan como parámetros. Si se arregla algo al leer, se arregla para las dos. |
| Pesos **relativos**, del 1 al 10 | Con porcentajes que sumen 100, tres pesos iguales no se pueden escribir con enteros (34, 33 y 33). Con pesos relativos, `{1, 1, 1}` son iguales y `{2, 1, 1}`, el doble para docente. El porcentaje lo calcula el programa y se ve en la tabla. |
| La cabecera de las tablas, en **`escribirCabecera`** | Las tablas de las opciones 2 y 4 tienen la misma cabecera, salvo las dos últimas columnas, que se le pasan. Así la cabecera y su línea de `=` se escriben en un solo sitio. |
| La mejor, por la **nota global** de la valoración | Es la que resume las tres notas con los pesos que se han elegido, la misma cuenta que la global de la opción 2. |
| En un empate, **la primera** | Al comparar con `>`, una valoración igual no sustituye a la que ya se tenía. Para quedarse con la última bastaría `>=`. |
| Las valoraciones al azar, en **`Principal`** | `Calculos` hace cuentas con los datos que recibe y siempre da el mismo resultado; crear datos al azar es otra cosa. Y `crearAlAzar` necesita `MAX_VALORACIONES` y `CATEGORIAS`, que están en `Principal`. |
| **Un solo** `Random` para todo el programa | Se crea una vez en `main` y se le pasa a `crearAlAzar`, como el `Scanner`. No hace falta uno nuevo cada vez. |
| Modificar con **`nuevaValoracion`** | Modificar una valoración es volver a rellenar su fila: la misma función sirve para las dos cosas, y pide las notas igual. |
| Modificar, **solo las que existen** | El número se lee con `leerEntero` entre 1 y `total`: un número de una valoración que no existe no se acepta, y vuelve a preguntar. |
| «Opción no válida: **elige una del menú**» | Con siete opciones, escribir todos los números en el aviso sería largo, y habría que cambiarlo cada vez que se añade una. |
| Pesos desde el **1**, sin 0 | Con todos a 0, la suma de los pesos sería 0 y la global, una división entre 0. |
| Las estrellas con **`*` y `-`** | Se ven igual en cualquier terminal. Los símbolos ★ y ☆ pueden salir como `?` en la consola de Windows o en algunos IDE. El `-` marca las que faltan, para que siempre haya 5 caracteres y se vea de cuántas es. |
| Las estrellas, **enteras** | La media se redondea a un entero. Las medias estrellas (3.5 = ★★★½) necesitarían otro símbolo y más casos en el código. |
| Escala del **1 al 5** | El 0 queda para «Salir» en el menú y no se confunde con una nota. |
| Valoraciones **en memoria** | Para guardarlas al salir hay que escribirlas en un archivo, y este programa solo usa lo visto hasta ahora. |
| Valoraciones **anónimas** | Solo tres notas (R8): nada en los datos dice quién valoró. |

## 6. Configuración de librerías y dependencias

Antes de programar, cada requisito del punto 1 se convierte en lo que necesita el programa. Quien empieza sabe **qué quiere que haga**, pero no qué clases de Java hacen falta ni si hay que instalar algo. Esto se averigua siempre de la misma forma.

### 6.1 · El método, en cuatro preguntas

Para cada cosa que tiene que hacer el programa:

1. **¿Qué necesita, en palabras técnicas?** «Que se pueda escribir la nota» es *leer del teclado*; «que no se rompa con letras» es *convertir texto a número y recoger el error*.
2. **¿Lo trae ya Java?** El JDK trae miles de clases ya hechas, la **biblioteca estándar**, agrupadas en paquetes: `java.lang`, `java.util`… Su lista está en la [documentación de la API de Java 21](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/module-summary.html).
3. **¿En qué paquete está?** La página de cada clase lo dice arriba: `Scanner` está en `java.util`. Las clases de **`java.lang`** (`String`, `Math`, `Integer`, las excepciones habituales) se usan sin más; las de cualquier otro paquete necesitan un **`import`** al principio del archivo.
4. **¿Hace falta instalar algo?** Solo si la clase no está en el JDK. Entonces es una **librería externa**: un archivo `.jar` que se descarga, normalmente con una herramienta como **Maven** o **Gradle**, que lo apunta en su archivo de configuración (`pom.xml` o `build.gradle`).

### 6.2 · Las preguntas aplicadas a este programa

| Lo que se quiere (requisito) | Qué necesita | Con qué se hace | Paquete | ¿`import`? |
|---|---|---|---|---|
| Leer la opción, las notas y los pesos (R1, R2, R9) | Leer del teclado | `Scanner` | `java.util` | **Sí**: `import java.util.Scanner;` |
| Escribir el menú y las respuestas | Escribir en la terminal | `System.out.println` y `print` | `java.lang` | No |
| El resumen en columnas (R4) | Escribir con formato | `System.out.printf` | `java.lang` | No |
| Pasar «4» a 4 (R2) | Convertir texto a número | `Integer.parseInt` | `java.lang` | No |
| No cerrarse con letras (R2) | Recoger el error | `NumberFormatException` y `try-catch` | `java.lang` | No |
| Las notas con comas, los textos (R4) | Textos | `String` | `java.lang` | No |
| Una media con un decimal (R4) | Redondear | `Math.round` | `java.lang` | No |
| Guardar las notas (R4, R7) | Una tabla de números | Una matriz, `int[][]` | Es parte del lenguaje | No |
| Guardar los pesos (R9) | Una lista de números | Un array, `int[]` | Es parte del lenguaje | No |
| Notas al azar (R11) | Números al azar | `Random` | `java.util` | **Sí**: `import java.util.Random;` |
| No crear más de las que caben (R11) | La menor de dos cantidades | `Math.min` | `java.lang` | No |

Todo está en el JDK: **no hay que instalar ninguna librería**, y solo hay dos `import`: el de `Scanner` y el de `Random`.

### 6.3 · Qué versión de Java

- Esta guía está probada con **Java 21**, una versión **LTS** (*Long-Term Support*): recibe correcciones durante años, y es la que se instala en Ubuntu con `openjdk-21-jdk`.
- El programa usa el `switch` con flechas (`case "1" -> …`), que existe desde Java 14: en versiones anteriores, no compila.
- **`javac` y `java` tienen que ser de la misma versión**, o `java` más nueva: un `.class` compilado con un Java más nuevo no se ejecuta en uno más antiguo.
- **Comprobar qué hay instalado:** `java -version` y `javac -version`.
- **Si falta algo, el error lo dice:**

| Error | Lo que falta |
|---|---|
| `javac: command not found` (o `orden no encontrada`) | El JDK no está instalado: `sudo apt install openjdk-21-jdk` |
| `cannot find symbol` … `class Scanner` | El `import java.util.Scanner;` al principio de `Principal.java` |
| `UnsupportedClassVersionError` al ejecutar | Se compiló con un Java más nuevo que el que ejecuta: compila y ejecuta con la misma versión |

---

# Parte 2 · Implementación

Cada paso dice **qué se hace**, trae el **código completo** del archivo y termina con **Comprueba que…**: no pases al siguiente hasta que se cumpla.

## Paso 0 · Preparar Ubuntu, Java y VS Code

### 0.1 · Lo que hace falta

Esta guía está probada con **Java 21** en **Ubuntu 24.04**, dentro de Windows con WSL, y con **VS Code**. Cómo se instala todo, paso a paso, lo explica la guía de SI [«Ubuntu Linux, WSL, Java y VS Code»](https://github.com/mrpiay/NTFOR_DAM2627_SI/blob/main/2026_11_02-06/actividades/Ubuntu%20Linux%20WSL%20Java%20y%20VS%20Code.md). En resumen, en la terminal de Ubuntu:

```bash
sudo apt install openjdk-21-jdk
```

Si ya lo tienes instalado, pasa al 0.2.

### 0.2 · La terminal de Ubuntu y VS Code

| Zona | Dónde | Para qué |
|---|---|---|
| **Terminal de Ubuntu** | En Windows, **Ubuntu** desde el menú Inicio | Crear la carpeta del proyecto y abrir VS Code con `code .` |
| **Explorador** de VS Code | Panel de la izquierda (`Ctrl + Mayús + E`) | Los archivos del proyecto. Un clic abre un archivo; con clic derecho sobre una carpeta, se crean archivos dentro |
| **Editor** | En el centro | Donde se escribe el código. Cada archivo abierto es una pestaña |
| **Terminal** de VS Code | Abajo: `Ctrl + ñ` | La misma terminal de Ubuntu, ya en la carpeta del proyecto. Ahí se compila y se ejecuta |
| **Indicador de WSL** | Abajo a la izquierda | Tiene que poner **WSL: Ubuntu-24.04**: así VS Code trabaja con los archivos y el Java de Ubuntu |

**Comprueba que…** en la terminal de Ubuntu, `javac -version` muestra `javac 21` y algo más, y `java -version`, `openjdk version "21` y algo más.

## Paso 1 · Crear el proyecto

En la terminal de Ubuntu, una línea cada vez:

```bash
mkdir -p ~/dam2627/prog/ValoraPROG/src/dam
cd ~/dam2627/prog/ValoraPROG
code .
```

| Comando | Qué hace |
|---|---|
| `mkdir -p ~/dam2627/prog/ValoraPROG/src/dam` | Crea la carpeta del proyecto y, dentro, `src/dam`: `src` para el código fuente y `dam` para el paquete. `-p` crea todas las carpetas del camino que falten. `~` es tu carpeta personal de Linux |
| `cd ~/dam2627/prog/ValoraPROG` | Entra en la carpeta del proyecto. Todos los comandos de la guía se escriben desde aquí |
| `code .` | Abre VS Code con la carpeta actual (`.`) |

**El árbol de archivos.** Así queda la carpeta al terminar la guía, en el Explorador de VS Code. Lo marcado como **NUEVO** lo creas tú en el paso que se indica.

```
VALORAPROG
├── bin                         la crea javac al compilar (paso 2) · no se toca
│   └── dam
│       ├── Calculos.class
│       └── Principal.class
└── src                         ya existe (paso 1)
    └── dam                     ya existe (paso 1)
        ├── Calculos.java       NUEVO · paso 2
        └── Principal.java      NUEVO · paso 3
```

**Cómo se crea un archivo** (pasos 2 y 3): en el Explorador de VS Code, abre `src` con su flecha, haz clic derecho sobre la carpeta **`dam`** → **New File…**, escribe el nombre **con** su extensión (por ejemplo, `Calculos.java`) y pulsa **Intro**. Se abre vacío a la derecha: pega el código de la guía y guarda con **Ctrl + S**.

**Comprueba que…** VS Code muestra la carpeta `VALORAPROG` con `src/dam` dentro, y abajo a la izquierda pone **WSL: Ubuntu-24.04**.

## Paso 2 · Los cálculos

`Calculos` hace todas las cuentas del programa. No lee del teclado ni escribe nada: cada función recibe datos y devuelve un resultado.

Crea el archivo **`Calculos.java`**, en `src/dam`:

**Las piezas del código:**

| Pieza | Qué hace |
|---|---|
| `package dam;` | La primera línea: la clase pertenece al paquete `dam`. Por eso el archivo está en la carpeta `src/dam` |
| `/** … */` y `// …` | **Comentarios**: textos para quien lee el código. Java no los ejecuta |
| `public class Calculos` | La clase. El archivo tiene que llamarse igual: `Calculos.java` |
| `public static final int NOTA_MINIMA = 1;` | Una **constante**: `final` impide cambiarla después |
| `public static boolean estaEntre(int numero, int minimo, int maximo)` | Una función: `boolean` es el tipo de lo que devuelve (`true` o `false`), `estaEntre` su nombre, y `numero`, `minimo` y `maximo`, sus tres parámetros |
| `return numero >= minimo && numero <= maximo;` | Devuelve `true` solo si se cumplen las dos condiciones (`&&`) |
| `int[][] notas` | Un parámetro que es una **matriz** de enteros |
| `notas[fila][categoria]` | La nota de esa fila (valoración) y esa columna (categoría) |
| `String texto = "";` y `texto += …` | Un texto que empieza vacío y al que se le van añadiendo cosas al final. Con `+=`, un número se añade como texto: `"4, " + 5` da `"4, 5"` |
| `(double) suma / total` | `(double)` convierte la suma en decimal **antes** de dividir. Entre dos `int`, Java hace una división entera: `7 / 2` da `3`; `(double) 7 / 2` da `3.5` |
| `pesos.length` | El tamaño del array de pesos: el número de categorías |
| `100.0 * pesos[categoria] / sumaPesos(pesos)` | El porcentaje: con `100.0`, decimal, la división no es entera. Con pesos 1, 1 y 1, da 33.33… |
| `media(…) * pesos[categoria]` | En la global, cada media se multiplica por su peso antes de sumar. Una función de `Calculos` puede usar otra de la misma clase sin escribir `Calculos.` delante |
| `Math.round(numero * 10) / 10.0` | Redondea a un decimal: 3.833 · 10 = 38.33, redondeado 38, entre 10.0 da 3.8. Dividir entre `10.0`, y no entre `10`, hace que el resultado sea decimal |
| `(int) Math.round(redondear(media))` | El número de estrellas: la media redondeada a un entero. `Math.round` devuelve un `long` (un entero más grande) y `(int)` lo convierte en `int`. Antes se redondea a un decimal, como se muestra, para que las estrellas coincidan con el número que se ve |
| `if (estrella <= llenas) { … } else { … }` | Para cada una de las 5 posiciones, añade un `*` si es de las llenas y un `-` si no |
| `globalDe(int[] fila, int[] pesos)` | La global de una sola valoración: recibe una fila de la matriz, que es un array con sus tres notas |
| `int mejorFila = 0;` y `if (… > …) { mejorFila = fila; }` | El patrón para buscar el máximo: se supone que es el primero y se compara con cada uno de los demás; si alguno es mayor, pasa a ser el mejor |

```java
package dam;

/**
 * Los cálculos de ValoraPROG.
 * Aquí no hay Scanner ni println: solo cuentas. Las usa Principal.
 *
 * Las notas están en una matriz: una fila por valoración y una columna por categoría.
 * Solo cuentan las primeras «total» filas: las demás aún están vacías.
 * Los pesos están en un array: uno por categoría, en el mismo orden que las columnas.
 */
public class Calculos {

    // ── Los límites: las notas van de 1 a 5, y los pesos, de 1 a 10 ──────
    public static final int NOTA_MINIMA = 1;
    public static final int NOTA_MAXIMA = 5;
    public static final int PESO_MINIMO = 1;
    public static final int PESO_MAXIMO = 10;

    // ¿Está el número entre minimo y maximo, los dos incluidos?
    public static boolean estaEntre(int numero, int minimo, int maximo) {
        return numero >= minimo && numero <= maximo;
    }

    // ── Las notas de una categoría, como texto: "4, 5, 3" ────────────────
    public static String unir(int[][] notas, int total, int categoria) {
        String texto = "";
        for (int fila = 0; fila < total; fila++) {
            if (fila > 0) {
                texto += ", ";      // la coma va antes de cada nota, menos de la primera
            }
            texto += notas[fila][categoria];
        }
        return texto;
    }

    // ── Las medias ───────────────────────────────────────────────────────
    // La media de una categoría: la suma de su columna entre el número de valoraciones.
    // (double) evita la división entera: 7 / 2 da 3, pero (double) 7 / 2 da 3.5
    public static double media(int[][] notas, int total, int categoria) {
        int suma = 0;
        for (int fila = 0; fila < total; fila++) {
            suma += notas[fila][categoria];
        }
        return (double) suma / total;
    }

    // ── Los pesos ────────────────────────────────────────────────────────
    // La suma de todos los pesos
    public static int sumaPesos(int[] pesos) {
        int suma = 0;
        for (int categoria = 0; categoria < pesos.length; categoria++) {
            suma += pesos[categoria];
        }
        return suma;
    }

    // Lo que cuenta una categoría en la valoración global, en porcentaje:
    // con pesos 2, 1 y 1, la primera cuenta el 50 % (2 de 4) y cada una de las otras, el 25 %
    public static double porcentaje(int[] pesos, int categoria) {
        return 100.0 * pesos[categoria] / sumaPesos(pesos);
    }

    // La valoración global, ponderada: cada media multiplicada por su peso, todo sumado,
    // y dividido entre la suma de los pesos.
    // Con todos los pesos iguales, es la media de las medias
    public static double global(int[][] notas, int total, int[] pesos) {
        double sumaPonderada = 0;
        for (int categoria = 0; categoria < pesos.length; categoria++) {
            sumaPonderada += media(notas, total, categoria) * pesos[categoria];
        }
        return sumaPonderada / sumaPesos(pesos);
    }

    // ── La mejor valoración ──────────────────────────────────────────────
    // La nota global de una sola valoración: sus notas, ponderadas con los pesos.
    // fila es una fila de la matriz: las notas de esa valoración
    public static double globalDe(int[] fila, int[] pesos) {
        int sumaPonderada = 0;
        for (int categoria = 0; categoria < pesos.length; categoria++) {
            sumaPonderada += fila[categoria] * pesos[categoria];
        }
        return (double) sumaPonderada / sumaPesos(pesos);
    }

    // La fila de la mejor valoración: la de nota global más alta.
    // Empieza suponiendo que es la primera (fila 0) y la compara con cada una de las demás.
    // Si hay empate, se queda con la primera: solo cambia con una mayor (>), no con una igual
    public static int mejor(int[][] notas, int total, int[] pesos) {
        int mejorFila = 0;
        for (int fila = 1; fila < total; fila++) {
            if (globalDe(notas[fila], pesos) > globalDe(notas[mejorFila], pesos)) {
                mejorFila = fila;
            }
        }
        return mejorFila;
    }

    // ── Redondear para mostrar ───────────────────────────────────────────
    // Redondea a un decimal: 3.8333 → 3.8, y 3.85 → 3.9
    public static double redondear(double numero) {
        return Math.round(numero * 10) / 10.0;
    }

    // ── Las estrellas: la media, de un vistazo ───────────────────────────
    // Un * por cada estrella y un - por cada una que falta, hasta 5: 3.8 → "****-"
    // Las estrellas son la media redondeada a un entero: 4.5 → 5, 3.8 → 4, 2.0 → 2.
    // Antes se redondea a un decimal, como se muestra, para que las estrellas
    // y el número coincidan: 4.46 se muestra 4.5, y da 5 estrellas, no 4
    public static String estrellas(double media) {
        int llenas = (int) Math.round(redondear(media));   // Math.round devuelve un long: (int) lo pasa a int
        String texto = "";
        for (int estrella = NOTA_MINIMA; estrella <= NOTA_MAXIMA; estrella++) {
            if (estrella <= llenas) {
                texto += "*";
            } else {
                texto += "-";
            }
        }
        return texto;
    }
}
```

En la terminal de VS Code (`Ctrl + ñ`), compila:

```bash
javac -d bin src/dam/*.java
```

**Comprueba que…** `javac` no muestra nada (sin mensajes, no hay errores) y ha aparecido la carpeta `bin`, con `bin/dam/Calculos.class` dentro. Si sale un error, dice el archivo y la línea: compáralos con el código de la guía.

**Comprueba que lo entiendes.** Contesta antes de abrir las respuestas:

1. ¿Qué devuelven `estaEntre(0, 1, 5)`, `estaEntre(5, 1, 5)` y `estaEntre(6, 1, 5)`?
2. Con las notas de docente 4, 5 y 3 (y `total` 3), ¿qué devuelven `unir(notas, 3, 0)` y `media(notas, 3, 0)`?
3. Si en `media` se quitara `(double)`, ¿cuánto daría la media de 4 y 5?
4. ¿Qué devuelven `estrellas(4.5)`, `estrellas(2.2)` y `estrellas(1.0)`?
5. Con los pesos `{3, 1, 1}`, ¿qué devuelve `porcentaje(pesos, 0)`? Si las medias son 5.0, 2.0 y 2.0, ¿qué devuelve `global`?
6. Con los pesos `{1, 1, 1}` y dos valoraciones, (5, 1, 3) y (3, 3, 3), ¿qué devuelve `mejor`? ¿Y si la comparación fuera `>=`?

<details>
<summary>Respuestas</summary>

1. `false`, `true` y `false`: solo valen del 1 al 5, los dos incluidos.
2. `"4, 5, 3"` y `4.0`: (4 + 5 + 3) / 3 = 12 / 3.
3. `4.0`: 9 / 2 entre dos `int` es una división entera y da 4; después se convierte en `4.0` para devolverlo. Con `(double)`, da 4.5.
4. `"*****"`, `"**---"` y `"*----"`: 4.5 se redondea a 5, 2.2 a 2 y 1.0 se queda en 1.
5. `60.0`: 3 de 5 (la suma de los pesos) son el 60 %. La global, `3.8`: (5.0 · 3 + 2.0 · 1 + 2.0 · 1) / (3 + 1 + 1) = 19 / 5. Sin pesos, la media de las medias daría 3.0: docente, con más peso, la sube.
6. `0`: las dos tienen global 3.0, y con `>` la fila 1 no sustituye a la fila 0. Con `>=`, devolvería `1`, la última de las empatadas.

</details>

## Paso 3 · El programa principal

`Principal` es lo que se ve: el menú, las preguntas y las respuestas. Lee con `Scanner`, escribe con `println` y pide las cuentas a `Calculos`. Cada trabajo está en su propia función, y `main` solo lleva el menú.

Crea el archivo **`Principal.java`**, en `src/dam`:

**Las piezas del código:**

| Pieza | Qué hace |
|---|---|
| `import java.util.Random;` y `import java.util.Scanner;` | Traen las clases `Random` y `Scanner`, que están en el paquete `java.util` |
| `static final String[] CATEGORIAS = {…};` | Un array constante con los nombres de las categorías. Su posición es la columna de la matriz: `"Docente"` es la columna 0 |
| `public static void main(String[] args)` | Donde empieza el programa. `void` quiere decir que no devuelve nada |
| `Scanner teclado = new Scanner(System.in);` | Crea el lector del teclado (`System.in`) |
| `new int[MAX_VALORACIONES][CATEGORIAS.length]` | Crea la matriz de 30 filas y 3 columnas. Un array de `int` empieza con todo a 0 |
| `do { … } while (!opcion.equals("0"));` | Un bucle que se ejecuta **al menos una vez** y se repite mientras la opción no sea `"0"`. Los textos se comparan con `equals`, no con `==` |
| `teclado.nextLine().trim()` | Lee una línea entera y le quita los espacios de los extremos: `" 1 "` queda en `"1"` |
| `switch (opcion) { case "1" -> … }` | Elige según el valor de `opcion`. Con flechas, cada caso hace solo lo suyo, sin `break`. `default` es para cualquier otro valor |
| `nuevaValoracion(teclado, notas[total])` | Le pasa a la función el `Scanner` y la primera fila libre de la matriz. `notas[total]` es un array: la fila entera |
| `total++;` | Suma 1 a `total` |
| `static void nuevaValoracion(Scanner teclado, int[] fila)` | Rellena la fila que recibe. Como la fila es un array, lo que se guarda en ella queda en la matriz de `main` |
| `static int leerEntero(Scanner teclado, String pregunta, int minimo, int maximo)` | Pregunta hasta que el número está entre `minimo` y `maximo` y lo **devuelve** (`return numero;`). Con 1 y 5 lee notas; con 1 y 10, pesos |
| `while (!Calculos.estaEntre(numero, minimo, maximo))` | Repite mientras el número **no** (`!`) esté entre los límites. `numero` empieza en `minimo - 1`, fuera de los límites, así que pregunta al menos una vez |
| `int[] pesos = {1, 1, 1};` | Crea el array de pesos con sus tres valores. Tiene que tener tantos como `CATEGORIAS` |
| `static void cambiarPesos(Scanner teclado, int[] pesos)` | Rellena el array que recibe, como `nuevaValoracion` con la fila: el cambio queda en el array de `main` |
| `Random azar = new Random();` | Crea el generador de números al azar. Uno para todo el programa |
| `azar.nextInt(Calculos.NOTA_MINIMA, Calculos.NOTA_MAXIMA + 1)` | Un entero al azar desde el primero hasta el segundo **sin incluirlo**: por eso `+ 1`, para que el 5 pueda salir |
| `Math.min(AL_AZAR, libres)` | La menor de las dos cantidades: 10, o las filas que quedan libres si son menos |
| `total += creadas;` | Suma a `total` lo que devuelve `crearAlAzar`. Como en la opción 1, `total` solo lo cambia `main` |
| `leerEntero(teclado, "Número de la valoración", 1, total)` | Solo acepta del 1 al número de valoraciones que hay: una que existe |
| `notas[numero - 1]` | La fila de la valoración n.º `numero`: las filas empiezan en 0 |
| `static void escribirCabecera(String columna4, String columna5)` | Escribe la cabecera de una tabla con las dos últimas columnas que recibe, y su línea de `=`. La usan las opciones 2 y 4 |
| `try { … } catch (NumberFormatException e) { … }` | Si `Integer.parseInt` recibe algo que no es un número, lanza esa excepción, y el `catch` la recoge en lugar de cerrar el programa |
| `Calculos.media(notas, total, categoria)` | Llama a una función de otra clase: el nombre de la clase, un punto y la función |
| `return;` en `mostrarResumen` | Termina la función ahí mismo: si no hay valoraciones, no sigue |
| `static final String FILA = "  %-12s %6s  %-10s %5s  %s%n";` | El formato de cada fila de la tabla. Cada `%…s` es un hueco para un dato: `%-12s` lo escribe en 12 caracteres, pegado a la izquierda (el `-`), y rellena con espacios; `%6s`, en 6, pegado a la derecha; `%s`, tal cual. `%n` es el salto de línea |
| `System.out.printf(FILA, "Docente", "33.3%", "****-", 4.0, "4")` | Escribe el formato cambiando cada hueco por un dato, en orden. Como todas las filas usan `FILA`, las columnas quedan alineadas |
| `String cabecera = String.format(FILA, …);` | Hace lo mismo que `printf`, pero en lugar de escribir el texto, lo **devuelve**: así se puede escribir y, además, medir |
| `"=".repeat(cabecera.trim().length())` | La línea de debajo de la cabecera: `repeat` repite el texto `"="` tantas veces como se le diga. `trim()` quita los espacios del principio y el salto de línea del final, y `length()` da cuántos caracteres quedan: la línea mide lo mismo que el texto de la cabecera |

```java
package dam;

import java.util.Random;
import java.util.Scanner;

/**
 * ValoraPROG: valoraciones anónimas de docente, materiales y clases, con un menú en la terminal.
 * Las valoraciones y los pesos se guardan en memoria: al salir del programa, se pierden.
 */
public class Principal {

    // Las categorías que se valoran: una columna de la matriz de notas para cada una
    static final String[] CATEGORIAS = {"Docente", "Materiales", "Clases"};

    // Cuántas valoraciones caben como máximo: el número de filas de la matriz
    static final int MAX_VALORACIONES = 30;

    // Cuántas valoraciones crea de una vez la opción 5
    static final int AL_AZAR = 10;

    // El formato de cada fila del resumen, para que las columnas queden alineadas como en una tabla:
    // %-12s, un texto en 12 caracteres pegado a la izquierda; %6s, en 6 pegado a la derecha;
    // %s, el texto tal cual; %n, el salto de línea.
    // Los números van con %s, no con %.1f: así salen con punto (4.5), como con println,
    // y no con coma (4,5) si el sistema está en español
    static final String FILA = "  %-12s %6s  %-10s %5s  %s%n";

    // ── El programa: el menú, que se repite hasta elegir 0 ───────────────
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Una fila por valoración y una columna por categoría:
        // notas[0][1] es la nota de «Materiales» (columna 1) de la primera valoración (fila 0)
        int[][] notas = new int[MAX_VALORACIONES][CATEGORIAS.length];
        int total = 0;      // cuántas valoraciones hay: las filas ya rellenas

        // Un peso por categoría, en el mismo orden que CATEGORIAS. Al empezar, todas cuentan lo mismo
        int[] pesos = {1, 1, 1};

        // El generador de números al azar de la opción 5: uno para todo el programa
        Random azar = new Random();

        String opcion;
        do {
            mostrarMenu();
            opcion = teclado.nextLine().trim();     // trim quita los espacios de los extremos
            System.out.println();                   // una línea en blanco entre el menú y la respuesta

            switch (opcion) {
                case "1" -> {
                    if (total == MAX_VALORACIONES) {
                        System.out.println("No caben más valoraciones: el máximo es " + MAX_VALORACIONES + ".");
                    } else {
                        nuevaValoracion(teclado, notas[total]);    // rellena la primera fila libre
                        total++;                                   // total es un int: se cambia aquí, en main
                        System.out.println("Valoración guardada (" + total + " en total).");
                    }
                }
                case "2" -> mostrarResumen(notas, total, pesos);
                case "3" -> cambiarPesos(teclado, pesos);
                case "4" -> mostrarMejor(notas, total, pesos);
                case "5" -> {
                    int creadas = crearAlAzar(notas, total, azar);
                    total += creadas;                              // como en la opción 1: total se cambia en main
                    if (creadas == 0) {
                        System.out.println("No caben más valoraciones: el máximo es " + MAX_VALORACIONES + ".");
                    } else {
                        System.out.println(creadas + " valoraciones creadas al azar (" + total + " en total).");
                    }
                }
                case "6" -> modificarValoracion(teclado, notas, total);
                case "0" -> System.out.println("Hasta pronto. Las valoraciones y los pesos no se guardan al salir.");
                default -> System.out.println("Opción no válida: elige una del menú.");
            }
        } while (!opcion.equals("0"));

        teclado.close();
    }

    // ── El menú ──────────────────────────────────────────────────────────
    static void mostrarMenu() {
        System.out.println();
        System.out.println("=== ValoraPROG ===");
        System.out.println("1. Nueva valoración");
        System.out.println("2. Ver valoración global");
        System.out.println("3. Cambiar pesos");
        System.out.println("4. Ver la mejor valoración");
        System.out.println("5. Crear " + AL_AZAR + " valoraciones al azar");
        System.out.println("6. Modificar una valoración");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    // ── Leer un número ───────────────────────────────────────────────────
    // Pregunta hasta que se escribe un número entero entre minimo y maximo, y lo devuelve.
    // Sirve para las notas (del 1 al 5) y para los pesos (del 1 al 10)
    static int leerEntero(Scanner teclado, String pregunta, int minimo, int maximo) {
        int numero = minimo - 1;    // empieza fuera del rango: así pregunta al menos una vez
        while (!Calculos.estaEntre(numero, minimo, maximo)) {
            System.out.print(pregunta + " (" + minimo + "-" + maximo + "): ");
            try {
                numero = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                numero = minimo - 1;    // no es un número: se trata como uno fuera del rango
            }
            if (!Calculos.estaEntre(numero, minimo, maximo)) {
                System.out.println("  Escribe un número del " + minimo + " al " + maximo + ".");
            }
        }
        return numero;
    }

    // ── 1. Nueva valoración ──────────────────────────────────────────────
    // Pide una nota por categoría y la guarda en la fila que recibe.
    // La fila es un array y se recibe por referencia: lo que se guarda aquí, queda en la matriz de main
    static void nuevaValoracion(Scanner teclado, int[] fila) {
        for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
            fila[categoria] = leerEntero(teclado, CATEGORIAS[categoria], Calculos.NOTA_MINIMA, Calculos.NOTA_MAXIMA);
        }
    }

    // ── Las tablas ───────────────────────────────────────────────────────
    // La cabecera de una tabla, y debajo una línea de = tan larga como su texto.
    // Las tres primeras columnas son siempre las mismas; las dos últimas, las que se le pasan.
    // String.format hace lo mismo que printf, pero devuelve el texto en lugar de escribirlo;
    // trim le quita los espacios del principio y el salto de línea del final
    static void escribirCabecera(String columna4, String columna5) {
        String cabecera = String.format(FILA, "Categoría", "Peso", "Estrellas", columna4, columna5);
        System.out.print(cabecera);
        System.out.println("  " + "=".repeat(cabecera.trim().length()));
    }

    // El peso de una categoría, en porcentaje y como texto: "33.3%"
    static String peso(int[] pesos, int categoria) {
        return Calculos.redondear(Calculos.porcentaje(pesos, categoria)) + "%";
    }

    // ── 2. Ver valoración global ─────────────────────────────────────────
    // Las cuentas las hace Calculos; aquí solo se muestran
    static void mostrarResumen(int[][] notas, int total, int[] pesos) {
        if (total == 0) {
            System.out.println("Aún no hay valoraciones.");
            return;
        }
        System.out.println("Valoraciones: " + total);
        System.out.println();
        escribirCabecera("Media", "Notas");
        for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
            double media = Calculos.media(notas, total, categoria);
            System.out.printf(FILA, CATEGORIAS[categoria], peso(pesos, categoria), Calculos.estrellas(media),
                    Calculos.redondear(media), Calculos.unir(notas, total, categoria));
        }
        double global = Calculos.global(notas, total, pesos);
        System.out.printf(FILA, "Global", "", Calculos.estrellas(global), Calculos.redondear(global), "");
    }

    // ── 3. Cambiar los pesos ─────────────────────────────────────────────
    // Muestra los pesos de ahora y pide uno nuevo, del 1 al 10, para cada categoría.
    // Como la fila en nuevaValoracion, pesos es un array: lo que se cambia aquí, queda en el de main
    static void cambiarPesos(Scanner teclado, int[] pesos) {
        System.out.println("Cuánto cuenta cada categoría en la valoración global. Pesos de ahora:");
        for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
            System.out.println("  " + CATEGORIAS[categoria] + ": " + pesos[categoria]);
        }
        for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
            pesos[categoria] = leerEntero(teclado, "Peso de " + CATEGORIAS[categoria],
                    Calculos.PESO_MINIMO, Calculos.PESO_MAXIMO);
        }
        System.out.println("Pesos guardados.");
    }

    // ── 4. Ver la mejor valoración ───────────────────────────────────────
    // La de nota global más alta, con los pesos de ahora. Si hay empate, la primera
    static void mostrarMejor(int[][] notas, int total, int[] pesos) {
        if (total == 0) {
            System.out.println("Aún no hay valoraciones.");
            return;
        }
        int mejor = Calculos.mejor(notas, total, pesos);
        int[] fila = notas[mejor];
        // Las filas empiezan en 0, y las valoraciones se cuentan desde 1: la fila 0 es la n.º 1
        System.out.println("Mejor valoración: n.º " + (mejor + 1) + " de " + total);
        System.out.println();
        escribirCabecera("Nota", "");
        for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
            System.out.printf(FILA, CATEGORIAS[categoria], peso(pesos, categoria),
                    Calculos.estrellas(fila[categoria]), fila[categoria], "");
        }
        double global = Calculos.globalDe(fila, pesos);
        System.out.printf(FILA, "Global", "", Calculos.estrellas(global), Calculos.redondear(global), "");
    }

    // ── 5. Crear valoraciones al azar ────────────────────────────────────
    // Rellena hasta AL_AZAR filas libres con notas al azar, sin pasar del máximo,
    // y devuelve cuántas ha creado: main las suma a total, porque total es un int.
    // Sirve para probar el programa con muchos datos sin escribirlos
    static int crearAlAzar(int[][] notas, int total, Random azar) {
        int libres = MAX_VALORACIONES - total;
        int crear = Math.min(AL_AZAR, libres);      // la menor de las dos: 10, o las que quepan
        for (int i = 0; i < crear; i++) {
            int[] fila = notas[total + i];          // la siguiente fila libre
            for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
                // nextInt(desde, hasta) da un entero al azar desde «desde» hasta «hasta» SIN incluirlo:
                // por eso NOTA_MAXIMA + 1, para que el 5 pueda salir
                fila[categoria] = azar.nextInt(Calculos.NOTA_MINIMA, Calculos.NOTA_MAXIMA + 1);
            }
        }
        return crear;
    }

    // ── 6. Modificar una valoración ──────────────────────────────────────
    // Solo una que ya existe: se pide su número, del 1 a total. Muestra sus notas y las vuelve a pedir.
    // La valoración n.º X está en la fila X - 1, y se rellena con nuevaValoracion, igual que una nueva.
    // total no cambia: no se añade ninguna
    static void modificarValoracion(Scanner teclado, int[][] notas, int total) {
        if (total == 0) {
            System.out.println("Aún no hay valoraciones.");
            return;
        }
        int numero = leerEntero(teclado, "Número de la valoración", 1, total);
        int[] fila = notas[numero - 1];
        System.out.println("Notas de ahora de la n.º " + numero + ":");
        for (int categoria = 0; categoria < CATEGORIAS.length; categoria++) {
            System.out.println("  " + CATEGORIAS[categoria] + ": " + fila[categoria]);
        }
        nuevaValoracion(teclado, fila);
        System.out.println("Valoración n.º " + numero + " modificada.");
    }
}
```

**Comprueba que…** `javac -d bin src/dam/*.java` no muestra nada y en `bin/dam` están `Calculos.class` y `Principal.class`.

**Comprueba que lo entiendes.** Contesta antes de abrir las respuestas:

1. ¿Por qué `total++` está en `main` y no dentro de `nuevaValoracion`?
2. Si se escribe `siete` cuando pide la nota de docente, ¿qué líneas del código se ejecutan, y qué sale en la pantalla?
3. ¿Qué pasa si se elige la opción `7`?
4. ¿Por qué `cambiarPesos` puede cambiar los pesos de `main` sin devolver nada?
5. ¿Por qué `crearAlAzar` devuelve un `int` y `nuevaValoracion` no devuelve nada?
6. Con 3 valoraciones, se elige la opción 6 y se escribe `4`. ¿Qué pasa?

<details>
<summary>Respuestas</summary>

1. Porque `total` es un `int`: si se le pasara a una función, la función recibiría una copia y, al sumarle 1, `total` no cambiaría en `main`. La fila sí se puede rellenar dentro de `nuevaValoracion`, porque es un array: la función y `main` apuntan a la misma fila.
2. `Integer.parseInt("siete")` lanza `NumberFormatException`; el `catch` pone `numero = 0` (`minimo - 1`); como 0 no está entre 1 y 5, se escribe «Escribe un número del 1 al 5.» y el `while` vuelve a preguntar «Docente (1-5):».
3. No coincide con ningún `case`, así que se ejecuta `default`: «Opción no válida: elige una del menú.». Como no es `"0"`, el bucle vuelve a mostrar el menú.
4. Porque `pesos` es un array: `cambiarPesos` recibe una copia de la referencia, que apunta al mismo array que el de `main`. Lo que guarda en `pesos[categoria]` se ve en `main`, igual que la fila en `nuevaValoracion`.
5. Las dos rellenan filas de la matriz, que se ven en `main`. Pero `crearAlAzar` además cambia cuántas hay, y `total` es un `int`: no lo puede cambiar, así que devuelve cuántas ha creado y `main` las suma. `nuevaValoracion` siempre rellena una, y `main` suma 1 con `total++`.
6. `leerEntero` se llamó con los límites 1 y 3: el 4 no está entre ellos, así que avisa «Escribe un número del 1 al 3.» y vuelve a preguntar. La valoración 4 no existe, y no se puede modificar.

</details>

## Paso 4 · Compilar y ejecutar

Siempre desde la carpeta del proyecto (`~/dam2627/prog/ValoraPROG`), en la terminal de VS Code:

```bash
javac -d bin src/dam/*.java
java -cp bin dam.Principal
```

| Comando | Qué hace |
|---|---|
| `javac -d bin src/dam/*.java` | Compila todos los `.java` de `src/dam`. **`-d bin`** es la carpeta de destino de los `.class`: si no existe, la crea, y dentro crea `bin/dam`, como el paquete |
| `java -cp bin dam.Principal` | Ejecuta el programa. **`-cp bin`** dice dónde buscar las clases, y la clase se escribe con su paquete, con punto: Java busca `dam.Principal` en `bin/dam/Principal.class` |

Cada vez que cambies un `.java`, **vuelve a compilar** antes de ejecutar: `java` ejecuta los `.class`, no los `.java`.

**Comprueba que…** sale el menú «=== ValoraPROG ===» y, al escribir `0` e **Intro**, el programa se despide y termina.

## Paso 5 · Probar el programa

Un programa se prueba con **casos de prueba**: una entrada preparada y la salida que se espera. Hay que probar los casos **normales**, los **límites** (el primero, el último, el vacío) y los **erróneos** (letras donde va un número, una opción que no existe).

**5.1 · Los casos de prueba.** Ejecuta el programa y hazlos en orden:

| N.º | Tipo | Entrada | Resultado esperado |
|---|---|---|---|
| 1 | Límite: vacío | `2` | «Aún no hay valoraciones.» |
| 2 | Normal | `1`, y las notas `4`, `3` y `5` | «Valoración guardada (1 en total).» |
| 3 | Normal | `2` | «Valoraciones: 1» y la tabla con las columnas alineadas, con 33.3% de peso en las tres categorías: Docente `****-` 4.0 y 4; Materiales `***--` 3.0 y 3; Clases `*****` 5.0 y 5; Global `****-` 4.0 |
| 4 | Erróneo: letras | `1`, docente `5`, materiales `siete` | «Escribe un número del 1 al 5.» y vuelve a preguntar «Materiales (1-5):» |
| 5 | Erróneo: fuera de rango | Materiales `0` y después `6` | Las dos veces, «Escribe un número del 1 al 5.» |
| 6 | Límite: 1 y 5 | Materiales `1` y clases `5` | «Valoración guardada (2 en total).»: el 1 y el 5, las notas de los extremos, se aceptan |
| 7 | Normal | `2` | «Valoraciones: 2» y la tabla: Docente `*****` 4.5 y 4, 5; Materiales `**---` 2.0 y 3, 1; Clases `*****` 5.0 y 5, 5; Global `****-` 3.8. 4.5 se redondea a 5 estrellas y 3.8, a 4 |
| 8 | Pesos | `3`, y los pesos `0`, `11`, `2`, `1` y `1` | Muestra los pesos de ahora (1, 1 y 1). Con el `0` y el `11`, «Escribe un número del 1 al 10.»; después, «Pesos guardados.» |
| 9 | Normal | `2` | La tabla, con pesos 50.0%, 25.0% y 25.0%, y «Global» `****-` 4.0: (4.5 · 2 + 2.0 + 5.0) / 4 = 4.0 |
| 10 | Normal | `4` | «Mejor valoración: n.º 1 de 2» y su tabla: Docente 4, Materiales 3, Clases 5, Global 4.0. Las dos valoraciones tienen global 4.0, y en el empate sale la primera |
| 11 | Límite: no existe | `6`, y el número `3` | «Escribe un número del 1 al 2.» y vuelve a preguntar: la 3 no existe |
| 12 | Normal | El número `2`, y las notas `2`, `2` y `2` | Muestra las notas de ahora de la n.º 2 (5, 1 y 5) y, después, «Valoración n.º 2 modificada.» |
| 13 | Normal | `4` | «Mejor valoración: n.º 1 de 2»: ahora la 2 tiene global 2.0 |
| 14 | Normal | `5` | «10 valoraciones creadas al azar (12 en total).» |
| 15 | Erróneo: opción | `7`, y después `hola` | Las dos veces, «Opción no válida: elige una del menú.» y el menú otra vez |
| 16 | Salir | `0` | «Hasta pronto. Las valoraciones y los pesos no se guardan al salir.» y el programa termina |

**5.2 · Probar sin teclear.** Se le puede dar al programa todo lo que se escribiría, de una vez, con la orden `printf` de la terminal (no es el `printf` de Java, aunque se llame igual) y una tubería (`|`): `printf` escribe el texto, `\n` es cada **Intro**, y `|` se lo pasa a `java` como si se tecleara. Así se repite una prueba larga en un segundo. Por ejemplo, los casos 2 y 3, y salir:

```bash
printf "1\n4\n3\n5\n2\n0\n" | java -cp bin dam.Principal
```

Y el límite de 30 valoraciones (R7 y R11): tres veces la opción 5 llenan la matriz; después, otra vez la 5 y una vez la 1, y se sale:

```bash
printf "5\n5\n5\n5\n1\n0\n" | java -cp bin dam.Principal | grep -E "creadas|No caben"
```

`grep -E` muestra solo las líneas que contienen «creadas» o («|») «No caben»: tienen que salir tres «10 valoraciones creadas al azar», con 10, 20 y 30 en total, y dos «No caben más valoraciones: el máximo es 30.».

**Comprueba que…** los dieciséis casos de 5.1 dan el resultado esperado y las dos órdenes de 5.2 muestran lo que se indica.

---

## Si algo falla

| Qué pasa | Qué hacer |
|---|---|
| `javac: command not found` o `java: command not found` | Falta el JDK: `sudo apt install openjdk-21-jdk` (paso 0) |
| `error: class Principal is public, should be declared in a file named Principal.java` | El archivo no se llama como la clase. Cámbiale el nombre en el Explorador de VS Code (clic derecho → *Rename*) |
| `error: cannot find symbol` | Un nombre mal escrito: Java distingue mayúsculas de minúsculas (`calculos` no es `Calculos`). El mensaje dice el archivo, la línea y el nombre que no encuentra |
| `error: ';' expected` u otro error de sintaxis | Falta un `;`, una llave o un paréntesis en la línea que dice el mensaje, o en la anterior |
| `Error: Could not find or load main class dam.Principal` | Se ha ejecutado desde otra carpeta, o sin compilar antes. Comprueba que estás en `~/dam2627/prog/ValoraPROG` (`pwd`) y que existe `bin/dam/Principal.class`. La clase se escribe con su paquete: `dam.Principal` |
| Los cambios del código no se notan al ejecutar | Falta volver a compilar: `javac -d bin src/dam/*.java` |
| `javac` no encuentra los archivos (`file not found: src/dam/*.java`) | No estás en la carpeta del proyecto, o los `.java` no están en `src/dam`. Compruébalo con `pwd` y `ls src/dam` |
| Abajo a la izquierda de VS Code no pone **WSL: Ubuntu-24.04** | VS Code está trabajando con los archivos como si fueran de Windows. Ciérralo y vuelve a abrirlo con `code .` desde la terminal de Ubuntu, en la carpeta del proyecto |
| Las tildes salen mal («valoraci�n») | La terminal no está en UTF-8. En la terminal de Ubuntu, y en la de VS Code conectada a WSL, se ven bien |
| Un caso de prueba no da lo esperado | Compara la función que interviene con la del código de la guía. Para ver cuánto vale una variable en un momento, añade un `System.out.println` provisional, compila y ejecuta |

## El proyecto terminado

El proyecto terminado, listo para compilar, está en [`ValoraPROG.zip`](ValoraPROG.zip). Descomprímelo en `~/dam2627/prog/` con `unzip ValoraPROG.zip` y compílalo como en el paso 4. El zip no trae la carpeta `bin`: la crea `javac` al compilar.

```
~/dam2627/prog/ValoraPROG
├── src                         el código fuente
│   └── dam                     el paquete dam
│       ├── Calculos.java       las cuentas (paso 2)
│       └── Principal.java      el menú y lo que se ve (paso 3)
└── bin                         lo compilado: la crea javac (paso 4)
    └── dam
        ├── Calculos.class
        └── Principal.class
```
