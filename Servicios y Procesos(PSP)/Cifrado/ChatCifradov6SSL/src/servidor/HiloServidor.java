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
import javax.net.ssl.SSLSocket;

/**
 *
 * @author seran
 */
public class HiloServidor implements Runnable {

    ArrayList<PlantillaCliente> losClientes;
    PlantillaCliente miCli;
    int id_cli;
    BufferedReader IN;
    PrintWriter OUT;
    SSLSocket conexion;

    HiloServidor(SSLSocket s, ArrayList<PlantillaCliente> cli, int id) {
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
            
            System.out.println("***** " + miCli.getNombre() + " se ha conectado *****");

            String mensajeRecibido = "";
            //Con esto el servidor recibe lo de todos los clientes
            while (mensajeRecibido != null && !mensajeRecibido.trim().equalsIgnoreCase("quit") && !mensajeRecibido.trim().equalsIgnoreCase("exit")) {
                
                //Recogemos los mensajes de los clientes
                mensajeRecibido = IN.readLine();
                
                String mensajeCompleto = "[" + miCli.getNombre() + "]> " + mensajeRecibido;

                System.out.println(mensajeCompleto);
                publicarMensaje(mensajeCompleto);
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
        for (PlantillaCliente c : losClientes) {
            if (c != miCli) {
                c.getFlujoSalida().println(textoCompletoCifrado);
            }
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void generaCliente() {
        miCli = new PlantillaCliente(id_cli, IN, OUT);
        losClientes.add(miCli);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void mostrarBanner(PrintWriter salida) {
        String banner = "+-----------------------------+\n"
                + "|---   << CLIENTE " + id_cli + " >>    ---|\n"
                + "+-----------------------------+";
        salida.println(banner);
    }
}
