package dam;

import java.util.Arrays;
import static dam.notas.Notas.*;
import static dam.Auxiliar.*;

public class Principal {

    public static void main(String[] args) {
        actividad();      // el proyecto guiado «CSV notas»
        // ejercicio1();    // el ejercicio de tablas, en Auxiliar
    }

    // El proyecto guiado «CSV notas»
    private static void actividad() {
        print("=== CSV notas ===");

        String[] lineas = generarLineas(25, 2627);
        String[] nombres = cargarNombres(lineas);
        int[][] notas = cargarNotas(lineas);
        print("Alumnos: " + nombres.length);

        int opcion;
        do {
            print("");
            print("1. ¿Está en la lista?");
            print("2. Notas de un alumno");
            print("3. Mejor de un trimestre");
            print("4. Mejores de cada trimestre y del curso");
            print("5. Aprobados de un trimestre");
            print("0. Salir");
            print("Opción:");
            opcion = getInt();
            switch (opcion) {
                case 1:
                    opcionEstaEnLaLista(nombres);
                    break;
                case 2:
                    opcionNotasDeUnAlumno(nombres, notas);
                    break;
                case 3:
                    opcionMejorDeUnTrimestre(nombres, notas);
                    break;
                case 4:
                    opcionMejores(nombres, notas);
                    break;
                case 5:
                    opcionAprobados(nombres, notas);
                    break;
                case 0:
                    print("Hasta luego");
                    break;
                default:
                    print("Opción no válida");
            }
        } while (opcion != 0);
    }

    // Paso 3
    static void opcionEstaEnLaLista(String[] nombres) {
        print("Nombre:");
        String nombre = getString();
        int pos = buscarPosNombre(nombres, nombre);
        if (pos == -1) {
            print(nombre + " no está en la lista");
        } else {
            print(nombres[pos] + " está en la posición " + pos);
        }
    }

    // Paso 4
    static void opcionNotasDeUnAlumno(String[] nombres, int[][] notas) {
        print("Nombre:");
        String nombre = getString();
        int pos = buscarPosNombre(nombres, nombre);
        if (pos == -1) {
            print(nombre + " no está en la lista");
        } else {
            print(nombres[pos] + ":" + Arrays.toString(notas[pos])
                    + " media " + String.format("%.1f", mediaDadasNotas(notas[pos])));
        }
    }

    // Paso 5
    static void opcionMejorDeUnTrimestre(String[] nombres, int[][] notas) {
        print("Trimestre (1, 2 o 3):");
        int trimestre = getInt();
        if (trimestre < 1 || trimestre > 3) {
            print("No hay trimestre " + trimestre);
        } else {
            int mejor = mejorDelTrimestre(notas, trimestre);
            print("Trimestre " + trimestre + ": " + nombres[mejor] + " (" + notas[mejor][trimestre - 1] + ")");
        }
    }

    // Paso 6
    static void opcionMejores(String[] nombres, int[][] notas) {
        for (int t = 1; t <= 3; t++) {
            int mejor = mejorDelTrimestre(notas, t);
            print("Trimestre " + t + ": " + nombres[mejor] + " (" + notas[mejor][t - 1] + ")");
        }
        int mejorCurso = mejorDelCurso(notas);
        print("Curso: " + nombres[mejorCurso] + " (media "
                + String.format("%.1f", mediaDadasNotas(notas[mejorCurso])) + ")");
    }

    // Paso 9
    static void opcionAprobados(String[] nombres, int[][] notas) {
        print("Trimestre (1, 2 o 3):");
        int trimestre = getInt();
        if (trimestre < 1 || trimestre > 3) {
            print("No hay trimestre " + trimestre);
            return;
        }
        int col = trimestre - 1;
        int aprobados = 0;
        for (int pos = 0; pos < nombres.length; pos++) {
            if (notas[pos][col] < 50) {
                continue;                   // suspenso: pasa al siguiente
            }
            print(nombres[pos] + " (" + notas[pos][col] + ")");
            aprobados++;
        }
        print("Aprobados: " + aprobados + " de " + nombres.length);
    }

}
