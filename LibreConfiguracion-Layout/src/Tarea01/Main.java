package Tarea01;

import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;

public class Main {
   
    public static void mostrar(){
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("DALE AL BOTON");
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    
    public static void main(String[] args){
        invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }

}
