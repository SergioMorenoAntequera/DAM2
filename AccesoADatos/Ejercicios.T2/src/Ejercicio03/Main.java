package Ejercicio03;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//C:\Users\windiurno\Desktop\carpeta1

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        ArrayList<File> directorios = new ArrayList<File>();
        
        System.out.println("Introduce el directorio para borrar los archivos");
        String ruta = sc.next();
        directorios.add(new File(ruta));
        
        for(int i = 0; i<directorios.size(); i++){
            if(!directorios.get(i).exists()){
            System.out.println("Directorio no válido");
            } else {
                if(!directorios.get(i).isDirectory()){
                    System.out.println("Se tiene que introducir un directorio");
                } else {
                    while(directorios.get(i).delete()){
                        directorios.get(i).delete();
                    }
                    directorios.remove(directorios.size()-1);
                }
            }
        }
        
                
                
                /*File[] ficheros = directorio.listFiles();
                for(int i = 0; i < ficheros.length; i++){
                    if(!ficheros[i].isDirectory()){
                        ficheros[i].delete();
                    } else {
                        while(!ficheros[i].delete()){
                            
                        }
                        
                        /*System.out.println("Fichero numero " + (i+1) + "(" + ficheros[i].getName() + ")" + " es un directorio, mostrando interior");
                        
                        File directorio2 = new File(ruta + "/" + ficheros[i].getName());
                        File[] ficheros2 = directorio2.listFiles();
                        for(int j = 0; j < ficheros2.length; j++){
                            System.out.println("    Fichero numero " + (j+1) + ": " + ficheros2[j].getName());
                        }
                        
                    }
                }*/
            
        
        
    }
}
