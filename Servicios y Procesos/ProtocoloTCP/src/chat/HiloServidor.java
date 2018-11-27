/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author windiurno
 */
public class HiloServidor extends Thread {
    
    Socket conec = null;
    int nCli = 0;
    ArrayList<PrintWriter> salida;
    
    public HiloServidor(Socket conec, int nCli, ArrayList<PrintWriter> s){
        this.conec = conec;
        this.nCli = nCli;
        salida = s;
    }
    
    @Override
    public void run() {
        String cad = "";
        
        try (   
                BufferedReader sIN = new BufferedReader(new InputStreamReader(conec.getInputStream()));
                PrintWriter sOUT = new PrintWriter(conec.getOutputStream());
            ){
           
                sOUT.println("aa");
            while(true){
                cad = sIN.readLine();
                sOUT.println(cad);
            }
            
            
        } catch (Exception e){}
    }
    
    public void hiloEscribir(){
        
    }
}
