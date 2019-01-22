/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author seran
 */
public class Servidor {
    
    public static Cliente cliente = new Cliente();
    public static String cadServidor = "";
    public static Scanner sc;
    
    public static void main(String [] args) {
        final int PTO=15000;
        sc = new Scanner(System.in);
        
        mensaje();
        try (
                ServerSocket tuberia = new ServerSocket(PTO);
                Socket cliente = tuberia.accept();
                BufferedReader IN = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter OUT = new PrintWriter(cliente.getOutputStream(), true);
        ) {
            
            //Mandamos un mensaje tanto al servidor como al cliente
            System.out.println("Ha entrado un cliente!");
            OUT.println("Conectado con el servidor en el puerto " + PTO);
            
            //Creamos un hilos que se encargue de leer todos los mensaje que mande el cliente
            HiloServerLeer hsl = new HiloServerLeer(IN);
            hsl.start();
            
            //De mientras en la misma clase servidor mandamos mensajes
            System.out.println("Introduces mensajes para madnar al cliente:");
            do{
                cadServidor = sc.nextLine();
                OUT.println("Servidor: " + cadServidor);
            } while(!cadServidor.equalsIgnoreCase("exit"));
                
            

        }catch(IOException ex){}
 }
    public static void mensaje(){
        System.out.println("--------------------------------------------");
        System.out.println("#  < Servidor unicliente Bidireccional >   #");
        System.out.println("#            ( Puerto 15000 )              #");
        System.out.println("------------------------------- ------------");
        
    }
}
