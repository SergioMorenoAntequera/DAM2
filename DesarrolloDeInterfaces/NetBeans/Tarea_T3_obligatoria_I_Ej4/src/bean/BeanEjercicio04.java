/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class BeanEjercicio04 extends JTextField implements Serializable {
    
    private Color color;
    private Font fuente;
    private String tipo;
    KeyListener listener;
    
    //--------------------------------------------------------------------------
    
    public BeanEjercicio04() {
        super();
        
        setColor(Color.BLACK);
        setFuente(new Font("Calibri", Font.BOLD, 15));
        this.tipo = "Texto";
        gestionarTipo();
    }
    
    //--------------------------------------------------------------------------

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setForeground(this.color);
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
        this.setFont(this.fuente);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //--------------------------------------------------------------------------
    
    private void gestionarTipo() {
        //Texto, entero, Real
        listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(tipo == "Texto"){
                    
                }
                if(tipo == "Entero"){
                    
                }
                if(tipo == "Real"){
                    
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }   
}
