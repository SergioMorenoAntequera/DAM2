/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RespuestaDependiente;
import PasarDate.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 *
 * @author windiurno
 */
public class Servidor1 {
    public static void main(String[] args){
        final int PORT = 12000;
        DatagramSocket conexion = null;
        
        try {
            conexion = new DatagramSocket(PORT);
            System.out.println("----------------------------");
            System.out.println("PUERTO " + PORT + " ABIERTO");
            System.out.println("----------------------------");
            conexion.setSoTimeout(300000);
            
            while(true){
                DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024); //Paquete vacio
                conexion.receive(recibido);
                //Si pasa de aqui significa que le ha llegado algo
                
                System.out.println("Pequete recibido // Mostrando información del que lo manda");
                System.out.println("Direccion IP: " + recibido.getAddress());
                System.out.println("Puerto: " + recibido.getPort());
                
                System.out.println("\nPreparando respuesta...");
                
                //Contenido de la respuesta en bytes
                String datosTxt = new String(recibido.getData());
                String respuesta = null;
                if (datosTxt.equalsIgnoreCase("Hora")) {
                    respuesta = "Hora del servidor: " + new Date(); //Este constructor de Date te devuelve una fecha y tal
                } else {
                    if(datosTxt.equalsIgnoreCase("Saludo")){
                        respuesta = "Buenos Dias Cliente";
                    } else {
                        respuesta = "Comando NO implementado";
                    }
                }
                System.out.println("Datos que llegan: " + datosTxt);
                System.out.println("Respuesta: " + respuesta);
                byte[] respuestaBytes = respuesta.getBytes();
                //Como este lo vamos a mandar hay que meterle la ip y el puerto al que va
                //Que en este caso son de los que vienen
                DatagramPacket enviado = new DatagramPacket(respuestaBytes, respuestaBytes.length, recibido.getAddress(), recibido.getPort());
                //Y lo mandamos
                conexion.send(enviado);
                System.out.println("Respuesta enviada correctamente");
            }
        } catch (Exception e) {
            System.out.println("La liaste John Lancaster: " + e.toString());
        }
    }
}
