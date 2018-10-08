package ej1;
public class CuentaAtras extends Thread{
    
    public CuentaAtras(String s){
        super(s);
    }
    
    @Override
    public void run(){
        long ti=System.currentTimeMillis();
        System.out.println("<<<<< INICIANDO HILO :" +this.getName());
        int cont=0;
        while(cont<15){
           dormir(1000); 
           System.out.println("\t\tCuenta Atras> "+(15-cont));
           cont++;
        }
        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de Programa, tiempo de Ejecucion:" + te);
    }
    public void dormir(long t){
        try {
            sleep(t);
         } catch (InterruptedException ex){
            System.err.println("Error, mensaje : "+ ex.getMessage());
         }
    }
}
//-----------------------------------------------------------------------
