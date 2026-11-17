# Cuestionario C1 · semana del 2 al 6 de noviembre · soluciones

Las salidas son las que da Java al compilar y ejecutar cada fragmento.

## Cuestiones sobre el proyecto

**1.** En `public static int getInt()`, ¿qué significan `public`, `static` e `int`?

**Respuesta.** `public`: el método se puede usar desde otras clases. `static`: pertenece a la clase y se llama sin crear un objeto (`Auxiliar.getInt()`, o `getInt()` con `import static`). `int`: el método devuelve un número entero.

**2.** Cambia el `main` de `Principal` por esto. Cuando pida la edad, escribe `20`.

```java
        print("Edad?");
        print("Tienes " + getInt() * 12 + " meses");
```

Copia lo que sale por pantalla.

**Respuesta.**

```
Edad?
Tienes 240 meses
```

La multiplicación se hace antes que la suma: primero `getInt() * 12` (20 × 12 = 240) y después se une al texto.

**3.** Cambia el `main` por esto:

```java
        print("Tienes " + 20 + 1 + " años");
        print("Tienes " + (20 + 1) + " años");
```

Copia lo que sale por pantalla.

**Respuesta.**

```
Tienes 201 años
Tienes 21 años
```

En la primera, `+` va de izquierda a derecha: `"Tienes " + 20` ya es un texto, y a un texto se le **unen** el `1` y `" años"`. En la segunda, los paréntesis hacen que primero se **sume** `20 + 1`.

**4.** ¿Qué tiene que ser la primera línea de `Auxiliar.java` y de `Principal.java`? ¿En qué carpeta deben estar los dos archivos, y por qué?

**Respuesta.** `package dam;`, antes de cualquier `import`. Deben estar en una carpeta llamada `dam` (en el proyecto, `src/dam`), porque Java busca la clase `dam.Principal` en `dam/Principal.class`: el nombre del paquete y el de la carpeta tienen que coincidir.

**5.** Cambia el `main` por `print(5);` y compila (no ejecutes). Copia lo que dice `javac`.

**Respuesta.** No compila:

```
error: incompatible types: int cannot be converted to String
```

`print` recibe un `String` y `5` es un `int`. Se arregla convirtiéndolo en texto: `print("" + 5);`.

**6.** Cambia el `main` por esto:

```java
        print("Raíz: " + Math.sqrt(16));
        print("Máximo: " + Math.max(7, 12));
        print("Potencia: " + Math.pow(2, 10));
```

Copia lo que sale por pantalla.

**Respuesta.**

```
Raíz: 4.0
Máximo: 12
Potencia: 1024.0
```

`Math.sqrt` y `Math.pow` devuelven siempre `double` (número con decimales), aunque el resultado sea exacto. `Math.max(7, 12)` recibe dos `int` y devuelve un `int`.

**7.** Añade este método a `Auxiliar`:

```java
    public static double areaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
```

y cambia el `main` por esto:

```java
        print("Área: " + areaCirculo(2));
        print("Redondeada: " + Math.round(areaCirculo(2) * 100) / 100.0);
```

Copia lo que sale por pantalla.

**Respuesta.**

```
Área: 12.566370614359172
Redondeada: 12.57
```

Multiplica por 100 (1256,637…), redondea (1257) y divide entre `100.0`. Se divide entre `100.0`, y no entre `100`, para que el resultado sea un `double` y conserve los decimales.

**8.** Cambia el `main` por esto:

```java
        String nombre = "Ana García";
        print("" + nombre.length());
        print(nombre.toUpperCase());
        print("" + nombre.charAt(0));
        print("" + nombre.indexOf("G"));
        print(nombre.substring(4));
```

Copia lo que sale por pantalla.

**Respuesta.**

```
10
ANA GARCÍA
A
4
García
```

Las posiciones empiezan en 0: la `A` está en la 0 y la `G` en la 4. `substring(4)` devuelve desde la posición 4 hasta el final. `length()` cuenta todos los caracteres, también el espacio.

