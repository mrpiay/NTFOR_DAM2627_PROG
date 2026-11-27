# Repaso de arrays de una y dos dimensiones

El ejercicio 3 del miniproyecto `regex` ([`regex.zip`](regex.zip)), explicado parte por parte. Es el método `ejercicio3()` de `src/regex/Principal.java`, el único que ejecuta el `main`. Cómo se compila y se ejecuta el proyecto está en [`ejercicios-regex.md`](ejercicios-regex.md).

**Enunciado:** con una tabla de 3 filas y 2 columnas de tipo `int`:

1. Crear la tabla.
2. Rellenarla.
3. Imprimirla.
4. Sumar la primera fila.
5. Sumar la segunda columna.
6. Sumar todos los valores de la tabla.

**Salida:**

```
[0, 1]
[2, 3]
[4, 5]
1
1
9
15
```

---

## 1 · Crear la tabla

```java
int [][] tabla = new int[3][2];
```

- `int[][]` es un array de dos dimensiones: un array **de arrays**. Cada fila es un `int[]`.
- En `new int[3][2]`, el primer número es el de **filas** y el segundo, el de **columnas**.
- Los índices empiezan en 0: las filas van de la 0 a la 2, y las columnas, de la 0 a la 1.
- Al crearla, todas las casillas valen 0.

| | Columna 0 | Columna 1 |
|---|---|---|
| **Fila 0** | `tabla[0][0]` | `tabla[0][1]` |
| **Fila 1** | `tabla[1][0]` | `tabla[1][1]` |
| **Fila 2** | `tabla[2][0]` | `tabla[2][1]` |

| Expresión | Valor | Qué es |
|---|---|---|
| `tabla.length` | 3 | El número de filas |
| `tabla[0].length` | 2 | El número de columnas (lo que mide una fila) |
| `tabla[1]` | Un `int[]` | La fila 1 entera |
| `tabla[1][0]` | Un `int` | Una casilla |

---

## 2 · Rellenarla

```java
for(int fila = 0; fila <=2; fila++)
    for(int col = 0; col <=1; col++ )
        //tabla[fila][col] = fila; //(0 0) (1 1) (2 2)
        //tabla[fila][col] = 2 - fila; //(2 2) (1 1) (0 0)
        tabla[fila][col] = col + 2 * fila; //(0 1) (2 3) (4 5)
```

- Los dos `for` están **anidados**. El de fuera recorre las filas. Por cada fila, el de dentro recorre todas sus columnas.
- Las casillas se visitan en este orden: `[0][0]`, `[0][1]`, `[1][0]`, `[1][1]`, `[2][0]` y `[2][1]`.
- Sin llaves, cada `for` abarca solo la instrucción siguiente: el de fuera, el `for` de dentro; y el de dentro, la asignación. Las líneas con `//` no cuentan.
- Hay tres fórmulas, y solo está activa la última. Para probar otra, se pone `//` delante de la que está activa y se quita de la que se quiere probar:

| Fórmula | Tabla que sale | Por qué |
|---|---|---|
| `tabla[fila][col] = fila;` | `[0, 0]` `[1, 1]` `[2, 2]` | Cada casilla vale el número de su fila |
| `tabla[fila][col] = 2 - fila;` | `[2, 2]` `[1, 1]` `[0, 0]` | La misma tabla, al revés: la fila 0 vale 2 − 0 y la fila 2 vale 2 − 2 |
| `tabla[fila][col] = col + 2 * fila;` | `[0, 1]` `[2, 3]` `[4, 5]` | Los números del 0 al 5, seguidos |

Con la tercera fórmula, cada fila tiene 2 columnas, así que la fila `f` empieza en `2 * f`. Al sumarle `col` (0 o 1), sale el número siguiente:

| `fila` | `col` | `col + 2 * fila` |
|---|---|---|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 2 |
| 1 | 1 | 3 |
| 2 | 0 | 4 |
| 2 | 1 | 5 |

---

## 3 · Imprimirla

```java
for(int [] fila : tabla)
    System.out.println(Arrays.toString(fila));
```

