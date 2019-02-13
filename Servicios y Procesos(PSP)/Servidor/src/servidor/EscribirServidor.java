package servidor;


import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Windiurno
 */
public class EscribirServidor extends Thread {

    Scanner teclado;
    String mensajeAEnviar;
    private PrintWriter flujoSalida;

    //--------------------------------------------------------------------------
    
    public EscribirServidor(PrintWriter out) {
        this.flujoSalida = out;
        teclado = new Scanner(System.in);
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {
        flujoSalida.println("Conexion establecida correctamente!");
        
        do {
            //Leer texto y enviar
            mensajeAEnviar = teclado.nextLine();
            flujoSalida.println(mensajeAEnviar);
            
            //Si el servidor manda el mensaje de cierre, la ejecucion finaliza
            if (mensajeAEnviar.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
        } while (true);
    }
}

