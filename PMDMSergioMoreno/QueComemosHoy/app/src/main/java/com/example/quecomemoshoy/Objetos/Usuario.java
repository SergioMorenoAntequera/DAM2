package com.example.quecomemoshoy.Objetos;

public class Usuario {

    String correo;
    String pass;


    //----------------------------------------------------------------------------------------------
    // Constructor ---------------------------------------------------------------------------------

    public Usuario(String correo, String pass) {
        this.correo = correo;
        this.pass = pass;
    }

    public Usuario() {
        this.correo = "Sin Correo";
        this.pass = "Sin Nombre";

    }

    //----------------------------------------------------------------------------------------------
    // Getter y Setter -----------------------------------------------------------------------------

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
