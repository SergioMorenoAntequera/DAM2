/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo02;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana2 extends JFrame{
    
    JButton bot1, bot2, bot3, bot4, bot5;
    
    public Ventana2(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        bot1 = new JButton("Boton 1");
        bot2 = new JButton("Boton 2");
        bot3 = new JButton("Boton 3");
        bot4 = new JButton("Boton 4");
        bot5 = new JButton("Boton 5");
        
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
                        .addComponent(bot1)
                        .addComponent(bot4)
                )
                .addComponent(bot2)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bot3)
                        .addComponent(bot5)
                )
        );
        
        //Añadimos el grupo vertical
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bot1)
                        .addComponent(bot2)
                        .addComponent(bot3)
                )
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bot4)
                        .addComponent(bot5)
                )
        );

        pack();
    }
}
