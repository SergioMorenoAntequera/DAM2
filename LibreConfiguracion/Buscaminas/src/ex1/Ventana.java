/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame {
    
    PanelCampo pc;
    PanelInfo pf;
    
    
    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        pc = new PanelCampo();
        pf = new PanelInfo();
        
        add(pc, BorderLayout.CENTER);
        pack();
    }
}
