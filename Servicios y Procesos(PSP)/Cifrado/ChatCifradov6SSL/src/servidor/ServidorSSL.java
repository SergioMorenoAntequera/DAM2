// keytool --gen-key -alias claveSSL -keyalg RSA -keystore ./AlmacenSSL -storepass usuario -deststoretype pkcs12
//Para crear la clave privada del Cliente
// keytool --gen-key -alias claveSSL -keyalg RSA -keystore ./AlmacenSSL -storepass contrasenia -deststoretype pkcs12

package servidor;
import cliente.PlantillaCliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class ServidorSSL {

    public static void main(String[] args) {
        int puerto = 11000;
        
        ArrayList<PlantillaCliente> misClientes = new ArrayList<PlantillaCliente>();
        int idCliente = 1;
        
        System.setProperty("javax.net.ssl.keyStore", "C:/Users/seran/AlmacenSSL");
        System.setProperty("javax.net.ssl.keyStorePassword", "contrasenia");
        
        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("\n----> SERVIDOR SSL CORRIENDO EN PUERTO 11000 <----\n");
        try (
                SSLServerSocket servidor = (SSLServerSocket) sfact.createServerSocket(puerto);
                
        ) {
            
            //------------------------------------------------------------------
            
            //Hilo para que el servidor le mande mensaje a los clientes conectados
            EscribirServidor hEscribirServidor = new EscribirServidor(misClientes);
            hEscribirServidor.start();
            
            //------------------------------------------------------------------
            
            //El programa principal se encarga de recibir a los clientes
            //Y a su vez de crear el hilo para que reciba los mensajes de los mismos
            while(true){
                HiloServidor hs = new HiloServidor((SSLSocket)servidor.accept(), misClientes, idCliente++);
                Thread hilo = new Thread(hs);
                hilo.start();
            }

        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
            System.err.println("ERROR: " + ex.toString());
            System.exit(0);
        }
    }
}
