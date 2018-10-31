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
public class Consumidor extends Thread {
    
    private int num;
    Contenedor c; 
    
     public Consumidor(Contenedor c){
         this.c = c;
     }

    @Override
    public void run(){
        while(true){
            num = c.retirar();
            System.out.println(" - Retirando: " + num);
            
            dormir(2000);
        }
    }
    
    public void dormir(long tiempo){
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
