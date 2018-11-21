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
    static boolean terminado;
    long tiempoJuego;
    int vInicio;
    int tiempo;
    
    public Ventana03(String titulo, Dimension dim){
        super(titulo);
        this.dim = dim;
        
        vInicio = 12;
        tiempoJuego = System.currentTimeMillis();
        
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
        int velocidadActual = vInicio;
        while (!terminado) {
            if(tiempo == 5 && velocidadActual > 1){
                velocidadActual -=1;
                tiempoJuego = System.currentTimeMillis();
            }
            j.mover();
            j.repaint();
            try {
                Thread.sleep(velocidadActual);
                
            } catch (InterruptedException ex) {}
            tiempo = (int)((System.currentTimeMillis()-tiempoJuego)/1000);
        }
    }
}
