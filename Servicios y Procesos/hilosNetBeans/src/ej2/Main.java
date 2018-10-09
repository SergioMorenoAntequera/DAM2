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
        int numero = 0, factor = 0;        
        ArrayList<Integer> factores = new ArrayList<Integer>();
        String mensaje = "numero = 1";
        
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
        
        for(factor = 2; factor<=numero; factor++){
            while(factor % numero == 0){
                factores.add(factor);
                numero/= factor;
                mensaje += (" X " +factor);
            }
        }
        System.out.println(mensaje);

        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de Programa, tiempo de Ejecucion total:" + te);
    }
}
