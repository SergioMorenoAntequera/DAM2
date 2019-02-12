/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author windiurno
 */
public class HiloServidor implements Runnable {
  
    Cifrar cifrar;
    DesCifrar descifrar;
    
    Socket con;
    ArrayList<Cliente> losClientes;
    Cliente miCliente;
    int id;
    
    BufferedReader entrada;
    PrintWriter salida;
    
    boolean chatPrivado = false;
    int cliPrivado = -1;

    //--------------------------------------------------------------------------
    
    public HiloServidor(Socket con, ArrayList<Cliente> alc, int id) {
        losClientes = alc;
        this.con = con;
        this.id = id;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                PrintWriter pw = new PrintWriter(con.getOutputStream(), true)
        ) {
            entrada = br;
            salida = pw;
            crearCliente();
            
            //Recibimos todo lo que nos manda este cliente y se lo mandamos a todos menos a el
            String cad = "";
            while (cad != null) {
                cad = entrada.readLine().trim();
                if (cad == null || cad.equalsIgnoreCase("exit")) {
                    break;
                }
                mandarMensaje(cad);
            }
            
            System.out.println("El Cliente: " + miCliente.getNomCli() + " se ha desconectado!!!");
            losClientes.remove(miCliente);
            
        } catch (IOException ex) {
            losClientes.remove(miCliente);
            System.out.println("Error en HiloServidor: " + ex.getMessage());
        }
    }

    //--------------------------------------------------------------------------
    
    public void crearCliente() {
        miCliente = new Cliente(id, entrada, salida);
        losClientes.add(miCliente);
        System.out.println("\tCliente: " + miCliente.getNomCli() + ", Conectado");
        miCliente.getSalida().println("Bienvenido al Chat cliente \"" + miCliente.getNomCli() + "\"");
    }

    //--------------------------------------------------------------------------
    
    public void mandarMensaje(String cad) {
        //Si quremos que el servidor lo vea: 
        
        String mensaje = "[" + miCliente.getNomCli() + "]>" + cad;
        
        cifrar = new Cifrar(mensaje);
        String mensajeCifrado = cifrar.getFraseCifrada();
        descifrar = new DesCifrar(mensajeCifrado);
        mensaje = descifrar.getFrase();
        
        System.out.println(mensajeCifrado);
        System.out.println(mensaje);
        
        
        for (Cliente c : losClientes) {
            if (c != miCliente) {
                c.getSalida().println(mensajeCifrado);
                c.getSalida().println(mensaje);
            }
        }
    }
}
