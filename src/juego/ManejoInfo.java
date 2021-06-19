package src.juego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManejoInfo {
    static Scanner scanner = new Scanner(System.in);

    private static void imprimirMensaje(String mensaje) {
        System.out.print("Ingrese " + mensaje + ": ");
    }

    public static int getEntero(String mensaje) {
        int numero = -1;
        
        do {
            try {
                System.out.print("Ingrese " + " " + mensaje + ": ");
                int ingresado = scanner.nextInt();
                if (ingresado < 0) {
                    System.out.println("\nNo puede ingresar un valor negativo\n");
                }
                numero = ingresado;

            } catch (InputMismatchException e) {
                System.out.println("\nERROR. Debes de ingresar un numero\n");
                scanner.nextLine();
                numero = -1;
            }
        } while (numero < 0);
        return numero;
    }

    public static String getTexto(String mensaje) {
        imprimirMensaje(mensaje);
        scanner.nextLine();
        String res = scanner.nextLine().toLowerCase().trim();
        if (res.length() > 11) {
            res = res.substring(0, 10);
        }
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
