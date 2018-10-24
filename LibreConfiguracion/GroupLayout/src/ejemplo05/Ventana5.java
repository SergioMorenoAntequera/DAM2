/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo05;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana5 extends JFrame{
    
    JLabel texto;
    JTextField area;
    JButton b1, b2;
    JCheckBox op1, op2, op3, op4;
    
    public Ventana5(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        texto = new JLabel("Escribe un texto");
        area = new JTextField();
        b1 = new JButton("Aceptar");
        b2 = new JButton("Cancelar");
        op1 = new JCheckBox("Opcion 1");
        op2 = new JCheckBox("Opcion 2");
        op3 = new JCheckBox("Opcion 3");
        op4 = new JCheckBox("Opcion 4");

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
                .addComponent(texto)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(area)
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(op1)
                            .addComponent(op3)
                        )
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(op2)
                            .addComponent(op4)
                        )
                    )
                )
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(b1)
                    .addComponent(b2)
                )
        );
        
        //Añadimos el grupo vertical
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(texto)
                        .addComponent(area)
                        .addComponent(b1)
                )
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup()
                            .addComponent(op1)
                            .addComponent(op2)
                        )
                        .addGroup(gl.createParallelGroup()
                            .addComponent(op3)
                            .addComponent(op4)
                        )    
                    )
                    .addComponent(b2)
                )
        );

        pack();
    }
}
