# Autoevaluación · semana del 9 al 13 de noviembre · soluciones

## Cuestiones sobre el proyecto

**1.** ¿Para qué sirve la semilla de `new Random(semilla)` en `generarLineas`? ¿Qué pasaría si cada uno usara una semilla distinta? ¿Por qué `generarLineas(25, 2627)` devuelve 26 líneas?

**Respuesta.** La semilla decide qué números da `Random`: con la misma semilla salen siempre los mismos, en el mismo orden, en cualquier ordenador. Así todos tienen las mismas notas y los mismos resultados en cada paso. Con semillas distintas, cada uno tendría otras notas, y otros mejores y aprobados. Devuelve 26 líneas porque la posición 0 es la cabecera (`nombre;t1;t2;t3`) y las otras 25, una por alumno.

**2.** Copia lo que sale por pantalla.

```java
        String linea = "Nombre05; 28 ;74;80";
        String[] campos = linea.split(";");
        print("Campos: " + campos.length);
        print("[" + campos[1] + "]");
        print("[" + campos[1].trim() + "]");
        print("Suma: " + (Integer.parseInt(campos[1].trim()) + Integer.parseInt(campos[2])));
        print("Unidos: " + campos[2] + campos[3]);
```

**Respuesta.**

```
Campos: 4
[ 28 ]
[28]
Suma: 102
Unidos: 7480
```

`split(";")` parte la línea por cada `;`: cuatro campos. El segundo conserva los espacios que había alrededor (`" 28 "`), y `trim()` los quita. `Integer.parseInt` convierte el texto en número: 28 + 74 = 102. Sin convertir, `+` une textos: `"74" + "80"` es `"7480"`.

**3.** Copia lo que sale por pantalla.

```java
        int[][] notas = {{42, 97, 33}, {57, 40, 88}};
        print("Filas: " + notas.length);
        print("Columnas: " + notas[0].length);
        print("Fila 1: " + Arrays.toString(notas[1]));
        print("notas[1][2]: " + notas[1][2]);
        print("Todo: " + Arrays.deepToString(notas));
```

**Respuesta.**

```
Filas: 2
Columnas: 3
Fila 1: [57, 40, 88]
notas[1][2]: 88
Todo: [[42, 97, 33], [57, 40, 88]]
```

Una matriz es un array de arrays: `notas.length` es el número de filas y `notas[0].length`, el de columnas de la primera fila. `notas[1]` es la segunda fila entera (las posiciones empiezan en 0) y `notas[1][2]`, su tercer valor. `Arrays.toString` muestra un array de una dimensión; para una matriz entera hace falta `Arrays.deepToString`.

**4.** Copia lo que sale por pantalla.

```java
        int[] trimestre1 = {42, 57, 82, 51, 28};
        int[] copia = Arrays.copyOf(trimestre1, trimestre1.length);
        Arrays.sort(copia);
        print("Ordenada: " + Arrays.toString(copia));
        print("Original: " + Arrays.toString(trimestre1));
        print("Mayor: " + copia[copia.length - 1]);
        int[] tres = Arrays.copyOf(copia, 3);
        print("Tres primeras: " + Arrays.toString(tres));
```

**Respuesta.**

```
Ordenada: [28, 42, 51, 57, 82]
Original: [42, 57, 82, 51, 28]
Mayor: 82
Tres primeras: [28, 42, 51]
```

`Arrays.copyOf(array, n)` crea un array nuevo con los `n` primeros valores. `Arrays.sort` ordena de menor a mayor el array que recibe, cambiándolo: por eso se ordena la copia y el original queda igual. Ordenado, el mayor es el último (`copia.length - 1`). `Arrays.copyOf(copia, 3)` da las tres primeras, las tres notas más bajas.

**5.** Copia lo que sale por pantalla.

```java
        int[] a = new int[3];
        print(Arrays.toString(a));
        Arrays.fill(a, 50);
        int[] b = {50, 50, 50};
        print(Arrays.toString(a));
        print("a == b: " + (a == b));
        print("Arrays.equals: " + Arrays.equals(a, b));
```

**Respuesta.**

```
[0, 0, 0]
[50, 50, 50]
a == b: false
Arrays.equals: true
```

