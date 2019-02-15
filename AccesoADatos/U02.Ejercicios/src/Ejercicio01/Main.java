package Ejercicio01;
import java.io.File;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el directorio para nombrar los archivos");
        String ruta = sc.next();
        File directorio = new File(ruta);
        
        if(!directorio.exists()){
            System.out.println("Directorio no válido");
        } else {
            if(!directorio.isDirectory()){
                System.out.println("Se tiene que introducir un directorio");
            } else {
                File[] ficheros = directorio.listFiles();
                for(int i = 0; i<ficheros.length; i++){
                    System.out.println("Fichero numero " + (i+1) + ": " + ficheros[i].getName());
                }
            }
        }
        
    }
}
