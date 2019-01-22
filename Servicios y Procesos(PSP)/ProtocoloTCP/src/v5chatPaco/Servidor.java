/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v5chatPaco;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author windiurno
 */
public class Servidor {

    static boolean terminado = false;

    public static void main(String[] args) {
        
        int puerto = 15000;
        int idCliente = 1;
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try (ServerSocket conexiones = new ServerSocket(puerto))
        {
            //Mensaje que se muestra al iniciar el servidor---------------------
            banner();
            
            //Hilo para que el servidor pueda mandar mensajes-------------------
            HablarServidor hablarServ = new HablarServidor(clientes, terminado);
            (new Thread(hablarServ)).start();
            
            //El proposito poincipal del servidor es recoger clientes, eso es aquí.
            while (!terminado) {
                HiloServidor hiloServ = new HiloServidor(conexiones.accept(), clientes, idCliente++);
                (new Thread(hiloServ)).start();
            }

        } catch (IOException ex) {
            System.err.println("Error al Iniciar el servidor: " + ex.getMessage());
        }
    }

    //--------------------------------------------------------------------------

    public static void banner() {
        System.out.println("+--------------------------------------+");
        System.out.println("|                                      |");
        System.out.println("|    **** Chat V 1.0 Iniciado ****     |");
        System.out.println("|    ****    Puerto 15000     ****     |");
        System.out.println("|                                      |");
        System.out.println("+--------------------------------------+\n");
    }

}
