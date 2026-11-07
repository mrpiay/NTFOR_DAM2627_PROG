package dam;

import java.util.Scanner;

public class Auxiliar {

    // Un solo teclado para todo el programa
    private static final Scanner teclado = new Scanner(System.in);

    public static void print(String texto) {
        System.out.println(texto);
    }

    public static int getInt() {
        return Integer.parseInt(teclado.nextLine().trim());
    }

    public static String getString() {
        return teclado.nextLine();
    }

}
