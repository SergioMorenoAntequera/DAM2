package tcp4;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Servidor4{
    public static void main(String [] args){

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        int id=1;
        int pto=15000;

        try(
            ServerSocket ss = new ServerSocket(pto);
        )
        {
            mensaje();

            //Para que el servidor Hable con los clientes
            HablarServidor has = new HablarServidor(clientes);
            (new Thread(has)).start();

            //---------------------
            
            while(true){
                HiloServidor hs = new HiloServidor(ss.accept(), clientes, id++);
                Thread hilo = new Thread(hs);
                hilo.start();
            }
        }catch(Exception ex){}
    }
    //-------------------------------------------------------------------------------------------
    public static void mensaje(){
        System.out.println("+--------------------------------+");
        System.out.println("|--------------------------------|");
        System.out.println("|--- # Servidor Chat Activo # ---|");
        System.out.println("|---     < Puerto 25000 >     ---|");
        System.out.println("|--------------------------------|");
        System.out.println("+--------------------------------+");
    }
    //-------------------------------------------------------------------------------------------------
    
}