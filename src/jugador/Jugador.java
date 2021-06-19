package src.jugador;

import src.juego.ManejoInfo;
import src.tablero.Ficha;

public class Jugador {

    private Ficha[] fichas;
    private String nombre;
    private int perdidas, ganadas, puntuacion;

    public Jugador(){
        this("Random");
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.fichas = new Ficha[12];
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
        String nombreS = ManejoInfo.llenarEspacio(nombre, 16);
        String puntuacionS = ManejoInfo.llenarEspacio(Integer.toString(puntuacion), 17);
        String partidasJugadas = ManejoInfo.llenarEspacio(Integer.toString(ganadas+perdidas), 15);
        String ganadasS = ManejoInfo.llenarEspacio(Integer.toString(ganadas), 13);
        return nombreS + puntuacionS + partidasJugadas + ganadasS + perdidas;
    }

    public void setPartidas(boolean gano){
        if (gano) {
            ganadas++;
        }else{
            perdidas--;
        }
    }

    public Ficha[] getFichas() {
        return fichas;
    }

    public void setFichas(Ficha[] fichas) {
        this.fichas = fichas;
    }

    
    //    NOMBRE     PUNTUACION    PARTIDAS JUGADAS    GANADAS     PERDIDAS
    //Manuel Rojas       7                15             14           12    

    
}
