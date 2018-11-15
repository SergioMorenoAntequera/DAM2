/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import juego02.*;
import java.awt.Container;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Ventana03 extends JFrame implements Runnable{
    
    Dimension dim;
    Juego03 j;
    
    public Ventana03(String titulo, Dimension dim){
        super(titulo);
        this.dim = dim;
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        Container lienzo = this.getContentPane();
        this.setSize(dim);
        j = new Juego03(this.dim);
        lienzo.add(j);
        //run();
    }

    @Override
    public void run() {
        while (true) {
            j.mover();
            j.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
