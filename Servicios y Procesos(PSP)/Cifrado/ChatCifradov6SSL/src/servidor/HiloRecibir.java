package servidor;

import java.io.BufferedReader;
import java.io.IOException;

public class HiloRecibir implements Runnable{
    BufferedReader entrada;
    public HiloRecibir(BufferedReader ent){
        entrada=ent;
    }
    @Override
    public void run(){
        String cad="";
        do{
            try{
                cad=entrada.readLine();
                System.out.println("[CLIENTE]>" + cad);
            }catch(IOException ex){
                System.err.println("HiloRecibir Error: " + ex.getMessage());
                System.exit(0);
            }
        }while(cad!=null);
        
    }
}