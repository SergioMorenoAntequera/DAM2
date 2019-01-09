/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;

/**
 *
 * @author seran
 */
public class Semaforo {
    
    private static boolean enMarcha;

    public Semaforo(){
        this.enMarcha = false;
    }
    
    public boolean isEnMarcha() {
        return enMarcha;
        
    }
    public void setEnMarcha(boolean enMarcha) {
        this.enMarcha = enMarcha;
    }
}
