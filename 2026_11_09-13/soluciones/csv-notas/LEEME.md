# CSV notas

Un programa de consola que genera las notas de 25 alumnos en los tres trimestres, en porcentaje y en formato CSV, y responde, con un menú:

| Opción | Qué hace | Método de `Notas` que usa |
|---|---|---|
| 1. ¿Está en la lista? | Dice si un nombre está y en qué posición, sin distinguir mayúsculas ni espacios | `buscarPosNombre` |
| 2. Notas de un alumno | Sus tres notas y su media, con un decimal | `buscarPosNombre` y `mediaDadasNotas` |
| 3. Mejor de un trimestre | Quién tiene la mejor nota del trimestre elegido | `mejorDelTrimestre` |
| 4. Mejores de cada trimestre y del curso | El mejor de cada trimestre y el de mejor media | `mejorDelTrimestre`, `mejorDelCurso` y `mediaDadasNotas` |
| 5. Aprobados de un trimestre | Quién tiene 50 o más en el trimestre elegido y cuántos son | — (el recorrido está en `Principal`, con `continue`) |

Los datos se generan y se cargan al empezar con `generarLineas` (notas al azar con la semilla 2627: siempre las mismas), `cargarNombres` y `cargarNotas`. Si se escribe algo que no es un número, `getInt` avisa y vuelve a preguntar.

| Archivo | Qué hay |
|---|---|
| `src/dam/Principal.java` | El `main`, que elige qué se ejecuta; `actividad()`, con el menú; y un método por opción |
| `src/dam/Auxiliar.java` | `print`, `getInt` (repite la pregunta hasta recibir un número), `getFloat` (un número con decimales), `getString` y `ejercicio1`, el ejercicio de tablas |
| `src/dam/notas/Notas.java` | Los métodos auxiliares; también `mediaDadoNombre`, la media dado el CSV y la posición, del paso 4, que el menú no usa |

Desde esta carpeta, en el terminal de Linux:

```bash
javac -d bin src/dam/*.java src/dam/notas/*.java
java -cp bin dam.Principal
```
