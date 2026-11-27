# 1ª evaluación · PROG

[← Programación](README.md)

Cómo se calcula la nota de la 1ª evaluación, qué contenidos entran en los exámenes y planificación semanal. La planificación empieza el 2 de noviembre; lo que ya evaluó Julia (exámenes y tareas de Teams) está en la fila «Antes del 2 nov».

**En este documento:** [Cómo se evalúa](#cómo-se-evalúa-de-dónde-sale-la-nota) · [Qué entra en los exámenes](#qué-entra-en-los-exámenes) · [Rúbricas](#rúbricas) · [Planificación semanal](#planificación-semanal) · [Notas](#notas)

## Cómo se evalúa: de dónde sale la nota

Porcentajes sobre la nota de la evaluación: entre todas las partes suman 100 %.

| Parte | Peso | Qué incluye |
|---|---|---|
| **P** · exámenes parciales | 40 % | Lo evaluado por Julia: P1 (Julia) 7,9 %<br>P2 · mié 2 dic: 32,1 % |
| **A** · actividades guiadas | 20 % | 3 actividades, 6,7 % cada una. Nivel de implementación (50 %) y de comprensión (50 %) |
| **F** · examen final | 30 % | jue 10 dic |
| **R** · autoevaluación | 10 % | Una sola, la semana del examen final: una tarea de Teams con la [plantilla de autoevaluación](autoevaluacion-1a.xlsx) |
| **C** · cuestionarios | — | 3 cuestionarios. No tienen nota propia, pero su entrega es obligatoria: sin todos ellos entregados, la R es un 0 |

## Qué entra en los exámenes

Los porcentajes de esta sección no son partes de la nota: dicen cuánto pesa cada unidad y cada contenido **dentro de los exámenes**. Con ellos se reparte el 40 % de los exámenes parciales (P) entre lo que evaluó Julia y el examen parcial, y valen igual para el examen final (F), que pregunta todas las unidades: los contenidos con más porcentaje tienen preguntas que valen más. Cada porcentaje es la suma de los pesos de sus criterios de evaluación en la programación oficial. Las actividades guiadas (A) y la autoevaluación (R) cuentan aparte, como se indica en «Cómo se evalúa».

### UD1 · Fundamentos de Java

Pesa un 18,2 % en los exámenes (6 % del módulo).

| Contenido | Peso en la unidad |
|---|---|
| Tipos, variables, constantes, operadores, comentarios, programas simples y consola | 60 % |
| Estructura del programa, proyectos, entorno y compilación | 30 % |
| Conversiones de tipo y formatos de salida | 10 % |

### UD2 · Control de flujo y excepciones

Pesa un 30,3 % en los exámenes (10 % del módulo).

| Contenido | Peso en la unidad |
|---|---|
| Selección y programas con varias estructuras de control | 29 % |
| Bucles, saltos y control de excepciones | 57 % |
| Probar un programa | 14 % |

### UD3 · Funciones

Pesa un 21,2 % en los exámenes (7 % del módulo).

| Contenido | Peso en la unidad |
|---|---|
| Métodos: parámetros, retorno, ámbito, sobrecarga y recursividad | 100 % |

### UD4 · Arrays, cadenas y regex

Pesa un 30,3 % en los exámenes (10 % del módulo).

| Contenido | Peso en la unidad |
|---|---|
| Arrays, matrices y cadenas | 80 % |
| Expresiones regulares | 20 % |

## Rúbricas

Cómo se califica cada parte de la evaluación.

### Exámenes parciales (P) y examen final (F)

En papel, con preguntas de dos tipos, de 1 punto cada una: verdadero o falso (cada acierto suma 1, cada error resta 0,5 y una pregunta en blanco vale 0; esta parte nunca baja de 0) y unir pares (0,25 por cada pareja bien unida; las mal unidas no restan). Los contenidos con más porcentaje tienen más preguntas, y la nota es proporcional a los puntos obtenidos. La rúbrica de cada examen se publica aquí antes del examen.

### Actividades guiadas (A)

Se califican una vez terminadas, por su **nivel de implementación y comprensión**, y cómo depende del tipo de actividad:

- **Proyecto de progresión continuada** (un mismo proyecto que avanza de una actividad a la siguiente): se califica **hasta dónde se ha implementado la solución final del proyecto**, no cada actividad por separado. Todas sus actividades tienen la misma nota.
- **Actividad independiente:** se califica su propio resultado.

La nota tiene dos mitades:

- **Implementación (50 %):** con el proyecto propio, en el ordenador, se muestran, por orden, las comprobaciones de las tablas de abajo: 12 por proyecto o actividad, 3 en cada nivel (del 1, lo más básico, al 4). Cada comprobación que sale bien suma por sí misma, aunque falle alguna de un nivel anterior: la nota de implementación es las que salen bien entre 12, por 10.
- **Comprensión (50 %):** cuánto se sabe explicar. Se hacen 4 preguntas sobre el diseño y la arquitectura, una por nivel, sobre lo que se muestra en ese nivel; se hacen las cuatro aunque no se haya alcanzado el nivel. Cada respuesta bien dada vale 2,5. De qué trata cada pregunta, en las tablas de abajo.

#### A1 · Java 0

**Implementación** (12 comprobaciones; cada una que sale bien suma 10/12)

| Nivel | Muestra que… |
|---|---|
| **1** | • `Principal` y `Auxiliar` compilan desde el terminal<br>• el programa se ejecuta y muestra su salida<br>• `Principal` usa los métodos `print` y `getInt` de `Auxiliar` |
| **2** | • `Principal` llama a esos métodos con `import static`, sin el nombre de la clase<br>• las dos clases están en el paquete `dam`<br>• cada paquete está en una carpeta con su nombre |
| **3** | • se compila desde la raíz del proyecto<br>• el bytecode (los `.class`) queda en `bin`<br>• se ejecuta con `java -cp bin dam.Principal` |
| **4** | • existe el zip del proyecto<br>• el zip contiene `src` y `bin`<br>• se ve lo que contiene el zip sin descomprimirlo |

**Comprensión** (una pregunta por nivel; se hacen las cuatro)

| Nivel | La pregunta trata sobre… |
|---|---|
| 1 | Qué hacen `javac` y `java` |
| 2 | `import static` y por qué cada paquete va en su carpeta |
| 3 | Dónde quedan y dónde se buscan las clases compiladas |
| 4 | Cómo se comprime el proyecto y se ve el zip |

#### A2–A3 · Proyecto «CSV notas»

Proyecto de progresión continuada: A2 y A3 tienen la misma nota, la del proyecto entero.

**Implementación** (12 comprobaciones; cada una que sale bien suma 10/12)

| Nivel | Muestra que… |
|---|---|
| **1** | • genera el CSV: sale `Líneas: 26`<br>• carga los alumnos: sale `Alumnos: 25`<br>• salen el primer y el último alumno con sus tres notas |
| **2** | • busca un alumno por su nombre y dice si está<br>• muestra sus notas y su media<br>• muestra el mejor de un trimestre |
| **3** | • el menú muestra sus opciones y se elige con un número<br>• muestra los mejores de cada trimestre y del curso<br>• no se rompe al escribir algo que no es un número |
| **4** | • las líneas del CSV se comprueban con una expresión regular antes de cargarlas<br>• el nombre se entiende aunque se escriba en mayúsculas («NOMBRE07»)<br>• el nombre se entiende aunque lleve un espacio o le falte el cero («nombre 7») |

**Comprensión** (una pregunta por nivel; se hacen las cuatro)

| Nivel | La pregunta trata sobre… |
|---|---|
| 1 | Cómo se cargan los datos del CSV |
| 2 | Cómo se calcula la media de un alumno |
| 3 | Cómo se evita que el programa se rompa al leer un número |
| 4 | Qué es una expresión regular y para qué se usa en el proyecto |

| Comprensión | Nota |
|---|---|
| Las 4 preguntas, bien respondidas | 10 |
| 3 preguntas | 7,5 |
| 2 preguntas | 5 |
| 1 pregunta | 2,5 |
| Ninguna | 0 |

La nota es la media de las dos. El mínimo de 4 se aplica a la media de las actividades de la evaluación.

### Cuestionarios (C) y autoevaluación (R)

Hay un cuestionario cada semana en la que se facilitan apuntes o actividades guiadas nuevas, con preguntas sobre ellos. Su entrega es obligatoria, hasta el lunes siguiente a su semana, salvo que se indique otra fecha (ver las notas de la [1ª evaluación](#cómo-se-evalúa-de-dónde-sale-la-nota)). No tienen nota propia, pero son un requisito de la autoevaluación: sin todos los cuestionarios entregados, la autoevaluación (R) es un 0.

La autoevaluación (R) se hace una sola vez, la semana del examen final, con la [plantilla de autoevaluación](autoevaluacion-1a.xlsx) en una tarea de Teams. Forma el 10 % de la nota. La mitad es la hoja completa: un nivel en cada tema, un tipo de fallo donde corresponde y una frecuencia en cada hábito de estudio. La otra mitad es la reflexión final, si es concreta: nombra los temas o los hábitos que más fallan y qué se va a hacer, en concreto, para mejorarlos. Requisito: tener entregados todos los cuestionarios (C); si falta alguno, la R es un 0. Lo marcado en cada tema y en cada hábito no cambia la nota.

## Planificación semanal

| Semana | Qué se trabaja | Cómo se evalúa | Exámenes |
|---|---|---|---|
| Antes del 2 nov<br>[repaso Julia](../repaso-julia/apuntes)<br>[examen de octubre](../examen-julia/enunciado.md) | Lo evaluado por Julia | — | **P1 (Julia)** (7,9 %) |
| [2–6 nov](../2026_11_02-06)<br>[apuntes](../2026_11_02-06/apuntes) · [actividades](../2026_11_02-06/actividades) | UD1 · Tipos, variables, constantes, operadores, comentarios, programas simples y consola<br>UD1 · Estructura del programa, proyectos, entorno y compilación<br>UD1 · Conversiones de tipo: la teoría<br>UD2 · Selección (if y switch): la teoría<br>UD2 · Bucles, saltos y excepciones: la teoría<br>UD2 · Probar un programa: la teoría | A1 (6,7 %), C1 | — |
| [9–13 nov](../2026_11_09-13)<br>[apuntes](../2026_11_09-13/apuntes) · [actividades](../2026_11_09-13/actividades) | UD1 · Formatos de salida: String.format en el proyecto<br>UD2 · Varias estructuras de control: el menú del proyecto, con do-while y switch<br>UD2 · Bucles, saltos y excepciones en el proyecto: recorrer arrays y leer números con try-catch<br>UD3 · Métodos: parámetros, retorno, ámbito, sobrecarga y recursividad<br>UD4 · Arrays, matrices y cadenas | A2 (6,7 %), C2 | — |
| [16–20 nov](../2026_11_16-20)<br>[apuntes](../2026_11_16-20/apuntes) · [actividades](../2026_11_16-20/actividades) | UD4 · Expresiones regulares: dos casos de uso en «CSV notas»<br>A3: continuación de la A2 «CSV notas» (pasos 3 a 10) y expresiones regulares | A3 (6,7 %), C3 | — |
| [23–27 nov](../2026_11_23-27)<br>[actividades](../2026_11_23-27/actividades) | Repaso de toda la evaluación | — | — |
| 30 nov–4 dic | Repaso (jue 3 y vie 4) | — | **P2** (32,1 %), mié 2 dic |
| 7–11 dic | Repaso (mié 9)<br>UD5 · POO I: Clases (desde el vie 11) | R (10 %) | **F** (30 %), jue 10 dic |
| 14–18 dic | UD5 · POO I: Clases | Cierre de la 1ª evaluación · jue 17 | — |

## Notas

- **Cuestionarios (C).** Hay uno cada semana en la que se facilitan apuntes o actividades guiadas nuevas, con preguntas sobre ellos. Su entrega es obligatoria, hasta el lunes siguiente a su semana, salvo que se indique otra fecha (ver las notas). No tienen nota propia, pero sin todos los cuestionarios entregados, la autoevaluación (R) es un 0.
- **Autoevaluación (R).** La R es de reflexión. Una sola, la semana del examen final, en una tarea de Teams: la [plantilla de autoevaluación](autoevaluacion-1a.xlsx), que cada estudiante rellena en su propia copia. Por cada tema de cada unidad, el nivel de comprensión y el tipo de fallo principal; la frecuencia de 15 hábitos de estudio, y una reflexión general sobre qué hacer para mejorar en la 2ª evaluación. Forma el 10 % de autoevaluación del apartado 6.1 de la programación oficial. La mitad de su nota es la hoja completa; la otra mitad, la reflexión, si es concreta. Requisito: tener entregados todos los cuestionarios (C); si falta alguno, la R es un 0. Lo marcado en cada tema y en cada hábito no cambia la nota.
- **Exámenes escritos** (parciales, **P**, y final, **F**). Son en papel, sobre los mismos contenidos que los cuestionarios, con preguntas de dos tipos, de 1 punto cada una: verdadero o falso (cada acierto suma 1, cada error resta 0,5 y una pregunta en blanco vale 0; esta parte nunca baja de 0) y unir pares (0,25 por cada pareja bien unida; las mal unidas no restan). Los contenidos con más porcentaje tienen más preguntas, y la nota es proporcional a los puntos obtenidos.
- **Actividades guiadas (A).** Se califican, una vez terminadas, por su nivel de implementación y comprensión, al 50 %. Si son partes de un proyecto de progresión continuada, se califica hasta dónde se ha implementado la solución final del proyecto, con la misma nota para todas; si son independientes, cada una por su resultado. Implementación: 12 comprobaciones ordenadas en 4 niveles; cada una que sale bien suma 10/12. Comprensión: 4 preguntas sobre el diseño y la arquitectura, una por nivel (2,5 cada una); qué pide cada nivel, en las [rúbricas](#rúbricas). Detalle, en las [rúbricas](#rúbricas). El mínimo de 4 se aplica a la media de las actividades de la evaluación.
- En Teams no hay tareas entregadas de PROG.
- El C1 se entrega el lunes 16 de noviembre. El C2 se entrega junto con el C3, el lunes 23 de noviembre, porque «CSV notas» se termina en la semana del 16 al 20.
- Se aplazan al final del curso (3ª evaluación) el depurador, Javadoc (CA3.7) y las excepciones propias y aserciones (CA3.8 y CA3.9): en la 1ª evaluación, la UD2 se calcula con lo que se da (CA3.1–3.6).
- En la programación todo se evaluaba con lista de cotejo; ahora se evalúa con exámenes, y esa lista sirve para corregirlos.
- En la UD4, la programación da el mismo peso (50 %) a los arrays (CA6.1) y a las expresiones regulares (CA6.7). Las expresiones regulares se ven por encima, con dos casos de uso en la semana del 16 al 20, para que dé tiempo a repasar toda la evaluación antes de los exámenes; por eso, en la 1ª evaluación, pesan un 20 % y los arrays, matrices y cadenas, trabajados a fondo en el proyecto «CSV notas», un 80 %.
- El examen parcial pregunta todo lo de la 1ª evaluación que no evaluó Julia, aunque sea de forma breve. Lo que ya evaluó Julia (fila «Antes del 2 nov» de la planificación semanal) cuenta con esa nota; si no se hizo ese examen o no se entregó esa tarea, en esa parte se obtiene un 5. El examen final pregunta toda la evaluación.
- Mínimo de 4 en cada examen parcial, en la media de las actividades guiadas y en el final para aplicar la media (apartado 6.1 de la programación oficial).
