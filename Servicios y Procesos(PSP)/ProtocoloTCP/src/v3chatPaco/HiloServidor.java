/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3chatPaco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor implements Runnable {
    private Socket concli;
    private int num;
    ArrayList<PrintWriter> salidas;
    PrintWriter out;
    
    public HiloServidor(Socket con, int num, ArrayList<PrintWriter> ls){
        concli=con;
        this.num=num;
        salidas=ls;
    }

    @Override
    public void run() {
        String cad = "";
        String cliente = "[Cliente_" + num + "]>";
        while (true) {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(concli.getInputStream()));
                    PrintWriter out = new PrintWriter(concli.getOutputStream(), true)) {
               
                //Lanzamos el hilo hablar para que el servidor hable con los clientes
                salidas.add(out);
                //Esto es para que al servidor le lleguen los mensajes de los clientes
                while (cad != null || !cad.equalsIgnoreCase("exit")) {
                    cad = in.readLine().trim();
                    if (cad.equalsIgnoreCase("exit")) {
                        salidas.remove(out);
                        System.out.println("Cliente: " + num + " desconectado");
                        break;
                    }
                    System.out.println(cliente + "" + cad);
                }
                break;
            } catch (Exception ex) {
                salidas.remove(out);
                System.out.println("Error en HiloServidor: " + ex.getMessage());
            }
        }
    }
   //----------------------------------------------------------------------------  
}
