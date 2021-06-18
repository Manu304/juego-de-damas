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

    public String getTop(){
        return color + "       " + Color.RESET;
    }

    public String getMedio(){
        if (ocupada) {
            return color + "   " + ficha + color + "   " + Color.RESET;
        } else {
            return getTop();
        }
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha fichaR) {
        if (fichaR == null) {
            ocupada = false;
        } else {
            ocupada = true;
        }
        this.ficha = fichaR;
        
    }

    

    
    
}