/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1b;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class PanelTexto extends JPanel {
    
    private JTextField txtMensaje;
    
    public PanelTexto(){
        
        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        
        txtMensaje = new JTextField("Escribir aquí...");
        txtMensaje.setBackground(Color.black);
        txtMensaje.setBackground(Color.green);
        txtMensaje.setPreferredSize(new Dimension(100, 60));
        txtMensaje.setMaximumSize(new Dimension(120, 60));
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        
        add(txtMensaje);
    }

    public void setTxtMensaje(JTextField txtMensaje) {
        this.txtMensaje = txtMensaje;
    }
    
    public JTextField getTxtMensaje() {
        return txtMensaje;
    }
}
