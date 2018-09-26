/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1c;

import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;


public class Main {
    
    public static void mostrar(){
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setTitle("Ejemplo varios paneles");
        calculadora.setVisible(true);
        calculadora.setResizable(false);
    }
    
    public static void main(String[] args){
        invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }
}
