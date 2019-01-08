/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v4chatPaco;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor implements Runnable {

    private Socket concli;
    private int num;
    ArrayList<PrintWriter> salidas;
    BufferedReader entrada;
    PrintWriter salida;
    

    public HiloServidor(Socket con, int num, ArrayList<PrintWriter> ls) {
        concli = con;
        this.num = num;
        salidas = ls;
    }

    @Override
    public void run() {
        String cad = "";
        String cliente = "[Cliente_" + num + "]>";
        while (true) {
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(concli.getInputStream()));
                    PrintWriter pw = new PrintWriter(concli.getOutputStream(), true)
            ) {
                entrada = br;
                salida = pw;
                //Lanzamos el hilo hablar para que el servidor hable con los clientes
                salidas.add(salida);
                //Esto es para que al servidor le lleguen los mensajes de los clientes
                while (cad != null || !cad.equalsIgnoreCase("exit")) {
                    cad = entrada.readLine().trim();
                    if (cad.equalsIgnoreCase("exit")) {
                        salidas.remove(salida);
                        System.out.println("Cliente: " + num + " desconectado");
                        break;
                    }
                    System.out.println(cliente + "" + cad);
                }
                break;
            } catch (Exception ex) {
                salidas.remove(salida);
                System.out.println("Error en HiloServidor: " + ex.getMessage());
            }
        }
    }
   //----------------------------------------------------------------------------  
}
