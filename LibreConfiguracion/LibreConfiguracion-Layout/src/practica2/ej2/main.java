/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.ej2;
import practica2.ej1.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.SwingUtilities.invokeLater;

/**
 *
 * @author windiurno
 */

public class main {
    
    public static void mostrarTodo(){
        Ventana ventana = new Ventana();
        ventana.setTitle("Practica BoxLayout");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        invokeLater(new Runnable(){
            @Override
            public void run(){
                mostrarTodo();
            }
        });
    }
}
