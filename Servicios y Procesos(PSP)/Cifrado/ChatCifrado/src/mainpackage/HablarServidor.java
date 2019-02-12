/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author windiurno
 */
public class HablarServidor implements Runnable {
    
    Cifrar cifrar;
    DesCifrar  descifrar;
    Scanner teclado= new Scanner(System.in);
    ArrayList<Cliente> clientes;
    boolean salir;
    
    static boolean chatPrivado = false;
    int clienteElegido = -1;
    
    //--------------------------------------------------------------------------
    
    public HablarServidor(ArrayList<Cliente> c, boolean exit){
        clientes = c;
        salir = exit;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void run(){
        String cad;
        while(true){
            cad = teclado.nextLine();
            
            mandarMensaje(cad);
        }   
    }
    
    //--------------------------------------------------------------------------
    
    public void mandarMensaje(String cad) {
        //Si quremos que el servidor lo vea:

        //Para hacer que se cierre el servidor----------------------------------
        if (cad.trim().equalsIgnoreCase("cerrar") || cad.trim().equalsIgnoreCase("exit")) {
            salir = true;
            return;
        }
        
        //Si hay clientes habla, si no manda un aviso---------------------------
        if (clientes.size() == 0) {
            System.out.println("*** No hay ningún cliente en el servidor ***");
            return;
        }
        
        String mensaje = "[Servidor]>" + cad;
        
        cifrar = new Cifrar(mensaje);
        String mensajeCifrado = cifrar.getFraseCifrada();
        descifrar = new DesCifrar(mensajeCifrado);
        mensaje = descifrar.getFrase();
        
        //hablar en general
        for (Cliente c : clientes) {
            c.getSalida().println(mensajeCifrado);
            c.getSalida().println(mensaje);
        }
    }
}
