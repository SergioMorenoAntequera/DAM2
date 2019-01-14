/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1_1;

import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        ventana.add(new Panel());
        
        ventana.pack();
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
