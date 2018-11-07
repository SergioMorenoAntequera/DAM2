/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego02;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        Juego j = new Juego();
        
        Ventana v = new Ventana("PONG", j);
        v.setSize(new Dimension(300, 400));
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        
        new Thread(v).start();
        
        v.setVisible(true);
    }
}
