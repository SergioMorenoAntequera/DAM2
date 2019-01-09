/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author seran
 */
public class PanelDerecha extends JPanel {
    
    private JButton bStart;
    
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
        
        //Configuración del botón
        this.bStart = new JButton("START");
        bStart.setBounds(5, 430, 90, 30);
        bStart.setBackground(Color.WHITE);
        this.add(bStart);
        
        
    }

    public JButton getbStart() {
        return bStart;
    }
}
