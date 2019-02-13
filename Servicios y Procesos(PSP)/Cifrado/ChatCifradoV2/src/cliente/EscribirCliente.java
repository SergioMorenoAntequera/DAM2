/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cifrado.Cifrar;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author windiurno
 */
public class EscribirCliente extends Thread {
    
    Cifrar cifrar;
    Scanner teclado;
    String mensajeAEnviar;
    PrintWriter flujoSalida;

   
    public EscribirCliente(PrintWriter salida){
        teclado = new Scanner(System.in);
        flujoSalida = salida;
        mensajeAEnviar = " ";
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {
        super.run();
        
        while(true){
            mensajeAEnviar = teclado.nextLine();
            
            cifrar = new Cifrar(mensajeAEnviar);
            String mensajeAEnviarCifrado = cifrar.getFraseCifrada();
            
            flujoSalida.println(mensajeAEnviarCifrado);
        }
    }
}
