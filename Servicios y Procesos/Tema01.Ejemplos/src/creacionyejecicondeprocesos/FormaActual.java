package creacionyejecicondeprocesos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FormaActual {
    
    public static void main(String[] args0){
        ProcessBuilder pb = new ProcessBuilder("notepad"); //Entre parentesis el programa
        //A lo de arriba se le pueden meter parámetros para que te lo cree y el lugar con ruta absoluta
        Process p; //Esto puede ir dentro del try
        try {
            p = pb.start();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            //Logger.getLogger(FormaAntigua.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
