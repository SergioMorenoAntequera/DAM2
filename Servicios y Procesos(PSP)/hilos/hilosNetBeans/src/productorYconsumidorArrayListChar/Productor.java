/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidorArrayListChar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Productor extends Thread {
    
    public String palabra = "";
    String[] palabras = new String[]{"", "Perro", "Gato", "Vaca", "Mesa", "Alpargata", "Rodolfo"};
    public MiLista ml;
    
    public Productor(MiLista ml){
        this.ml = ml;
    }
    
    @Override
    public void run(){
        
        while(true){
            palabra = palabras[(int)(Math.random()+1)*6];
         
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//Colocar la palabra en MiLista con un metodo que me hace falta de milista
            ml.ponerPalabra(palabra);
        }
    }
}
