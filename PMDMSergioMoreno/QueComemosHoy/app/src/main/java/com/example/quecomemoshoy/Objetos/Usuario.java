package com.example.quecomemoshoy.Objetos;

public class Usuario {

    int codigo;
    String correo;
    String pass;


    //----------------------------------------------------------------------------------------------
    // Constructor ---------------------------------------------------------------------------------

    public Usuario(int codigo, String correo, String pass) {
        this.codigo = codigo;
        this.correo = correo;
        this.pass = pass;
    }

    public Usuario() {
        this.codigo = 0;
        this.correo = "Sin Correo";
        this.pass = "Sin Nombre";

    }

    //----------------------------------------------------------------------------------------------
    // Getter y Setter -----------------------------------------------------------------------------

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
