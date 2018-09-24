package Ejercicio06;
import java.io.File;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica la ruta del archivo a copiar");
        String ruta1 = sc.next();
        System.out.println("Indica el nombre del archivo a copiar");
        String nombre1 = sc.next();
        File original = new File(ruta1 + "/" + nombre1);
        
    }
    
}
