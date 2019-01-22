/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Servidor {
    
    public static void main(String[] args){
        final int PUERTO = 15000;
        banner();
        
        //----------------------------------------------------------------------
        
        //Creamos el servidor en el try para que se cierre solo
        try (ServerSocket host = new ServerSocket(PUERTO)) {
            
            while (true) {
                //Creamos el hilo servidor(El que manda el archivo)
                HiloServidor hiloServidor = new HiloServidor(host.accept());
                Thread hilo = new Thread(hiloServidor);
                hilo.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    //--------------------------------------------------------------------------
    
    private static void banner(){
        System.out.println("-------------------------");
        System.out.println("--Abriendo puerto 15000--");
        System.out.println("-------------------------");
    }
    
}
