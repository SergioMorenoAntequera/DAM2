/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class HiloHora extends Thread{

    JTextField panel;
    Semaforo semaforo;
    int min, seg;
    
    public HiloHora(JTextField panel, Semaforo semaforo){
        this.panel = panel;
        this.semaforo = semaforo;
        min = 0; 
        seg = 0;
    }
    
    @Override
    public void run() {
        while(!semaforo.getPausado()) {
            this.panel.setText(contruirHora(min, seg));
            //System.out.println(contruirHora(min, seg));
            esperarSeg();
            seg++;
            if(seg>60){
                seg-=60;
                min++;
            }
        }
    }
    
    public static String contruirHora(int min, int seg){
        String result = "";
        if(min < 10)
            result = "0" + min + ":" + seg;
        if(seg < 10)
           result = min + ":" + "0" + seg;
        if(min<10 && seg<10)
            result = "0" + min + ":" + "0" + seg;
        return result;
    } 
    public static void esperarSeg(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloHora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
