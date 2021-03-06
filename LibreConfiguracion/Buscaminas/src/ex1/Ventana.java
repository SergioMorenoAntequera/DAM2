/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame {
    
    public panelCampo pc;
    public PanelRight pr;
    public JButton[][] campo;
    public JButton bStart, bExit, bPause;
    public Semaforo semaforo;
    public HiloHora hilo;

    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        Container lienzo = new Container();
        lienzo.setLayout(new BorderLayout());
        
        pc = new panelCampo();
        pr = new PanelRight();
        
        this.campo = pc.campo;
        for (int f = 0; f < campo.length; f++) {
            for (int c = 0; c < campo[f].length; c++) {
                campo[f][c].addActionListener(new Control(this));
                campo[f][c].addMouseListener(new Control(this));
            }
        }

        bStart = pr.getbStart();
        bPause = pr.getbPause();
        bExit = pr.getbExit();
        bStart.addActionListener(new Control(this));
        bPause.addActionListener(new Control(this));
        bExit.addActionListener(new Control(this));
        
        semaforo = new Semaforo(true);
        hilo = new HiloHora(pr.getTfTiempo(), semaforo);
        
        lienzo.add(pc, BorderLayout.CENTER);
        lienzo.add(pr, BorderLayout.EAST);
        
        this.add(lienzo);
        
        pack();
    }
}