- El `for` mejorado (*for-each*) recorre la tabla fila a fila. En cada vuelta, `fila` es un `int[]`: un array de una dimensión.
- `Arrays.toString` convierte un array en texto, con corchetes y comas: `[0, 1]`. Necesita `import java.util.Arrays;`.
- `System.out.println(tabla)` no sirve: imprime algo como `[[I@1b6d3586`, que es la referencia del array y no su contenido.

---

## 4 · Sumar la primera fila

En el código, el comentario dice «Sumar la fila 1» contando desde 1: es la **primera fila**, `tabla[0]`. Se suma de dos formas, y las dos dan `1` (0 + 1).

**Con un `for` mejorado:**

```java
int total = 0;
for(int dato : tabla[0])
    total = total + dato;
System.out.println(total);
```

`tabla[0]` es un array de una dimensión, `[0, 1]`, y el `for` lo recorre dato a dato.

**Con un `for` con índice:**

```java
total = 0;
for(int col = 0; col < tabla[0].length; col++)
    total = total + tabla[0][col];
System.out.println(total);
```

- `tabla[0].length` es el número de columnas, 2. Así el bucle sirve aunque la tabla cambie de tamaño, sin escribir un 1 a mano como en `col <=1`.
- `total = 0;` antes de empezar: si no, se seguiría sumando sobre el resultado anterior y saldría 2.

| Vuelta | `col` | `tabla[0][col]` | `total` |
|---|---|---|---|
| Antes | | | 0 |
| 1ª | 0 | 0 | 0 |
| 2ª | 1 | 1 | 1 |

---

## 5 · Sumar la segunda columna

«Sumar la columna 2» también cuenta desde 1: es la **segunda columna**, la de índice `1`.

```java
total = 0;
for(int fila = 0; fila < tabla.length; fila++)
    total = total + tabla[fila][1];
System.out.println(total);
```

- Una columna **no es un array**: sus datos están cada uno en una fila distinta. Por eso no hay un `tabla[?]` que la dé entera, y no se puede recorrer con un `for` mejorado.
- Se recorren las filas con un índice, hasta `tabla.length` (3), y la columna queda fija: `tabla[fila][1]`.

| Vuelta | `fila` | `tabla[fila][1]` | `total` |
|---|---|---|---|
| Antes | | | 0 |
| 1ª | 0 | 1 | 1 |
| 2ª | 1 | 3 | 4 |
| 3ª | 2 | 5 | 9 |

| | Sumar una fila | Sumar una columna |
|---|---|---|
| Qué índice cambia | La columna | La fila |
| Qué índice queda fijo | La fila: `tabla[0][col]` | La columna: `tabla[fila][1]` |
| Hasta dónde llega el bucle | `tabla[0].length` (columnas) | `tabla.length` (filas) |
| ¿Sirve el `for` mejorado? | Sí, una fila es un array | No |

---

## 6 · Sumar toda la tabla

```java
int totalTabla = 0;
int totalFila;
for(int[] fila : tabla){
    totalFila = 0;
    for(int dato : fila){
        totalFila = totalFila + dato;
    }
    totalTabla = totalTabla + totalFila;
}
System.out.println(totalTabla);
```

- Son dos `for` mejorados anidados: el de fuera da cada fila (`int[]`) y el de dentro, cada dato de esa fila (`int`).
- `totalFila` vuelve a 0 al empezar **cada** fila, suma sus datos y se añade a `totalTabla` al acabar la fila.
- Aquí sí hay llaves, porque el `for` de fuera hace tres cosas.

| Fila | Datos | `totalFila` | `totalTabla` |
|---|---|---|---|
| 0 | `[0, 1]` | 1 | 1 |
| 1 | `[2, 3]` | 5 | 6 |
| 2 | `[4, 5]` | 9 | 15 |

---

## Para comprobarlo

Activa la primera fórmula del paso 2, `tabla[fila][col] = fila;` (quitando `//` de esa línea y poniéndolo en la tercera), compila y ejecuta. Antes de ejecutar, piensa qué deberían dar las sumas. La salida es:

```
[0, 0]
[1, 1]
[2, 2]
0
0
3
6
```

---

## Dónde consultar

- **Arrays y matrices:** los [apuntes de arrays y cadenas](../../2026_11_09-13/apuntes/UD4-arrays-y-cadenas.md), apartados 1 a 3.
