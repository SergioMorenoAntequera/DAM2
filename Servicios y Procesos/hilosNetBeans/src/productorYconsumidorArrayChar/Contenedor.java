/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidorArrayChar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Contenedor {
    
    private boolean lleno = false;
    private char[] chars = new char[10];
    
    public synchronized void poner(char[] chars){
        while(lleno){
            esperar();
        }
        
        lleno = true;
        notify();
        for (int i = 0; i < 10; i++) {
            this.chars[i] = chars[i];
        }
        
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
