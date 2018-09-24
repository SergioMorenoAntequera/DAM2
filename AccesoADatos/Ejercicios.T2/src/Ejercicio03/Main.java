package Ejercicio03;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//C:\Users\windiurno\Desktop\carpeta1

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        //ArrayList<File> directorios = new ArrayList<File>();
        
        System.out.println("Introduce el directorio para borrar los archivos");
        String ruta = sc.next();
        File d1 = new File(ruta);
        
        borrarInterior(d1);
    }
    
    public static void borrarInterior(File d1){
        ArrayList<File> directorios = new ArrayList<File>();
        directorios.add(d1);
        //Entra en el arrayList
        for(int i = 0; i < directorios.size(); i++){
            File[] d2 = directorios.get(i).listFiles();
            for(int j = 0; j < d2.length; j++){
                if(d2[j].isFile()){
                    d2[j].delete();
                } else {
                    directorios.add(d2[j]);
                }
            }
        }
        //Esta parte borra las carpetas
        int tam = directorios.size();
        for(int i = 0; i < tam; i++){
            directorios.get(directorios.size()-1).delete();
            tam--;
        }
        
    }
}
