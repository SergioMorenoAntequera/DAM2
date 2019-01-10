/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Ventana03 extends JFrame implements Runnable {
    
    BorderLayout bl;
    Dimension dim;
    Juego03 game;
    public static PanelDerecha pd;
    
    static boolean terminado;
    long tiempoJuego;
    int vInicio;
    int tiempo;
    
    //--------------------------------------------------------------------------
    
    public Ventana03(String titulo, Dimension dim){
        super(titulo);
        this.dim = dim;
        
        vInicio = 12;
        tiempoJuego = System.currentTimeMillis();
        
        iniciarComponentes();
    }
    
    //--------------------------------------------------------------------------
    
    public void iniciarComponentes(){
        Container lienzo = this.getContentPane();
        bl = new BorderLayout(5, 5);
        this.setMinimumSize(dim);
        lienzo.setLayout(bl);
        
        game = new Juego03(this.dim);
        pd = new PanelDerecha();
        pd.getbStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.semaforo.isEnMarcha()){
                    pd.getbStart().setText("START");
                    game.semaforo.setEnMarcha(false);
                    game.requestFocus();
                } else {
                    pd.getbStart().setText("STOP");
                    game.semaforo.setEnMarcha(true);
                }
            }
        });
        
        pd.getbReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Falta este codigo (el boton de reiniciar)
            }
        });
        
        lienzo.add(game, BorderLayout.CENTER);
        lienzo.add(pd, BorderLayout.EAST);
        
    }

    //--------------------------------------------------------------------------
    
    //Como la propia ventana es el hilo del juego lo iniciamos
    @Override
    public void run() {
        int velocidadActual = vInicio;
        while (!terminado) {
            
            //Sleep que meto aquí para que funcione el parar
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana03.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //------------------------------------------------------------------
            
            if (game.semaforo.isEnMarcha()) {
                if (tiempo == 5 && velocidadActual > 1) {
                    velocidadActual -= 1;
                    tiempoJuego = System.currentTimeMillis();
                }
                game.mover();
                game.repaint();
                try {
                    Thread.sleep(velocidadActual);

                } catch (InterruptedException ex) {}
                tiempo = (int) ((System.currentTimeMillis() - tiempoJuego) / 1000);
            }
        }
    }
    
}
