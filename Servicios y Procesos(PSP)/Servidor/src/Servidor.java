
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Angel Salas Calvo
 */
public class Servidor {
    public static void main(String[] args) {
        int PTO=15000;
        String cad=" ";
        EscribirServidor hiloEscritura;
        System.out.println("## Servidor Activo y Aceptando Una Conexion ##");
        
        try (
                    ServerSocket tuberia = new ServerSocket(PTO); //Necesario unicamente el el servidor
                    Socket conex = tuberia.accept();
                    BufferedReader IN = new BufferedReader(new InputStreamReader(conex.getInputStream()));
                    PrintWriter OUT = new PrintWriter(conex.getOutputStream(), true);
                )
        {
            //Crear y ejecutar hilo que permitira escribir mensajes desde el servidor
            hiloEscritura = new EscribirServidor(OUT);
            hiloEscritura.start();

            //Servidor que se mantendra a la escucha
            do{
                //Almacenar y mostrar el mensaje recibido
                cad=IN.readLine();
                System.out.println("Cliente: " + cad.trim());
                
                //Si se recibe mensaje de cierre de conexión
                if(cad.equalsIgnoreCase("exit")){
                    OUT.println("exit"); //Devolver el mensaje para que el cliente cierre su conexion
                    System.out.println("El usuario cerro la conexion!!!");
                    System.exit(0); //Finalizar ejecución
                }
            }while(true);
            
        }catch(Exception ex){
        }
    }
}