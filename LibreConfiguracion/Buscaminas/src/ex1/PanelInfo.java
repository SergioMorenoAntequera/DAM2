/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class PanelInfo extends JPanel{
    
    GroupLayout gl;
    private JLabel iBandera, iReloj;
    private JTextField tfMinas, tfTiempo;
    private JButton bStart, bPause, bExit;
    
    public PanelInfo(){
        iniciarComponentes();
    } 
    
    private void iniciarComponentes(){
        
        iBandera = new JLabel(new ImageIcon("/src/source/flag.png"));
        iReloj = new JLabel(new ImageIcon("/src/source/stopwatch.png"));
        tfMinas = new JTextField();
        tfMinas.setBounds(0, 0, 30, 100);
        tfTiempo = new JTextField();
        bStart = new JButton("START");
        bPause = new JButton("PAUSE");
        bExit = new JButton("EXIT");
        
        gl = new GroupLayout(this);
        this.setLayout(gl);
        //Crear espaciado automatico entre elementos.
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(iBandera)
                        .addComponent(iReloj)
                        .addComponent(tfMinas)
                        .addComponent(tfTiempo)
                        .addComponent(bStart)
                        .addComponent(bPause)
                        .addComponent(bExit)
                )
        );
      
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(iBandera)
                .addComponent(iReloj)
                .addComponent(tfMinas)
                .addComponent(tfTiempo)
                .addComponent(bStart)
                .addComponent(bPause)
                .addComponent(bExit)
        );
    }
}
