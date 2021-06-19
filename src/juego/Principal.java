package src.juego;

import src.jugador.VectorJugador;
import src.tablero.Tablero;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
    }

    VectorJugador tablaJugadores;
    Tablero tablero;

    public Principal(){
        tablaJugadores = new VectorJugador();
        //tablero = new Tablero();
        menuPrincipal();

    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + margenes(20) + "MENU" + margenes(21));
            System.out.println("1) Jugar \n2) Nuevo Jugador \n3) Mostrar Jugadores \n4) Salir");
            System.out.println(margenes(45));
            opcion = ManejoInfo.getEntero("una opcion");
            switch (opcion) {
                //case 1 -> {tablero.dibujarTablero();}
                case 2 -> {tablaJugadores.registrarJugador();}
                case 3 -> {tablaJugadores.mostrarJugadores();}
                case 4 -> {salir = true; System.out.println("\nVuelve pronto :)\n");}
                default -> {System.out.println("Ups, esa opción no existe :c");}
            }
        }
    }

    public static String margenes(int cantidad) {
        String guiones = "";
        for (int i = 0; i < cantidad; i++) {
            guiones += "-";
        }
        return guiones;
    }
}
