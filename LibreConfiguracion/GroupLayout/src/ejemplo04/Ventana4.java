/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo04;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana4 extends JFrame{
    
    JButton b1, b2, b3, b4, b5, b6, b7;
    
    public Ventana4(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        b1 = new JButton("Boton 1");
        b2 = new JButton("Boton 2");
        b3 = new JButton("Boton 3");
        b4 = new JButton("Boton 4");
        b5 = new JButton("Boton 5");
        b6 = new JButton("Boton 6");
        b7 = new JButton("Boton 7");
        
        //Asignar Layout 
        Container lienzo = getContentPane();
        GroupLayout gl = new GroupLayout(lienzo);
        lienzo.setLayout(gl);
        
        //Crear espaciado automatico entre elementos.
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        //Añadimos el grupo horizontal
        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(b1)
                        .addComponent(b5)
                )
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(b2)
                        .addComponent(b4)
                        .addComponent(b6)
                )
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(b3)
                        .addComponent(b7)
                )
        );
        
        //Añadimos el grupo vertical
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(b1)
                        .addComponent(b2)
                        .addComponent(b3)
                )
                .addComponent(b4)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(b5)
                        .addComponent(b6)
                        .addComponent(b7)
                )
        );

        pack();
    }
}
