/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo04;

import ejemplo03.*;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Principal {
    
    public static void main(String [] main) {
        Ventana4 ventana = new Ventana4();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setVisible(true);
    }
    
}
