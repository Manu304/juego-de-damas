package src.jugador;

public class Jugador {

    private String nombre;
    private int perdidas, ganadas, puntuacion;

    public Jugador(){
        this("Random");
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(boolean gano, int puntos){
        if (gano) {
            puntuacion += puntos;
        } else {
            if (puntuacion - puntos > 0) {
                puntuacion -= puntos;
            } else {
                puntuacion = 0;
            }
        }
    }

    public void setPartidas(boolean gano){
        if (gano) {
            ganadas++;
        }else{
            perdidas--;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
}
