# Repaso · UD3 · Funciones

Lo básico que hay que saber de la UD3. Cada apartado tiene la idea clave, lo que tienes que saber y, cuando hay conceptos que se confunden, una tabla para compararlos. Los ejemplos son de «CSV notas». Las preguntas para comprobar que lo entiendes están en los cuestionarios de autoevaluación.

---

## 1. Qué es una función (método)

**En una frase:** un método es un bloque de código con nombre que hace una sola cosa y se puede usar todas las veces que haga falta.

**Lo que tienes que saber**

- Se declara con lo que devuelve, su nombre y sus parámetros: `public static double media(int[] notasAlumno)`.
- **`void`** indica que no devuelve nada; si devuelve algo, termina con **`return valor;`**.
- Se **llama** por su nombre con los valores que necesita: `media(notas[0])`.
- Dividir el programa en métodos pequeños hace que se lea mejor, se pruebe por partes y no se repita código. En «CSV notas», `Notas` tiene un método para cada cosa y `Principal` solo los usa.
- `static` permite llamarlo sin crear un objeto; los objetos se ven en la UD5.

---

## 2. Parámetros y valor de retorno

**En una frase:** los parámetros son los datos que recibe un método y el valor de retorno, lo que entrega.

**Lo que tienes que saber**

- Los **parámetros** se declaran con tipo y nombre: `buscar(String[] nombres, String nombre)`. Al llamar, se pasan los **argumentos** en el mismo orden y del mismo tipo.
- El **valor de retorno** se puede guardar, usar en una expresión o pasar a otro método: `nombres[mejorDelTrimestre(notas, 1)]`.
- Un método puede devolver un valor especial para decir que algo no ha ido bien: `buscar` devuelve **`-1`** si el nombre no está.

---

## 3. Paso por valor y ámbito

**En una frase:** un método recibe una copia de lo que se le pasa; con un tipo primitivo no cambia el original, pero con un array sí.

**Lo que tienes que saber**

- **Tipos primitivos** (`int`, `double`…): el método recibe una **copia del valor**. Si la cambia, el original no cambia.
- **Arrays y objetos:** la copia es de la **referencia**, que apunta al mismo array. Si el método cambia el contenido del array, el original cambia.
- **Ámbito:** una variable declarada dentro de un método o de un bloque `{ }` solo existe ahí. Dos métodos pueden tener variables con el mismo nombre sin que choquen.

**Compara**

| | Parámetro `int` | Parámetro `int[]` |
|---|---|---|
| Qué recibe el método | Una copia del número | Una copia de la referencia al mismo array |
| ¿Cambia el original si el método lo modifica? | No | Sí, su contenido |

---

## 4. Sobrecarga y recursividad

**En una frase:** la sobrecarga son varios métodos con el mismo nombre y distintos parámetros; la recursividad, un método que se llama a sí mismo.

**Lo que tienes que saber**

- **Sobrecarga:** `media(double a, double b)` y `media(double a, double b, double c)` pueden convivir. Java elige según los argumentos. Cambiar solo el tipo de retorno no vale.
- **Recursividad:** el método se llama a sí mismo con un problema más pequeño. Necesita un **caso base** (cuándo parar); sin él, no para nunca y da `StackOverflowError`.
- Ejemplo: la suma de 1 a `n` es `n + suma(n - 1)`, y el caso base es `n == 0`.
