package clientegrafico;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Angel Salas Calvo
 */
public class LeerCliente extends Thread{
    BufferedReader entrada;
    
    /**
     * CONSTRUCTOR PARAMETRIZADO
     * @param in 
     */
    public LeerCliente(BufferedReader in){
        this.entrada = in;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * SOBRESCRITURA DEL METODO RUN
     */
    @Override
    public void run(){
        do{
            try {
                String leido = entrada.readLine().trim();
                
                //Si el mensaje recibido del servidor es exit finalizamos este hilo
                if(leido.equalsIgnoreCase("exit")){
                    System.exit(0);
                }else{
                    VentanaCliente.jTAConversacion.append("\nSERVIDOR: "+leido);
                }
            } catch (IOException ex) {
                Logger.getLogger(LeerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while (true);
    }
}
