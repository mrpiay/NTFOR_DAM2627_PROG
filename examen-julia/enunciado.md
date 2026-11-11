# PROGRAMACIÓN

Esta prueba consta de dos partes, cada una con un valor específico:

- **Cuestionario (5 puntos).**
  - Cada respuesta errónea restará 0.3.
- **Problemas (5 puntos).**
  - Problema 1 (2 puntos)
  - Problema 2 (3 puntos)

---

## CUESTIONARIO

### 1. ¿Qué tipo de comentario se usa para comentar varias líneas en Java (no JavaDoc)?

a) `// comentario`\
b) `/* comentario */`\
c) `/** comentario */`\
d) `/ comentario`

### 2. Siguiendo las reglas de creación de identificadores, ¿cuál de las siguientes opciones es un identificador válido en Java?

a) `123Variable`\
b) `nombre_usuario`\
c) `int`\
d) `nombre-usuario`

### 3. ¿Cuál de los siguientes es un tipo de dato primitivo para almacenar números con decimales en Java?

a) `int`\
b) `char`\
c) `double`\
d) `boolean`

### 4. ¿Qué efecto tiene la palabra clave *final* cuando se utiliza al declarar una variable en Java?

a) La variable no puede cambiar su valor una vez asignado\
b) La variable se puede modificar solo una vez\
c) La variable no puede ser accedida desde fuera de la clase\
d) La variable debe ser inicializada en tiempo de ejecución

### 5. ¿Qué hace el operador `==` cuando se usa con tipos primitivos?

a) Compara referencias\
b) Compara valores\
c) Asigna valores\
d) Invoca `equals()`

### 6. Dado el siguiente código, ¿cuál es el valor de la variable *resultado*?

```java
int a = 7;
int b = 2;
int resultado = a % b;
```

a) 1\
b) 0\
c) 2\
d) 5

### 7. Dado el siguiente código, ¿cuál es el valor de la variable *resultado*?

```java
int x = 5;
int y = 10;
boolean resultado = (x != y) && (x < y);
```

a) true\
b) false\
c) 10\
d) 5

### 8. ¿Qué valor tendrá la variable *valor* después de ejecutar el siguiente código?

```java
int valor = 2;
valor *= 3 + 2;
valor -= 4;
```

a) true\
b) 5\
c) 10\
d) 6

### 9. ¿Cuál será el valor de la variable *resultado* tras ejecutar el siguiente código?

```java
int a = 8;
int b = 3;
boolean resultado = (a > b) || (a % b == 1);
```

a) true\
b) false\
c) 8\
d) 5

### 10. ¿Cuál de las siguientes afirmaciones sobre la estructura switch en Java es correcta?

a) En un switch, se evalúa una expresión que puede ser verdadera o falsa.\
b) En un switch, se pueden usar múltiples tipos de datos como condiciones, incluyendo booleanos.\
c) En un switch, se evalúa una expresión específica para seleccionar un caso, no se evalúa una condición.\
d) En un switch, los casos deben ser evaluados en orden secuencial y no se pueden saltar.

---

## PROBLEMAS

### Problema 1 (2 puntos)

Desarrolla un programa en Java que solicite al usuario tres números enteros y determine cuál es el mayor.

El programa deberá mostrar exactamente uno de los siguientes mensajes:

- **Si los tres números son iguales:** Los tres números son iguales
- **En cualquier otro caso:** El número mayor es X, donde X es el valor máximo.

Si dos números comparten el valor máximo, será suficiente con mostrar dicho valor.

**Ejemplos de ejecución:**

- Entrada: 5, 9, 3 → El número mayor es 9
- Entrada: 7, 4, 7 → El número mayor es 7
- Entrada: 6, 6, 6 → Los tres números son iguales
- Entrada: 4, 4, 8 → El número mayor es 8

### Problema 2 (3 puntos)

Desarrolla un programa en Java que muestre el siguiente menú, solicite al usuario una opción y realice la operación correspondiente.

```
MENÚ
1. Comprobar si un número es par o impar
2. Comprobar si un número es positivo, negativo o cero
3. Calcular el doble de un número
0. Salir
```

**Funcionamiento de cada opción:**

- **Opción 1:** Solicita un número entero y muestra "El número es par" o "El número es impar", según corresponda.
- **Opción 2:** Solicita un número entero y muestra "El número es positivo", "El número es negativo" o "El número es cero", según corresponda.
- **Opción 3:** Solicita un número entero y muestra "El doble es X", donde X es el resultado de multiplicarlo por 2.
- **Opción 0:** Muestra "Saliendo del programa".
- **Cualquier otra opción:** Muestra "Opción no válida".

**Consideraciones:**

- Todos los datos introducidos serán números enteros.
- El programa ejecutará únicamente la opción seleccionada y finalizará, sin volver a mostrar el menú.
- Los mensajes deberán coincidir exactamente con los indicados.
