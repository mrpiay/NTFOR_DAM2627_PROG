# PROGRAMACIÓN — SOLUCIONES

---

## CUESTIONARIO

**1. b) `/* comentario */`.** Es el comentario de varias líneas. `//` es de una sola línea, `/** */` es un comentario Javadoc (para documentación) y `/` no es un comentario.

**2. b) `nombre_usuario`.** Un identificador puede tener letras, dígitos, `_` y `$`. `123Variable` empieza por un dígito, `int` es una palabra reservada y `nombre-usuario` lleva `-`, que es el operador resta.

**3. c) `double`.** Es el tipo primitivo para números con decimales. `int` solo guarda enteros, `char` un carácter y `boolean` solo `true` o `false`.

**4. a) La variable no puede cambiar su valor una vez asignado.** `final` la convierte en constante: un segundo intento de asignarle valor da error de compilación.

**5. b) Compara valores.** Con tipos primitivos, `==` compara el valor. Con objetos compararía referencias, y para comparar su contenido se usa `equals()`.

**6. a) 1.** `%` da el resto de la división entera: 7 = 2 · 3 + 1.

**7. a) true.** `x != y` (5 distinto de 10) es `true` y `x < y` también; `true && true` es `true`.

**8. d) 6.** `valor *= 3 + 2` es `valor = valor * (3 + 2)`, porque la asignación compuesta se aplica después de la suma: 2 · 5 = 10. Luego `valor -= 4` deja 6.

**9. a) true.** `a > b` (8 > 3) ya es `true`, y con `||` basta con que una parte sea verdadera; la segunda ni siquiera se evalúa.

**10. c) En un switch, se evalúa una expresión específica para seleccionar un caso, no se evalúa una condición.** `switch` compara el valor de la expresión con cada `case` y salta directamente al que coincide. No admite condiciones (`a`), en Java no admite `boolean` (`b`) y no recorre los casos uno a uno (`d`).

| Pregunta | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|:--------:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|
| **Respuesta** | b | b | c | a | b | a | a | d | a | c |

---

## PROBLEMAS

### Problema 1 (2 puntos)

Desarrolla un programa en Java que solicite al usuario tres números enteros y determine cuál es el mayor.

El programa deberá mostrar exactamente uno de los siguientes mensajes:

- **Si los tres números son iguales:** Los tres números son iguales
- **En cualquier otro caso:** El número mayor es X, donde X es el valor máximo.

Si dos números comparten el valor máximo, será suficiente con mostrar dicho valor.

**Solución: primero se comprueba si los tres son iguales. Si no lo son, se parte del primero como mayor y se compara con los otros dos.**

```java
import java.util.Scanner;

public class NumeroMayor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int a = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        int b = sc.nextInt();
        System.out.print("Introduce el tercer número: ");
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("Los tres números son iguales");
        } else {
            int mayor = a;
            if (b > mayor) {
                mayor = b;
            }
            if (c > mayor) {
                mayor = c;
            }
            System.out.println("El número mayor es " + mayor);
        }

        sc.close();
    }
}
```

**Otras respuestas válidas.** Cualquiera que lea los tres números, trate primero el caso de los tres iguales y muestre los mensajes exactos. Por ejemplo, el bloque `else` puede ser:

- con `Math.max`:

  ```java
  int mayor = Math.max(a, Math.max(b, c));
  System.out.println("El número mayor es " + mayor);
  ```

- con `if` y `else if`, comparando cada número con los otros dos:

  ```java
  int mayor;
  if (a >= b && a >= c) {
      mayor = a;
  } else if (b >= c) {
      mayor = b;
  } else {
      mayor = c;
  }
  System.out.println("El número mayor es " + mayor);
  ```

Hace falta `>=` y no `>`: con `7, 4, 7`, `a > c` es falso y el programa no mostraría 7.

### Problema 2 (3 puntos)

Desarrolla un programa en Java que muestre el siguiente menú, solicite al usuario una opción y realice la operación correspondiente.

```
MENÚ
1. Comprobar si un número es par o impar
2. Comprobar si un número es positivo, negativo o cero
3. Calcular el doble de un número
0. Salir
```

**Solución: se muestra el menú una sola vez, se lee la opción y un `switch` ejecuta el caso correspondiente; `default` cubre cualquier otra opción.**

```java
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("MENÚ");
        System.out.println("1. Comprobar si un número es par o impar");
        System.out.println("2. Comprobar si un número es positivo, negativo o cero");
        System.out.println("3. Calcular el doble de un número");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        int numero;

        switch (opcion) {
            case 1:
                System.out.print("Introduce un número: ");
                numero = sc.nextInt();
                if (numero % 2 == 0) {
                    System.out.println("El número es par");
                } else {
                    System.out.println("El número es impar");
                }
                break;

            case 2:
                System.out.print("Introduce un número: ");
                numero = sc.nextInt();
                if (numero > 0) {
                    System.out.println("El número es positivo");
                } else if (numero < 0) {
                    System.out.println("El número es negativo");
                } else {
                    System.out.println("El número es cero");
                }
                break;

            case 3:
                System.out.print("Introduce un número: ");
                numero = sc.nextInt();
                System.out.println("El doble es " + (numero * 2));
                break;

            case 0:
                System.out.println("Saliendo del programa");
                break;

            default:
                System.out.println("Opción no válida");
        }

        sc.close();
    }
}
```

**Otras respuestas válidas.** Cualquiera que muestre el menú una sola vez, lea la opción, haga solo esa operación con los mensajes exactos y trate cualquier otra opción. Por ejemplo:

- el `switch` sustituido por `if` y `else if` sobre `opcion`:

  ```java
  if (opcion == 1) {
      System.out.print("Introduce un número: ");
      int numero = sc.nextInt();
      System.out.println(numero % 2 == 0 ? "El número es par" : "El número es impar");
  } else if (opcion == 2) {
      // positivo, negativo o cero, igual que en la solución
  } else if (opcion == 3) {
      // el doble, igual que en la solución
  } else if (opcion == 0) {
      System.out.println("Saliendo del programa");
  } else {
      System.out.println("Opción no válida");
  }
  ```

- el `switch` con flechas (Java 14 o posterior; en clase se usa Java 21), que no necesita `break` y está en los apuntes de la UD2, apartado 1:

  ```java
  switch (opcion) {
      case 1 -> {
          System.out.print("Introduce un número: ");
          int numero = sc.nextInt();
          System.out.println(numero % 2 == 0 ? "El número es par" : "El número es impar");
      }
      case 2 -> { /* positivo, negativo o cero */ }
      case 3 -> { /* el doble */ }
      case 0 -> System.out.println("Saliendo del programa");
      default -> System.out.println("Opción no válida");
  }
  ```

En el `switch` clásico, olvidar un `break` es un error: el programa seguiría ejecutando el caso siguiente.
