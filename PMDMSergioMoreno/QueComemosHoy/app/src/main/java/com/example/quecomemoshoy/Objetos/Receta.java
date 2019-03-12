package com.example.quecomemoshoy.Objetos;

import java.util.ArrayList;

public class Receta {

    String nombre;
    ArrayList<String> ingredientes;
    ArrayList<String> instrucciones;
    String tiempo;
    String propietario;

    //----------------------------------------------------------------------------------------------
    // Constructor ---------------------------------------------------------------------------------

    public Receta(String nombre, ArrayList<String> ingredientes, ArrayList<String> instrucciones, String tiempo, String propietario) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.tiempo = tiempo;
        this.propietario = propietario;
    }

    public Receta() {
        this.nombre = "Sin Nombre";
        this.ingredientes = new ArrayList<String>();
        this.instrucciones = new ArrayList<String>();;
        this.tiempo = "Sin tiempo";
        this.propietario = "Sin propietario";
    }

    //----------------------------------------------------------------------------------------------
    // Getter y Setter ---------------------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<String> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<String> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
