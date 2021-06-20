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
        if (indiceJugador < CANTIDAD) {
            System.out.println("\n" + Principal.margenes(10) + "REGISTRANDO NUEVO JUGADOR" + Principal.margenes(10) + "\n");
            String nombre = ManejoInfo.getTexto("el nombre del jugador");
            jugadores[indiceJugador] = new Jugador(nombre);
            indiceJugador++;
        } else {
            System.out.println("\nNo se pueden registrar mas jugadores!\n");
        }
    }

    public void mostrarJugadores() {
        if (indiceJugador > 0) {
            ordenPorGanadas(true);
            System.out.println("\n" + Principal.margenes(27) + "JUGADORES REGISTRADOS" + Principal.margenes(27));
            System.out.println("No.    NOMBRE     PUNTUACION    PARTIDAS JUGADAS    GANADAS     PERDIDAS");
            System.out.println(Principal.margenes(75));
            for (int i = 0; i < indiceJugador; i++) {
                System.out.println((i+1) + "     " + jugadores[i].getInfo());
            }
            System.out.println(Principal.margenes(75));
        } else {
            System.out.println("\nNo hay jugadores registrados. Desea registrar uno? \n1) Si \n2) No");
            int opcion = ManejoInfo.getEntero("una opción");
            if (opcion == 1) {
                registrarJugador();
            }
        }
    }

    public Jugador seleccionar(int indice){
        return jugadores[indice];
    }

    public void ordenPorGanadas(boolean ascendente){
        boolean cambio = true;
        Jugador selec = null;
        int pos = 0;

        for (int i = 0; i < indiceJugador; i++) {
            selec = jugadores[i];
            pos = i;

            for (int j = i+1; j < indiceJugador; j++) {
                
                if (ascendente) {
                    cambio = selec.getGanadas() > jugadores[j].getGanadas();
                    
                }else{
                    cambio = selec.getGanadas() < jugadores[j].getGanadas();
                }
                if (cambio){
                    selec = jugadores[j];
                    pos = j;
                }
            }
            jugadores[pos] = jugadores[i];
            jugadores[i] = selec;
        }
    }

    public int getIndiceJugador() {
        return indiceJugador;
    }
    
}