`new int[3]` crea un array de tres enteros, todos a 0. `Arrays.fill` pone el mismo valor en todas las posiciones. `==` con arrays compara si son **el mismo** array, no su contenido: `a` y `b` son dos arrays distintos, aunque tengan los mismos valores. `Arrays.equals` compara el contenido, posición a posición.

**6.** Copia lo que sale por pantalla.

```java
        String uno = "Nombre07";
        String dos = "  nombre07 ";
        print("equals: " + uno.equals(dos));
        print("equalsIgnoreCase: " + uno.equalsIgnoreCase(dos));
        print("Con trim: " + uno.equalsIgnoreCase(dos.trim()));
        print("contains: " + uno.contains("07"));
        print("substring: " + uno.substring(6));
        print("Número: " + Integer.parseInt(uno.substring(6)));
```

**Respuesta.**

```
equals: false
equalsIgnoreCase: false
Con trim: true
contains: true
substring: 07
Número: 7
```

`equals` distingue mayúsculas y espacios. `equalsIgnoreCase` no distingue mayúsculas, pero los espacios siguen ahí: falso. Con `trim()` sí son iguales: es lo que hace `buscarPosNombre`. `contains` dice si el texto contiene otro. `substring(6)` da desde la posición 6 hasta el final (`N` es la 0). `Integer.parseInt("07")` es 7.

**7.** Copia lo que sale por pantalla.

```java
        int suma = 42 + 97 + 33;
        print("Sin double: " + suma / 3);
        print("Con double: " + (double) suma / 3);
        print("Con formato: " + String.format("%.2f", (double) suma / 3));
        print("Columnas: " + String.format("%-10s|%5d|", "Nombre01", 42));
```

**Respuesta.**

```
Sin double: 57
Con double: 57.333333333333336
Con formato: 57.33
Columnas: Nombre01  |   42|
```

`int / int` es una división entera: se pierden los decimales. Con `(double)` la división es decimal, y sale con todas las cifras que guarda un `double`. `String.format("%.2f", …)` lo deja en dos decimales (según el idioma del sistema, con coma: `57,33`). `%-10s` ocupa 10 huecos, con el texto a la izquierda, y `%5d`, 5 huecos con el número a la derecha: sirve para alinear columnas.

**8.** Usa los métodos de `Notas` con otros datos. Copia lo que sale por pantalla.

```java
        String[] nombres = {"Ana", "Luis", "Marta"};
        int[][] notas = {{70, 80, 90}, {95, 60, 50}, {65, 85, 99}};
        print("Luis: " + buscarPosNombre(nombres, "LUIS"));
        print("Pepe: " + buscarPosNombre(nombres, "Pepe"));
        print("Media de Ana: " + mediaDadasNotas(notas[0]));
        print("Mejor del 1.º: " + nombres[mejorDelTrimestre(notas, 1)]);
        print("Mejor del 3.º: " + nombres[mejorDelTrimestre(notas, 3)]);
        print("Mejor del curso: " + nombres[mejorDelCurso(notas)]);
```

**Respuesta.**

```
Luis: 1
Pepe: -1
Media de Ana: 80.0
Mejor del 1.º: Luis
Mejor del 3.º: Marta
Mejor del curso: Marta
```

Los métodos funcionan con cualquier array, no solo con los del CSV. `buscarPosNombre` encuentra `LUIS` en la posición 1 sin distinguir mayúsculas, y devuelve `-1` con `Pepe`. La media de Ana es (70 + 80 + 90) / 3 = 80.0. En el 1.er trimestre (columna 0) gana Luis, con 95; en el 3.º (columna 2), Marta, con 99. Las medias son 80, 68,33 y 83: el mejor del curso es Marta.

**9.** `buscarPosNombre`, `mejorDelTrimestre` y `mejorDelCurso` devuelven una **posición**, no un nombre ni una nota. ¿Por qué? ¿Para qué sirve que `buscarPosNombre` devuelva `-1`?

**Respuesta.** Porque con la posición se puede llegar a todo: el nombre está en `nombres[pos]` y las notas en `notas[pos]`, ya que los dos arrays van en el mismo orden. Si devolviera el nombre o la nota, habría que volver a buscar lo demás. `-1` no es ninguna posición válida, así que sirve para decir «no está»: quien llama a `buscarPosNombre` lo comprueba antes de usar la posición, y así no se sale del array.

