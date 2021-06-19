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
        int num1 = aleatorio(1, 3);
        int num2 = aleatorio(1, 3);
        boolean ganaPrimero = (num1 == 1 && num2 == 3) || (num1 == 2 && num2 == 1) || (num1 == 3 && num2 == 2);
        System.out.println(jugador1.getNombre() + nombrePapel(num1));
        System.out.println("y " + jugador2.getNombre() + nombrePapel(num2));
        if (!ganaPrimero) {
            Jugador aux = jugador1;
            jugador1 = jugador2;
            jugador2 = aux;
        }

    }

    private void elegirTableroFichas(){
        tablero = new Tablero(jugador1.getFichas(), jugador2.getFichas());
        System.out.println(jugador1.getNombre() + " selecciona el color para el tablero: ");
        tablero.crearTablero();
        System.out.println(jugador1.getNombre() + " selecciona el color de tus fichas: ");
        String color1 = Color.getColor();
        String color2;
        do {
            System.out.println(jugador2.getNombre() + " selecciona el color de tus fichas: ");
            color2 = Color.getColor();
            if (color1.equals(color2)) {
                System.out.println("\nSon del mismo color que las de " + jugador1.getNombre() + "!");
            }
        } while (color1.equals(color2));
        tablero.crearFichas(jugador1.getFichas(), color1);
        tablero.crearFichas(jugador2.getFichas(), color2);

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
