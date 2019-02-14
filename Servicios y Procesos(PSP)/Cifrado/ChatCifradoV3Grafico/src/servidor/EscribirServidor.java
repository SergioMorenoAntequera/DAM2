package servidor;


import cifrado.Cifrar;
import cliente.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Windiurno
 */
public class EscribirServidor extends Thread {

    Scanner teclado;
    String mensajeAEnviar;
    Cifrar cifrar;
    ArrayList<Cliente> misClientes;

    //--------------------------------------------------------------------------
    
    public EscribirServidor(ArrayList<Cliente> mc) {
        misClientes = mc;
        teclado = new Scanner(System.in);
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {  
        do {
            //Leer texto y enviar
            mensajeAEnviar = teclado.nextLine();
            
            cifrar = new Cifrar(mensajeAEnviar);
            String mensajeAEnviarCifrado = cifrar.getFraseCifrada();
            
            for(Cliente c : misClientes){
                c.getFlujoSalida().println("[Servidor]> " + mensajeAEnviarCifrado);
                c.getFlujoSalida().println("[Servidor]> " + mensajeAEnviar);
            }
            
            //Si el servidor manda el mensaje de cierre, la ejecucion finaliza
            if (mensajeAEnviar.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
        } while (true);
    }
}

