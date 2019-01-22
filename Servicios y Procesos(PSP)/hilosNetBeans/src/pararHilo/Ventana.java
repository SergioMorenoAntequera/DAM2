/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pararHilo;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame {
    
    public Reloj pr;
    public Botones pb;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        Container lienzo = this.getContentPane();
        lienzo.setLayout(new BorderLayout());
        
        pr = new Reloj();
        pb = new Botones();
        
        lienzo.add(pr, BorderLayout.CENTER);
        lienzo.add(pb, BorderLayout.SOUTH);
    }
}
