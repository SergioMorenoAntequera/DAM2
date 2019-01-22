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
public class Ponente {
    
    private String nif;
    private String nombre;
    private String email;
    private int cache;

    //--------------------------------------------------------------------------
    
    public Ponente(String nif, String nombre, String email, int cache) {
        this.nif = nif;
        this.nombre = nombre;
        this.email = email;
        this.cache = cache;
    }

    //--------------------------------------------------------------------------
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }
    
    
}
