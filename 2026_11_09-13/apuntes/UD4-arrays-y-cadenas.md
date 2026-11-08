# UD4 · Arrays y cadenas

Lo básico que hay que saber de la UD4. Cada apartado tiene la idea clave, lo que tienes que saber y, cuando hay conceptos que se confunden, una tabla para compararlos. Los ejemplos son de «CSV notas». Las preguntas para comprobar que lo entiendes están en el [cuestionario](../cuestionario.md) de la semana, en «Cuestiones sobre los apuntes».

Las expresiones regulares (regex) se trabajan en la 2.ª evaluación.

---

## 1. Arrays

**En una frase:** un array guarda varios valores del mismo tipo, uno en cada posición, y su tamaño no cambia.

**Lo que tienes que saber**

- Se crea con su tamaño o con sus valores (`{42, 97, 33}`). Creado con su tamaño, un array de números empieza lleno de ceros (`new int[3]` es `{0, 0, 0}`), y uno de `String`, vacío (`null` en cada posición).
- Las posiciones van de **`0`** a **`length - 1`**. Salir de ahí da `ArrayIndexOutOfBoundsException`.
- `array.length` es su tamaño (sin paréntesis).
- Se recorre con un `for` (cuando hace falta la posición) o con un **for-each** (cuando solo hace falta el valor): `for (int nota : notas) { … }` da cada valor en `nota`, sin usar posiciones.
- Operaciones típicas: sumar, contar, buscar el **máximo** o el **mínimo** (empezando por el primero y comparando con el resto) y buscar la **posición** de un valor.
- Dos arrays en el mismo orden pueden ir emparejados: `nombres[i]` y `notas[i]` son del mismo alumno.

---

## 2. Matrices (arrays de dos dimensiones)

**En una frase:** una matriz es un array de arrays: filas y columnas.

**Lo que tienes que saber**

- `int[][] notas = new int[25][3];` crea 25 filas de 3 columnas.
- `notas[i]` es una fila entera (las tres notas del alumno `i`) y `notas[i][t]`, un valor.
- `notas.length` es el número de filas; `notas[0].length`, el de columnas.
- Recorrer una **fila**: se fija `i` y se mueve la columna. Recorrer una **columna** (un trimestre): se fija la columna y se mueve `i`.
- Para recorrerla entera, dos `for` anidados.

---

## 3. La clase `Arrays`

**En una frase:** `java.util.Arrays` trae las operaciones habituales con arrays ya hechas.

**Lo que tienes que saber**

| Método | Qué hace |
|---|---|
| `Arrays.toString(a)` | Lo muestra como texto: `[42, 97, 33]` |
| `Arrays.deepToString(m)` | Lo mismo con una matriz |
| `Arrays.sort(a)` | Lo ordena de menor a mayor (cambia el original) |
| `Arrays.copyOf(a, n)` | Una copia con los `n` primeros valores |
| `Arrays.fill(a, v)` | Pone `v` en todas las posiciones |
| `Arrays.equals(a, b)` | Compara el contenido de dos arrays |

- `a == b` con arrays no compara el contenido: compara si son el **mismo** array.

---

## 4. Cadenas (`String`)

**En una frase:** un `String` es un texto; sus métodos permiten partirlo, limpiarlo, compararlo y convertirlo.

**Lo que tienes que saber**

| Método | Qué hace | Ejemplo |
|---|---|---|
| `length()` | Número de caracteres | `"Ana".length()` → `3` |
| `charAt(i)` | El carácter de la posición `i` | `"Ana".charAt(0)` → `'A'` |
| `substring(a)` | El trozo desde `a` hasta el final | `"Nombre07".substring(6)` → `"07"` |
| `substring(a, b)` | El trozo de `a` a `b` (sin incluir `b`) | `"Nombre07".substring(0, 6)` → `"Nombre"` |
| `trim()` | Quita los espacios del principio y del final | `" Ana ".trim()` → `"Ana"` |
| `toUpperCase()` / `toLowerCase()` | A mayúsculas / minúsculas | |
| `equals` / `equalsIgnoreCase` | Comparar (con o sin distinguir mayúsculas) | |
| `contains(t)` | Si contiene el texto `t` | |
| `split(";")` | Lo parte en un array por el separador | `"Ana;7;8".split(";")` → `{"Ana","7","8"}` |
| `String.format(…)` | Texto con formato: `%d` entero, `%02d` entero con dos cifras, `%.2f` dos decimales, `%s` texto; `%5d` ocupa 5 huecos alineado a la derecha y `%-10s`, 10 huecos alineado a la izquierda | `String.format("%.2f", 7.333)` → `"7.33"` |

- Los `String` **no cambian**: cada método devuelve un texto nuevo. `nombre.trim()` no cambia `nombre`; hay que guardar el resultado.
- Para convertir un texto en número: `Integer.parseInt`.
- Los textos se comparan con **`equals`** (o `equalsIgnoreCase`), nunca con `==`, que compara si son el mismo objeto y no su contenido.

---

## 5. Datos en formato CSV

**En una frase:** un CSV es texto con un registro por línea y los campos separados por `;` o `,`; para usarlo, cada línea se parte en campos.

**Lo que tienes que saber**

- Un **CSV** tiene una línea de cabecera y una línea por registro, con los campos separados por `;` o `,`.
- Para cargarlo en arrays: saltar la cabecera, partir cada línea con `split`, limpiar con `trim` y convertir los números con `parseInt`.
- **Datos al azar:** `new Random(semilla)` crea un generador y `nextInt(101)` da un entero de 0 a 100. Con la misma semilla salen siempre los mismos números, en cualquier ordenador.
- En «CSV notas», las líneas se generan con `Random` y `String.format`. Leer y escribir archivos se ve en la UD8.
