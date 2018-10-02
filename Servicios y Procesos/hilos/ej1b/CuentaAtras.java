package ej1b;
import static java.lang.Thread.sleep;
public class CuentaAtras implements Runnable{
    String nom;
    public CuentaAtras(String s){
        nom=s;
    }
    
    @Override
    public void run(){
        System.out.println("<<<<< INICIANDO HILO :" +nom);
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

//-------------------------------------------------------------------
public String getNom(){
    return nom;
}
//--------------------------------------------------------------------
}
//-----------------------------------------------------------------------
