package ej1;
public class CuentaAtras extends Thread{
    
    public CuentaAtras(String s){
        super(s);
    }
    
    @Override
    public void run(){
        System.out.println("<<<<< INICIANDO HILO :" +this.getName());
        int cont=0;
        while(cont<20){
           dormir(1000); 
           System.out.println("\t\tCuenta Atras> "+(20-cont));
           cont++;
    
        }
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
