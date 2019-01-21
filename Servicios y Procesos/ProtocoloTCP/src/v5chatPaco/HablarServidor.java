/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v5chatPaco;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author windiurno
 */
public class HablarServidor implements Runnable {
    Scanner teclado= new Scanner(System.in);
    ArrayList<Cliente> clientes;
    boolean salir;
    boolean chatPrivado;
    
    //--------------------------------------------------------------------------
    
    public HablarServidor(ArrayList<Cliente> c, boolean exit){
        clientes=c;
        salir=exit;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void run(){
        String cad;
        while(true){
            cad=teclado.nextLine();
            //Para hacer que se cierre el servidor
            if(cad.trim().equalsIgnoreCase("cerrar") ||cad.trim().equalsIgnoreCase("exit")){
                salir=true;
                break;
            }
            
            //Si hay clientes habla, si no manda un aviso
            if(clientes.size()!=0){
                for(Cliente c: clientes){
                    c.getSalida().println("[Servidor]>"+cad);
                }
            } else{
                System.out.println("*** No hay ningún cliente en el servidor ***");
            }
        }   
    }
    
    //--------------------------------------------------------------------------
    
    public void mandarMensaje(String cad) {
        //Si quremos que el servidor lo vea:
        if (cad.length() == 2 && cad.charAt(0) == '/') {
            evaluaOrden(cad);
            return;
        }

        if (!chatPrivado) {
            for (Cliente c : clientes) {
                if (c != miCliente || !miCliente.getBaneados().contains(c)) {
                    c.getSalida().println("[" + miCliente.getNomCli() + "]>" + cad);
                }
            }
        } else {
            for (Cliente c : losClientes) {
                if (c != miCliente && c.getIdCli() == this.cliPrivado) {
                    c.getSalida().println("<<" + miCliente.getNomCli() + ">>: " + cad);
                }
            }
        }
    }
    
    //--------------------------USO DE COMANDOS---------------------------------
    //--------------------------------------------------------------------------
    
    public void evaluaOrden(String comando) {
        char letra = comando.charAt(1);
        switch (letra) {
            case 'h':
                //Ayuda (Muestra los comando)
                verAyuda();
                break;
            case 'l':
                //listar Clientes
                listarClientes();
                break;
            case 'p':
                //Chat privado
                iniciarPrivado();
                break;
            case 'z':
                //Salir de Privado
                break;
            case 'b':
                //Banear Cliente 
                break;
            case 'r':
                //Ver clientes Baneados
                break;
            case 'q':
                //Quitar baneo a cliente
                break;
            case 'd':
                //Expulsar Cliente
                break;
            default:
                System.out.println("Orden erronea o comando NO implementado");
        }
    }
    
    //--------------------------------------------------------------------------
    
    public void verAyuda() {
        System.out.println("** Los Comandos Activos son :");
        System.out.println("1.- /h Ayuda.");
        System.out.println("2.- /l Listar Usuarios.");
        System.out.println("3.- /p Chat Privado con cliente.");
        System.out.println("3.- /s Chat Privado con servidor.");
        System.out.println("4.- /z Salir Chat Privado.");
        System.out.println("5.- /b Bloquear usuario.");
    }
    
    //--------------------------------------------------------------------------
    
    public void listarClientes() {
        int num = 1;
        System.out.println("** Los Clientes Activos son :");
        for (Cliente c : this.clientes) {
            System.out.println(num++ + ".- Nombre: " + c.getNomCli() + " // Codigo: " + c.getIdCli());
        }
    }
    
    //--------------------------------------------------------------------------
    
    public void iniciarPrivado() {
        
    }
    
    
    
}
