/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cifrado.DesCifrar;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author seran
 */
public class LeerCliente extends Thread {
    
    BufferedReader flujoEntrada;
    String mensajeLlegadoCifrado;
    DesCifrar descifrar;

    public LeerCliente(BufferedReader flujoEntrada) {
        this.flujoEntrada = flujoEntrada;
        this.mensajeLlegadoCifrado = null;
    }

    @Override
    public void run() {
        super.run();
        
        while(true){
            try {
                //El error salta en la siguiente linea
                mensajeLlegadoCifrado = flujoEntrada.readLine();
                
                descifrar = new DesCifrar(mensajeLlegadoCifrado);
                
                System.out.println(mensajeLlegadoCifrado);
                System.out.println(descifrar.getFrase());
                
            } catch (IOException ex) {
                System.err.println("Error en Leer Cliente: " + ex.getMessage());
                break;
            }
        }
        
    }
}
