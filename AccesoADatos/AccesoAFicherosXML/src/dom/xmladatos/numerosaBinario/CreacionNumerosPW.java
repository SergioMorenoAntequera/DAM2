package dom.xmladatos.numerosaBinario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class CreacionNumerosPW {
    
    public static void main(String[] args) {
        
        //File directorio = new File("C:/Users/windiurno/Desktop/e1.dat");
        File directorio = new File("C:\\Users\\windiurno\\Desktop\\e1.dat");
        
        FileWriter fw = null;
        PrintWriter pw = null;
        try{
            
            fw = new FileWriter(directorio);
            pw = new PrintWriter(fw);
            
            pw.println(4);
            pw.println(45);
            pw.println(232);
            pw.println(86);
            pw.println(67);
            pw.println(87);
            pw.println(56);

        }catch(IOException io){
            System.out.println("Dentro del IOException");
            System.out.println("HA SURGIDO UN ERROR");
        
        } finally {
            try {
                if (null != fw)
                    fw.close();
           } catch (IOException e2) {
              System.out.println("Error en el finally");
           }
        }

    
    }
}
