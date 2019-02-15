/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cifrado.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import cliente.*;

/**
 *
 * @author seran
 */
public class HiloServidor implements Runnable {

    ArrayList<Cliente> losClientes;
    Cliente miCli;
    int id_cli;
    BufferedReader IN;
    PrintWriter OUT;
    Socket conexion;
    DesCifrar descifrar;
    Cifrar cifrar;

    public HiloServidor(Socket s, ArrayList<Cliente> cli, int id) {
        conexion = s;
        losClientes = cli;
        id_cli = id;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                PrintWriter out = new PrintWriter(conexion.getOutputStream(), true);
        ) {
            IN = in;
            OUT = out;
            
            generaCliente();
            
            mostrarBanner(OUT);
            
            System.out.println(miCli.getNombre() + " se ha conectado");

            String mensajeARecibirCifrado = "";
            //Con esto el servidor recibe lo de todos los clientes
            while (mensajeARecibirCifrado != null && !mensajeARecibirCifrado.trim().equalsIgnoreCase("quit") && !mensajeARecibirCifrado.trim().equalsIgnoreCase("exit")) {
                
                //Recogemos y desciframos la cadena tal y como nos llega de los clientes
                mensajeARecibirCifrado = IN.readLine();
                descifrar = new DesCifrar(mensajeARecibirCifrado);
                String mensajeARecibirDescifrado = descifrar.getFrase();
                
                //Le ponemos a la cadena al principio el cliente que la ha pasado
                String mensajeCompletoDescifrado = "[" + miCli.getNombre() + "]> " + mensajeARecibirDescifrado;

                //Una vez que ya hemos mostrado esto en el servido lo ciframos pero ahora entero
                cifrar = new Cifrar(mensajeCompletoDescifrado);
                String mensajeCompletoCifrado = cifrar.getFraseCifrada();
                
                System.out.println(mensajeCompletoCifrado);
                System.out.println(mensajeCompletoDescifrado);
                
                
                publicarMensaje(mensajeCompletoCifrado);
            }
            
            System.out.println("\t\tDesconectando a cliente: " + miCli.getNombre());
            losClientes.remove(miCli);
            
        } catch (Exception ex) {
            System.err.println("ERROR EN HILO SERVIDOR: " + ex.getMessage());
            losClientes.remove(miCli);

        }
    }

    //--------------------------------------------------------------------------
    
    public void publicarMensaje(String textoCompletoCifrado) {

        for (Cliente c : losClientes) {
            if (c != miCli) {
                c.getFlujoSalida().println(textoCompletoCifrado);
            }
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void generaCliente() {
        miCli = new Cliente(id_cli, IN, OUT);
        losClientes.add(miCli);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void mostrarBanner(PrintWriter salida) {
        String banner = "+-----------------------------+\n"
                + "|---   << CLIENTE " + id_cli + " >>    ---|\n"
                + "+-----------------------------+";
        
        Cifrar cifrar = new Cifrar(banner);
        
        salida.println(cifrar.getFraseCifrada());
        
        /*salida.println("+-----------------------------+");
        salida.println("|---   << CLIENTE " + id_cli + " >>    ---|");
        salida.println("+-----------------------------+");*/
    }
}
