/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.ej1;
import java.awt.Dimension;
import javax.swing.*;
 
/**
 *
 * @author windiurno
 */
public class Panel extends JPanel{
    public JButton b1, b2, b3, b4;
    
    public Panel(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //this.setPreferredSize(new Dimension(200, 400));

        this.add(new JButton("B1"));
        this.add(new JButton("B2"));
        this.add(new JButton("B3"));
        this.add(new JButton("B4"));

    }
}
