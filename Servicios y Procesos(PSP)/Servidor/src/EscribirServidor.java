
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Angel Salas Calvo
 *  Hilo que permitira al servidor mandar mensajes
 */
public class EscribirServidor extends Thread{
    private PrintWriter out;
    Scanner teclado;
    String texto;
    boolean cerrarConexion=false;
    
    /**
     * CONSTRUCTOR PARAMETRIZADO
     * @param out 
     */
    public EscribirServidor(PrintWriter out){
        this.out=out;
        teclado = new Scanner(System.in);
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * SOBRESCRITURA DEL METODO RUN
     */
    @Override
    public void run(){
        out.println("Conexion establecida correctamente!");
        do{
            //Leer texto y enviar
            texto = teclado.nextLine();
            out.println(texto);
            
            //Si el servidor manda el mensaje de cierre, la ejecucion finaliza
            if(texto.equalsIgnoreCase("exit")){
                System.exit(0);
            }
        }while(true);
    }
}

