/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        Ventana v = new Ventana();
        v.setTitle("BUSCAMINAS");
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        v.setVisible(true);
    }
}
