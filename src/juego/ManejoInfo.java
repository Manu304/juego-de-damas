package src.juego;

import java.util.Scanner;

public class ManejoInfo {
    static Scanner scanner = new Scanner(System.in);

    private static void imprimirMensaje(String mensaje) {
        System.out.print("Ingrese " + mensaje + ": ");
    }

    public static int getEntero(String mensaje) {
        imprimirMensaje(mensaje);
        int tmp = scanner.nextInt();
        if (tmp < 0) {
            do {
                imprimirMensaje("\nERROR. No puede ingresar números negativos\n");
                imprimirMensaje(mensaje);
                tmp = scanner.nextInt();
            } while (tmp < 0);
        }

        return tmp;
    }

    public static String getTexto(String mensaje) {
        imprimirMensaje(mensaje);
        scanner.nextLine();
        String res = scanner.nextLine().toLowerCase().trim();
        return res;
    }

    public static int aleatorio(int minimo, int maximo) {
        int aleatorio = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
        return aleatorio;
    }

    public static String llenarEspacio(String palabra, int max){
        while (palabra.length() < max) {
            palabra += " ";
        }
        return palabra;
    }
}
