package ej1b;
import static java.lang.Thread.sleep;
public class CuentaAtras2 implements Runnable{
    String nom;
    public CuentaAtras2(String s){
        nom=s;
    }
    
    @Override
    public void run(){
        System.out.println("<<<<< INICIANDO HILO :" +nom);
        int cont=0;
        while(cont<25){
           dormir(1000); 
           System.out.println("\t\t\t\tCuenta Atras> "+(25-cont));
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

//-------------------------------------------------------------------
public String getNom(){
    return nom;
}
//--------------------------------------------------------------------
}
//-----------------------------------------------------------------------
