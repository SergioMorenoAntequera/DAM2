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
    ArrayList<PrintWriter> salidas;
    Scanner teclado = null;
    
    public HiloHablar(ArrayList<PrintWriter> pw) {
        this.salidas = pw;
        teclado = new Scanner(System.in);
    }

    @Override
    public void run() {
        String cad = "";
        while (true) {
            cad = teclado.nextLine();
            if (cad.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            if (salidas.size() == 0) {
                System.out.println("No hay ningún cliente");
            } else {
                for (PrintWriter out : salidas) {
                    out.println("[Servidor]> " + cad);
                }
            }
        }
    }
}
