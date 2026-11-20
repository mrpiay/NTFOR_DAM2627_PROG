# Ejemplos · Paquetes, carpetas y compilación

Ejemplos del apartado «Paquetes, carpetas y compilación» de los [apuntes de UD1](UD1-fundamentos-de-java.md). Todas las órdenes se han probado en la terminal de Linux con Java 21; los errores son los que muestra Java.

## Las dos clases

`Cl1`, en el paquete `a`, tiene el `main` y usa `Cl2`, del paquete `a.b`:

```java
package a;

import a.b.Cl2;

public class Cl1 {
    public static void main(String[] args) {
        System.out.println(Cl2.saludo());
    }
}
```

```java
package a.b;

public class Cl2 {
    public static String saludo() {
        return "Hola desde a.b.Cl2";
    }
}
```

Al ejecutar `Cl1` se muestra `Hola desde a.b.Cl2`.

## 1. Fuentes en el árbol del paquete

```
proyecto/
└── src/
    └── a/
        ├── Cl1.java
        └── b/
            └── Cl2.java
```

### Compilar

| Desde | Orden | Resultado |
|---|---|---|
| `proyecto` | `javac -d bin src/a/Cl1.java src/a/b/Cl2.java` | ✅ Se le pasan los dos archivos |
| `proyecto` | `javac -d bin src/a/*.java src/a/b/*.java` | ✅ Lo mismo, con `*` |
| `proyecto` | `javac -d bin -sourcepath src src/a/Cl1.java` | ✅ Se le pasa solo `Cl1`; busca `Cl2` en `src/a/b/Cl2.java` y la compila también |
| `proyecto/src` | `javac -d ../bin a/Cl1.java` | ✅ La carpeta actual ya es la raíz de las fuentes |
| `proyecto` | `javac -d bin src/a/b/Cl2.java` | ✅ Pero solo compila `Cl2`: nadie le pide `Cl1` |
| `proyecto` | `javac -d bin src/a/Cl1.java` | ❌ `error: package a.b does not exist`: busca `Cl2` en `./a/b/`, que no existe |
| `proyecto` | `javac -d bin -sourcepath src a/Cl1.java` | ❌ `error: file not found: a/Cl1.java`: la ruta del archivo se toma desde la carpeta actual, no desde `src` |

Las órdenes correctas dejan lo mismo:

```
bin/
└── a/
    ├── Cl1.class
    └── b/
        └── Cl2.class
```

### Ejecutar

| Desde | Orden | Resultado |
|---|---|---|
| `proyecto` | `java -cp bin a.Cl1` | ✅ `Hola desde a.b.Cl2` |
| `proyecto/bin` | `java a.Cl1` | ✅ Sin `-cp`, busca en la carpeta actual, que aquí es `bin` |
| `proyecto` | `java a.Cl1` | ❌ `ClassNotFoundException: a.Cl1`: busca `./a/Cl1.class`, y está en `bin/a/` |
| `proyecto` | `java -cp bin Cl1` | ❌ `ClassNotFoundException: Cl1`: falta el paquete; el nombre completo es `a.Cl1` |
| `proyecto` | `java -cp bin a.Cl1.class` | ❌ `ClassNotFoundException: a.Cl1.class`: se escribe el nombre de la clase, sin `.class` |
| `proyecto` | `java -cp bin/a Cl1` | ❌ `NoClassDefFoundError: Cl1 (wrong name: a/Cl1)`: encuentra el archivo, pero la clase se llama `a.Cl1`; el *classpath* tiene que ser la raíz (`bin`), no la carpeta del paquete |
| `proyecto` | `java -cp bin a.b.Cl2` | ❌ `Main method not found in class a.b.Cl2`: la clase existe, pero no tiene `main` |

`java -cp bin a/Cl1` también funciona, porque Java cambia la `/` por un punto, pero el nombre de una clase se escribe con puntos.

## 2. Fuentes sueltas en la carpeta del proyecto

```
proyecto/
├── Cl1.java     (package a;)
└── Cl2.java     (package a.b;)
```

| Desde | Orden | Resultado |
|---|---|---|
| `proyecto` | `javac -d bin Cl1.java Cl2.java` | ✅ Crea `bin/a/Cl1.class` y `bin/a/b/Cl2.class`: con `-d`, el árbol sale de la línea `package`, no de dónde está el `.java` |
| `proyecto` | `java -cp bin a.Cl1` | ✅ `Hola desde a.b.Cl2` |
| `proyecto` | `javac -d bin Cl1.java` | ❌ `error: package a.b does not exist`: busca `Cl2` en `./a/b/Cl2.java`; hay que pasarle siempre todos los archivos |
| `proyecto` | `javac Cl1.java Cl2.java` | ⚠️ Compila, pero sin `-d` deja `Cl1.class` y `Cl2.class` sueltos junto a los `.java` |
| `proyecto` | `java -cp . a.Cl1` (después de la anterior) | ❌ `ClassNotFoundException: a.Cl1`: busca `./a/Cl1.class`, y el `.class` está suelto |

## En resumen

- **`javac` recibe rutas de archivo**, desde la carpeta actual. **`java` recibe el nombre completo de la clase** (`paquete.Clase`), sin ruta ni `.class`.
- **Los `.class` tienen que estar en el árbol del paquete**, a partir de la carpeta que se da en `-cp`. `-d` los coloca así.
- **Los `.java` pueden estar en cualquier sitio**, pero si siguen el árbol del paquete basta con pasarle a `javac` la clase del `main` (con `-sourcepath`): las demás las encuentra solo.
