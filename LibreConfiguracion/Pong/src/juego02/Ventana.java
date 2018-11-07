/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego02;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame implements Runnable{
    
    Juego j;
    
    public Ventana(String titulo, Juego j){
        super(titulo);
        this.j = j;
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        Container lienzo = this.getContentPane();
        lienzo.add(j);
        //run();
    }

    @Override
    public void run() {
        while (true) {
            j.mover();
            j.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
