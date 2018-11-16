/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RespuestaDependiente;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author windiurno
 */
public class Cliente1 {
    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("No se han especificado la IP, el puerto correctamente y/o comentario");
            System.exit(0);
        }
        
        //Tenemos que pasar los parametros a algo que podamos usar
        //El primero a una IP(InetAddress) y el segundo a un puerto(int)
        InetAddress destino = null;
        try {
            destino = InetAddress.getByName(args[0]);
        } catch (Exception e) {
            System.err.println("Imposible Verificar IP, formato incorrecto!");
            System.exit(0);
        }
        int pto = 0;
        try {
            pto = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.err.println("Imposible Verificar el puerto, formato incorrecto!");
            System.exit(0);
        }
        String parametro = null;
        try {
            parametro = args[2];
        } catch (Exception e) {
            System.err.println("Imposible la cadena!");
            System.exit(0);
        }
        
        //Ahora ya  tenemos datos que usar en destino y pto
        //Toca preparar las cosas para poder enviar la peticion y recibir los datos
        DatagramSocket conexion = null;
        DatagramPacket enviado;
        byte [] msj_enviado = parametro.getBytes();
        
        //Preparamos la conecxion y mandamos el paquete con el String
        try {
            conexion = new DatagramSocket();
            enviado = new DatagramPacket(msj_enviado, msj_enviado.length, destino, pto);
            conexion.send(enviado);
            System.out.println("Petición/paquete enviada/o....");

            //Preparamos la respuesta
            DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024);
            conexion.receive(recibido);
            System.out.println("Recibido! IP: " + recibido.getAddress() + " // Puerto: " + recibido.getPort() + "\nLa respuesta es: ");
            String res = new String(recibido.getData());
            System.out.println("\t\"" + res + "\"");
        } catch (Exception e) {
        }
    }
}
