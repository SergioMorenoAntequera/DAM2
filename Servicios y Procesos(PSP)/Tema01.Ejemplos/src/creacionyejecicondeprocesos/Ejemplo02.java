package creacionyejecicondeprocesos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


//Lo que haria esto en LINUX es qe te dictaria los documentos del la direccion 
//Pero en W10 habría que abrir a parte la CMD y pasarle la orden de listar(dir)
public class Ejemplo02 {
    public static void main(String[] args0){
        ProcessBuilder pb = new ProcessBuilder("cmd"); //Entre parentesis el programa
        //ProcessBuilder pb = new ProcessBuilder("ls", /home/windiurno/Escritorio);
        //A lo de arriba se le pueden meter parámetros para que te lo cree y el lugar con ruta absoluta
        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
            //Logger.getLogger(FormaAntigua.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
