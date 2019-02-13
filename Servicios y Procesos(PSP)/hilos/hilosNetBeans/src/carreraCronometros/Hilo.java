/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraCronometros;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author seran
 */
public class Hilo extends Thread{
    
    static boolean terminado;
    int numero;
    String espacios = "   ";
    JLabel txt;
    JButton bStart;
    int nJugador;

    public Hilo(JLabel txt, JButton bStart, int nJugador){
        this.txt = txt;
        this.bStart = bStart;
        this.nJugador = nJugador;
    }

    @Override
    public void run() {
        terminado = false;
        numero = (int)(Math.random() * 40 + 1);
        while (numero < 100) {
            dormir(80);
            numero++;
            String numeroTxt = espacios + numero;
            txt.setText(numeroTxt);
        }
        if (!terminado) {
            terminado = true;
            bStart.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Ha ganado el jugador " + nJugador);
        }

    }

    public void dormir(int numero) {
        try {
            Thread.sleep(numero);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
