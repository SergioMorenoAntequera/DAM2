/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author seran
 */
public class Semaforo {
    
    private boolean activo;
    
    public Semaforo(boolean activo){
        this.activo = activo;
    }
    public boolean getActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
