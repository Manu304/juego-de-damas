package src.tablero;

import src.juego.ManejoInfo;

public class Color {
    //RESET TEXTO
    public static final String RESET = "\033[0m";
    //Background
    public static final String BLACK = "\033[40m";  // BLACK -> 1
    public static final String RED = "\033[41m";    // RED -> 2
    public static final String GREEN = "\033[42m";  // GREEN -> 3
    public static final String YELLOW = "\033[43m"; // YELLOW-> 4
    public static final String BLUE = "\033[44m";   // BLUE -> 5
    public static final String PURPLE = "\033[45m"; // PURPLE -> 6
    public static final String CYAN = "\033[46m";   // CYAN -> 7
    public static final String WHITE = "\033[47m";  // WHITE -> 8

    public static String getColor(){
        
        String seleccionado = "";
        boolean listo = false;
        do {
            System.out.println(muestra(BLACK) + "1) Negro" + muestra(RED) + "2) Rojo" + muestra(GREEN) + "3) Verde"
                    + muestra(YELLOW) + "4) Amarillo" + muestra(BLUE) + "5) Azul" + muestra(PURPLE) + "6) Morado" + muestra(CYAN) + "7) Cyan");
            int opcion = ManejoInfo.getEntero("el color que desee");
            switch (opcion) {
                case 1 -> {seleccionado = BLACK;}
                case 2 -> {seleccionado = RED;}
                case 3 -> {seleccionado = GREEN;}
                case 4 -> {seleccionado = YELLOW;}
                case 5 -> {seleccionado = BLUE;}
                case 6 -> {seleccionado = PURPLE;}
                case 7 -> {seleccionado = CYAN;}
                default -> {System.out.println("\nEse color no está en la lista :c\n"); listo = true;}
            }
        } while (listo);
        return seleccionado;
    }

    private static String muestra(String color){
        return "\n " + color + "  " + RESET + " ";
    }

}
