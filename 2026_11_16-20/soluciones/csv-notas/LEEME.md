# CSV notas, con expresiones regulares

El proyecto «CSV notas» completo (semanas del 9 al 13 y del 16 al 20), con los dos pasos de expresiones regulares de la semana del 16 al 20:

| Paso | Qué hace | Dónde |
|---|---|---|
| 1 | Antes de cargar los datos, comprueba con `matches` que cada línea del CSV tiene la forma `NombreNN;nota;nota;nota`; si alguna no la tiene, avisa y no sigue | `lineaValida` en `Notas`; la comprobación, en `actividad()` de `Principal` |
| 2 | Las opciones 1 y 2 entienden «nombre 7», «NOMBRE07» o « Nombre07 »: quita los espacios con `replaceAll`, comprueba la forma con `matches` y lo reescribe como «Nombre07» | `normalizarNombre` en `Notas`; su uso, en `opcionEstaEnLaLista` y `opcionNotasDeUnAlumno` |

Compilar y ejecutar, desde la carpeta `csv-notas`:

```bash
javac -d bin src/dam/*.java src/dam/notas/*.java
java -cp bin dam.Principal
```
