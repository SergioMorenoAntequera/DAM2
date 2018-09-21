package Ejercicio02;
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
                for(int i = 0; i < ficheros.length; i++){
                    if(!ficheros[i].isDirectory()){
                        System.out.println("Fichero numero " + (i+1) + ": " + ficheros[i].getName());
                    } else {
                        System.out.println("Fichero numero " + (i+1) + "(" + ficheros[i].getName() + ")" + " es un directorio, mostrando interior");
                        
                        File directorio2 = new File(ruta + "/" + ficheros[i].getName());
                        File[] ficheros2 = directorio2.listFiles();
                        for(int j = 0; j < ficheros2.length; j++){
                            System.out.println("    Fichero numero " + (j+1) + ": " + ficheros2[j].getName());
                        }
                        
                    }
                }
            }
        }
        
    }
}
