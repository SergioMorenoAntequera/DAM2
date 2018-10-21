/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author seran
 */
public class Ventana extends JFrame {
    
    JPanel panelCont, panel1, panel2, panel3, panel4, panelBotones;
    JButton botonAnterior, botonSiguiente;
    CardLayout cl = new CardLayout();
    
    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        //Inicializamos paneles y cambiamos fondo
        panelCont = new JPanel();
        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.add(new JLabel("1"));
        panel2 = new JPanel();
        panel2.setBackground(Color.GRAY);
        panel2.add(new JLabel("2"));
        panel3 = new JPanel();
        panel3.setBackground(Color.YELLOW);
        panel3.add(new JLabel("3"));
        panel4 = new JPanel();
        panel4.setBackground(Color.GREEN);
        panel4.add(new JLabel("4"));
        panelBotones = new JPanel();
        panelCont.setLayout(cl);
        
        
        //Metemos los paneles dentro del mayor para cambiarlos
        panelCont.add(panel1, "1");
        panelCont.add(panel2, "2");
        panelCont.add(panel3, "3");
        panelCont.add(panel4, "4");
        cl.show(panelCont, "1"); //Que el que se muestre de primeras sea el 1
        //El panel que cambia ya estaría
        
        //Vamos con el panel de los botones
        botonAnterior = new JButton("Mostrar anterior");
        botonSiguiente = new JButton("Mostrar Siguiente");
        panelBotones.add(botonAnterior);
        panelBotones.add(botonSiguiente);
        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.previous(panelCont);
            } 
        });
        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.next(panelCont);
            } 
        });
        
        this.setLayout(new BorderLayout());
        this.add(panelCont, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);
        
    }
    
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Ventana de CardLayout");
        ventana.setSize(300, 300);
        ventana.setVisible(true);
    }
}
