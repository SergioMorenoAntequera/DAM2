/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cifrado.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author windiurno
 */
public class LeerCliente extends Thread {
    
    JTextArea ta;
    DesCifrar descifrar;
    String mensajeRecibidoCifrado;
    BufferedReader flujoEntrada;

    public LeerCliente(BufferedReader flujoEntrada, JTextArea ta) {
        this.flujoEntrada = flujoEntrada;
        mensajeRecibidoCifrado = "";
        this.ta = ta;
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {
        super.run();
        
        while(true){
            try {
                mensajeRecibidoCifrado = flujoEntrada.readLine();
                //descifrar = new DesCifrar(mensajeRecibidoCifrado);
                
                //ta.append(descifrar.getFrase());
                ta.append(mensajeRecibidoCifrado);
                
            } catch (IOException ex) {
                Logger.getLogger(LeerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
