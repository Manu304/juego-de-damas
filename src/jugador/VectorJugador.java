package src.jugador;

import src.juego.ManejoInfo;
import src.juego.Principal;

public class VectorJugador {
    private final int CANTIDAD = 5;
    Jugador[] jugadores = new Jugador[CANTIDAD];
    private int indiceJugador = 0;

    public VectorJugador(){

    }

    public void registrarJugador(){
        String nombre = ManejoInfo.getTexto("el nombre del jugador");
        jugadores[indiceJugador] = new Jugador(nombre);
        indiceJugador++;
    }

    public void mostrarJugadores() {
        System.out.println("\n" + Principal.margenes(25) + "JUGADORES REGISTRADOS" + Principal.margenes(26));
        System.out.println("    NOMBRE     PUNTUACION    PARTIDAS JUGADAS    GANADAS     PERDIDAS");
        System.out.println(Principal.margenes(72));
        for (int i = 0; i < indiceJugador; i++) {
            System.out.println(jugadores[i].getInfo());
        }
    }
}
