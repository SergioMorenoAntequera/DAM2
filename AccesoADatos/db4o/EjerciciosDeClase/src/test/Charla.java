/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author windiurno
 */
public class Charla {
    
    private String titulo;
    private float duracion;
    private Ponente p1;

    //--------------------------------------------------------------------------
    
    public Charla(String titulo, float duracion, Ponente p1) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.p1 = p1;
    }

    //--------------------------------------------------------------------------
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public Ponente getP1() {
        return p1;
    }

    public void setP1(Ponente p1) {
        this.p1 = p1;
    }
    
    
}
