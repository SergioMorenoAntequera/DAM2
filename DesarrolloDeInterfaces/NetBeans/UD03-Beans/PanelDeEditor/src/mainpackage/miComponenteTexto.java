/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class miComponenteTexto extends JTextField implements Serializable {
    
    private String texto;
    private String tipo;

    //--------------------------------------------------------------------------
    
    public miComponenteTexto(String texto, String tipo) {
        this.texto = texto;
        this.tipo = tipo;
    }

    //--------------------------------------------------------------------------
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public synchronized void addKeyListener(KeyListener l) {

        KeyListener ac = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tipo == "Numero" && !Character.isDigit(e.getKeyChar())) {
                    e.consume();  
                }
                if (tipo == "Letra" && Character.isDigit(e.getKeyChar())) {
                    e.consume();  
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
            
        };
        this.addKeyListener(ac);
    }
}
