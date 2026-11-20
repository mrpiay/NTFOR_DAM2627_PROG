# UD1 · Fundamentos de Java

Lo básico que hay que saber de la UD1. Cada apartado tiene la idea clave, lo que tienes que saber y, cuando hay conceptos que se confunden, una tabla para compararlos. Los ejemplos son de «Java 0». Las preguntas para comprobar que lo entiendes están en el [cuestionario](../cuestionario.md) de la semana, en «Cuestiones sobre los apuntes».

---

## 1. Cómo se organiza un programa en Java

**En una frase:** un programa Java está hecho de clases, organizadas en paquetes; empieza a ejecutarse por el método `main`.

**Lo que tienes que saber**

- Todo el código va dentro de una **clase**. El archivo se llama como la clase pública: `Principal` va en `Principal.java`.
- El programa empieza en **`public static void main(String[] args)`**.
- Un **paquete** agrupa clases relacionadas y es también una carpeta: `package dam;` va en `src/dam/`.
- `package dam;` es la **primera instrucción** del archivo, antes de cualquier `import`. Desde ese momento, el **nombre completo** de la clase lleva el paquete delante: `dam.Principal`.
- **`public`** permite usar un método o una clase desde cualquier otra clase, también de otros paquetes. Sin `public`, solo se puede usar desde las clases de su mismo paquete.
- Un **método estático** (`static`) se llama sin crear objetos: `Auxiliar.print("Hola")`, o solo `print("Hola")` con `import static dam.Auxiliar.*;`.
- **`import static paquete.Clase.*;`** importa los miembros estáticos de esa clase (no la clase): `.*` quiere decir todos. Un `import` siempre necesita la forma `paquete.Clase`, así que no se puede importar desde una clase que no está en ningún paquete.
- El tipo que va delante del nombre del método es lo que **devuelve**: `public static int getInt()` devuelve un `int`; `void` (como en `main`) significa que no devuelve nada.
- Los **comentarios** explican el código: `//` (una línea) y `/* … */` (varias).

---

## 2. Compilar y ejecutar

**En una frase:** `javac` traduce el código fuente a bytecode, y `java` lo ejecuta en la máquina virtual de Java.

**Lo que tienes que saber**

- El código fuente (`.java`) se compila con **`javac`** y da **bytecode** (`.class`), que no depende del sistema operativo.
- El bytecode lo ejecuta la **JVM** (máquina virtual de Java) con **`java`**. Por eso un programa Java funciona igual en Windows, Linux y macOS.
- El **JDK** trae el compilador y la JVM; el **JRE**, solo la JVM.
- Con paquetes se compila con `javac -d bin src/dam/*.java`. **`-d bin`** es la carpeta de destino de los `.class`: si no existe, la crea, y dentro crea una carpeta por paquete (`bin/dam/`), con la misma estructura que el código. Sin `-d`, los `.class` quedan mezclados con los `.java`.
- Se ejecuta con `java -cp bin dam.Principal`. **`-cp bin`** (el *classpath*) dice dónde buscar las clases, y la clase se escribe con su nombre completo, con punto, sin `.class` ni ruta: Java busca `dam.Principal` en `bin/dam/Principal.class`.
- `java` ejecuta los `.class`, no el código fuente: después de cambiar un `.java`, hay que volver a compilar.
- Un **IDE** (VS Code, IntelliJ, Eclipse, NetBeans) hace lo mismo con un botón.

**Compara**

| | Error de compilación | Error de ejecución |
|---|---|---|
| Cuándo sale | Al compilar, con `javac` | Al ejecutar, con `java` |
| Ejemplo | Falta un `;`, un nombre mal escrito (`cannot find symbol`) | Dividir entre 0, salir de un array (`ArrayIndexOutOfBoundsException`) |

---

### Paquetes, carpetas y compilación

**En una frase:** el paquete dice en qué carpeta tiene que estar cada `.class`; seguir el mismo árbol con los `.java` es lo que permite a `javac` encontrar solo las clases que necesita.

**Lo que tienes que saber**

- **La clase pública se llama como su archivo.** `public class Principal` va en `Principal.java`, con las mismas mayúsculas. Si no coinciden, `javac` da error.
- **Los `.class` tienen que estar en el árbol del paquete. Esto es obligatorio.** La clase `dam.Principal` se busca en `bin/dam/Principal.class`; si no está ahí, `java` no la encuentra. `javac -d bin` ya los coloca así.
- **Los `.java` en el mismo árbol (`src/dam/Principal.java`) es una convención**, no una obligación: `javac` compila los archivos que se le pasan estén donde estén. Tampoco `src` ni `bin` son nombres obligatorios.
- **La convención sirve para algo.** Cuando `javac` compila una clase que usa otra que no se le ha pasado, convierte su nombre en una ruta (`dam.Auxiliar` → `dam/Auxiliar.java`) y la busca a partir de la raíz de las fuentes. Si los archivos siguen el árbol, la encuentra y la compila también; si no, da `cannot find symbol`.
- La raíz de las fuentes es la carpeta actual o la que se indica con **`-sourcepath`**.
- **`javac` recibe rutas de archivo; `java` recibe nombres de clase.** Los archivos que se le pasan a `javac` se escriben como cualquier ruta, a partir de la carpeta actual (`src/dam/Principal.java`): `-sourcepath` no las cambia, solo dice dónde buscar las clases que **no** se le han pasado. A `java` se le da el nombre de la clase con puntos (`dam.Principal`), y `-cp` dice dónde buscarla.

