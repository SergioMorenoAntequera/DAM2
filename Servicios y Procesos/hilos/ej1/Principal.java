package ej1;
import static java.lang.Thread.sleep;

public class Principal{
    public static void main(String [] args){
        CuentaAtras ca= new CuentaAtras("hilo1");
        long ti=System.currentTimeMillis();
        System.out.println("## Hilos Ejemplo1 ##");
        System.out.println(">CASO 1 Heredando de Thread\n");
        ca.start(); //lanzo un hilo el programa sigue en ejecucion
        //--------
        for(int i=0; i<10; i++){
            System.out.println("Saludo : " +i);
            dormir(500);
        }
        
       // while(ca.isAlive()){

        //}
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
