package ej1a;
import static java.lang.Thread.sleep;

public class Principal{
    public static void main(String [] args){
        CuentaAtras ca= new CuentaAtras("hilo1");
        long ti=System.currentTimeMillis();
        System.out.println("## Hilos Ejemplo1 ##");
        System.out.println(">CASO 2 Implementando Runnable\n");
        Thread hilo1= new Thread(ca);
        hilo1.start();
        //--------
        for(int i=0; i<10; i++){
            System.out.println("Saludo : " +i);
            dormir(500);
        }
        
        while(hilo1.isAlive()){

        }
        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de Programa, tiempo de Ejecucion:" + te);
    }
    //------------------------------------------------------------------------
    public static void dormir(long t){
        try {
            sleep(t);
         } catch (InterruptedException ex){
            System.err.println("Error, mensaje : "+ ex.getMessage());
         }
    }
    //-----------------------------------------------------------------------
}