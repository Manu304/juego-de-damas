package src.juego;

import src.jugador.VectorJugador;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
        
    }
    VectorJugador tablaJugadores;

    public Principal(){
        tablaJugadores = new VectorJugador();

    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(margenes(40));
            System.out.println(margenes(18) + "MENU" + margenes(18));
            System.out.println("1) Jugar \n2) Nuevo Jugador \n3) Mostrar Jugadores \n4) Salir");
            System.out.println(margenes(40));
            opcion = ManejoInfo.getEntero("una opcion");
            switch (opcion) {
                case 1 -> {System.out.println("Quiere jugar");}
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
