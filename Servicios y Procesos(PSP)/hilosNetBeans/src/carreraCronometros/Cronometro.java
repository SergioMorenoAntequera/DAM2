/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author seran
 */
public class Cronometro extends JPanel {
    
    JLabel txtCrono;
    
    public Cronometro(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Cosas estéticas
        txtCrono = new JLabel("    00");
        txtCrono.setPreferredSize(new Dimension(200, 200));
        txtCrono.setBorder(BorderFactory.createLineBorder(Color.black));
        Font fuente = new Font("Console", 0, 60);
        txtCrono.setFont(fuente);
        
        this.add(txtCrono);
    }
    
    public JLabel getTxtCrono() {
        return txtCrono;
    }
    public void setTxtCrono(JLabel txtCrono) {
        this.txtCrono = txtCrono;
    }
    
    
}
