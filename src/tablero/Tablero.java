package src.tablero;

public class Tablero {

    Casilla[][] casillas = new Casilla[8][8];
    Ficha[] fichasOponente;
    Ficha[] fichasJugador;

    public Tablero(Ficha[] fichasOponente, Ficha[] fichasJugador) {
        this.fichasJugador = fichasJugador;
        this.fichasOponente = fichasOponente;
    }

    public void dibujarTablero() {
        crearFichas(fichasJugador, Color.BLACK);
        crearFichas(fichasOponente, Color.RED);
        crearTablero();
        System.out.println();
        fichasIniciales(fichasJugador, false);
        fichasIniciales(fichasOponente, true);
        System.out.println("\n------------------TABLERO DE DAMAS ESPAÑOLAS-------------------\n");
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
        System.out.println("     A      B      C      D      E      F      G      H");
        for (int i = 0; i < casillas.length; i++) {
            System.out.print("  ");
            dibujarTopLinea(i);
            System.out.print((i+1) +" ");
            dibujarMedio(i);
            System.out.print("  ");
            dibujarTopLinea(i);
        }
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

    public void crearTablero(){
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
}