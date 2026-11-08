# Autoevaluación · semana del 9 al 13 de noviembre

Preguntas sobre el proyecto «CSV notas» y sobre los apuntes. Puede que sufran modificaciones a lo largo de la semana. Responde poniendo el número de cada pregunta.

En las preguntas de código, parte del proyecto `csv-notas` terminado. Crea `src/dam/Pregunta.java` con este código y pega el de cada pregunta donde dice `// aquí va el código de la pregunta` (antes, borra el de la anterior):

```java
package dam;

import static dam.Auxiliar.*;
import static dam.notas.Notas.*;

import java.util.Arrays;

public class Pregunta {

    public static void main(String[] args) {
        // aquí va el código de la pregunta
    }

}
```

Desde la carpeta `csv-notas`, compila y ejecuta `Pregunta` (no `Principal`):

```bash
javac -d bin src/dam/*.java src/dam/notas/*.java
java -cp bin dam.Pregunta
```

En cada una, copia en tu respuesta lo que sale por pantalla y asegúrate de que lo entiendes: en las pruebas escritas tendrás que explicarlo sin ayuda de la IA. Cuando termines, borra `Pregunta` del proyecto: `rm src/dam/Pregunta.java bin/dam/Pregunta.class`.

Si en una pregunta aparece un método que no has visto, búscalo en «Dónde consultar», en el [README de `apuntes/`](apuntes/README.md).

---

## Cuestiones sobre el proyecto

**1.** ¿Para qué sirve la semilla de `new Random(semilla)` en `generarLineas`? ¿Qué pasaría si cada uno usara una semilla distinta? ¿Por qué `generarLineas(25, 2627)` devuelve 26 líneas?

**2.** Copia lo que sale por pantalla.

```java
        String linea = "Nombre05; 28 ;74;80";
        String[] campos = linea.split(";");
        print("Campos: " + campos.length);
        print("[" + campos[1] + "]");
        print("[" + campos[1].trim() + "]");
        print("Suma: " + (Integer.parseInt(campos[1].trim()) + Integer.parseInt(campos[2])));
        print("Unidos: " + campos[2] + campos[3]);
```

**3.** Copia lo que sale por pantalla.

```java
        int[][] notas = {{42, 97, 33}, {57, 40, 88}};
        print("Filas: " + notas.length);
        print("Columnas: " + notas[0].length);
        print("Fila 1: " + Arrays.toString(notas[1]));
        print("notas[1][2]: " + notas[1][2]);
        print("Todo: " + Arrays.deepToString(notas));
```

**4.** Copia lo que sale por pantalla.

```java
        int[] trimestre1 = {42, 57, 82, 51, 28};
        int[] copia = Arrays.copyOf(trimestre1, trimestre1.length);
        Arrays.sort(copia);
        print("Ordenada: " + Arrays.toString(copia));
        print("Original: " + Arrays.toString(trimestre1));
        print("Mayor: " + copia[copia.length - 1]);
        int[] tres = Arrays.copyOf(copia, 3);
        print("Tres primeras: " + Arrays.toString(tres));
```

**5.** Copia lo que sale por pantalla.

```java
        int[] a = new int[3];
        print(Arrays.toString(a));
        Arrays.fill(a, 50);
        int[] b = {50, 50, 50};
        print(Arrays.toString(a));
        print("a == b: " + (a == b));
        print("Arrays.equals: " + Arrays.equals(a, b));
```

**6.** Copia lo que sale por pantalla.

```java
        String uno = "Nombre07";
        String dos = "  nombre07 ";
        print("equals: " + uno.equals(dos));
        print("equalsIgnoreCase: " + uno.equalsIgnoreCase(dos));
        print("Con trim: " + uno.equalsIgnoreCase(dos.trim()));
        print("contains: " + uno.contains("07"));
        print("substring: " + uno.substring(6));
        print("Número: " + Integer.parseInt(uno.substring(6)));
```

**7.** Copia lo que sale por pantalla.

```java
        int suma = 42 + 97 + 33;
        print("Sin double: " + suma / 3);
        print("Con double: " + (double) suma / 3);
        print("Con formato: " + String.format("%.2f", (double) suma / 3));
        print("Columnas: " + String.format("%-10s|%5d|", "Nombre01", 42));
```

**8.** Usa los métodos de `Notas` con otros datos. Copia lo que sale por pantalla.

```java
        String[] nombres = {"Ana", "Luis", "Marta"};
        int[][] notas = {{70, 80, 90}, {95, 60, 50}, {65, 85, 99}};
        print("Luis: " + buscar(nombres, "LUIS"));
        print("Pepe: " + buscar(nombres, "Pepe"));
        print("Media de Ana: " + media(notas[0]));
        print("Mejor del 1.º: " + nombres[mejorDelTrimestre(notas, 1)]);
        print("Mejor del 3.º: " + nombres[mejorDelTrimestre(notas, 3)]);
        print("Mejor del curso: " + nombres[mejorDelCurso(notas)]);
```

**9.** `buscar`, `mejorDelTrimestre` y `mejorDelCurso` devuelven una **posición**, no un nombre ni una nota. ¿Por qué? ¿Para qué sirve que `buscar` devuelva `-1`?

**10.** ¿Por qué los métodos auxiliares están en una clase aparte, `Notas`, en el paquete `dam.notas`? ¿Qué hace `import static dam.notas.Notas.*;`? Si el CSV tuviera cuatro trimestres en lugar de tres, ¿qué habría que cambiar en `Notas` y en `Principal`?

**11.** Copia lo que sale por pantalla. ¿Por qué no sale `Aprobado: 61`?

```java
        int[] notas = {72, 35, 90, 48, 100, 61};
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 50) {
                continue;
            }
            if (notas[i] == 100) {
                print("Un 100 en la posición " + i);
                break;
            }
            print("Aprobado: " + notas[i]);
        }
        print("Fin");
```

## Cuestiones sobre los apuntes

Estas preguntas se responden con los apuntes de cada unidad, en `apuntes/`.

**12.** Un método recibe un `int` y lo cambia; otro recibe un array y cambia uno de sus valores. ¿En cuál cambia también el original y por qué?

**13.** ¿Qué es la sobrecarga de métodos? ¿Qué es un método recursivo y qué pasa si no tiene caso base?

**14.** ¿Qué es el ámbito de una variable? ¿Pueden dos métodos distintos tener una variable con el mismo nombre?

**15.** ¿Por qué la línea `nombre.trim();`, sola, no quita los espacios de `nombre`? ¿Cómo se escribe para que sí lo haga?

**16.** ¿Qué es el formato CSV? ¿Qué pasos hay para cargar sus líneas en arrays?
