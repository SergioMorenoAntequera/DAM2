/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seran
 */
public class HiloServerLeer extends Thread{
    
    BufferedReader IN;
    
    public HiloServerLeer(BufferedReader IN){
        this.IN = IN;
    }
    
    @Override
    public void run(){
        String cad = "";
        
        while(true){
            try {
                cad = IN.readLine();
                System.out.println("Cliente: " + cad);
                
            } catch (IOException ex) {
                System.out.println("Error al leer mensaje");
            }
        }
    }
}
