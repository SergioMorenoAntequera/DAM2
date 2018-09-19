/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1a;

import static java.awt.EventQueue.invokeLater;

/**
 *
 * @author windiurno
 */
public class Principal {
    
    public static void mostrar(){
        Ventana miVentana = new Ventana();
        miVentana.setTitle("Mi segunda ventana");
        miVentana.setDefaultCloseOperation(3);
        miVentana.setVisible(true);
        miVentana.pack();
        
    }
    
    public static void main(String[] args){
        invokeLater (new Runnable(){
            @Override
            public void run(){
                mostrar();
            }
        });
    }
    
}
