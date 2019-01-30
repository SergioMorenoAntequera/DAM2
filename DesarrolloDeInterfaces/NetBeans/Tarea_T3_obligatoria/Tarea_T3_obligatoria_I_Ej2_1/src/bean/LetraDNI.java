/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class LetraDNI extends JTextField implements Serializable {
    
    private String texto;
    private KeyListener listener;
    
    //--------------------------------------------------------------------------
    public LetraDNI() {
        super();

        //Accion----------------------------------------------------------------
        this.listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    try {
                        int numero = Integer.parseInt(getText());

                        if (numero >= 100000000 || numero <= 1000000) {
                            throw new Exception();
                        }
                        calculaLetra(numero);

                    } catch (Exception ex) {
                        System.out.println("Error al recibir el DNIi" + ex.getMessage());
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        };
        this.addKeyListener(listener);
    }

    //--------------------------------------------------------------------------
       
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        this.setText(this.texto);
    }
    
    //--------------------------------------------------------------------------
    
    char calculaLetra(int dni) {
        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni % 23;
        char letra = juegoCaracteres.charAt(modulo);
        this.setTexto(this.getText() + letra);
        return letra;
    }
    
}