**10.** ¿Por qué los métodos auxiliares están en una clase aparte, `Notas`, en el paquete `dam.notas`? ¿Qué hace `import static dam.notas.Notas.*;`? Si el CSV tuviera cuatro trimestres en lugar de tres, ¿qué habría que cambiar en `Notas` y en `Principal`?

**Respuesta.** Para separar las responsabilidades: `Notas` sabe hacer cada cálculo con los datos (leer, cargar, buscar, la media, los mejores), sin preguntar nada a nadie; `Principal` organiza el programa (el menú, qué preguntar y qué mostrar) usando esos métodos. Así cada parte es más fácil de entender, de probar (como en la pregunta 8) y de reutilizar en otro programa. `import static dam.notas.Notas.*;` permite llamar a todos los métodos estáticos de `Notas` sin escribir `Notas.` delante.

Con cuatro trimestres:

- en `Notas`, solo `generarLineas`, que inventa el CSV: la cabecera con `t4` y una nota más en cada línea. `cargarNotas` no cambia, porque saca el número de columnas de la cabecera (`campos.length - 1`), y `mediaDadasNotas`, `mejorDelTrimestre` y `mejorDelCurso` tampoco, porque recorren lo que haya;
- en `Principal`, `opcionMejorDeUnTrimestre` y `opcionAprobados` tendrían que aceptar del 1 al 4 (y el texto de la pregunta), y el bucle de `opcionMejores` llegar hasta 4.

**11.** Copia lo que sale por pantalla. ¿Por qué no sale `Aprobado: 61`?

```java
        int[] notas = {72, 35, 90, 48, 100, 61};
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 50) {
                continue;
            }
            if (notas[i] == 100) {
                print("Un 100 en la posición " + i);
                break;
            }
            print("Aprobado: " + notas[i]);
        }
        print("Fin");
```

**Respuesta.**

```
Aprobado: 72
Aprobado: 90
Un 100 en la posición 4
Fin
```

`continue` se salta el resto de la vuelta: con 35 y 48 no llega a ningún `print`. `break` termina el bucle entero: al encontrar el 100, en la posición 4, escribe su mensaje y sale, así que el 61, que va después, ya no se mira. El programa sigue después del bucle y escribe `Fin`.

## Cuestiones sobre los apuntes

**12.** Un método recibe un `int` y lo cambia; otro recibe un array y cambia uno de sus valores. ¿En cuál cambia también el original y por qué?

**Respuesta.** *(UD3, apartado 3)* Solo en el del array. El método recibe una copia: con un `int`, copia del valor, que no afecta al original; con un array, copia de la referencia, que apunta al mismo array.

**13.** ¿Qué es la sobrecarga de métodos? ¿Qué es un método recursivo y qué pasa si no tiene caso base?

**Respuesta.** *(UD3, apartado 4)* Sobrecarga: varios métodos con el mismo nombre y distintos parámetros (Java elige según los argumentos). Recursivo: un método que se llama a sí mismo con un problema más pequeño; sin caso base no para nunca y da `StackOverflowError`.

**14.** ¿Qué es el ámbito de una variable? ¿Pueden dos métodos distintos tener una variable con el mismo nombre?

**Respuesta.** *(UD3, apartado 3)* La parte del código donde existe: el método o el bloque `{ }` donde se declara. Sí: cada una solo existe en su método y no chocan.

**15.** ¿Por qué la línea `nombre.trim();`, sola, no quita los espacios de `nombre`? ¿Cómo se escribe para que sí lo haga?

**Respuesta.** *(UD4, apartado 4)* Porque los `String` no cambian: `trim()` devuelve un texto nuevo, que se pierde si no se guarda. Se escribe `nombre = nombre.trim();`.

**16.** ¿Qué es el formato CSV? ¿Qué pasos hay para cargar sus líneas en arrays?

**Respuesta.** *(UD4, apartado 5)* Texto con una línea de cabecera y una línea por registro, con los campos separados por `;` o `,`. Para cargarlo: saltar la cabecera, partir cada línea con `split`, limpiar con `trim` y convertir los números con `parseInt`.

