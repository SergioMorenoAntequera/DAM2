/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3chatPaco;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HiloHablar implements Runnable {
    ArrayList<PrintWriter> salidas;
    Scanner teclado;
    
    public HiloHablar(ArrayList<PrintWriter> salidas){
			this.salidas=salidas;
        teclado = new Scanner(System.in);
    }

    @Override
    public void run() {
        String cad = "";
        while (true) {
            cad = teclado.nextLine();
            if (cad.trim().equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            if (salidas.size() == 0) { //Si el array list esta vacio no mando nada
                System.out.println("No hay NINGUN Cliente!!!");
            } else {
                for (PrintWriter out : salidas) {
                    out.println("[Servidor]> " + cad);
                }
            }
        }

    }
}
