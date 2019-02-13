/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author seran
 */
public class Control implements ActionListener{
    
    Ventana v;
    Hilo hilo1, hilo2;
    boolean terminado;
    
    public Control(Ventana v){
        this.v = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == v.bStart){
            hilo1 = new Hilo(v.cronometro1.txtCrono, v.bStart, 1);
            hilo2 = new Hilo(v.cronometro2.txtCrono, v.bStart, 2);
            hilo1.start();
            hilo2.start();
            v.bStart.setEnabled(false);
        }
        
        if(e.getSource() == v.bSalir){
            System.exit(0);
        }
    }
    
}
