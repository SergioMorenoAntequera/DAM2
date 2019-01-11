/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author seran
 */
public class PanelDerecha extends JPanel {
    
    private JButton bStart, bReset;
    public static JTextField tfPuntos1, tfPuntos2;
    public static int puntos1 = 0, puntos2 = 0;
    
    public PanelDerecha(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        this.setLayout(null);
        
        //----------------------------------------------------------------------
        
        //Cosas de la ventana y tal
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(100, 0));
        
        //----------------------------------------------------------------------
        
        //***Botones***
        this.bStart = new JButton("START");
        bStart.setBounds(5, 390, 90, 30);
        bStart.setBackground(Color.WHITE);
        this.add(bStart);
        
        this.bReset = new JButton("RESET");
        bReset.setBounds(10, 430, 80, 30);
        bReset.setBackground(Color.WHITE);
        this.add(bReset);
        
        //***MARCADORES***
        this.tfPuntos1 = new JTextField(puntos1+"");
        this.tfPuntos1.setBounds(5, 10, 90, 30);
        this.tfPuntos1.setEditable(false);
        this.tfPuntos1.setHorizontalAlignment(JTextField.CENTER); 
        this.add(tfPuntos1);
        
        this.tfPuntos2 = new JTextField(puntos2+"");
        this.tfPuntos2.setBounds(5, 50, 90, 30);
        this.tfPuntos2.setEditable(false);
        this.tfPuntos2.setHorizontalAlignment(JTextField.CENTER);
        this.add(tfPuntos2);
        
    }

    //--------------------------------------------------------------------------
    
    public JButton getbReset() {
        return bReset;
    }

    public JButton getbStart() {
        return bStart;
    }

    public JTextField getTfPuntos1() {
        return tfPuntos1;
    }

    public JTextField getTfPuntos2() {
        return tfPuntos2;
    }

    
    
}
