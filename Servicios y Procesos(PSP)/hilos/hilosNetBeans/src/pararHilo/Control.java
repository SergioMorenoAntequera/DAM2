/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pararHilo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author windiurno
 */
public class Control implements ActionListener {

    Botones botones;    
    public Control(Botones botones){
        this.botones = botones;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botones.getbStart()){
            
        }
        if(e.getSource() == botones.getbPause()){
            
        }
        if(e.getSource() == botones.getbReset()){
            
        }
        if(e.getSource() == botones.getbExit()){
            System.exit(0);
        }
        
    }
    
}
