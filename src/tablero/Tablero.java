package src.tablero;

public class Tablero {

    Casilla[][] casillas = new Casilla[8][8];
    Ficha[] fichasOponente = new Ficha[12];
    Ficha[] fichasJugador = new Ficha[12];

    public Tablero() {

    }

    public void dibujarTablero() {
        crearFichas(fichasJugador, Color.BLACK);
        crearFichas(fichasOponente, Color.RED);
        llenarCasillas();
        refrescarTablero();
        System.out.println();
        fichasIniciales(fichasJugador, false);
        fichasIniciales(fichasOponente, true);
        refrescarTablero();

    }

    public void fichasIniciales(Ficha [] fichas, boolean oponente){
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

    public void refrescarTablero() {
        for (int i = 0; i < casillas.length; i++) {
            dibujarTopLinea(i);
            dibujarMedio(i);
            dibujarTopLinea(i);
        }
    }

    public void dibujarTopLinea(int fila) {
        // for (int j = 0; j < 3; j++) {
        for (int i = 0; i < casillas[0].length; i++) {
            System.out.print(casillas[fila][i].getTop());
        }
        System.out.println();
        // }
    }

    public void dibujarMedio(int fila) {
        // for (int j = 0; j < 3; j++) {
        for (int i = 0; i < casillas[0].length; i++) {
            System.out.print(casillas[fila][i].getMedio());
        }
        System.out.println();
        // }
    }

    public void llenarCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    casillas[i][j] = new Casilla(Color.WHITE);
                } else {
                    casillas[i][j] = new Casilla(Color.RED);
                }

            }
        }
    }

    public void colocarFicha(Ficha[] fichas, int fila, int columna) {
        casillas[fila][columna].setFicha(fichas[0]);
    }

    public void crearFichas(Ficha[] fichas, String color) {
        for (int i = 0; i < fichas.length; i++) {
            fichas[i] = new Ficha(color);
        }
    }
}