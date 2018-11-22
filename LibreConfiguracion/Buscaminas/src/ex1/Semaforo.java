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
    
    private boolean pausado;
    
    public Semaforo(boolean pausado){
        this.pausado = pausado;
    }
    public boolean getPausado() {
        return pausado;
    }
    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }
    
}
