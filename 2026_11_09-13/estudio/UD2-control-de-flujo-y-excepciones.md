# UD2 · Control de flujo y excepciones

Lo básico que hay que saber de la UD2. Cada apartado tiene la idea clave, lo que tienes que saber y, cuando hay conceptos que se confunden, una tabla para compararlos. Los ejemplos son de «CSV notas». Las preguntas para comprobar que lo entiendes están en los cuestionarios de autoevaluación.

Crear excepciones propias, las aserciones, la depuración con el depurador y la documentación del código se trabajan más adelante.

---

## 1. Decidir: `if` y `switch`

**En una frase:** las estructuras de selección ejecutan un bloque u otro según una condición.

**Lo que tienes que saber**

- **`if`** ejecuta un bloque si la condición es verdadera; **`else`**, si es falsa; y **`else if`** encadena varias condiciones.
- **`switch`** elige entre varios valores concretos de una variable. Cada **`case`** termina con **`break`**; si falta, se ejecuta también el siguiente. **`default`** recoge cualquier otro valor.
- En «CSV notas», el menú es un `switch` sobre la opción elegida.

**Compara**

| | `if / else if` | `switch` |
|---|---|---|
| Qué compara | Cualquier condición (rangos, varias variables…) | Un valor contra una lista de valores concretos |
| Ejemplo | `if (trimestre < 1 \|\| trimestre > 3)` | El menú: `case 1:`, `case 2:`… |

---

## 2. Repetir: `while`, `do-while` y `for`

**En una frase:** los bucles repiten un bloque mientras se cumple una condición, o un número de veces.

**Lo que tienes que saber**

- **`while`**: comprueba la condición **antes**; puede no ejecutarse nunca.
- **`do-while`**: comprueba **después**; se ejecuta al menos una vez. Por eso el menú es un `do-while`: sale siempre una vez.
- **`for`**: cuando se sabe cuántas veces: `for (int i = 0; i < nombres.length; i++)`.
- **for-each**: recorre todos los elementos sin usar posiciones: `for (int nota : notasAlumno)`.
- Elementos típicos: un **contador** (`aprobados++`), un **acumulador** (`suma += nota`) y un **centinela** (un valor que indica el final, como `0` para salir).

**Compara**

| | `while` | `do-while` | `for` |
|---|---|---|---|
| Comprueba la condición | Antes | Después | Antes |
| Mínimo de vueltas | 0 | 1 | 0 |
| Uso típico | Repetir mientras pase algo | Menús y preguntas que deben salir una vez | Recorrer un número conocido de veces |

---

## 3. Saltar: `break`, `continue` y `return`

**En una frase:** las sentencias de salto cambian el recorrido normal de un bucle o de un método.

**Lo que tienes que saber**

- **`break`** termina el bucle (o el `switch`) en ese momento.
- **`continue`** salta al **siguiente** giro del bucle, sin ejecutar lo que queda del actual.
- **`return`** sale del método; si devuelve algo, con su valor.
- En «CSV notas»: `continue` salta los suspensos al listar los aprobados; `break` sale del bucle de `getInt` cuando el número es válido; `return i` sale de `buscar` en cuanto encuentra el nombre.

**Compara**

| | `break` | `continue` |
|---|---|---|
| Qué hace | Termina el bucle | Pasa a la siguiente vuelta |
| ¿Se ejecuta lo que queda del bucle? | No, ni esta vuelta ni las demás | No en esta vuelta; las demás, sí |

---

## 4. Excepciones: `try-catch`

**En una frase:** una excepción es un error durante la ejecución; con `try-catch` se recoge y el programa sigue en lugar de terminar.

**Lo que tienes que saber**

- Si algo falla (un número mal escrito, un archivo que no existe, salir de un array), Java **lanza** una excepción y, si nadie la recoge, el programa termina con un mensaje rojo.
- **`try { … } catch (Tipo e) { … }`**: si dentro del `try` se lanza esa excepción, se ejecuta el `catch` y el programa sigue.
- Excepciones habituales: **`NumberFormatException`** (`parseInt` de un texto que no es un número), **`ArrayIndexOutOfBoundsException`** (posición fuera del array), **`NullPointerException`** (usar algo que vale `null`), **`IOException`** (fallo al leer un archivo).
- Algunas, como `IOException`, son **comprobadas**: Java obliga a tratarlas, y sin `try-catch` el programa no compila.
- En «CSV notas»: `getInt` recoge la `NumberFormatException` y vuelve a preguntar.

---

## 5. Probar un programa

**En una frase:** un programa se prueba con casos preparados, incluidos los raros, y comparando lo que sale con lo que debería salir.

**Lo que tienes que saber**

- Un **caso de prueba** es una entrada y la salida que se espera («Nombre22» → «media 70.67»).
- Hay que probar los casos normales, los **límites** (el primero, el último, el vacío) y los **erróneos** (letras donde va un número, un trimestre que no existe).
- Si sale algo distinto, se busca dónde cambia el valor esperado: con mensajes de control (`print`) o con el depurador, que para el programa en una línea y muestra las variables.
