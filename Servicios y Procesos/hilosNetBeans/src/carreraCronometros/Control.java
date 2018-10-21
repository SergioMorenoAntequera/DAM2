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
    
    static Cronometro pc;
    Botones pb;
    Hilo hilo;

    public Control(Botones pb){
        this.pb = pb;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pb.bStart){
            hilo.run();
        }
        if(e.getSource() == pb.bSalir){
            System.exit(0);
        }
    }
    
}
