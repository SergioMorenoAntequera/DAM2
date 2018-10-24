/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03;

import ejemplo02.*;
import ejemplo.*;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Principal {
    
    public static void main(String [] main) {
        Ventana3 ventana = new Ventana3();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setVisible(true);
    }
    
}
