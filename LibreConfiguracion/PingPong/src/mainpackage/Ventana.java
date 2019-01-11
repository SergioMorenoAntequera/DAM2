/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
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
public class Ventana extends JFrame implements Runnable {
    
    BorderLayout bl;
    Dimension dim;
    Juego game;
    public PanelDerecha pd;
    
    static boolean terminado;
    long tiempoJuego;
    public static int vInicio;
    public static int vActual;
    int tiempo;
    
    //--------------------------------------------------------------------------
    
    public Ventana(String titulo, Dimension dim){
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
        
        game = new Juego(this.dim);
        pd = new PanelDerecha();
        
        //Acciones de los botones del panel de la derecha
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
                Juego.reset();
                //Ponemos esto aquií para que le de tiempo a terminar el ciclo 
                //del paint y de este modo no le suba la velocidad y se pare
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                game.semaforo.setEnMarcha(false);

                //Reiniciamos puntuación
                PanelDerecha.puntos1 = 0;
                PanelDerecha.tfPuntos1.setText(PanelDerecha.puntos1+"");
                PanelDerecha.puntos2 = 0;
                PanelDerecha.tfPuntos2.setText(PanelDerecha.puntos2+"");
                pd.getbStart().setText("START");
                
                if (terminado) {
                    terminado = false;
                }
            }
        });
        
        lienzo.add(game, BorderLayout.CENTER);
        lienzo.add(pd, BorderLayout.EAST);
        
    }

    //--------------------------------------------------------------------------
    
    //Como la propia ventana es el hilo del juego lo iniciamos
    @Override
    public void run() {
        vActual=  vInicio;
        while(true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while (!terminado) {
            
            //Sleep que meto aquí para que funcione el parar
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            //------------------------------------------------------------------
            
            if (game.semaforo.isEnMarcha()) {
                if (tiempo == 5 && vActual > 1) {
                    vActual -= 1;
                    tiempoJuego = System.currentTimeMillis();
                }
                game.mover();
                game.repaint();
                try {
                    Thread.sleep(vActual);

                } catch (InterruptedException ex) {}
                tiempo = (int) ((System.currentTimeMillis() - tiempoJuego) / 1000);
            }
        }
        }
        
    }
    
}
