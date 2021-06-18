package src.tablero;

public class Tablero {

    Casilla [][] casillas = new Casilla[8][8];
    Ficha [] fichasOponente = new Ficha[12];
    Ficha [] fichasJugador = new Ficha[12];

    public Tablero() {

    }

    public void dibujarTablero() {
        crearFichas(fichasJugador, Color.BLACK);
        crearFichas(fichasOponente, Color.RED);
        llenarCasillas();
        refrescarTablero();
        colocarFicha(0, 0);
        System.out.println();
        refrescarTablero();


    }

    public void refrescarTablero() {
        for (int i = 0; i < casillas.length; i++) {
            dibujarTopLinea(i);
            dibujarMedio(i);
            dibujarTopLinea(i);
        }
    }

    public void dibujarTopLinea(int fila){
        //for (int j = 0; j < 3; j++) {
            for (int i = 0; i < casillas[0].length; i++) {
                System.out.print(casillas[fila][i].getTop());
            }
            System.out.println();
        //}
    }

    public void dibujarMedio(int fila){
        //for (int j = 0; j < 3; j++) {
            for (int i = 0; i < casillas[0].length; i++) {
                System.out.print(casillas[fila][i].getMedio());
            }
            System.out.println();
        //} 
    }

    public void llenarCasillas(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if (i%2 == 0) {
                    if (j%2 != 0) {
                        casillas[i][j] = new Casilla(Color.RED);
                    } else {
                        casillas[i][j] = new Casilla(Color.WHITE);
                    }
                    
                } else {
                    if (j%2 == 0) {
                        casillas[i][j] = new Casilla(Color.RED);
                    } else {
                        casillas[i][j] = new Casilla(Color.WHITE);
                    }
                    
                }
                
            }
        }
    }

    public void colocarFicha(int fila, int columna) {
        casillas[fila][columna].setFicha(fichasJugador[0]);
    }



    public void crearFichas(Ficha[] fichas, String color) {
        for (int i = 0; i < fichas.length; i++) {
            fichas[i] = new Ficha(color);
        }
    }
}