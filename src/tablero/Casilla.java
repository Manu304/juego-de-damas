package src.tablero;

public class Casilla {
    private boolean ocupada;
    private String color;
    private Ficha ficha;

    public Casilla(String color) {
        this.ocupada = false;
        this.color = color;
    }

    

    public Casilla(String color, Ficha ficha) {
        this.color = color;
        this.ficha = ficha;
        this.ocupada = true;
    }
    
    public String getLineaVacia() {
        return color + "   " + Color.RESET;
    }
    public String getLineaLlena() {
        if (ocupada) {
            return color + " "+ ficha + " " + Color.RESET;
        } else {
            return getLineaVacia();
        }
        
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}