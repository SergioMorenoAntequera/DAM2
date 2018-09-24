package Ejercicio07;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        
        System.out.println("Introduce la ruta del archivo donde trabajar");
        String ruta = sc.next();
        File archivo = new File(ruta);
        
        FileWriter fl = null;
        PrintWriter pw = null;
        try {
            fl = new FileWriter(archivo);
            pw = new PrintWriter(fl);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un número entre entre 0 y 100 (" + i + "/10)");
            int num = sc.nextInt();
            if(num < 0 || num > 100){
                System.out.println("Numero no valido");
                i--;
            } else {
                pw.print(num + " ");
            }
        }
        pw.println("");
    }
    
}
