/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author seran
 */
public class Botones extends JPanel {
    
    //Ventana para hacer los paneles con los botones
    JButton bStart, bSalir;
    
    public Botones(){
        //Cambaimso Layout
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Inicializamos
        bStart = new JButton("START");
        bSalir = new JButton("SALIR");
        //Añadimos los Action
        bStart.addActionListener(new Control(this));
        bSalir.addActionListener(new Control(this));
        //Los ñadimos al panel
        this.add(bStart);
        this.add(bSalir);
    }

    public JButton getbStart() {
        return bStart;
    }
    public JButton getbSalir() {
        return bSalir;
    }
    
    
}
