package src.juego;

import src.jugador.VectorJugador;
import src.tablero.Tablero;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
    }

    private Partida partida;
    private VectorJugador tablaJugadores;
    private Tablero tablero;

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
                case 1 -> {iniciarPartida();}
                case 2 -> {tablaJugadores.registrarJugador();}
                case 3 -> {tablaJugadores.mostrarJugadores();}
                case 4 -> {salir = true; System.out.println("\nVuelve pronto :)\n");}
                default -> {System.out.println("Ups, esa opción no existe :c");}
            }
        }
    }

    private void iniciarPartida(){
        if (tablaJugadores.getIndiceJugador() >= 2) {
            System.out.println(margenes(14) + "INICIANDO PARTIDA" + margenes(14));
            tablaJugadores.mostrarJugadores();
            int primero = ManejoInfo.getEntero("el numero del primer jugador a seleccionar");
            int segundo;
            do {
                segundo = ManejoInfo.getEntero("el numero del segundo jugador a seleccionar");
                if (primero == segundo) {
                    System.out.println("\nNo puede seleccionar al mismo jugador!\n");
                }
            } while (primero == segundo);
            partida = new Partida(tablaJugadores.seleccionar(primero-1), tablaJugadores.seleccionar(segundo-1));
            
        } else {
            System.out.println("\nNo hay suficientes jugadores registrados para iniciar la partida.");
            System.out.println("Desea registrar un jugador? \n1) Si \n2) No");
            int opcion = ManejoInfo.getEntero("una opción");
            if (opcion == 1) {
                tablaJugadores.registrarJugador();
                iniciarPartida();
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
