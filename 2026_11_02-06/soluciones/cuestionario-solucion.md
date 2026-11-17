# Cuestionario C1 · semana del 2 al 6 de noviembre · soluciones

Las salidas son las que da Java al compilar y ejecutar cada fragmento.

## Cuestiones sobre el proyecto

**1.** `public`: el método se puede usar desde otras clases. `static`: pertenece a la clase y se llama sin crear un objeto (`Auxiliar.getInt()`, o `getInt()` con `import static`). `int`: el método devuelve un número entero.

**2.**

```
Edad?
Tienes 240 meses
```

La multiplicación se hace antes que la suma: primero `getInt() * 12` (20 × 12 = 240) y después se une al texto.

**3.**

```
Tienes 201 años
Tienes 21 años
```

En la primera, `+` va de izquierda a derecha: `"Tienes " + 20` ya es un texto, y a un texto se le **unen** el `1` y `" años"`. En la segunda, los paréntesis hacen que primero se **sume** `20 + 1`.

**4.** `package dam;`, antes de cualquier `import`. Deben estar en una carpeta llamada `dam` (en el proyecto, `src/dam`), porque Java busca la clase `dam.Principal` en `dam/Principal.class`: el nombre del paquete y el de la carpeta tienen que coincidir.

**5.** No compila:

```
error: incompatible types: int cannot be converted to String
```

`print` recibe un `String` y `5` es un `int`. Se arregla convirtiéndolo en texto: `print("" + 5);`.

**6.**

```
Raíz: 4.0
Máximo: 12
Potencia: 1024.0
```

`Math.sqrt` y `Math.pow` devuelven siempre `double` (número con decimales), aunque el resultado sea exacto. `Math.max(7, 12)` recibe dos `int` y devuelve un `int`.

**7.**

```
Área: 12.566370614359172
Redondeada: 12.57
```

Multiplica por 100 (1256,637…), redondea (1257) y divide entre `100.0`. Se divide entre `100.0`, y no entre `100`, para que el resultado sea un `double` y conserve los decimales.

**8.**

```
10
ANA GARCÍA
A
4
García
```

Las posiciones empiezan en 0: la `A` está en la 0 y la `G` en la 4. `substring(4)` devuelve desde la posición 4 hasta el final. `length()` cuenta todos los caracteres, también el espacio.

**9.**

```
136
AG
```

Un `char` es, por dentro, un número (su código): `'A'` es 65 y `'G'` es 71. En la primera, los paréntesis hacen que primero se sumen los dos `char`, sin ningún texto: `+` **suma** los códigos, 65 + 71 = 136, y después ese número se une a `""`. En la segunda, `""` va primero y todo se une como texto.

**10.** `-cp bin` dice dónde buscar las clases y `dam.Principal` es el nombre completo de la clase (paquete, punto y clase). Con `java -cp bin Principal` sale:

```
Error: Could not find or load main class Principal
Caused by: java.lang.ClassNotFoundException: Principal
```

porque falta el paquete en el nombre.

## Cuestiones sobre los apuntes

**11.** *(UD1, apartado 3)* `int`, `double`, `char` y `boolean`. `String` no es primitivo porque es una clase: un texto con sus métodos (`length`, `trim`…).

**12.** *(UD1, apartado 2)* El de compilación sale al compilar con `javac` y el programa no llega a ejecutarse (falta un `;`, un nombre mal escrito: `cannot find symbol`). El de ejecución sale al ejecutar con `java` (dividir entre 0, salir de un array: `ArrayIndexOutOfBoundsException`).

**13.** *(UD1, apartados 4 y 5)* `3` (división entera), `1` (el resto) y `3.5`. La implícita la hace Java sola, sin perder información (un `int` en un `double`); la explícita (*casting*) la pide el programador con `(tipo)` y puede perder información (`(int) 7.9` da `7`).

**14.** *(UD2, apartado 2)* `while`, para repetir mientras pase algo (puede no ejecutarse nunca); `do-while`, cuando tiene que ejecutarse al menos una vez; `for`, cuando se sabe cuántas veces. El menú es `do-while` porque tiene que salir al menos una vez antes de preguntar si se sale.

**15.** *(UD2, apartado 1)* El `switch`, cuando se compara una variable con una lista de valores concretos (un menú); el `if`, para cualquier otra condición (rangos, varias variables). Sin `break`, se ejecuta también el `case` siguiente.

**16.** *(UD2, apartado 4)* Un error durante la ejecución: si nadie la recoge con `try-catch`, el programa termina. Por ejemplo: `NumberFormatException` (`parseInt` de un texto que no es un número), `ArrayIndexOutOfBoundsException` (una posición fuera del array), `NullPointerException` (usar algo que vale `null`) e `IOException` (fallo al leer un archivo).
