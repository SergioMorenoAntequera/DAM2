package reloj;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        
        ventana.setTitle("Practica cronometros");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
