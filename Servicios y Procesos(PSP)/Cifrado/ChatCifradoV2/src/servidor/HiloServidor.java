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
            
            mostrarBanner();
            
            System.out.println(miCli.getNombre() + " se ha conectado");

            String mensajeARecibirCifrado = " ";
            //Con esto el servidor recibe lo de todos los clientes
            while (mensajeARecibirCifrado != null && !mensajeARecibirCifrado.trim().equalsIgnoreCase("quit") && !mensajeARecibirCifrado.trim().equalsIgnoreCase("exit")) {
                
                mensajeARecibirCifrado = IN.readLine();
                //System.out.println(mensajeARecibirCifrado+"");
            
                descifrar = new DesCifrar(mensajeARecibirCifrado);
                String mensajeARecibirDescifrado = descifrar.getFrase();
                System.out.println("[" + miCli.getNombre() + "]>" + mensajeARecibirCifrado+"");
                System.out.println("[" + miCli.getNombre() + "]>" + mensajeARecibirDescifrado);

                publicarMensaje(mensajeARecibirCifrado, mensajeARecibirDescifrado);
            }
            
            System.out.println("\t\tDesconectando a cliente: " + miCli.getNombre());
            losClientes.remove(miCli);
            
        } catch (Exception ex) {
            System.err.println("ERROR EN HILO SERVIDOR: " + ex.getMessage());
            losClientes.remove(miCli);

        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void generaCliente() {
        miCli = new Cliente(id_cli, IN, OUT);
        losClientes.add(miCli);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void mostrarBanner() {
        OUT.println("+------------------------------------------+");
        OUT.println("|---   << CLIENTE " + id_cli + " >>    ---|");
        OUT.println("+------------------------------------------+");
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void publicarMensaje(String textoCifrado, String textoDescifrado) {
        for (Cliente c : losClientes) {
            if (c != miCli) {
                c.getFlujoSalida().println("[" + miCli.getNombre() + "]>" + textoCifrado);
                c.getFlujoSalida().println("[" + miCli.getNombre() + "]>" + textoDescifrado);
            }
        }
    }

}
