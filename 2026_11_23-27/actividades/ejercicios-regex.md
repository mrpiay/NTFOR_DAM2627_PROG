# Expresiones regulares y arrays: ejercicios de repaso

Un miniproyecto Java, `regex`, con tres ejercicios:

- **Ejercicio 1:** validar con `matches`.
- **Ejercicio 2:** buscar con `Pattern` y `Matcher`.
- **Ejercicio 3:** repasar los arrays de una y dos dimensiones.

Los tres ejercicios están resueltos.

Antes del código va un ejercicio sobre el proyecto en sí: deducir sus carpetas y su paquete a partir de los comandos que lo compilan y lo ejecutan.

El proyecto está en [`regex.zip`](regex.zip). Se descomprime y se abre la carpeta `regex`.

---

## Antes de empezar · Deducir el proyecto a partir de los comandos

**Enunciado:** el proyecto se llama `regex` y la clase con el `main` se llama `Principal`. Desde la carpeta `regex/`, estos dos comandos funcionan:

```bash
javac -d out src/regex/Principal.java
java -cp out regex.Principal
```

A la vista de los comandos, deduce:

1. En qué carpeta se guarda `Principal.java`.
2. Cuál es la primera línea de `Principal.java`.
3. Qué archivo genera `javac` y dónde lo deja.
4. Cómo queda la estructura de carpetas completa, antes y después de compilar.

**Solución:**

1. En **`src/regex/`**. Es la ruta que recibe `javac`: `src/regex/Principal.java`.
2. **`package regex;`**. El comando `java` usa el nombre completo `regex.Principal`: el paquete, un punto y la clase. Además, el paquete coincide con la carpeta dentro de `src`.
3. **`out/regex/Principal.class`**. `-d out` dice que el compilado va a `out`, y dentro de `out` `javac` crea una carpeta por cada paquete.
4. La estructura:

```
Antes de compilar           Después de compilar
regex/                      regex/
└── src/                    ├── src/
    └── regex/              │   └── regex/
        └── Principal.java  │       └── Principal.java
                            └── out/
                                └── regex/
                                    └── Principal.class
```

**Explicación:**

| | `javac -d out src/regex/Principal.java` | `java -cp out regex.Principal` |
|---|---|---|
| Qué recibe | La **ruta** del archivo, con `/` y `.java` | El **nombre completo** de la clase, con `.` y sin `.class` |
| Qué hace la opción | `-d out`: dónde dejar los `.class` | `-cp out`: dónde buscar los `.class` |
| Qué se deduce | Dónde está el `.java` | Cómo se llama el paquete |

- La carpeta `out` no hace falta crearla: la crea `javac`.
- El `-cp` apunta a la carpeta **de la que cuelgan los paquetes** (`out`), no a la del paquete (`out/regex`).
- `out/regex/` la decide la línea `package regex;`, no la carpeta de `src`. Si las dos no coinciden, `javac` compila sin dar error, pero `java -cp out regex.Principal` no encuentra la clase. Por eso la línea `package` y la carpeta tienen que coincidir.

---

## El código

`src/regex/Principal.java`:

```java
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Arrays;

public class Principal {

    // Ejercicio 1: validar formatos con matches
    static void ejercicio1() {
        System.out.println("== Ejercicio 1: validar con matches ==");
        String[] codigos = {"28013", "2801", "28O13", "280135"};
        for (String c : codigos) {
            System.out.println(c + " es código postal: " + c.matches("\\d{5}"));
        }
        String[] dnis = {"12345678Z", "1234567Z", "12345678z"};
        for (String d : dnis) {
            System.out.println(d + " es DNI: " + d.matches("\\d{8}[A-Z]"));
        }
    }

    // Ejercicio 2: buscar DNI y códigos postales dentro de un texto
    static void ejercicio2() {
        System.out.println("== Ejercicio 2: buscar con Pattern y Matcher ==");
        String texto = "Ana García, DNI 12345678Z, vive en el 15001 (A Coruña). "
                     + "Luis Pérez, DNI 87654321x, vive en el 36201 (Vigo).";

        Pattern dni = Pattern.compile("\\d{8}[A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher m = dni.matcher(texto);
        while (m.find()) {
            // Se guarda con la letra en mayúscula, como se escribe un DNI
            System.out.println("DNI encontrado: " + m.group().toUpperCase());
        }

        // \b: el código postal es un número suelto de 5 cifras, no un trozo del DNI
        Matcher cp = Pattern.compile("\\b\\d{5}\\b").matcher(texto);
        int cuantos = 0;
        while (cp.find()) {
            cuantos++;
            System.out.println("Código postal " + cuantos + ": " + cp.group());
        }
    }

    // Ejercicio 3 - repaso de arrays de 1 y 2 dimensiones
    static void ejercicio3(){
        // Crear tabla con 2 columnas y 3 filas de tipo int
        int [][] tabla = new int[3][2];

        // Poner toda la fila 0 a 0, toda la fila 1 a 1 y toda la fila 2 a 2
        for(int fila = 0; fila <=2; fila++)
            for(int col = 0; col <=1; col++ )
                //tabla[fila][col] = fila; //(0 0) (1 1) (2 2)
                //tabla[fila][col] = 2 - fila; //(2 2) (1 1) (0 0)
                tabla[fila][col] = col + 2 * fila; //(0 1) (2 3) (4 5)

        // Imprimir tabla
        for(int [] fila : tabla)
            System.out.println(Arrays.toString(fila));

        // Sumar la fila 1
        int total = 0;
        for(int dato : tabla[0])
            total = total + dato;
        System.out.println(total);

        total = 0;
        for(int col = 0; col < tabla[0].length; col++)
            total = total + tabla[0][col];
        System.out.println(total);

        // Sumar la columna 2
        total = 0;
        for(int fila = 0; fila < tabla.length; fila++)
            total = total + tabla[fila][1];
        System.out.println(total);

        // Sumar todos los valores de la tabla
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
    }

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        ejercicio3();
    }
}
```

