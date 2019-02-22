package servidor;

import cliente.PlantillaCliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Windiurno
 */
public class EscribirServidor extends Thread {

    Scanner teclado;
    String mensajeAEnviar;
    ArrayList<PlantillaCliente> misClientes;

    //--------------------------------------------------------------------------
    
    public EscribirServidor(ArrayList<PlantillaCliente> mc) {
        misClientes = mc;
        teclado = new Scanner(System.in);
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {  
        do {
            
            //Leer texto y enviar
            mensajeAEnviar = teclado.nextLine();
            
            if(misClientes.size() == 0){
                System.out.println("No hay ningún cliente todavía!");
                continue;
            }
            
            for(PlantillaCliente c : misClientes){
                c.getFlujoSalida().println("[Servidor]> " + mensajeAEnviar);
            }
            
            //Si el servidor manda el mensaje de cierre, la ejecucion finaliza
            if (mensajeAEnviar.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
        } while (true);
    }
}

