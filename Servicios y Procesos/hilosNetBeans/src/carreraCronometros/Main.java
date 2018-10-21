/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;

import javax.swing.JFrame;

/**
 *
 * @author seran
 */
public class Main {
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(450, 320);
        ventana.setTitle("PRACTICA 3 HILOS");
        ventana.setVisible(true);
        
    }
}
