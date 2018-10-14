/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.ej3;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame{
    
    Panel panel;
    
    public Ventana(){
        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        this.setSize(100, 200);

        
        panel = new Panel();
        
        this.add(panel);
    }
}
