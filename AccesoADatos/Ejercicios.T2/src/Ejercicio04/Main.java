package Ejercicio04;
import java.io.File;
import java.util.Scanner;
import java.util.Date;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //ArrayList<File> directorios = new ArrayList<File>();
        
        System.out.println("Introduce el directorio para mostrar");
        String ruta = sc.next();
        File d1 = new File(ruta);
        
        System.out.println("Introduce la primera fecha DD/MM/AAAA");
        String f1 = sc.next();
        System.out.println("Introduce la segunda fecha DD/MM/AAAA");
        String f2 = sc.next();
        int f1D = Integer.parseInt(f1.substring(0, 2));
        int f1M = Integer.parseInt(f1.substring(3, 5))-1;
        int f1A = Integer.parseInt(f1.substring(6, 10));
        int f2D = Integer.parseInt(f2.substring(0, 2));
        int f2M = Integer.parseInt(f2.substring(3, 5))-1;
        int f2A = Integer.parseInt(f2.substring(6, 10));
        
        Date fecha1 = new Date(f1A, f1M, f1D);
        Date fecha2 = new Date(f2A, f2M, f2D);
        
        fecha1.compareTo(fecha2);
    }
}
