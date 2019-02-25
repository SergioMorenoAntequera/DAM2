/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.GameMaster;
import controlador.GenerateEnemies;
import java.awt.Dimension;
import javax.swing.JFrame;
import modelo.Sleep;

/**
 *
 * @author seran
 */
public class Frame extends JFrame implements Runnable {
    
    Dimension frameDimensions;
    String title;
    public GenerateEnemies hiloGenerarEnemigos;
    
    public CanvasGame cv;
    public GameMaster gm;
    
    public Frame(){
         
        frameDimensions = new Dimension(800, 500);
        title = "Juego en pañales";
        
        initFrame();
        initComponentes();
        
        Thread hiloPintar = new Thread(this);
        hiloPintar.start();
        
        hiloGenerarEnemigos = new GenerateEnemies(cv);
        hiloGenerarEnemigos.start();
        
        this.setVisible(true);
    }

    private void initComponentes() {
        cv = new CanvasGame(this);
        gm = new GameMaster(this);
        this.addKeyListener(gm);
        cv.addKeyListener(gm);
    }

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

    @Override
    public void run() {
        while (true) {
            cv.repaint();
            Sleep.sleep(10);
        }
    }
}
