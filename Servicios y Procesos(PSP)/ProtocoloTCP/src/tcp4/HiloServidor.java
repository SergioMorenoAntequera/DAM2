package tcp4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor implements Runnable{
    
    ArrayList<Cliente> losClientes;
    Cliente miCli;
    int id_cli;
    BufferedReader IN;
    PrintWriter OUT;
    Socket conexion;
    
    public HiloServidor(Socket s, ArrayList<Cliente> cli, int id){
        conexion=s;
        losClientes=cli;
        id_cli=id;
    }
    
    @Override 
    public void run(){
        try(
            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter out  = new PrintWriter(conexion.getOutputStream(), true);

        ){
            IN=in;
            OUT=out;
            generaCliente();
            //Lamamamos al hilo HablarServidor para que el server pueda hablar con los clientes
            //HablarServidor hs = new HablarServidor(losClientes);
            //Thread hilo1= new Thread(hs);
            //hilo1.start();
            mostrarBanner();
            
            String cad="";
            //Con esto el servidor recibe lo de todos los clientes
            while(cad!=null && !cad.trim().equalsIgnoreCase("quit") && !cad.trim().equalsIgnoreCase("exit")){
                cad=IN.readLine();
                if(cad==null || cad.trim().equalsIgnoreCase("quit") || cad.trim().equalsIgnoreCase("exit") || cad.trim().equals("/x")) break;
                if(cad.trim().charAt(0)=='/'){
                    evaluarOrden(cad.trim());
                }
                else{
                    System.out.println("["+miCli.getNombre()+"]>"+cad);
                    publicarMensaje(cad);
                }
            }
            System.out.println("\t\tDesconectando a cliente: " +miCli.getNombre());
            losClientes.remove(miCli);
        }catch(Exception ex){
            System.err.println("ERROR EN HILO SERVIDOR: " +ex.getMessage());
            losClientes.remove(miCli);
            

        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void generaCliente(){
        miCli=new Cliente(id_cli, IN, OUT);
        losClientes.add(miCli);
    
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void mostrarBanner(){
        //OUT.orintln("COD_108"+miCli.getNombre());
        OUT.println("+------------------------------------------+");
        OUT.println("|------------------------------------------|");
        OUT.println("|---   << CLIENTE " + id_cli +" >>    ---|");
        OUT.println("|------------------------------------------|");
        OUT.println("+------------------------------------------+");
        OUT.println("\n(Hay un total de : " + losClientes.size() + ", clientes activos en este momento.)");
        OUT.println("Teclea \"/h\", para ver comandos disponibles.");
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void publicarMensaje(String texto){
        for(Cliente c: losClientes){
            if(c!=miCli){
                c.getSal().println("["+miCli.getNombre()+"]>"+texto);
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------
    
   //------------------------------------------------------------------------------------------------------------------------------------------ 
   public void evaluarOrden(String orden){
       if(orden.length()>2 || orden.length()==1){
           OUT.println("Comando Incorrecto, Teclea \"/h\", para ver comandos disponibles");
           return;
       }
       char op=orden.charAt(1);
       switch(op){
           case 'h':
                OUT.println("< < < <     AYUDA     > > > >");
                OUT.println("Los Comandos Disponibles son: ");
                OUT.println("\t1.- /h Muestra Comandos disponibles:");
                OUT.println("\t2.- /l Muestra Usuarios Conectados.");
                OUT.println("\t3.- /p Inicia chat privado con usuario");
                OUT.println("\t4.- /s Inicia chat privado con Servidor.");
                OUT.println("\t5.- /x Salir.");
                break;
            case 'l':
                verClientes();
                break;
            case 'p':
                OUT.println("No implemantado todavia, en breve!!!!");
                break;
            case 's':
                OUT.println("No implementado todavia, en breve!!!!");
                break;
            case 'x':
                losClientes.remove(miCli);
                try{
                    this.conexion.close();
                }catch(Exception ex){}
            default:
                OUT.println("COMANDO ERRONEO!!!!");


       }
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------
    public void chatPrivado(){
        if(losClientes.size()<2){
            OUT.println("NO hay clientes Activos !!!");
        }
        else{
            verClientes();
            OUT.println("Elige Clientes ?");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------<<<<<<
    public void verClientes(){
        int i=1;
        OUT.println("< < < < CLIENTES ACTIVOS > > > >");
        for(Cliente c : losClientes){
            if (c!=miCli) OUT.println(i++ + ".- "+c.getNombre());
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------
}
