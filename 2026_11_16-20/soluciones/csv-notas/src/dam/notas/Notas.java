package dam.notas;

import java.util.Random;

import static dam.Auxiliar.*; // Para poder usar print()

// Los métodos auxiliares del proyecto: uno para cada cosa

public class Notas {

    // Paso 1 · Generar y devolver CSV: un array de strings (líneas de texto)
    // con una cabecera y una línea por alumno;
    // cada línea contiene un nombre y 3 notas al azar entre 0 y 100,
    // todo separado por ;
    public static String[] generarLineas(int alumnos, long semilla) {
        Random azar = new Random(semilla);
        String[] lineas = new String[alumnos + 1];
        lineas[0] = "nombre;t1;t2;t3";
        for (int i = 1; i <= alumnos; i++) {
            int t1 = azar.nextInt(101);
            int t2 = azar.nextInt(101);
            int t3 = azar.nextInt(101);
            lineas[i] = String.format("Nombre%02d;%d;%d;%d", i, t1, t2, t3);
        }
        return lineas;
    }

    // Paso 2 · Devolver array de nombres dado el CSV
    public static String[] cargarNombres(String[] lineas) {
        String[] nombres = new String[lineas.length - 1];
        for (int pos = 1; pos < lineas.length; pos++) {
            String[] campos = lineas[pos].split(";");
            nombres[pos - 1] = campos[0].trim();
        }
        return nombres;
    }

    // Paso 2 · Devolver tabla de notas dado el CSV
    public static int[][] cargarNotas(String[] lineas) {
        int numAlumnos = lineas.length - 1;
        String[] campos = lineas[0].split(";");
        int numNotas = campos.length - 1;
        int[][] notas = new int[numAlumnos][numNotas];
        for (int fila = 1; fila <= numAlumnos; fila++) {
            campos = lineas[fila].split(";");
            for (int col = 0; col < numNotas; col++) {
                notas[fila - 1][col] = Integer.parseInt(campos[col + 1].trim());
            }
        }
        return notas;
    }

    // Paso 3 · Devolver posición de un nombre (-1 si no está)
    // dado el array de nombres y un nombre
    public static int buscarPosNombre(String[] nombres, String nombre) {
        for (int pos = 0; pos < nombres.length; pos++) {
            if (nombres[pos].equalsIgnoreCase(nombre.trim())) {
                return pos;
            }
        }
        return -1;
    }

    // Paso 4 · Devolver media de notas de un alumno, dadas las notas
    public static double mediaDadasNotas(int[] notas) {
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.length;
    }

    // Paso 4 · Devolver media de notas de un alumno, dado el CSV y la posición del nombre
    public static double mediaDadoNombre(String[] lineas, int pos) {
        if (pos == -1) {
            print("El alumno no existe");
            return -1;
        } else {
            return mediaDadasNotas(cargarNotas(lineas)[pos]);
        }
    }

    // Paso 5 · Devolver posición del alumno con la mejor nota de un trimestre (1, 2 o 3)
    // dada la tabla de notas y el trimestre
    public static int mejorDelTrimestre(int[][] notas, int trimestre) {
        int col = trimestre - 1;
        int mejor = 0;
        for (int pos = 1; pos < notas.length; pos++) {
            if (notas[pos][col] > notas[mejor][col]) {
                mejor = pos;
            }
        }
        return mejor;
    }

    // Paso 6 · Devolver posición del alumno con la mejor media del curso
    // dada la tabla de notas
    public static int mejorDelCurso(int[][] notas) {
        int mejor = 0;
        for (int pos = 1; pos < notas.length; pos++) {
            if (mediaDadasNotas(notas[pos]) > mediaDadasNotas(notas[mejor])) {
                mejor = pos;
            }
        }
        return mejor;
    }

    // Expresiones regulares, paso 1: ¿la línea tiene la forma «NombreNN;nota;nota;nota»?
    public static boolean lineaValida(String linea) {
        return linea.matches("Nombre\\d{2};\\d{1,3};\\d{1,3};\\d{1,3}");
    }

    // Expresiones regulares, paso 2: «nombre 7», «NOMBRE07»… se escriben como «Nombre07»;
    // si lo escrito no tiene la forma de un nombre, devuelve "".
    public static String normalizarNombre(String texto) {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        if (!limpio.matches("nombre\\d{1,2}")) {
            return "";
        }
        int numero = Integer.parseInt(limpio.substring(6));
        return String.format("Nombre%02d", numero);
    }

}
