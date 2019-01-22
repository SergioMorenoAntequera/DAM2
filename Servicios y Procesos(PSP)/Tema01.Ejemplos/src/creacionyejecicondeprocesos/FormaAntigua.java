package creacionyejecicondeprocesos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FormaAntigua {
    
    public static void main(String[] args0){
       Runtime rt = Runtime.getRuntime();
        String programa = "notepad"; //Nombre de la aplicación
        Process p;
        try {
            p = rt.exec(programa);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            //Logger.getLogger(FormaAntigua.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
