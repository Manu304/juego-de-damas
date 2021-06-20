package src.tablero;

public class Ficha {
    private String color;
    private boolean comida;

    public Ficha(String color) {
        this.comida = false;
        this.color = color;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return color + "@" + Color.RESET;
    }

    
}
