package dom.datosaxml.ejercicioClaseBinario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class CreacionFOS {
    
    public static void main(String[] args) {
        
        File directorio = new File("C:/Users/windiurno/Desktop/e1.dat");
        
        FileOutputStream fos = null;
        try{
            
            fos = new FileOutputStream(directorio);
            
            Byte[] bytes = {5, 10, 45, 25, 39};
            
            fos.write(bytes[0]);
            fos.write(bytes[1]);
            fos.write(bytes[2]);
            fos.write(bytes[3]);
            fos.write(bytes[4]);
            
        }catch(IOException io){
            System.out.println("Dentro del IOException");
            System.out.println("HA SURGIDO UN ERROR");
        
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("ERROR AL CERRAR");
            }
        }

    
    }
}
