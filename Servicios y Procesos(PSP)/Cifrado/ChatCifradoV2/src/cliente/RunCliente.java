/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author seran
 */
public class RunCliente {
   
    public static void main(String[] args) {
        
        
        InetAddress direccionIP = null;
        int puerto = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la dirección IP a la que conectarte(puede ser localhost)");
        String ipCad = sc.next();
        System.out.println("Introduce el puerto(15000 por lo general)");
        String puertoCad = sc.next();
        
        BufferedReader flujoEntrada = null;
        PrintWriter flujoSalida = null;

        //Convertimos la dirección a formato InetAdress y el puerto a int
        try {
            
            direccionIP = InetAddress.getByName(ipCad);
            puerto = Integer.parseInt(puertoCad);

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
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                PrintWriter out = new PrintWriter(con.getOutputStream(), true);
        ) {
            flujoEntrada = in;
            flujoSalida = out;
            
            EscribirCliente hElClienteEscribe = new EscribirCliente(flujoSalida);
            hElClienteEscribe.start();
            
            //La siguiente parte pone al cliente en escucha de lo que diga el server
            while(true){
                String mensajeRecibido = flujoEntrada.readLine();
                System.out.println(mensajeRecibido);
            }
            
        } catch (IOException ex) {
            System.err.println("Error");
            System.err.println("Mensaje: " + ex.getMessage());
            System.exit(-1);
        }

    }
}
