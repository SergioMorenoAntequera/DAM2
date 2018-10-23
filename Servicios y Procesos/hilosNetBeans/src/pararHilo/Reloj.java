/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pararHilo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author windiurno
 */
public class Reloj extends JPanel{
    
    public JTextField reloj;
    
    public Reloj(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        this.setLayout(new FlowLayout());
        reloj = new JTextField("00:00:00");
        reloj.setPreferredSize(new Dimension(250, 100));
        reloj.setBackground(Color.BLACK);
        reloj.setForeground(Color.GREEN);
        reloj.setFont(new Font("Consoles", Font.BOLD, 30));
        reloj.setHorizontalAlignment(SwingConstants.CENTER);
        reloj.setVisible(true);
        reloj.setEditable(false);
        
        this.add(reloj);
    }
}
