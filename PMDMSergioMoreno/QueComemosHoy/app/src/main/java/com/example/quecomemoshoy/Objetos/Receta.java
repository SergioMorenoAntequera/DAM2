package com.example.quecomemoshoy.Objetos;

import java.util.ArrayList;

public class Receta {

    String nombre;
    Usuario usuario;
    ArrayList<String> ingredientes;
    ArrayList<String> instrucciones;
    String tiempo;

    //----------------------------------------------------------------------------------------------
    // Constructor ---------------------------------------------------------------------------------

    public Receta(String nombre, Usuario usuario, ArrayList<String> ingredientes, ArrayList<String> instrucciones, String tiempo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.tiempo = tiempo;
    }

    public Receta() {
        this.nombre = "Sin Nombre";
        this.usuario = new Usuario();
        this.ingredientes = new ArrayList<String>();
        this.instrucciones = new ArrayList<String>();;
        this.tiempo = "Sin tiempo";
    }

    //----------------------------------------------------------------------------------------------
    // Getter y Setter ---------------------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
