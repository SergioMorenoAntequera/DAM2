package ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaDivertido implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println("Java es divertido");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Saludar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
