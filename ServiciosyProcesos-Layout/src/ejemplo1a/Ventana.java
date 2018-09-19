/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1a;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame{
    
    JButton btnIzq, btnDer;
    JTextField txtCentro;
    JLabel txtArriba, txtAbajo;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
       
        btnIzq = new JButton("Saludo");
        btnDer = new JButton("Adios");
        txtCentro = new JTextField("HOLA");
        txtArriba = new JLabel("Cabecera");
        txtAbajo = new JLabel("Pie");
        
        btnIzq.setBackground(Color.BLUE);
        btnDer.setBackground(Color.RED);
        txtCentro.setBackground(Color.BLACK);
        txtCentro.setForeground(Color.GREEN);
        
        Container lienzo = this.getContentPane();
        lienzo.setPreferredSize(new Dimension(400, 200));
        lienzo.add(btnIzq, BorderLayout.LINE_START);
        lienzo.add(btnDer, BorderLayout.LINE_END);
        lienzo.add(txtArriba, BorderLayout.PAGE_START);
        lienzo.add(txtAbajo, BorderLayout.PAGE_END);
        lienzo.add(txtCentro, BorderLayout.CENTER);
        
        btnIzq.addActionListener(e->saludar());
        btnDer.addActionListener(e->cerrar());
    }
    
    public void saludar(){
        if(txtCentro.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Escribe algo");
        } else {
            JOptionPane.showMessageDialog(null, "Hola: " + txtCentro.getText().trim());
        }
    }
    public void cerrar(){
        System.exit(0);
    }
    
    
}
