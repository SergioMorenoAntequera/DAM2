package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class HiloRecibir extends Thread{
   
    BufferedReader flujoEntrada;
    String mensajeRecibido;
    JTextArea ta;

    public HiloRecibir(BufferedReader flujoEntrada) {
        this.flujoEntrada = flujoEntrada;
        this.mensajeRecibido = null;
        this.ta = ta;
    }

    @Override
    public void run() {
        super.run();
        
        while(true){
            try {
                //El error salta en la siguiente linea
                mensajeRecibido = flujoEntrada.readLine();
                
                System.out.println(mensajeRecibido);
                
            } catch (IOException ex) {
                System.err.println("Error en Leer Cliente: " + ex.getMessage());
                break;
            }
        }
        
    }
}