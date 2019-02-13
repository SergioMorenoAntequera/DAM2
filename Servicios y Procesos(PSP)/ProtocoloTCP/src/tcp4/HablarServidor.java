package tcp4;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HablarServidor implements Runnable{
    ArrayList<Cliente> cli;
    public HablarServidor(ArrayList<Cliente> cli){
        this.cli=cli;

    }
    @Override
    public void run(){
        String cad="";
        Scanner teclado = new Scanner(System.in);
        while(cad!=null){
            cad=teclado.nextLine();
            if(cli.size()==0){
                System.out.println("No hay Clientes Conectados!!!!!!");
            }
            else{
                for(Cliente miCli : cli){
                    miCli.getSal().println("[# Servidor #]>"+cad);
                }
            }
        }
    }
    //--------------------------------------------------------------------------------------------------------
}
