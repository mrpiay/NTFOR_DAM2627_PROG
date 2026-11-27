# Ejercicio de repaso: ausencias de la semana

Un miniproyecto Java, `ausencias`, para repasar los arrays de una y dos dimensiones y los métodos. Se apuntan las ausencias de un grupo de 10 estudiantes de lunes a viernes, y se consulta quién faltó cada día.

El proyecto está en [`ausencias.zip`](ausencias.zip). Se descomprime y se abre la carpeta `ausencias`. Compila tal como viene; los huecos que hay que completar están marcados con `// escribe aquí tu código`.

---

## El proyecto

```
ausencias/
└── src/
    └── ausencias/
        ├── Datos.java         la clase de datos: los tres arrays
        └── Operaciones.java   la clase de operaciones: los métodos y el main
```

Las dos clases están en el paquete `ausencias`. Desde la carpeta `ausencias/`, se compila y se ejecuta con:

```bash
javac -d out src/ausencias/*.java
java -cp out ausencias.Operaciones
```

- `src/ausencias/*.java` compila las dos clases a la vez.
- La clase que se ejecuta es `Operaciones`, porque es la que tiene el `main`.

| Clase | Qué hace |
|---|---|
| `Datos` | Solo **guarda** la información: los nombres, los días y las ausencias. No tiene métodos |
| `Operaciones` | **Trabaja** con esa información: buscar, poner una ausencia e imprimir. Los arrays se usan con el nombre de la clase delante: `Datos.estudiantes`, `Datos.dias` y `Datos.ausencias` |

---

## Parte 1 · Los datos (`Datos.java`)

Declarar e inicializar tres arrays:

1. **`estudiantes`:** un array de `String` con los nombres de 10 estudiantes. Para que salga lo que espera el `main`, son, en este orden: Ana, Brais, Carla, Daniel, Elena, Fran, Iria, Lucas, Noa y Xoán.
2. **`dias`:** un array de `String` con los días de lunes a viernes: `"L"`, `"M"`, `"X"`, `"J"` y `"V"`.
3. **`ausencias`:** un array de `boolean` de dos dimensiones, con una fila por estudiante y una columna por día.
   - `ausencias[e][d]` es `true` si el estudiante de la posición `e` faltó el día `d`.
   - Su tamaño sale de los otros dos arrays, sin escribir 10 ni 5 a mano.

Los tres son `static`, como los métodos de `Operaciones`, para usarlos sin crear objetos.

Así queda `ausencias` después de las pruebas del `main` (ver la parte 3):

| | L | M | X | J | V |
|---|---|---|---|---|---|
| 0 · Ana | `true` | `false` | `false` | `false` | `false` |
| 1 · Brais | `false` | `false` | `true` | `false` | `false` |
| 2 · Carla | `false` | `false` | `false` | `false` | `false` |
| … | | | | | |
| 6 · Iria | `true` | `false` | `false` | `false` | `false` |
| … | | | | | |

Al crear un array de `boolean`, todas las casillas valen `false`: al principio, nadie ha faltado.

---

## Parte 2 · Las operaciones (`Operaciones.java`)

Cada método tiene encima un comentario con lo que hace. Algunos traen un `return` provisional, que solo está para que el proyecto compile y hay que cambiar.

| Método | Qué recibe | Qué hace |
|---|---|---|
| `buscarEstudiante` | Un nombre | Devuelve su posición en `Datos.estudiantes`, o `-1` si no está. No distingue mayúsculas de minúsculas: `"ana"` encuentra a `"Ana"` |
| `buscarDia` | Un día (`"L"`…`"V"`) | Devuelve su posición en `Datos.dias`, o `-1` si no está |
| `ponerAusencia` | Un nombre y un día | Pone a `true` la casilla de ese estudiante y ese día. Devuelve `true` si la pone, y `false` si el estudiante o el día no existen |
| `imprimirAusentes` | Un día | Imprime los estudiantes que faltaron ese día, uno por línea, o `Nadie` si no faltó nadie. Si el día no existe, lo dice |

- `buscarEstudiante` y `buscarDia` hacen lo mismo con arrays distintos: recorrer el array y comparar cada elemento con el que se busca.
- `ponerAusencia` usa `buscarEstudiante` y `buscarDia` para saber en qué fila y en qué columna poner el `true`.
- `imprimirAusentes` deja fija la columna del día y recorre las filas, una por estudiante.

---

## Parte 3 · Comprobar el resultado

El `main` de `Operaciones` ya está escrito. Prueba los métodos y, a la derecha de cada llamada, dice lo que debe salir. Con todo completado, la salida es:

```
Brais está en la posición 1
noa está en la posición 8
Pepe está en la posición -1
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
| 1 a 3 | `buscarEstudiante`: un nombre que está, uno en minúsculas y uno que no está |
| 4 a 8 | `ponerAusencia`: tres ausencias correctas, un estudiante que no existe y un día que no existe |
| 9 en adelante | `imprimirAusentes`: un día con dos ausentes, uno con uno, uno sin nadie y un día que no existe |

> **Si las tildes salen mal en la terminal de Windows** («est� en la posici�n»), el programa está bien: es la consola, que no usa UTF-8. Se arregla ejecutando con `java -Dstdout.encoding=UTF-8 -cp out ausencias.Operaciones`. En la terminal de Linux salen bien.

---

## Dónde consultar

- **Arrays y matrices:** los [apuntes de arrays y cadenas](../../2026_11_09-13/apuntes/UD4-arrays-y-cadenas.md), apartados 1 a 3. Comparar cadenas sin distinguir mayúsculas (`equalsIgnoreCase`), en el apartado 4.
- **Recorrer una tabla y sumar una fila o una columna:** [`repaso-arrays.md`](repaso-arrays.md).
