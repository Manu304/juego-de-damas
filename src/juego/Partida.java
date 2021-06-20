package src.juego;

import src.jugador.Jugador;
import src.tablero.Color;
import src.tablero.Tablero;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        piedraPapel();
        elegirTableroFichas();
    }

    private void piedraPapel(){
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

    private void elegirTableroFichas(){
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

    private void tableroPartida(){
        tablero.dibujarTablero();
        System.out.println("\n" + Principal.margenes(29) + "JUGANDO" + Principal.margenes(30));
        String datosPlayer1 = " " + jugador1.getFichas()[0] + " " + ManejoInfo.llenarEspacio(jugador1.getNombre(), 10);
        String datosPlayer2 = " " + jugador2.getFichas()[0] + " " + jugador2.getNombre();
        String pie = datosPlayer1 + Principal.margenes(16) + "CONTRA" + Principal.margenes(16) + ManejoInfo.llenarEspacio(datosPlayer2, 13);
        System.out.println(pie);
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

    private static int aleatorio(int minimo, int maximo) {
        int aleatorio = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
        return aleatorio;
    }

}
