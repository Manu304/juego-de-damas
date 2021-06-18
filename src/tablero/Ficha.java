package src.tablero;

public class Ficha {
    private String color;

    public Ficha(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "O" + Color.RESET;
    }

    
}
