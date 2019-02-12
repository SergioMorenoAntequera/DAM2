package clientegrafico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Angel Salas Calvo
 */
public class Cliente {
    InetAddress ipDestino=null;
    int puerto=0;
    VentanaCliente ventana= null;
    Socket conex;
    PrintWriter salida = null;
    BufferedReader entrada = null;
    LeerCliente hiloLectura = null;

    
    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public Cliente(VentanaCliente ventana){
        this.ventana=ventana;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * METODO PARA ABRIR LA CONEXIÓN ENTRE EL CLIENTE Y SERVIDOR CON LOS DATOS PASADOS
     * @param ipDestino
     * @param puerto
     * @return 
     */
    public boolean abrirConexion(InetAddress ipDestino, int puerto){
        boolean conexionEstablecida=true;
        
        //Dar valor a la IP y puerto de conexion
        this.ipDestino = ipDestino;
        this.puerto = puerto;
        
        //Crear conexión y flujos entrada/salida
        try {
            conex = new Socket(ipDestino, puerto);
            salida = new PrintWriter(conex.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(conex.getInputStream()));
            
            //Crear y ejecutar hilo que permitirá leer mensajes al cliente
            hiloLectura = new LeerCliente(entrada);
            hiloLectura.start();
        } catch(ConnectException ce){
            JOptionPane.showMessageDialog(ventana, "No se ha podido establecer la conexión.\nRevise los datos introducidos.","", JOptionPane.ERROR_MESSAGE);
            conexionEstablecida = false;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            conexionEstablecida = false;
        }
        
        //Devolver booleano indicando si se ha podido establecer la conexión o no
        return conexionEstablecida;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * METODO PARA ENVIAR UN MENSAJE AL SERVIDOR A TRAVES DEL FUJO DE SALIDA
     * @param mensaje 
     */
    public void enviarMensaje(String mensaje){
        salida.println(mensaje);
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * METODO PARA CERRAR LA CONEXION Y LOS FLUJOS DE SALIDA
     */
    public void cerrarConexion(){
        try {
            if(conex!=null && salida!=null && entrada!=null){
                //Enviar mensaje al servidor para cerrar la conexión
                salida.println("exit");
                conex.close();
                //Cerrar los flujos de datos
                salida.close();
                entrada.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}