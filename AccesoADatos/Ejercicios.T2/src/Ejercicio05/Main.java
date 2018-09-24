package ejercicio05;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica la ruta del archivo a copiar");
        String ruta1 = sc.next();
        System.out.println("Indica el nombre del archivo a copiar");
        String nombre1 = sc.next();
        File original = new File(ruta1 + "/" + nombre1);

        System.out.println("Indica la ruta del archivo nuevo");
        String ruta2 = sc.next();
        System.out.println("Indica el nombre del archivo nuevo");
        String nombre2 = sc.next();
        File copia = new File(ruta2 + "/" + nombre2);
        try {
            copia.createNewFile();
        } catch (IOException e1) {
            System.out.println("Ese archivo ya existe");
        }
        try {
            FileReader fr = new FileReader(original);
            BufferedReader br = new BufferedReader(fr);
            PrintWriter pw = new PrintWriter(copia);
            
            String linea;
            while((linea = br.readLine()) != null) {
                pw.println(linea);
            }
            br.close();
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo original no existe");
        }
        sc.close();
    }
}