**9.** Cambia el `main` por esto:

```java
        String nombre = "Ana García";
        print("" + (nombre.charAt(0) + nombre.charAt(4)));
        print("" + nombre.charAt(0) + nombre.charAt(4));
```

Copia lo que sale por pantalla.

**Respuesta.**

```
136
AG
```

Un `char` es, por dentro, un número (su código): `'A'` es 65 y `'G'` es 71. En la primera, los paréntesis hacen que primero se sumen los dos `char`, sin ningún texto: `+` **suma** los códigos, 65 + 71 = 136, y después ese número se une a `""`. En la segunda, `""` va primero y todo se une como texto.

**10.** Ejecuta `java -cp bin dam.Principal` y después `java -cp bin Principal`. Copia lo que sale por pantalla.

**Respuesta.** `-cp bin` dice dónde buscar las clases y `dam.Principal` es el nombre completo de la clase (paquete, punto y clase). Con `java -cp bin Principal` sale:

```
Error: Could not find or load main class Principal
Caused by: java.lang.ClassNotFoundException: Principal
```

porque falta el paquete en el nombre.

## Cuestiones sobre los apuntes

**11.** ¿Qué tipo de Java usarías para guardar una edad, un precio, la inicial de un nombre y si un alumno ha aprobado? ¿Por qué `String` no es un tipo primitivo?

**Respuesta.** *(UD1, apartado 3)* `int`, `double`, `char` y `boolean`. `String` no es primitivo porque es una clase: un texto con sus métodos (`length`, `trim`…).

**12.** ¿Qué diferencia hay entre un error de compilación y uno de ejecución? Pon un ejemplo de cada uno.

**Respuesta.** *(UD1, apartado 2)* El de compilación sale al compilar con `javac` y el programa no llega a ejecutarse (falta un `;`, un nombre mal escrito: `cannot find symbol`). El de ejecución sale al ejecutar con `java` (dividir entre 0, salir de un array: `ArrayIndexOutOfBoundsException`).

**13.** ¿Cuánto dan `7 / 2`, `7 % 2` y `(double) 7 / 2`? ¿Qué diferencia hay entre una conversión implícita y una explícita?

**Respuesta.** *(UD1, apartados 4 y 5)* `3` (división entera), `1` (el resto) y `3.5`. La implícita la hace Java sola, sin perder información (un `int` en un `double`); la explícita (*casting*) la pide el programador con `(tipo)` y puede perder información (`(int) 7.9` da `7`).

**14.** ¿Cuándo usarías `while`, `do-while` y `for`? ¿Por qué un menú suele ser un `do-while`?

**Respuesta.** *(UD2, apartado 2)* `while`, para repetir mientras pase algo (puede no ejecutarse nunca); `do-while`, cuando tiene que ejecutarse al menos una vez; `for`, cuando se sabe cuántas veces. El menú es `do-while` porque tiene que salir al menos una vez antes de preguntar si se sale.

**15.** ¿Cuándo es mejor un `switch` que un `if / else if`? ¿Qué pasa si a un `case` le falta el `break`?

**Respuesta.** *(UD2, apartado 1)* El `switch`, cuando se compara una variable con una lista de valores concretos (un menú); el `if`, para cualquier otra condición (rangos, varias variables). Sin `break`, se ejecuta también el `case` siguiente.

**16.** ¿Qué es una excepción? Di tres excepciones habituales y cuándo aparece cada una.

**Respuesta.** *(UD2, apartado 4)* Un error durante la ejecución: si nadie la recoge con `try-catch`, el programa termina. Por ejemplo: `NumberFormatException` (`parseInt` de un texto que no es un número), `ArrayIndexOutOfBoundsException` (una posición fuera del array), `NullPointerException` (usar algo que vale `null`) e `IOException` (fallo al leer un archivo).

