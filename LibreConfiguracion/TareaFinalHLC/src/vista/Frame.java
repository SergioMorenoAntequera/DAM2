/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Controller;
import controlador.GenerateEnemies;
import controlador.HiloCancionDeFondo;
import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import modelo.Sleep;
import javazoom.jl.player.*;

/**
 *
 * @author seran
 */
public class Frame extends JFrame implements Runnable {
    
    Dimension frameDimensions;
    String title;
    public GenerateEnemies hiloGenerarEnemigos;
    public CanvasGame cv;
    public Controller gm;

    
    public Frame(){
        frameDimensions = new Dimension(400, 700);
        title = "INVASORES DEL ESPACIO";
        
        initFrame();
        initComponentes();
        
        HiloCancionDeFondo cancion = new HiloCancionDeFondo();
        cancion.start();
        
        Thread hiloPintar = new Thread(this);
        hiloPintar.start();
        
        hiloGenerarEnemigos = new GenerateEnemies(cv);
        hiloGenerarEnemigos.start();
        
        this.setVisible(true);
    }

    //--------------------------------------------------------------------------
    private void initComponentes() {

        cv = new CanvasGame(this);
        gm = new Controller(this);

        this.addKeyListener(gm);
        cv.addKeyListener(gm);

    }

    //--------------------------------------------------------------------------
    
    //Metodo que se encarga de la creación de la ventana
    //Mostrarla y todas sus propiedades
    private void initFrame() {
        this.setPreferredSize(frameDimensions);
        this.setMinimumSize(frameDimensions);
        this.setMaximumSize(frameDimensions);
        this.setResizable(false);
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //--------------------------------------------------------------------------
    @Override
    public void run() {
        while (!cv.end) {
            cv.repaint();
            Sleep.sleep(10);
        }
    }
}
