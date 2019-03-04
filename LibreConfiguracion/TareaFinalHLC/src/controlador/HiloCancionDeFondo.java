/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import vista.Frame;

/**
 *
 * @author seran
 */
public class HiloCancionDeFondo extends Thread{

    @Override
    public void run() {
        super.run();
        Player player;
        
        try {
            player = new Player(new BufferedInputStream(new FileInputStream("src/resource/cancionFondo.mp3")));
            player.play();
            
        } catch (JavaLayerException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