**Compara**: tres formas de compilar el mismo proyecto (`Principal` usa `Auxiliar`, las dos en el paquete `dam`):

| Desde | Orden | Qué hace |
|---|---|---|
| La carpeta del proyecto | `javac -d bin src/dam/*.java` | Se le pasan todos los archivos |
| La carpeta del proyecto | `javac -d bin -sourcepath src src/dam/Principal.java` | Se le pasa solo `Principal`; busca `Auxiliar` en `src/dam/` |
| `src` | `javac -d ../bin dam/Principal.java` | La carpeta actual ya es la raíz de las fuentes |

Las tres dejan los mismos `.class` en `bin/dam/`. En cambio, desde la carpeta del proyecto fallan estas dos:

| Orden | Error | Por qué |
|---|---|---|
| `javac -d bin src/dam/Principal.java` | `cannot find symbol` (`Auxiliar`) | Sin `-sourcepath`, busca `Auxiliar` en `./dam/`, que no existe |
| `javac -d bin -sourcepath src dam/Principal.java` | `file not found: dam/Principal.java` | La ruta del archivo se toma desde la carpeta actual, no desde `src` |

Más casos, con dos paquetes (`a` y `a.b`) y también para `java`: [ejemplos de paquetes y compilación](ejemplos-paquetes-y-compilacion.md).

## 3. Tipos, variables y constantes

**En una frase:** cada dato tiene un tipo, que dice qué valores admite y qué se puede hacer con él.

**Lo que tienes que saber**

- **Tipos primitivos:** enteros (`byte`, `short`, `int`, `long`), decimales (`float`, `double`), `char` (un carácter, entre comillas simples: `'A'`; por dentro es un número, su código: por eso `'A' + 'B'` da un número, `131`) y `boolean` (`true` o `false`).
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
- `+` con un `String` **une textos**: `"Tienes " + 20 + " años"`. Se calcula de izquierda a derecha: en cuanto hay un `String`, lo que viene después se une como texto (`"Tienes " + 20 + 1` da `"Tienes 201"`, y `20 + 1 + " años"` da `"21 años"`).
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
- En los proyectos, todo esto va en métodos auxiliares (`print`, `getInt`), y el `main` los usa.

---

## 7. Métodos que ya vienen hechos: `Math` y `String`

**En una frase:** Java trae clases con métodos listos para usar; `Math` hace cálculos y cada `String` sabe hacer cosas con su texto.

**Lo que tienes que saber**

- Los de **`Math`** son estáticos: se llaman con el nombre de la clase delante, `Math.sqrt(9)`.
- Los de **`String`** se llaman sobre el texto, con un punto: `nombre.length()`.
- Las **posiciones** de un texto empiezan en **0**: en `"Hola"`, la `H` está en la posición 0 y la `a`, en la 3.
- `print` recibe un texto: para escribir un número solo, se une a un texto vacío, `print("" + 5)`.

| Método | Qué hace | Ejemplo |
|---|---|---|
| `Math.sqrt(x)` | Raíz cuadrada. Devuelve un `double` | `Math.sqrt(9)` → `3.0` |
| `Math.pow(a, b)` | `a` elevado a `b`. Devuelve un `double` | `Math.pow(3, 2)` → `9.0` |
| `Math.max(a, b)` | El mayor de los dos (`Math.min`, el menor) | `Math.max(3, 8)` → `8` |
| `Math.round(x)` | Redondea al entero más cercano. Para dejar dos decimales: `Math.round(x * 100) / 100.0` | `Math.round(2.6)` → `3` |
| `Math.PI` | El número π (una constante, sin paréntesis) | `3.141592653589793` |
| `texto.length()` | Cuántos caracteres tiene | `"Hola".length()` → `4` |
| `texto.toUpperCase()` | El texto en mayúsculas (`toLowerCase`, en minúsculas) | `"Hola".toUpperCase()` → `"HOLA"` |
| `texto.charAt(n)` | El carácter de la posición `n`, como `char` | `"Hola".charAt(1)` → `'o'` |
| `texto.indexOf(t)` | La posición donde empieza `t`, o `-1` si no está | `"Hola".indexOf("la")` → `2` |
| `texto.substring(n)` | El trozo desde la posición `n` hasta el final | `"Hola".substring(2)` → `"la"` |

Los demás métodos están en la documentación oficial, en inglés: ver «Dónde consultar», en el README de `apuntes/`.
