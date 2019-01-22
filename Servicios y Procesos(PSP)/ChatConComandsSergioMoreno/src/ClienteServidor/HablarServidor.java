/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;
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
        if (cad.length() == 2 && cad.charAt(0) == '/') {
            evaluaOrden(cad);
            return;
        }

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

        //hablar en general (Chat normal y privado  )
        if (!chatPrivado) {
            for (Cliente c : clientes) {
                if(!c.isBaneado()){
                    c.getSalida().println("[Servidor]>" + cad);
                }
            }
        } else {
            for (Cliente c : clientes) {
                if (c.getIdCli() == clienteElegido) {
                    c.getSalida().println("<<[Servidor]>>" + cad);
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
                chatPrivado = false;
                System.out.println("*** Se ha salido del chat privado ***");
                //Salir de Privado
                break;
            case 'b':
                banearCliente();
                //Banear Cliente 
                break;
            case 'r':
                verBaneados();
                //Ver clientes Baneados
                break;
            case 'q':
                desbanearCliente();
                //Quitar baneo a cliente
                break;
            case 'd':
                expulsarCliente();
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
        System.out.println("3.- /z Salir del char privado.");
        System.out.println("4.- /b Banear Cliente.");
        System.out.println("5.- /r Ver clientes baneados.");
        System.out.println("6.- /q Desbanear Cliente.");
        System.out.println("7.- /d Expulsar cliente.");
        
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
    
    public int iniciarPrivado() {
        listarClientes();
        System.out.println("*** Elige al cliente con el que iniciar el chat privado ***");
        try {
            clienteElegido = teclado.nextInt();
            chatPrivado = true;
            System.out.println("*** Se ha iniciado un chat privado ***");
            return clienteElegido;
        } catch (Exception e) {}
        return -1;
    }
    
    //--------------------------------------------------------------------------

    private void banearCliente() {
        listarClientes();
        System.out.println("*** Elige el cliente al que banear ***");
        try {
            clienteElegido = teclado.nextInt();
            for (Cliente c : clientes) {
                if(c.getIdCli() == clienteElegido){
                    c.setBaneado(true);
                    System.out.println("Cliente baneado");
                    c.getSalida().println("*** Has sido baneado por el servidor ***");
                }
            }
        } catch (Exception e) {}
    }

    //--------------------------------------------------------------------------
    
    private void verBaneados() {
        System.out.println("*** Clientes baneados ***");
        int num = 1;
        for(Cliente c : clientes){
            if(c.isBaneado()){
            System.out.println(num++ + ".- Nombre: " + c.getNomCli() + " // Codigo: " + c.getIdCli());    
            }
        }
    }

    //--------------------------------------------------------------------------
    
    private void desbanearCliente() {
        verBaneados();
        System.out.println("Selecciona un clientes para desbanear");
        int clienteElegido = teclado.nextInt();
        for(Cliente c : clientes){
            if(c.getIdCli() == clienteElegido){
                c.setBaneado(false);
                System.out.println("Cliente desbaneado");
                c.getSalida().println("*** Has sido desbaneado por el servidor ***");
            }
        }
    }
    
    //--------------------------------------------------------------------------

    private void expulsarCliente() {
        Cliente cli = null;
        listarClientes();
        System.out.println("*** Indica a que clientes quieres expulsar ***");
        int clienteElegido = teclado.nextInt();
        
        for(Cliente c : clientes){
            if(c.getIdCli() == clienteElegido){
                cli = c;
                System.out.println("Cliente expulsado con exito");
                c.getSalida().println("Has sido expulsado por el servidor");
            }
        }
        
        clientes.remove(cli);
    }
    
    
    
}