El `main` solo ejecuta el ejercicio 3. Para ejecutar el 1 o el 2, se quitan las dos barras (`//`) de delante de su llamada.

> **Si las tildes salen mal en la terminal de Windows** («c�digo»), el programa está bien: es la consola, que no usa UTF-8. Se arregla ejecutando con `java -Dstdout.encoding=UTF-8 -cp out regex.Principal`. En la terminal de Linux salen bien.

---

## Ejercicio 1 · Validar con `matches`

**Enunciado:** comprobar qué textos son códigos postales (5 cifras) y cuáles son DNI (8 cifras y una letra mayúscula).

**Solución:** el método `ejercicio1()` del código.

**Salida:**

```
== Ejercicio 1: validar con matches ==
28013 es código postal: true
2801 es código postal: false
28O13 es código postal: false
280135 es código postal: false
12345678Z es DNI: true
1234567Z es DNI: false
12345678z es DNI: false
```

**Explicación:**

- `matches` comprueba si el texto **entero** encaja con el patrón:
  - `280135` falla porque le sobra una cifra;
  - `2801` falla porque le falta una.
- `28O13` falla porque lleva la letra O en lugar de un cero, y `\d` solo encaja con dígitos.
- `[A-Z]` encaja con **una** letra mayúscula, así que `12345678z` no es un DNI válido.
- En Java, la barra se escribe dos veces: `\d` se escribe `"\\d"`.

---

## Ejercicio 2 · Buscar con `Pattern` y `Matcher`

**Enunciado:** en un texto con datos de varias personas, encontrar todos los DNI (aunque la letra esté en minúscula) y numerar los códigos postales.

**Solución:** el método `ejercicio2()` del código.

**Salida:**

```
== Ejercicio 2: buscar con Pattern y Matcher ==
DNI encontrado: 12345678Z
DNI encontrado: 87654321X
Código postal 1: 15001
Código postal 2: 36201
```

**Explicación:**

- `Pattern.compile` prepara el patrón, y `matcher(texto)` lo aplica al texto.
- `find()` busca la **siguiente** coincidencia dentro del texto. Devuelve `true` mientras encuentre alguna; por eso va en un `while`.
- `group()` devuelve el trozo encontrado.
- `Pattern.CASE_INSENSITIVE` no distingue mayúsculas de minúsculas, así que también encuentra `87654321x`. Después se pasa a mayúscula con `toUpperCase()`.
- **`\b`** marca el límite de una palabra:
  - sin él, `\d{5}` encontraría también las cinco primeras cifras de cada DNI (`12345` y `87654`), porque `find()` busca trozos y no textos enteros;
  - con `\b\d{5}\b`, el número tiene que ir suelto.
- En el ejercicio 1, con `matches`, `\b` no hace falta: `matches` exige que encaje el texto **entero**, así que `"12345678Z".matches("\\d{5}")` ya da `false`. Lo que hace necesario `\b` es `find()`, que busca trozos. `Pattern.compile` solo prepara el patrón: con `patron.matcher(texto).matches()`, tampoco haría falta.

| | `matches()` | `find()` |
|---|---|---|
| Qué comprueba | Que el texto **entero** encaje | Que **algún trozo** del texto encaje |
| `\d{5}` con `12345678Z` | `false` | Encuentra `12345` |
| ¿Hace falta `\b`? | No | Sí, para que el número vaya suelto |

**Para comprobarlo:** cambia `"\\b\\d{5}\\b"` por `"\\d{5}"`, compila y ejecuta. Salen cuatro códigos postales en lugar de dos:

```
Código postal 1: 12345
Código postal 2: 15001
Código postal 3: 87654
Código postal 4: 36201
```

`12345` y `87654` no son códigos postales: son las cinco primeras cifras de los DNI `12345678Z` y `87654321x`.

---

## Ejercicio 3 · Repaso de arrays de una y dos dimensiones

**Enunciado:** con una tabla de 3 filas y 2 columnas de tipo `int`:

1. Crear la tabla.
2. Rellenarla.
3. Imprimirla.
4. Sumar la primera fila.
5. Sumar la segunda columna.
6. Sumar todos los valores de la tabla.

**Solución:** el método `ejercicio3()` del código.

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

**Explicación:** en [`repaso-arrays.md`](repaso-arrays.md), parte por parte: cómo se crea y se rellena la tabla, las tres fórmulas del código, cómo se imprime y cómo se suman una fila, una columna y la tabla entera.

---

## Dónde consultar

- **Expresiones regulares:** los [apuntes de expresiones regulares](../../2026_11_16-20/apuntes/UD4-expresiones-regulares.md), apartados 1 a 3.
- **Arrays y matrices:** los [apuntes de arrays y cadenas](../../2026_11_09-13/apuntes/UD4-arrays-y-cadenas.md), apartados 1 a 3.
- **Los símbolos de las expresiones regulares:** la tabla del principio de [Pattern](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html), en la documentación oficial de Java 21 (en inglés).
- **Probar un patrón** antes de ponerlo en el programa: [RegexPlanet](https://www.regexplanet.com/advanced/java/index.html).
