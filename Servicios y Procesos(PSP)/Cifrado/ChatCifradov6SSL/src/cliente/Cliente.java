//keytool -export -alias claveSSL -file C:\Users\windiurno\certificado.cer  -keystore AlmacenSSL -deststoretype pkcs12
//keytool -import -alias claveSSL -file C:\Users\windiurno\certificado.cer  -keystore AlmacenClienteSSL -deststoretype pkcs12

package cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocketFactory;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;

public class Cliente {

    public static void main(String[] args) {
        String serv = "localhost";
        int puerto = 11000;

        System.setProperty("javax.net.ssl.trustStore", "C:/Users/windiurno/AlmacenClienteSSL");
        System.setProperty("javax.net.ssl.trustStorePassword", "contrasenia");
        System.out.println("Iniciando Cliente......");

        System.out.println("Conectando a : " + serv + ", puerto: " + puerto + " Conexion cifrada pto a pto");
        Scanner teclado = new Scanner(System.in);
        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (
                SSLSocket cliente = (SSLSocket) sfact.createSocket(serv, puerto);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);) {

            String cad = "";
            //Recibimos el saludo
            cad = entrada.readLine();
            System.out.println(cad);

            //Para recibir mensajes
            HiloRecibir hr = new HiloRecibir(entrada);
            hr.start();

            //Para poder mandar mensajes
            while (cad != null) {
                cad = teclado.nextLine();
                salida.println(cad);
            }

        } catch (IOException ex) {

        }
    }
}
