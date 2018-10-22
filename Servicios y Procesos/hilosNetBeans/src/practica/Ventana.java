package practica;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    Panel p1, p2;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        Container lienzo = getContentPane();
        lienzo.setLayout(new BoxLayout(lienzo, BoxLayout.Y_AXIS));
        
        p1= new Panel();
        p2 = new Panel();
        
        lienzo.add(p1);
        lienzo.add(p2);
    }
}
