package src.jugador;

import src.juego.ManejoInfo;

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

    public String getInfo() {
        String nombreS = ManejoInfo.llenarEspacio(nombre, 19);
        String puntuacionS = ManejoInfo.llenarEspacio(Integer.toString(puntuacion), 16);
        String partidasJugadas = ManejoInfo.llenarEspacio(Integer.toString(ganadas+perdidas), 13);
        String ganadasS = ManejoInfo.llenarEspacio(Integer.toString(ganadas), 11);
        return nombreS + puntuacionS + partidasJugadas + ganadasS + perdidas;
    }

    public void setPartidas(boolean gano){
        if (gano) {
            ganadas++;
        }else{
            perdidas--;
        }
    }
    //    NOMBRE     PUNTUACION    PARTIDAS JUGADAS    GANADAS     PERDIDAS
    //Manuel Rojas       7                15             14           12    
    
}
