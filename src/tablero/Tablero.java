package src.tablero;

import src.juego.ManejoInfo;
import src.juego.Principal;

public class Tablero {

    Casilla[][] casillas = new Casilla[8][8];
    Ficha[] fichasOponente;
    Ficha[] fichasJugador;

    public Tablero(Ficha[] fichasOponente, Ficha[] fichasJugador) {
        this.fichasJugador = fichasJugador;
        this.fichasOponente = fichasOponente;
    }

    public void dibujarTablero() {
        System.out
                .println("\n" + Principal.margenes(20) + "TABLERO DE DAMAS ESPAÑOLAS" + Principal.margenes(20) + "\n");
        refrescarTablero();

    }

    public void fichasIniciales(Ficha[] fichas, boolean oponente) {
        int contadorFicha = 0;
        int inicio = 0, fin = 3;
        if (oponente) {
            inicio = 5;
            fin = 8;
        }
        for (int i = inicio; i < fin; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    casillas[i][j].setFicha(fichas[contadorFicha]);
                    contadorFicha++;
                }
            }

        }
    }

    private void refrescarTablero() {
        System.out.println("      A      B      C      D      E      F      G      H");
        for (int i = 0; i < casillas.length; i++) {
            System.out.print("   ");
            dibujarTopLinea(i);
            System.out.print(" " + (i + 1) + " ");
            dibujarMedio(i);
            System.out.print("   ");
            dibujarTopLinea(i);
        }
    }

    //COMPONER METODO QUE PRESENTA LAS FICHAS COMIDAS DE CADA UNO

    public void fichasComidas(){
        System.out.println();
        int contadorJugador = 0;
        for (int i = 0; i < fichasJugador.length; i++) {

            if (fichasJugador[i].isComida()) {
                System.out.print(fichasJugador[i].toString() + " " + ManejoInfo.espacios(42+(12-(contadorJugador*2))));
                contadorJugador++;
            }
            if (fichasOponente[i].isComida()) {
                if (contadorJugador == 0) {
                    System.out.print(ManejoInfo.espacios(54));
                }
                System.out.print((fichasOponente[i].toString() + " "));
                if (contadorJugador == 5) {
                    System.out.println();
                }
            }

        }
        System.out.println();
    }

    private void dibujarTopLinea(int fila) {
        // for (int j = 0; j < 3; j++) {
        for (int i = 0; i < casillas[0].length; i++) {
            System.out.print(casillas[fila][i].getTop());
        }
        System.out.println();
        // }
    }

    private void dibujarMedio(int fila) {
        // for (int j = 0; j < 3; j++) {
        for (int i = 0; i < casillas[0].length; i++) {
            System.out.print(casillas[fila][i].getMedio());

        }
        System.out.println();
        // }
    }

    public void crearTablero() {
        crearTablero(Color.getColor());
    }

    private void crearTablero(String color) {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    casillas[i][j] = new Casilla(Color.WHITE);
                } else {
                    casillas[i][j] = new Casilla(color);
                }

            }
        }
    }

    public void crearFichas(Ficha[] fichas, String color) {
        for (int i = 0; i < fichas.length; i++) {
            fichas[i] = new Ficha(color);
        }
    }

    public boolean verificarFicha(Ficha[] fichas, Ficha ficha) {
        boolean correcto = false;
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i].equals(ficha)) {
                correcto = true;
            }
        }
        return correcto;
    }

    public void moverFicha(int filaIni, int columIni, int filaFin, int coluFin, Ficha[] fichasMueve) {
        //CONSIDERAR COMPROBACIONES PARA OTRO METODO QUE LOS REQUIERA
        if (casillas[filaIni][columIni].isOcupada() && verificarFicha(fichasMueve, casillas[filaIni][columIni].getFicha())) {
            Casilla inicial = casillas[filaIni][columIni];
            System.out.println("\n la ficha que voy a mover esta en fila: " + filaIni + " y columna: " + columIni);
            if (casillas[filaFin][coluFin].isOcupada() && !verificarFicha(fichasMueve, casillas[filaFin][coluFin].getFicha())) {
                comerFicha(inicial, casillas[filaFin][coluFin]);
            } else if (!casillas[filaFin][coluFin].isOcupada()) {
                casillas[filaFin][coluFin].setFicha(inicial.getFicha());
                casillas[filaIni][columIni].setFicha(null);
            }
        } else {
            System.out.println("\nLa casilla no tiene ninguna pieza tuya para mover!\n");
        }

    }

    public void comerFicha(Casilla come, Casilla comida) {
        comida.getFicha().setComida(true);
        comida.setFicha(null);
        comida.setFicha(come.getFicha());
        come.setFicha(null);
    }
}