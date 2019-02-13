/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author seran
 */
public class RunCliente {
   
    public static void main(String[] args) {
        InetAddress direccionIP = null;
        int puerto = 0;

        if (args.length != 2) {
            System.err.println("Error se esperaba Dirección Ip y Puerto: ");
            System.out.println("USO \"java Cliente dirIP Puerto\"");
            System.exit(-1);
        }

        //Convertimos la dirección a formato InetAdress y el puerto a int
        String cad = args[0];
        try {
            direccionIP = InetAddress.getByName(cad);
            puerto = Integer.parseInt(args[1]);

        } catch (UnknownHostException ex) {
            System.err.println("Formato de Dirreción IP Errorneo o Desconocido");
            System.exit(-1);
        } catch (NumberFormatException ex) {
            System.err.println("Formato Puerto Erroneo!!!!");
            System.exit(-1);
        }
    
        //----------------------------------------------------------------------
        try (
                Socket con = new Socket(direccionIP, puerto);
        ) {

            
        } catch (IOException ex) {
            System.err.println("Error al recibir el fichero!!!!!");
            System.err.println("Mensaje: " + ex.getMessage());
            System.exit(-1);
        }

    }
}
