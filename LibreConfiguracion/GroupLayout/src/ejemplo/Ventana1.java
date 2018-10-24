package ejemplo;

import java.awt.*;
import javax.swing.*;

/**
 * @author angel
 */
public class Ventana1 extends JFrame{
    private JButton bot1,bot2,bot3,bot4;
    
    public Ventana1(){
        iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        bot1 = new JButton("Boton 1");
        bot2 = new JButton("Boton 2");
        bot3 = new JButton("Boton 3");
        bot4 = new JButton("Boton 4");
    
        //Asignar Layout 
        Container lienzo = getContentPane();
        GroupLayout gl = new GroupLayout(lienzo);
        lienzo.setLayout(gl);
        
        //Crear espaciado automatico entre elementos.
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        //Añadimos el grupo horizontal
        gl.setHorizontalGroup(
                //Crear grupo secuencial
                gl.createSequentialGroup()
                    //Añadir botones al grupo
                    .addComponent(bot1)
                    .addComponent(bot2)
                    //Añadir grupo paralelo con 2 botones (ultima columna)
                    .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING) //Alineacion de derecha aizquierda
                            .addComponent(bot3)
                            .addComponent(bot4)
                    )
        );
        
        //Añadimos el grupo vertical
        gl.setVerticalGroup(
            //Crear grupo secuencial
            gl.createSequentialGroup()
                //Añadimos el grupo paralelo de la primera fila
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bot1)
                        .addComponent(bot2)
                        .addComponent(bot3)
                )
                //Añadimos el boton de la segunda fila 
                .addComponent(bot4)
        );

        pack();
    }
}
