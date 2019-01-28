/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author windiurno
 */
public class ValorSpinner extends JSpinner implements Serializable {
    
    private int numAviso = 0;
    private ChangeListener cambiar;
    
    //--------------------------------------------------------------------------
    
    public ValorSpinner() {
        super();
        
        this.setValue(0);
        numAviso = 5;
        
        //Acción----------------------------------------------------------------
        cambiar = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if((int)getValue() == numAviso){
                    JOptionPane.showMessageDialog(null, "Se ha llegado al valor determinado");
                }
            }
        };
        this.addChangeListener(cambiar);
    }
    
    //--------------------------------------------------------------------------

    public int getNumAviso() {
        return numAviso;
    }
    
    public void setNumAviso(int numAviso) {
        this.numAviso = numAviso;
    }
}
