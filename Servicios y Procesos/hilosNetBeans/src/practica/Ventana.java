package practica;
import java.awt.Container;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    Panel p;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        Container lienzo = getContentPane();
        p = new Panel();
        
        lienzo.add(p);
    }
}
