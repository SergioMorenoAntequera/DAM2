//Con esto creamos el cerificado para poder hacer las claves publicas
//keytool -export -alias claveSSL -file C:\Users\seran\certificado.cer  -keystore AlmacenSSL -deststoretype pkcs12
//Generamos las clacves publicas
//keytool -import -alias claveSSL -file C:\Users\seran\certificado.cer  -keystore AlmacenClienteSSL -deststoretype pkcs12

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

        System.setProperty("javax.net.ssl.trustStore", "C:/Users/seran/AlmacenClienteSSL");
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

            //Para poder mandar mensajes(Esto puede ir en un hilo a parte)
            while (cad != null) {
                cad = teclado.nextLine();
                salida.println(cad);
            }

        } catch (IOException ex) {

        }
    }
}
