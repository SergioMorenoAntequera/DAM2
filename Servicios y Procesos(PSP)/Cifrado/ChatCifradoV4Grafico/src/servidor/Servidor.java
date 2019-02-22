package servidor;

import cliente.Cliente;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * @author windiurno
 */
public class Servidor {
    public static void main(String[] args) {
        
        int PTO = 15000;
        int idCliente = 1;
        ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
        EscribirServidor hServidorMandarMensajes;
        
        //----------------------------------------------------------------------
        
        System.out.println("## Servidor Activo y Aceptando Una Conexion ##");
        System.out.println("## ----------------15000------------------- ##");
        
        try (
                ServerSocket conexion = new ServerSocket(PTO); //Necesario unicamente el servidor
        ){
            
            //------------------------------------------------------------------
            
            hServidorMandarMensajes = new EscribirServidor(misClientes);
            hServidorMandarMensajes.start();

            //------------------------------------------------------------------
            
            //El servidor recibe a el cliente
            while (true) {
                
                HiloServidor hs = new HiloServidor(conexion.accept(), misClientes, idCliente++);
                Thread hilo = new Thread(hs);
                hilo.start();
                
            }

        } catch (Exception ex) {
            System.err.println("La liaste: " + ex.getMessage());
        }
    }
}