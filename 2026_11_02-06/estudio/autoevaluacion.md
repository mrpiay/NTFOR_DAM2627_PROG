# Autoevaluación · semana del 2 al 6 de noviembre

Preguntas sobre «Java 0». Puede que sufran modificaciones a lo largo de la semana. Responde poniendo el número de cada pregunta.

En las preguntas de código, parte del proyecto `java-pr0` terminado: cambia el `main` de `Principal` (o añade el método a `Auxiliar`) como se indica, y desde la carpeta `java-pr0` compila y ejecuta:

```bash
javac -d bin src/dam/*.java
java -cp bin dam.Principal
```

En cada una, copia en tu respuesta lo que sale por pantalla y asegúrate de que lo entiendes: en las pruebas escritas tendrás que explicarlo sin ayuda de la IA.

---

**1.** En `public static int getInt()`, ¿qué significan `public`, `static` e `int`?

**2.** Cambia el `main` de `Principal` por esto. Cuando pida la edad, escribe `20`.

```java
        print("Edad?");
        print("Tienes " + getInt() * 12 + " meses");
```

Copia lo que sale por pantalla.

**3.** Cambia el `main` por esto:

```java
        print("Tienes " + 20 + 1 + " años");
        print("Tienes " + (20 + 1) + " años");
```

Copia lo que sale por pantalla.

**4.** ¿Qué tiene que ser la primera línea de `Auxiliar.java` y de `Principal.java`? ¿En qué carpeta deben estar los dos archivos, y por qué?

**5.** Cambia el `main` por `print(5);` y compila. Copia lo que sale por pantalla.

**6.** Cambia el `main` por esto:

```java
        print("Raíz: " + Math.sqrt(16));
        print("Máximo: " + Math.max(7, 12));
        print("Potencia: " + Math.pow(2, 10));
```

Copia lo que sale por pantalla.

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

**9.** Cambia el `main` por esto:

```java
        String nombre = "Ana García";
        print("" + (nombre.charAt(0) + nombre.charAt(4)));
        print("" + nombre.charAt(0) + nombre.charAt(4));
```

Copia lo que sale por pantalla.

**10.** Ejecuta `java -cp bin dam.Principal` y después `java -cp bin Principal`. Copia lo que sale por pantalla.
