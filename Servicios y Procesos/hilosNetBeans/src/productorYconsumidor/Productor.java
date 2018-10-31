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
public class Productor extends Thread {
     
    public int num;
    Contenedor c; 
    
     public Productor(Contenedor c){
         this.c = c;
     }

    @Override
    public void run() {
        while (true) {
            num = (int) (Math.random() * 10);
            System.out.println(" + Colocando: " + num);
            c.poner(num);
            dormir(2000);
        }
    }
    
    public void dormir(long tiempo){
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            System.out.println("La liaste John Lancaster");
        }
    }  
}
