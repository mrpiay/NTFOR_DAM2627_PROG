# UD1 · Fundamentos de Java

Lo básico que hay que saber de la UD1. Cada apartado tiene la idea clave, lo que tienes que saber y, cuando hay conceptos que se confunden, una tabla para compararlos. Los ejemplos son de «Java 0» y de «CSV notas». Las preguntas para comprobar que lo entiendes están en los cuestionarios de autoevaluación.

---

## 1. Cómo se organiza un programa en Java

**En una frase:** un programa Java está hecho de clases, organizadas en paquetes; empieza a ejecutarse por el método `main`.

**Lo que tienes que saber**

- Todo el código va dentro de una **clase**. El archivo se llama como la clase pública: `Principal` va en `Principal.java`.
- El programa empieza en **`public static void main(String[] args)`**.
- Un **paquete** agrupa clases relacionadas y es también una carpeta: `package dam;` va en `src/dam/`.
- Un **método estático** (`static`) se llama sin crear objetos: `Auxiliar.print("Hola")`, o solo `print("Hola")` con `import static dam.Auxiliar.*;`.
- Los **comentarios** explican el código: `//` (una línea) y `/* … */` (varias).

---

## 2. Compilar y ejecutar

**En una frase:** `javac` traduce el código fuente a bytecode, y `java` lo ejecuta en la máquina virtual de Java.

**Lo que tienes que saber**

- El código fuente (`.java`) se compila con **`javac`** y da **bytecode** (`.class`), que no depende del sistema operativo.
- El bytecode lo ejecuta la **JVM** (máquina virtual de Java) con **`java`**. Por eso un programa Java funciona igual en Windows, Linux y macOS.
- El **JDK** trae el compilador y la JVM; el **JRE**, solo la JVM.
- Con paquetes: `javac -d bin src/dam/*.java` (deja los `.class` en `bin`) y `java -cp bin dam.Principal` (el nombre de la clase, con su paquete).
- Un **IDE** (VS Code, IntelliJ, Eclipse, NetBeans) hace lo mismo con un botón.

**Compara**

| | Error de compilación | Error de ejecución |
|---|---|---|
| Cuándo sale | Al compilar, con `javac` | Al ejecutar, con `java` |
| Ejemplo | Falta un `;`, un nombre mal escrito (`cannot find symbol`) | Dividir entre 0, salir de un array (`ArrayIndexOutOfBoundsException`) |

---

## 3. Tipos, variables y constantes

**En una frase:** cada dato tiene un tipo, que dice qué valores admite y qué se puede hacer con él.

**Lo que tienes que saber**

- **Tipos primitivos:** enteros (`byte`, `short`, `int`, `long`), decimales (`float`, `double`), `char` (un carácter, entre comillas simples: `'A'`) y `boolean` (`true` o `false`).
- **`String`** es un texto, entre comillas dobles (`"Ana"`). No es primitivo: es una clase.
- Una **variable** se declara con su tipo y su nombre: `int edad = 20;`. Solo existe dentro del bloque `{ }` donde se declara (su **ámbito**).
- Una **constante** no cambia: `final int MAXIMO = 100;` (por convenio, en mayúsculas).
- Un **literal** es un valor escrito tal cual en el código: `20`, `7.5`, `'A'`, `"Hola"`, `true`.

---

## 4. Operadores y expresiones

**En una frase:** los operadores combinan valores para calcular, comparar y decidir.

**Lo que tienes que saber**

- **Aritméticos:** `+ - * /` y `%` (el resto). Entre enteros, `/` es división entera: `7 / 2` da `3`.
- **Relacionales:** `== != < > <= >=`; dan `true` o `false`.
- **Lógicos:** `&&` (y), `||` (o) y `!` (no).
- **Asignación:** `=`, y los abreviados `+=`, `-=`, `++` y `--`.
- `+` con un `String` **une textos**: `"Tienes " + 20 + " años"`.
- Los textos se comparan con **`equals`**, no con `==`.

---

## 5. Conversiones de tipo

**En una frase:** Java convierte solo cuando no se pierde nada; si se puede perder algo, hay que pedirlo con un *casting*.

**Lo que tienes que saber**

- **Implícita:** de un tipo pequeño a uno mayor, sin perder nada: un `int` en un `double`.
- **Explícita (*casting*):** se pide con el tipo entre paréntesis y puede perder información: `(int) 7.9` da `7`.
- Para obtener decimales de una división de enteros, se convierte antes uno de ellos: `(double) suma / 3`.
- De texto a número: `Integer.parseInt("42")` y `Double.parseDouble("7.5")`. Si el texto no es un número, lanzan una excepción (UD2).

**Compara**

| | Implícita | Explícita (*casting*) |
|---|---|---|
| Quién la hace | Java, sola | El programador, con `(tipo)` |
| ¿Se puede perder información? | No | Sí |
| Ejemplo | `double d = 5;` | `int n = (int) 7.9;` |

---

## 6. Entrada y salida por consola

**En una frase:** se escribe en la consola con `System.out` y se lee del teclado con `Scanner`.

**Lo que tienes que saber**

- `System.out.println(…)` escribe y salta de línea; `System.out.print(…)` no salta.
- **`printf`** o **`String.format`** dan formato: `%d` entero, `%.2f` decimal con dos cifras, `%s` texto, `%n` salto de línea.
- **`Scanner`** lee del teclado: `teclado.nextLine()` lee una línea de texto.
- En los proyectos, todo esto va en métodos auxiliares (`print`, `getInt`, `getString`), y el `main` los usa.
