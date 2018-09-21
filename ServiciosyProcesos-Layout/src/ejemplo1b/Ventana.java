/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1b;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame{
    
    private PanelBotones pb;
    private PanelTexto pt;
    private PanelTitulo ptit;
    private JButton btnSalir;
    private JTextField mensaje;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        pb = new PanelBotones();
        pt = new PanelTexto();
        ptit = new PanelTitulo();
        btnSalir = pb.getBtnSalir();
        mensaje = pt.getTxtMensaje();
        
        Container lienzo = this.getContentPane();
                
        
    }
    
}
