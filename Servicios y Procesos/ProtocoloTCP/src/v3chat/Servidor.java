/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3chat;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author windiurno
 */
public class Servidor {
    
    public static void main(String[] args){
        
        final int PORT = 15000;
        int nCli = 1;
        ArrayList<PrintWriter> salidas =  new ArrayList<PrintWriter>();
        
        try(
                ServerSocket server = new ServerSocket(PORT)
        ) {
            mensaje();
            HiloHablar hh = new HiloHablar(salidas);
            hh.start();
            
            while(true){
                //XCAda vez que llega un cliente que se sabe con el 
                HiloServidor hServer = new HiloServidor(server.accept(), nCli, salidas);
                System.out.println("Ha entradoo el cliente num " + nCli++);
                hServer.start();
            }       
        } catch (Exception e) {
             
        }
    }
    
    private static void mensaje(){
        System.out.println("======================");
        System.out.println("Servidor Multicliente");
        System.out.println("=====Puerto 15000=====");
        System.out.println("======================");
    }
}
