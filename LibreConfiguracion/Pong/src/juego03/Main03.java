/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Main03 {
    public static void main(String[] args){
        
        Ventana03 v = new Ventana03("Rebotes", new Dimension(300, 400));
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        
        new Thread(v).start();
        //La linea de arriba y las de abajo son lo mismo
        //Thread hilo = new Thread(mv);
        //hilo.start();
        
        v.setVisible(true);
    }
}
