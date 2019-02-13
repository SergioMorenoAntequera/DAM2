package servidor;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author windiurno
 */
public class Servidor {
    public static void main(String[] args) {
        
        int PTO = 15000;
        String mensajeDelCliente = "";
        EscribirServidor hServidorMandarMensajes;
        
        //----------------------------------------------------------------------
        
        System.out.println("## Servidor Activo y Aceptando Una Conexion ##");
        try (
                ServerSocket tuberia = new ServerSocket(PTO); //Necesario unicamente el el servidor
                Socket conex = tuberia.accept();
                BufferedReader flujoEntradaDesdeCliente = new BufferedReader(new InputStreamReader(conex.getInputStream()));
                PrintWriter flujoSalidaHaciaCliente = new PrintWriter(conex.getOutputStream(), true);
        ){
            
            //------------------------------------------------------------------
            
            hServidorMandarMensajes = new EscribirServidor(flujoSalidaHaciaCliente);
            hServidorMandarMensajes.start();

            //------------------------------------------------------------------
            
            //El servidor recibe a el cliente
            do {
                //Almacenar y mostrar el mensaje recibido
                mensajeDelCliente = flujoEntradaDesdeCliente.readLine();
                System.out.println("Cliente: " + mensajeDelCliente.trim());

                //Si se recibe mensaje de cierre de conexión
                if (mensajeDelCliente.equalsIgnoreCase("exit")) {
                    System.out.println("El usuario cerro la conexion!!!");
                    System.exit(0);
                }
            } while (true);

        } catch (Exception ex) {
        }
    }
}