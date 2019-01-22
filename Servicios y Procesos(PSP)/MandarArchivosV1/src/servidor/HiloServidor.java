/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class HiloServidor implements Runnable {
    
    Socket conexion;
    //ObjectInputStream ois;
    ObjectOutputStream oos;
    //Como necesitamos tener un un File para mandarlo
    File archivo;
    
    //--------------------------------------------------------------------------
    
    public HiloServidor(Socket c){
        this.conexion =  c;
        System.out.println("IP: " + this.conexion.getRemoteSocketAddress() + " CONECTADA!");
    }
    
    //--------------------------------------------------------------------------

    @Override
    public void run() {
        try(ObjectOutputStream auxOos = new ObjectOutputStream(conexion.getOutputStream())){
            this.oos = auxOos;
            
            //Aquí se manda un objeto String a modo de saludo
            //Este String lo tiene que recoger la clase Cliente en forma de objeto
            oos.writeObject(new String("****Se ha conectado con el servidor****"));
            
            //------------------------------------------------------------------
            
            //Aqui es donde se manda el fichero
            System.out.println("Procediento a mandar fichero a " + conexion.getRemoteSocketAddress());
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
