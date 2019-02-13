/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

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

    public HiloServidor(Socket s, ArrayList<Cliente> cli, int id) {
        conexion = s;
        losClientes = cli;
        id_cli = id;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                PrintWriter out = new PrintWriter(conexion.getOutputStream(), true);) {
            IN = in;
            OUT = out;
            generaCliente();
            mostrarBanner();

            String cad = "";
            //Con esto el servidor recibe lo de todos los clientes
            while (cad != null && !cad.trim().equalsIgnoreCase("quit") && !cad.trim().equalsIgnoreCase("exit")) {
                
                cad = IN.readLine();

                System.out.println("[" + miCli.getNombre() + "]>" + cad);
                publicarMensaje(cad);

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
        //OUT.orintln("COD_108"+miCli.getNombre());
        OUT.println("+------------------------------------------+");
        OUT.println("|---   << CLIENTE " + id_cli + " >>    ---|");
        OUT.println("+------------------------------------------+");
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public void publicarMensaje(String texto) {
        for (Cliente c : losClientes) {
            if (c != miCli) {
                c.getFlujoSalida().println("[" + miCli.getNombre() + "]>" + texto);
            }
        }
    }

}
