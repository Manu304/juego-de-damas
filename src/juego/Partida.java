package src.juego;

import src.jugador.Jugador;
import src.tablero.Color;
import src.tablero.Ficha;
import src.tablero.Tablero;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugar();
    }

    private void jugar(){
        piedraPapel();
        elegirTableroFichas();
        movimientosPartida();
    }

    private void piedraPapel() {
        System.out.println();
        System.out.println(Principal.margenes(11) + "PIEDRA, PAPEL O TIJERAS" + Principal.margenes(11));
        int num1 = aleatorio(1, 3);
        int num2;
        do {
            num2 = aleatorio(1, 3);
        } while (num1 == num2);

        boolean ganaPrimero = (num1 == 1 && num2 == 3) || (num1 == 2 && num2 == 1) || (num1 == 3 && num2 == 2);
        System.out.print(jugador1.getNombre() + nombrePapel(num1));
        System.out.println("\n y " + jugador2.getNombre() + nombrePapel(num2));
        if (!ganaPrimero) {
            Jugador aux = jugador1;
            jugador1 = jugador2;
            jugador2 = aux;
        }
        System.out.println(jugador1.getNombre() + " ha ganado!!");

    }

    private void elegirTableroFichas() {
        tablero = new Tablero(jugador1.getFichas(), jugador2.getFichas());
        System.out.println("\n" + Principal.margenes(8) + "DEFINIENDO COLOR DEL TABLERO" + Principal.margenes(9));
        System.out.println("\n" + jugador1.getNombre() + " selecciona el color para el tablero: ");
        tablero.crearTablero();
        System.out.println("\n" + Principal.margenes(14) + "ESCOGIENDO FICHAS" + Principal.margenes(14));
        System.out.println("\n" + jugador1.getNombre() + " selecciona el color de tus fichas: ");
        String color1 = Color.getColor();
        String color2;
        do {
            System.out.println("\n" + jugador2.getNombre() + " selecciona el color de tus fichas: ");
            color2 = Color.getColor();
            if (color1.equals(color2)) {
                System.out.println("\nSon del mismo color que las de " + jugador1.getNombre() + "!");
            }
        } while (color1.equals(color2));
        tablero.crearFichas(jugador1.getFichas(), color1);
        tablero.crearFichas(jugador2.getFichas(), color2);
        tablero.fichasIniciales(jugador1.getFichas(), false);
        tablero.fichasIniciales(jugador2.getFichas(), true);
        tableroPartida();

    }

    private void tableroPartida() {
        tablero.dibujarTablero();
        System.out.println("\n" + Principal.margenes(29) + "JUGANDO" + Principal.margenes(30));
        String datosPlayer1 = " " + jugador1.getFichas()[0] + " " + ManejoInfo.llenarEspacio(jugador1.getNombre(), 10);
        String datosPlayer2 = " " + jugador2.getFichas()[0] + " " + jugador2.getNombre();
        String pie = datosPlayer1 + Principal.margenes(16) + "CONTRA" + Principal.margenes(16)
                + ManejoInfo.llenarEspacio(datosPlayer2, 13);
        System.out.println(pie);
        tablero.fichasComidas();
        System.out.println(Principal.margenes(66));
    }

    private String nombrePapel(int num) {
        String seleccion = "";
        switch (num) {
            case 1 -> {
                seleccion = " ha sacado piedra";
            }
            case 2 -> {
                seleccion = " ha sacado papel";
            }
            case 3 -> {
                seleccion = " ha sacado tijeras";
            }
        }
        return seleccion;
    }

    //METODOS PARA PEDIR LAS CASILLAS Y VALIDAR LOS DATOS

    private String pedirCasilla(String mensaje) {
        char columna;
        int fila;
        String casilla;
        do {
            casilla = ManejoInfo.getTextoSimple("la casilla " + mensaje);
            columna = casilla.charAt(0);
            fila = Character.getNumericValue(casilla.charAt(1));
            if (!validarColum(columna) && fila >= 9) {
                System.out.println("\nIngrese una casilla valida!\n");
            }
        } while (!validarColum(columna) && fila >= 9);
        return casilla;
    }

    private void movimientosPartida(){
        boolean jugador1Pierde = false;
        boolean jugador2Pierde = false;
        while ((!jugador1Pierde && !jugador2Pierde)) {
            movimientoJugador(jugador1, false);
            jugador2Pierde = finPartida(jugador2.getFichas());
            if (!jugador2Pierde) {
                movimientoJugador(jugador2, true);
                jugador1Pierde = finPartida(jugador1.getFichas());
            } 
        }
        String ganador, perdedor;
        int punteo1 = 5, punteo2 = 2;
        if (jugador2Pierde) {
            ganador = jugador1.getNombre();
            perdedor = jugador2.getNombre();
        }else{
            ganador = jugador2.getNombre();
            perdedor = jugador1.getNombre();
            punteo1 = 2;
            punteo2 = 5;
        }
        jugador1.setPuntuacion(!jugador1Pierde, punteo1);
        jugador2.setPuntuacion(!jugador2Pierde, punteo2);
        System.out.println(ganador + " ha gando la partida! Gana 5 puntos!");
        System.out.println("Mejor suerte para la otra " + perdedor + " has perdido 2 puntos :c");
        System.out.println("\nQuieren iniciar otra partida? \n1) Si, queremos revancha \n2) No, vamos al menú");
        int opcion = ManejoInfo.getEntero("una opción");
        if (opcion == 1) {
            jugar();
        }
    }

    private void movimientoJugador(Jugador jugadorMueve, boolean oponente){
        int filaIni, columIni, filaFin, columFin;
        boolean comprobacion1, comprobacion2, comprobacion3, comprobacion4, comprobacion5;
        do {
            String mueveIniJ1 = pedirCasilla("que tiene la ficha que desea mover " + jugadorMueve.getNombre());
            String mueveFinJ1 = pedirCasilla("hacia donde quiere mover la ficha " + jugadorMueve.getNombre());
    
            filaIni = sacarFila(mueveIniJ1);
            columIni = sacarColumna(mueveIniJ1);
            filaFin = sacarFila(mueveFinJ1);
            columFin = sacarColumna(mueveFinJ1);
            
            comprobacion1 = tablero.verificarCasilla(filaIni, columIni);
            comprobacion2 = (filaFin % 2 == 0 && columFin % 2 == 0) || (filaFin % 2 != 0 && columFin % 2 != 0);
            comprobacion3 = verificarMovimiento(oponente, filaIni, columIni, filaFin, columFin);
            comprobacion4 = tablero.verificarFicha(jugadorMueve.getFichas(), filaIni, columIni);
            comprobacion5 = tablero.verificarFicha(jugadorMueve.getFichas(), filaFin, columFin);

            if (!comprobacion1 || !comprobacion2 || !comprobacion3 || !comprobacion4 || comprobacion5) {
                System.out.println("\nNo puedes mover esas casillas!\n");
            }   
        } while (!comprobacion1 || !comprobacion2 || !comprobacion3 || !comprobacion4 || comprobacion5);

        tablero.moverFicha(filaIni, columIni, filaFin, columFin, jugadorMueve.getFichas());
        tableroPartida();
    }

    private boolean verificarMovimiento(boolean oponente, int filaIni, int columnaIni, int filaFin, int columnaFin){
        boolean correcto = false;
        int restoFila = filaFin - filaIni;
        int restoColum = columnaIni - columnaFin;

        if (oponente) {
            restoFila = filaIni - filaFin;
        }
        if ((restoFila == 1) && (restoColum == -1 || restoColum == 1)) {
            correcto = true;
        }
        return correcto;
    }

    private boolean finPartida(Ficha[] fichasEvaluar){
        boolean acabo = false;
        int contador = 0;
        for (int i = 0; i < fichasEvaluar.length; i++) {
            if (fichasEvaluar[i].isComida()) {
                contador++;
            }
        }
        if (contador == (fichasEvaluar.length)) {
            acabo = true;
        }
        return acabo; 
    }

    private int sacarColumna(String orden){
        int fila = 0;
        char filaChar = orden.charAt(0);
        switch (filaChar) {
            case 'A'-> {fila = 0;}
            case 'B'-> {fila = 1;}
            case 'C'-> {fila = 2;}
            case 'D'-> {fila = 3;}
            case 'E'-> {fila = 4;}
            case 'F'-> {fila = 5;}
            case 'G'-> {fila = 6;}
            case 'H'-> {fila = 7;}
        }
        return fila;
    }

    private int sacarFila(String orden){
        char columnaChar = orden.charAt(1);
        return (Character.getNumericValue(columnaChar)-1);
    }

    private boolean validarColum(char colum) {
        boolean valido = false;
        for (int i = 65; i <= 72; i++) {
            char compara = (char) i;
            if (colum == compara) {
                valido = true;
            }
        }
        return valido;
    }
    //FIN DE LOS METODOS PARA CASILLAS Y VALIDAR DATOS

    private static int aleatorio(int minimo, int maximo) {
        int aleatorio = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
        return aleatorio;
    }

}