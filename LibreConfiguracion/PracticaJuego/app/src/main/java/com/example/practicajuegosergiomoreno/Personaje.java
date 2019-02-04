package com.example.practicajuegosergiomoreno;

public class Personaje {

    //Variables
    private int dinero;
    private int danio;

    //----------------------------------------------------------------------------------------------

    //Constructores
    public Personaje() {
        this.dinero = 0;
        int danio = 1;
    }

    public Personaje(int dinero, int danio) {
        this.dinero = dinero;
        this.danio = danio;
    }

    //----------------------------------------------------------------------------------------------

    //Metodos variados
    //Subir de nivel--------------------------------------------------------------------------------
    public void subirDeNivel(){
        this.danio += this.danio + 4;
    }



    //----------------------------------------------------------------------------------------------

    //Getters y setters

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }
}
