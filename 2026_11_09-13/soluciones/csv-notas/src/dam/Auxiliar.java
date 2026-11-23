package dam;

import java.util.Scanner;

public class Auxiliar {

    // Un solo teclado para todo el programa
    private static final Scanner teclado = new Scanner(System.in);

    public static void print(String texto) {
        System.out.println(texto);
    }

    public static int getInt() {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(teclado.nextLine().trim());
                break;                      // es un número: sale del bucle
            } catch (NumberFormatException e) {
                print("Eso no es un número. Prueba otra vez:");
            }
        }
        return numero;
    }

    public static double getFloat() {
        return Double.parseDouble(teclado.nextLine().trim());
    }

    public static String getString() {
        return teclado.nextLine();
    }

    // Ejercicio de tablas (antes del paso 3)
    public static void ejercicio1() {
        print("Ejercicio 1: tablas");

        // Crea una tabla de números decimales (double) con 3 filas y 2 columnas
        double[][] tabla = new double[3][2];

        // Pon todos los valores de la tabla a -1
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int col = 0; col < tabla[0].length; col++) {
                tabla[fila][col] = -1;
            }
        }

        // Pide al usuario el valor de la primera columna y última fila
        // y guárdalo en la tabla
        print("Dame número:");
        tabla[2][0] = getFloat();

        // Muestra el valor guardado desde la tabla
        print(String.valueOf(tabla[2][0]));

        // Calcula y muestra la suma de todos los valores de la primera fila
        double suma = 0;
        for (int col = 0; col < tabla[0].length; col++) {
            suma += tabla[0][col];
        }
        print(String.valueOf(suma));

        // Calcula y muestra la suma de todos los valores de la segunda columna
        suma = 0;
        for (int fila = 0; fila < tabla.length; fila++) {
            suma += tabla[fila][1];
        }
        print(String.valueOf(suma));
    }

}
