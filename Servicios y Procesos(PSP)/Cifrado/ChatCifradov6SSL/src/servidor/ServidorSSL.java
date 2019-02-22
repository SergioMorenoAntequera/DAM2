// keytool --gen-key -alias claveSSL -keyalg RSA -keystore ./AlmacenSSL -storepass usuario -deststoretype pkcs12
// keytool --gen-key -alias claveSSL -keyalg RSA -keystore ./AlmacenSSL -storepass contrasenia -deststoretype pkcs12

package servidor;
import cliente.Cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;

public class ServidorSSL {

    public static void main(String[] args) {
        int puerto = 11000;
        int idCliente = 1;
        ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
        EscribirServidor hServidorMandarMensajes;
        System.setProperty("javax.net.ssl.keyStore", "C:/Users/windiurno/AlmacenSSL");
        System.setProperty("javax.net.ssl.keyStorePassword", "contrasenia");

        Scanner teclado = new Scanner(System.in);
        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("\n----> SERVIDOR SSL CORRIENDO EN PUERTO 11000 <----\n");
        try (
                SSLServerSocket servidor = (SSLServerSocket) sfact.createServerSocket(puerto);
                SSLSocket cliente = (SSLSocket) servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        ) {
            System.out.println("LLego Un Cliente.....");
            String cad = "";

            //le mando Un saludo
            salida.println("**** Conectado Al Servidor, toda la comunicación será cifrada ****");
            //Para Ver lo que dice el cliente
            HiloRecibir hr = new HiloRecibir(entrada);
            Thread hilo = new Thread(hr);
            hilo.start();

            // Para Hablar con el Cliente
            while (cad != null) {
                cad = teclado.nextLine();
                salida.println(cad);
            }

        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
            System.err.println("ERROR: " + ex.toString());
            System.exit(0);
        }
    }
}
