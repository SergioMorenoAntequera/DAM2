package reloj;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    MainPanel panel = new MainPanel();
    
    public Ventana(){
        iniciarComponentes();
        setVisible(true);
    }
    
    private void iniciarComponentes(){
        setTitle("Practica cronometros");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(panel);
        //pack();
    }
}
