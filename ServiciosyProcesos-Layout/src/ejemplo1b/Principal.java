
package ejemplo1b;

import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;


public class Principal {
    
    public static void mostrar(){
        Ventana miVentana = new Ventana();
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setTitle("Ejemplo varios paneles");
        miVentana.setVisible(true);
        miVentana.setResizable(false);
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
