/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidorArrayChar;

/**
 *
 * @author windiurno
 */
public class Productor extends Thread {
     
    public char[] chars = new char[10];
    Contenedor c; 
    
     public Productor(Contenedor c){
         this.c = c;
     }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                int  n = (int) (Math.random() * 25) + 97;
                chars[i] = (char) n;
                System.out.println(" + Colocando: " + chars[i]);
                dormir(1000);
            }
            
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
