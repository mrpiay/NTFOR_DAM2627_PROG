# C3 · Cuestionario · semana del 16 al 20 de noviembre

Preguntas sobre la actividad de expresiones regulares en «CSV notas» y sobre los apuntes. Puede que sufran modificaciones a lo largo de la semana. Responde poniendo el número de cada pregunta. Se entrega junto con el C2, de la semana del 9 al 13.

Responde con tus palabras y asegúrate de que lo entiendes: en las pruebas escritas tendrás que explicarlo sin ayuda de la IA.

Si en una pregunta aparece algo que no has visto, búscalo en «Dónde consultar», en el [README de `apuntes/`](apuntes/README.md).

---

## Cuestiones sobre la actividad

**1.** Explica, símbolo a símbolo, qué comprueba el patrón de `lineaValida`: `"Nombre\\d{2};\\d{1,3};\\d{1,3};\\d{1,3}"`. ¿Qué pasaría en `cargarNotas` si una línea trajera `8a` como nota y no se comprobara antes? ¿Por qué el bucle que comprueba las líneas empieza en `i = 1`?

**2.** En el paso 1, ¿para qué sirve el `return` que hay después de avisar de las líneas no válidas? ¿Qué pasaría sin él?

**3.** ¿Qué devuelve `normalizarNombre` con cada uno de estos textos, y por qué? `"nombre 7"`, `" NOMBRE07 "`, `"Pepe"`, `"nombre 123"`. ¿Por qué se usa `replaceAll("\\s+", "")` y no `trim()`?

**4.** ¿Por qué en el código Java las expresiones regulares llevan la barra doble, `"\\d"`, y no `"\d"`? ¿Qué pasa si se escribe con una sola?

## Cuestiones sobre los apuntes

Estas preguntas se responden con los apuntes de esta semana, en `apuntes/`.

**5.** Escribe, como se escribirían en Java, los patrones de: un código postal (5 cifras), un DNI (8 cifras y una letra mayúscula), una hora como `09:45` y una matrícula de coche como `1234BCD` (4 cifras y 3 letras mayúsculas).

**6.** ¿Cuáles de estos textos encajan con `"\\d{2,3}[a-z]+"` usando `matches`, y por qué los demás no? `"12a"`, `"1a"`, `"123abc"`, `"1234a"`, `"12A"`.

**7.** ¿Qué diferencia hay entre `texto.matches(regex)` y buscar con `Pattern` y `Matcher` usando `find()`? ¿Qué muestra este código?

```java
Pattern patron = Pattern.compile("\\d+");
Matcher m = patron.matcher("Tengo 3 gatos y 12 peces");
while (m.find()) {
    System.out.println(m.group());
}
```

**8.** ¿Qué devuelve cada una de estas expresiones? `"Ana ; 7 ;8".split("\\s*;\\s*")` y `"Nombre07".replaceAll("\\d", "#")`.
