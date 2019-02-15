/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cifrado.DesCifrar;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author seran
 */
public class LeerCliente extends Thread {
    
    BufferedReader flujoEntrada;
    String mensajeLlegadoCifrado;
    DesCifrar descifrar;
    JTextArea ta;

    public LeerCliente(BufferedReader flujoEntrada, JTextArea ta) {
        this.flujoEntrada = flujoEntrada;
        this.mensajeLlegadoCifrado = null;
        this.ta = ta;
    }

    @Override
    public void run() {
        super.run();
        
        while(true){
            try {
                //El error salta en la siguiente linea
                mensajeLlegadoCifrado = flujoEntrada.readLine();
                
                descifrar = new DesCifrar(mensajeLlegadoCifrado);
                
                ta.append(descifrar.getFrase()+"\n");

            } catch (IOException ex) {
                System.err.println("Error en Leer Cliente: " + ex.getMessage());
                break;
            }
        }
        
    }
}
