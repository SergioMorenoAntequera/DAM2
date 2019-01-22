import static java.lang.Thread.sleep;
public class Ejemplo1{
    public static void dormir(long t){
        try {
            sleep(t);
         } catch (InterruptedException ex){
            System.err.println("Error, mensaje : "+ ex.getMessage());
         }
    }
    //----------------------------------------------------------------------------------------------------
    public static void cuentaAtras(){
        int cont=0;
        while(cont<20){
           dormir(1000); 
           System.out.println("\t\tCuenta Atras> "+(20-cont));
           cont++;
    
        }
    }
    //------------------------------------------------------------------------------------------------
    public static void main(String [] args){
        long ti=System.currentTimeMillis();
        System.out.println("## Hilos Ejemplo1 ##");
       
        cuentaAtras();
        System.out.println("Continuando el programa después de 20s !!!");
        for(int i=0; i<10; i++){
            System.out.println("Saludo : " +i);
            dormir(500);
        }
        long te=(System.currentTimeMillis()-ti)/1000;
        System.out.println("Final de Programa, tiempo de Ejecucion:" + te);

    }
}
