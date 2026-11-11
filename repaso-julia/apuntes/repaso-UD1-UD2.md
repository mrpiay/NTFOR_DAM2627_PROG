# Repaso · UD1 y UD2

Repaso de lo que entró en la P1 (Julia), el examen de octubre: lo básico de Java y el control de flujo. Lo que se explica en los apuntes de la semana del 2 al 6 solo se menciona aquí, con su enlace. Al final, dos problemas resueltos del tipo de los del examen.

---

## 1. Identificadores

**En una frase:** un identificador es el nombre que se da a una variable, una constante, un método o una clase, y tiene reglas fijas.

**Lo que tienes que saber**

- Puede tener **letras, dígitos, `_` y `$`**, pero **no puede empezar por un dígito**.
- **No puede tener espacios ni guiones** (`-` es el operador resta).
- **No puede ser una palabra reservada** de Java: `int`, `class`, `if`, `for`, `public`…
- Distingue **mayúsculas y minúsculas**: `edad` y `Edad` son dos identificadores distintos.
- Por convención: variables y métodos en **camelCase** (`notaMedia`, `calcularMedia`); clases empezando por mayúscula (`GestorNotas`); constantes en mayúsculas con `_` (`NOTA_MAXIMA`).

**Compara**

| Identificador | ¿Válido? | Por qué |
|---|---|---|
| `notaFinal` | Sí | Letras, en camelCase |
| `nota_final` | Sí | `_` está permitido |
| `nota2` | Sí | El dígito no va al principio |
| `2nota` | No | Empieza por un dígito |
| `nota-final` | No | `-` no está permitido |
| `class` | No | Es una palabra reservada |

---

## 2. Comentarios

**En una frase:** los comentarios explican el código y el compilador los ignora; hay tres tipos.

**Lo que tienes que saber**

- **`//`**: comentario de **una línea**, desde `//` hasta el final de la línea.
- **`/* … */`**: comentario de **varias líneas**.
- **`/** … */`**: comentario **Javadoc**. Va justo antes de una clase o un método y sirve para generar su documentación (`javadoc`). Se ve en la semana del 16 al 20.

**Compara**

| | `//` | `/* … */` | `/** … */` |
|---|---|---|---|
| Ocupa | Una línea | Las que haga falta | Las que haga falta |
| Para qué | Aclarar una línea | Explicar un bloque o desactivarlo | Documentar una clase o un método |
| Genera documentación | No | No | Sí |

---

## 3. Precedencia de los operadores

**En una frase:** cuando una expresión tiene varios operadores, se calculan en un orden fijo; los paréntesis lo cambian.

**Lo que tienes que saber**

- Orden, de **primero a último**:
  1. paréntesis `( )`;
  2. `!`, `++`, `--` y el signo `-`;
  3. `*`, `/`, `%`;
  4. `+`, `-`;
  5. comparaciones `<`, `>`, `<=`, `>=`;
  6. `==`, `!=`;
  7. `&&`;
  8. `||`;
  9. asignaciones `=`, `+=`, `-=`, `*=`, `/=`, `%=` (las **últimas**).
- Por eso **`x *= 2 + 3`** es `x = x * (2 + 3)`: primero la suma, después la asignación compuesta.
- Con `int`, **`/`** da el cociente entero (`7 / 2` es `3`) y **`%`** el resto (`7 % 2` es `1`).
- `&&` y `||` **no evalúan la segunda parte** si con la primera ya se sabe el resultado: en `a != 0 && b / a > 1`, si `a` es `0` no se divide.

**Compara**

| Expresión (con `int x = 4;`) | Se calcula como | Resultado |
|---|---|---|
| `x + 2 * 3` | `x + (2 * 3)` | `10` |
| `(x + 2) * 3` | `(x + 2) * 3` | `18` |
| `x *= 2 + 3` | `x = x * (2 + 3)` | `x` vale `20` |
| `x % 3 == 1` | `(x % 3) == 1` | `true` |
| `x > 5 \|\| x % 2 == 0` | `(x > 5) \|\| ((x % 2) == 0)` | `true` |

---

## 4. Lo demás, en los apuntes de la semana del 2 al 6

| Tema | Dónde |
|---|---|
| Tipos primitivos (`int`, `double`, `char`, `boolean`…), variables, constantes con `final` y literales | [UD1, apartado 3](../../2026_11_02-06/apuntes/UD1-fundamentos-de-java.md#3-tipos-variables-y-constantes) |
| Operadores aritméticos, de comparación (`==` compara valores en los primitivos), lógicos y de asignación | [UD1, apartado 4](../../2026_11_02-06/apuntes/UD1-fundamentos-de-java.md#4-operadores-y-expresiones) |
| Leer del teclado con `Scanner` y escribir en pantalla | [UD1, apartado 6](../../2026_11_02-06/apuntes/UD1-fundamentos-de-java.md#6-entrada-y-salida-por-consola) |
| `if`, `else if`, `else` y `switch` (evalúa una expresión y salta al `case` que coincide; `break` y `default`) | [UD2, apartado 1](../../2026_11_02-06/apuntes/UD2-control-de-flujo-y-excepciones.md#1-decidir-if-y-switch) |

---

## 5. Problemas resueltos

### El menor de tres números

Pedir tres enteros y mostrar «Los tres números son iguales» o «El número menor es X».

**Idea:** primero se descarta el caso especial (los tres iguales); después se supone que el primero es el menor y se compara con los otros dos.

```java
import java.util.Scanner;

public class NumeroMenor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Primer número: ");
        int a = sc.nextInt();
        System.out.print("Segundo número: ");
        int b = sc.nextInt();
        System.out.print("Tercer número: ");
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("Los tres números son iguales");
        } else {
            int menor = a;
            if (b < menor) {
                menor = b;
            }
            if (c < menor) {
                menor = c;
            }
            System.out.println("El número menor es " + menor);
        }
        sc.close();
    }
}
```

Con `4, 9, 2` muestra `El número menor es 2`; con `5, 5, 5`, `Los tres números son iguales`.

### Un menú con `switch`

Mostrar un menú una vez, leer la opción y hacer solo esa operación.

```
MENÚ
1. Pasar de euros a céntimos
2. Saber si un número es múltiplo de 3
0. Salir
```

**Idea:** se lee la opción y un `switch` elige el caso; cada `case` termina con `break`, y `default` cubre cualquier otra opción.

```java
import java.util.Scanner;

public class MenuSimple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("MENÚ");
        System.out.println("1. Pasar de euros a céntimos");
        System.out.println("2. Saber si un número es múltiplo de 3");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Euros: ");
                int euros = sc.nextInt();
                System.out.println(euros + " euros son " + euros * 100 + " céntimos");
                break;
            case 2:
                System.out.print("Número: ");
                int n = sc.nextInt();
                if (n % 3 == 0) {
                    System.out.println("Es múltiplo de 3");
                } else {
                    System.out.println("No es múltiplo de 3");
                }
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

Sin el `break` de un `case`, el programa seguiría ejecutando el `case` siguiente.
