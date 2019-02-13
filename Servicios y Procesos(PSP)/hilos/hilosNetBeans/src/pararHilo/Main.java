/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pararHilo;

import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setTitle("Cronometro que se para");
        ventana.setSize(350, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
    }
}
