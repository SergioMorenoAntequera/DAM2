/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3chat;

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
    ArrayList<PrintWriter> salidas;
    PrintWriter Out;
    
    public HiloServidor(Socket conec, int nCli, ArrayList<PrintWriter> llegadas){
        this.conec = conec;
        this.nCli = nCli;
        salidas =  llegadas;
        
    }
    
    @Override
    public void run() {
        String cad = "";
        String cliente = "[Cliente_" + nCli + "]> ";
        while (true) {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(conec.getInputStream()));
                    PrintWriter out = new PrintWriter(conec.getOutputStream());
            ) {
                Out=out;
                salidas.add(Out);
                while (cad != null || !cad.equalsIgnoreCase("exit")) {
                    cad = in.readLine().trim();
                    if (cad.equalsIgnoreCase("exit")) {
                        salidas.remove(Out);
                        System.out.println("Cliente " + nCli + " desconectado");
                        break;
                    }
                    System.out.println(cliente + " " + cad);
                }
                break;
            } catch (Exception e) {
                salidas.remove(Out);
                
            }
        }
    }
}
