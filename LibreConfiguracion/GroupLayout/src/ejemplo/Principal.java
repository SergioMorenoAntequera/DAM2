/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Principal {
    
    public static void main(String [] main) {
        Ventana1 ventana = new Ventana1();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 125);
        
        ventana.setVisible(true);
    }
    
}
