/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Contenedor {
    
    private boolean lleno = false;
    private int num;
    
    public synchronized void poner(int num){
        while(lleno){
            esperar();
        }
        
        lleno = true;
        this.num = num;
        notify();
    }
    
    
    public synchronized int retirar(){
        while(!lleno){
            esperar();
        }
        lleno = false;
        notify();
        return this.num;
    }
    
    public void setNum(int num){
        this.num = num;
    }
    
    public int getNum(){
        return this.num;
    }
    
    public void esperar(){
        try {
            wait();
        } catch (InterruptedException ex) {
            
        }
    }
    
    
}
