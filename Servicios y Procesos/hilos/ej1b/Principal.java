package ej1b;
import static java.lang.Thread.sleep;

public class Principal{
    public static void main(String [] args){
		
        CuentaAtras ca1= new CuentaAtras("hilo1");
		CuentaAtras2 ca2= new CuentaAtras2("hilo2");
		
        long ti=System.currentTimeMillis();
		
        System.out.println("## Hilos Ejemplo1b ##");
        System.out.println(">CASO 2 Implementando Runnable\n");
        Thread hilo1= new Thread(ca1);
	Thread hilo2= new Thread(ca2);
        hilo1.start();
	hilo2.start();
        //--------
        for(int i=0; i<10; i++){
            System.out.println("Saludo : " +i);
            dormir(500);
        }
        
        while(hilo1.isAlive() || hilo2.isAlive()){

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
