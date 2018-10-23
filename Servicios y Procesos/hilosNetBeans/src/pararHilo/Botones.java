/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pararHilo;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author windiurno
 */
public class Botones extends JPanel {
    
    public JButton bStart, bPause, bReset, bExit;
    
    public Botones(){
        iniciarcomponentes();
    }
    
    private void iniciarcomponentes(){
        this.setLayout(new FlowLayout());
        
        bStart = new JButton("START");
        bPause = new JButton("PAUSE");
        bReset = new JButton("RESET");
        bExit = new JButton("EXIT");
        
        bStart.addActionListener(new Control(this));
        bPause.addActionListener(new Control(this));
        bReset.addActionListener(new Control(this));
        bExit.addActionListener(new Control(this));
        
        this.add(bStart);
        this.add(bPause);
        this.add(bReset);
        this.add(bExit);
    }
    
    //Getters
    public JButton getbStart() {
        return bStart;
    }
    public JButton getbPause() {
        return bPause;
    }
    public JButton getbReset() {
        return bReset;
    }
    public JButton getbExit() {
        return bExit;
    }
    
}
