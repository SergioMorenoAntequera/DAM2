/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasarDate;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 *
 * @author windiurno
 */
public class Servidor {
    public static void main(String[] args){
        final int PORT = 9000;
        DatagramSocket conexion = null;
        
        try {
            conexion = new DatagramSocket(PORT);
            System.out.println("--------------");
            System.out.println("PUERTO ABIERTO");
            System.out.println("--------------");
            conexion.setSoTimeout(180000);
            
            while(true){
                DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024); //Paquete vacio
                conexion.receive(recibido);
                //Si pasa de aqui significa que le ha llegado algo
                
                System.out.println("Pequete recibido(yay) // Mostrando información del que lo manda");
                System.out.println("Direccion IP: " + recibido.getAddress());
                System.out.println("Puerto: " + recibido.getPort());
                
                System.out.println("Preparando respuesta...");
                //Contenido de la respuesta
                String respuesta = "Hora del servidor: " + new Date(); //Este constructor de Date te devuelve una fecha y tal
                byte[] respuestaBytes = respuesta.getBytes();
                //Como este lo vamos a mandar hay que meterle la ip y el puerto al que va
                //Que en este caso son de los que vienen
                DatagramPacket enviado = new DatagramPacket(respuestaBytes, respuestaBytes.length, recibido.getAddress(), recibido.getPort());
                //Y lo mandamos
                conexion.send(enviado);
                System.out.println("Fecha enviada correctamente");
            }
        } catch (Exception e) {
            System.out.println("La liaste John Lancaster: " + e.toString());
        }
    }
}
