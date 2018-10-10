package ej2;
import java.util.ArrayList;
import java.util.Scanner;

//Desde esta clase se llama a los hilos
//Además en esta haremos lo de los numeros primos
public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //CuentaAtras ca = new CuentaAtras("hilo1");
        long ti=System.currentTimeMillis();
        int numero = 0, numero2 = 0;       
        String mensaje = "Descompuesto = 1";
        
        System.out.println("Introduce un numero entre 100.000 y 1.000.000");
        try {
            numero = sc.nextInt();
            if(numero < 100000 || numero > 1000000){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Numero no valido");
            System.exit(0);
        }
        
        //PEDIMOS NUMERO Y LLAMAMOS A LA SEGUNDA PARTE
        System.out.println("Introduce un numero entre 1 y 10");
        try {
            numero2 = sc.nextInt();
            if(numero2 < 1 || numero2 > 10){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Numero no valido");
            System.exit(0);
        }
        Saludar saludos = new Saludar(numero2);
        //OPERACIONES DE LA SEGUNDA PARTE
        saludos.start();
        
        JavaDivertido jd = new JavaDivertido();
        jd.run();
        
        //OPERACIOENS DE LA PRIMERA PARTE
        for(int factor = 2; factor <= numero; factor++){
            while(numero % factor == 0){
                //factores.add(factor);
                System.out.println(numero + "%" + factor + " = " + "0");
                numero /= factor;
                mensaje += (" X " +factor);
            }
        }
        System.out.println(mensaje);

        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de Programa, tiempo de Ejecucion total: " + te + " seg");
    }
}
