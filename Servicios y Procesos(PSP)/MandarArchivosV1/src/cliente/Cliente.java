/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Cliente {
    
    //El cliente solo se prepara para recibir el archivo
    static ObjectInputStream ois;
    static File archivo;
    static String nombArchivo;
    
    //Variables para recoger los parametros (IP y Puerto)
    static InetAddress ipServer = null;
    static int puerto = 0;
        
    
    //--------------------------------------------------------------------------
    
    
    public static void main(String[] args) {
        //Lo que haec el main es como vamos a ejecutarlo desde consola:
        //Comprobamos que nos llegan bien los aprametros IP y puerto
        comprobarParametros(args);
        
        //----------------------------------------------------------------------
        
        //Una vez tenemos los datos establecemos una conexion
        try (Socket conexion = new Socket(ipServer, puerto);
                ObjectInputStream auxOis = new ObjectInputStream(conexion.getInputStream());){
            
            ois = auxOis;
            //Recibimos un string que nos llega desde HiloServidor
            String cadena = (String)ois.readObject();
            System.out.println(cadena);
            
            
        } catch (IOException ex) {
            System.err.println("La liaste Jhon Lancaster: " + ex.toString());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al leer un objeto " + ex.toString());
        } catch (Exception e) {
            System.err.println("Pua la que has liao tu " + e.toString());
        }
        
        
    }
    
    //--------------------------------------------------------------------------
    
    static private void comprobarParametros(String[] args){
        
        //Miramos si llegan dos parametros(IP y Puerto)
        if(args.length != 2){
            System.out.println("Numero de parametros no valido");
            System.exit(-1);
        }
        
        String param1 = args[0];
        String param2 = args[1];
        //Miramos si podemos pasar esto a IP y Puerto válidos
        try {
            
            ipServer = InetAddress.getByName(param1);
            puerto = Integer.parseInt(param2);
            //Si conseguimos los valores es que no ha habido problemas
            
        } catch (UnknownHostException ex) {
            System.err.println("Error al introducir la IP");
            System.exit(-1);
        } catch(NumberFormatException ex){
            System.err.println("Error al introducir el puerto");
            System.exit(-1);
        }
    }
}
