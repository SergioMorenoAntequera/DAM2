/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo02;

import ejemplo.*;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Principal {
    
    public static void main(String [] main) {
        Ventana2 ventana = new Ventana2();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setVisible(true);
    }
    
}
