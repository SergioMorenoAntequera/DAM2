package ej2;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludar extends Thread{
    
    int c;
    
    public Saludar(int c){
        this.c = c;
    }
    
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i<this.c; i++){
            System.out.println("¡Hola!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Saludar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
