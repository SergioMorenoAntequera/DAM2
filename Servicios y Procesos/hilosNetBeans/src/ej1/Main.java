package ej1;
import static java.lang.Math.sqrt;
import java.util.Scanner;

//Desde esta clase se llama a los hilos
//Además en esta haremos lo de los numeros primos
public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CuentaAtras ca = new CuentaAtras("hilo1");
        long ti=System.currentTimeMillis();
        ca.start();
        int numero = 0, i = 0, j = 0, divisor = 0, raiz = 0;
        
        System.out.println("Introduce un numero mayor que 10");
        
        //Controlamos que el numero sea mayor que 10
        //Si no lo es se acaba el programa
        try {
            numero = sc.nextInt();
            if(numero < 10){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ha surgido un error");
            System.exit(0);
        }
        
        for (i = 1; i < numero; i++) {
            divisor = 0;
            raiz = (int)sqrt(i);
            for (j = 1; j <= raiz; j++) {
                if (i % j == 0) {
                    divisor++;
                }
            }
            if (divisor <= 1) {
                System.out.println(i + " es primo");
            }
        }
        while(ca.isAlive()){

        }
        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de Programa, tiempo de Ejecucion total:" + te);
    }
}
