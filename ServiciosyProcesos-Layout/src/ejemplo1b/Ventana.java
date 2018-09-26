/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1b;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame{
    
    private PanelBotones pb;
    private PanelTexto pt;
    private PanelTitulo ptit;
    private JButton btnSalir;
    private JTextField mensaje;
    private JButton btnSaludo;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        pb = new PanelBotones();
        pt = new PanelTexto();
        ptit = new PanelTitulo();
        btnSalir = pb.getBtnSalir();
        btnSaludo = pb.getBtnSaludo();
        mensaje = pt.getTxtMensaje();
        Container lienzo = this.getContentPane();
        
        //Colocamos todo
        BorderLayout bl = new BorderLayout(5, 5);
        lienzo.setLayout(bl);
        
        lienzo.add(ptit, BorderLayout.PAGE_START);
        lienzo.add(pt, BorderLayout.CENTER);
        lienzo.add(pb, BorderLayout.PAGE_END);
        lienzo.setPreferredSize(new Dimension (450, 200));
        //Alñadimos listener al boton de saludo
        btnSaludo.addActionListener(e-> saludo());
        pack();
        
    }
    public void saludo(){
        String text = mensaje.getText();
        if(text.length() == 0){
            JOptionPane.showMessageDialog(this, "ESCRIBE UN SALUDO!");
        } else {
            JOptionPane.showMessageDialog(this, "Tu saludo es: " + text);
            mensaje.setText("");
        }
    }
}
