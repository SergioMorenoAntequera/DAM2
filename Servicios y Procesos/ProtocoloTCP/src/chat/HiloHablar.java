/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author windiurno
 */
public class HiloHablar {
    ArrayList<PrintWriter> salida;
    Scanner teclado = null;
    
    public HiloHablar(ArrayList<PrintWriter> pw){
        this.salida = pw;
        teclado = new Scanner(System.in);
    }
    
    public void run(){
        String cad = "";
        while(cad != null){
            cad = teclado.nextLine();
            teclado.nextLine();
            for(PrintWriter out:salida){
                out.println("[Servidor]>" + cad);
            }
        }
    }
}
