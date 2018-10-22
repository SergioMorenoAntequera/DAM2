/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author seran
 */
public class Ventana extends JFrame{
    
    //En esta ventana SOLO ponemos los paneles
    Cronometro cronometro1, cronometro2;
    //Botones botones;
    JPanel panelBotones;
    JButton bStart, bSalir;
    boolean terminado;
    
    public Ventana(){
        cronometro1 = new Cronometro();
        cronometro2 = new Cronometro();
        //botones = new Botones();
        
        //PANEL BOTONES CREADO DENTRO DE VENTANA
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Inicializamos
        bStart = new JButton("START");
        bSalir = new JButton("SALIR");
        //Añadimos los Action
        bStart.addActionListener(new Control(this));
        bSalir.addActionListener(new Control(this));
        //Los ñadimos al panel
        panelBotones.add(bStart);
        panelBotones.add(bSalir);
        
        
        this.setLayout(new BorderLayout());
        add(cronometro1, BorderLayout.WEST);
        add(cronometro2, BorderLayout.EAST);
        add(panelBotones, BorderLayout.SOUTH);
        //add(botones, BorderLayout.SOUTH);
    }
}
