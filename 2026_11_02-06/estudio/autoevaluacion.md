# Autoevaluación · semana del 2 al 6 de noviembre

Preguntas sobre «Java 0». Puede que sufran modificaciones a lo largo de la semana. Responde poniendo el número de cada pregunta.

En las preguntas de código, parte del proyecto `java-pr0` terminado: cambia el `main` de `Principal` (o añade el método a `Auxiliar`) como se indica, y desde la carpeta `java-pr0` compila y ejecuta:

```bash
javac -d bin src/dam/*.java
java -cp bin dam.Principal
```

Copia en tu respuesta lo que imprime y explica por qué sale eso.

---

**1.** En `public static int getInt()`, ¿qué significan `public`, `static` e `int`?

**2.** Cambia el `main` de `Principal` por esto. Cuando pida la edad, escribe `20`.

```java
        print("Edad?");
        print("Tienes " + getInt() * 12 + " meses");
```

¿Qué imprime? ¿Por qué no sale `2012`?

**3.** Cambia el `main` por esto:

```java
        print("Tienes " + 20 + 1 + " años");
        print("Tienes " + (20 + 1) + " años");
```

¿Qué imprime cada línea? ¿Por qué son distintas?

**4.** ¿Qué tiene que ser la primera línea de `Auxiliar.java` y de `Principal.java`? ¿En qué carpeta deben estar los dos archivos, y por qué?

**5.** Cambia el `main` por `print(5);` y compila. ¿Compila? Copia el error y explícalo. ¿Cómo lo cambias para que imprima `5` usando `print`?

**6.** Cambia el `main` por esto:

```java
        print("Raíz: " + Math.sqrt(16));
        print("Máximo: " + Math.max(7, 12));
        print("Potencia: " + Math.pow(2, 10));
```

¿Qué imprime? ¿Por qué la raíz y la potencia salen con `.0` y el máximo no?

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

¿Qué imprime cada línea? Explica cómo consigue la segunda dejar dos decimales.

**8.** Cambia el `main` por esto:

```java
        String nombre = "Ana García";
        print("" + nombre.length());
        print(nombre.toUpperCase());
        print("" + nombre.charAt(0));
        print("" + nombre.indexOf("G"));
        print(nombre.substring(4));
```

¿Qué imprime cada línea? ¿Desde qué número empiezan a contarse las posiciones de un `String`?

**9.** Cambia el `main` por esto:

```java
        String nombre = "Ana García";
        System.out.println(nombre.charAt(0) + nombre.charAt(4));
        System.out.println("" + nombre.charAt(0) + nombre.charAt(4));
```

¿Qué imprime cada línea? ¿Por qué la primera no imprime letras?

**10.** ¿Por qué se ejecuta con `java -cp bin dam.Principal`? ¿Qué error sale con `java -cp bin Principal` y por qué?
