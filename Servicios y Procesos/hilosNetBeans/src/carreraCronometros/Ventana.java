/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author seran
 */
public class Ventana extends JFrame{
    
    //En esta ventana SOLO ponemos los paneles
    Cronometro cronometro1, cronometro2;
    Botones botones;
    
    public Ventana(){
        cronometro1 = new Cronometro();
        cronometro2 = new Cronometro();
        botones = new Botones();
        
        this.setLayout(new BorderLayout());
        add(cronometro1, BorderLayout.EAST);
        add(cronometro2, BorderLayout.WEST);
        add(botones, BorderLayout.SOUTH);
        
    }
    
    
}
