/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author windiurno
 */
public class PanelRight extends JPanel{
    
    GroupLayout gl;
    public JLabel iBandera, iReloj;
    public JTextField tfMinas, tfTiempo;
    public JButton bStart, bPause, bExit;
    
    public PanelRight(){
        iniciarComponentes();
    } 
    
    private void iniciarComponentes(){
        
        iBandera = new JLabel(new ImageIcon("src/source/flag.png"));
        iReloj = new JLabel(new ImageIcon("src/source/stopwatch.png"));
        tfMinas = new JTextField("00/10");
        tfTiempo = new JTextField("00");
        bStart = new JButton("START");
        bPause = new JButton("PAUSE");
        bPause.setEnabled(false);
        bExit = new JButton("EXIT");
        
        //Aspecto tfMinas
        tfMinas.setPreferredSize(new Dimension(100, 20));
        tfMinas.setBackground(Color.BLACK);
        tfMinas.setForeground(Color.WHITE);
        tfMinas.setHorizontalAlignment(SwingConstants.CENTER);
        tfMinas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfMinas.setEditable(false);
        //Aspecto tfTiempo
        tfTiempo.setPreferredSize(new Dimension(100, 20));
        tfTiempo.setBackground(Color.BLACK);
        tfTiempo.setForeground(Color.WHITE);
        tfTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        tfTiempo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfTiempo.setEditable(false);
        //Aspecto boton
        bStart.setBackground(Color.WHITE);
        bPause.setBackground(Color.WHITE);
        bExit.setBackground(Color.WHITE);
        
        gl = new GroupLayout(this);
        this.setLayout(gl);
        //Crear espaciado automatico entre elementos.
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(20)
                        .addComponent(iBandera)
                        .addComponent(tfMinas)
                        .addGap(20)
                        .addComponent(iReloj)
                        .addComponent(tfTiempo)
                        .addGap(100)
                        .addComponent(bStart)
                        .addComponent(bPause)
                        .addComponent(bExit)
                )
        );
      
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(20)
                .addComponent(iBandera)
                .addComponent(tfMinas)
                .addGap(20)
                .addComponent(iReloj)
                .addComponent(tfTiempo)
                .addGap(100)
                .addComponent(bStart)
                .addComponent(bPause)
                .addComponent(bExit)
        );
        gl.linkSize(SwingConstants.HORIZONTAL, iBandera, tfMinas, iReloj, tfTiempo, bStart, bPause, bExit);
        this.setBackground(Color.WHITE);    
    }

    public JTextField getTfMinas() {
        return tfMinas;
    }

    public void setTfMinas(JTextField tfMinas) {
        this.tfMinas = tfMinas;
    }

    public JTextField getTfTiempo() {
        return tfTiempo;
    }

    public void setTfTiempo(JTextField tfTiempo) {
        this.tfTiempo = tfTiempo;
    }

    public JButton getbStart() {
        return bStart;
    }

    public void setbStart(JButton bStart) {
        this.bStart = bStart;
    }

    public JButton getbPause() {
        return bPause;
    }

    public void setbPause(JButton bPause) {
        this.bPause = bPause;
    }

    public JButton getbExit() {
        return bExit;
    }

    public void setbExit(JButton bExit) {
        this.bExit = bExit;
    }
    
}
