/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3chat;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author windiurno
 */
public class HiloHablar extends Thread{
    ArrayList<PrintWriter> salida;
    Scanner teclado = null;
    
    public HiloHablar(ArrayList<PrintWriter> pw){
        this.salida = pw;
        teclado = new Scanner(System.in);
    }
    
    @Override
    public void run(){
        String cad = "";
        while(true){
            cad=teclado.nextLine();
            if(cad.equalsIgnoreCase("exit")){
                
            } else {
                for(PrintWriter out : salida){
                    out.println(cad);
                }
            }
        }
        /*while(cad != null){
            cad = teclado.nextLine();
            teclado.nextLine();
            for(PrintWriter out: salida){
                out.println("[Servidor]>" + cad);
            }
        }*/
    }
}
