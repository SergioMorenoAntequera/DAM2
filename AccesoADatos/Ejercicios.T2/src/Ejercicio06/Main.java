package Ejercicio06;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje con el que trabajar");
        String mensaje = sc.next();
        System.out.println(mostrarAlReves(mensaje));
        
        System.out.println("Indica la ruta del archivo donde escribir");
        String ruta = sc.next();
        File archivo =  new File(ruta);
        escribir(archivo, mensaje);
    }
    
    public static String mostrarAlReves(String mensaje){
        String resultado = "";
        char[] caracteres = mensaje.toCharArray();
        for(int i = 0; i < caracteres.length; i++){
            if(Character.isUpperCase(caracteres[i])){
                caracteres[i] = Character.toLowerCase(caracteres[i]);
            } else {
                if(Character.isLowerCase(caracteres[i])){
                    caracteres[i] = Character.toUpperCase(caracteres[i]);
                }
            }
        }
        resultado = String.valueOf(caracteres);
        return resultado;
    }
    
    public static void escribir(File archivo, String mensaje){
        if(archivo.isDirectory()){
            System.out.println("Se necesita elegir un archivo .txt, no un repositorio");
        } else {
            try {
                PrintWriter pw = new PrintWriter(archivo);
                pw.println(mensaje);
                
            } catch (IOException ex) {
                System.out.println("Archivo no válido");
            }
        }
    }
}
