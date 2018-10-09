package TareaClase01;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
    
    public static void main(String[] args){
        Ventana v = new Ventana();
    }
    
    public Ventana(){
        super();
        inicializiarVentana();
        iniciarComponentes();
    }
    
    public void inicializiarVentana(){
        setTitle("BoxLayoutHorizontal");
        setBounds(50, 50, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void iniciarComponentes(){
        Panel p = new Panel();
        //p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
    }
}

class Panel extends JPanel{
    
    private JButton b1, b2, b3, b4;
    
    public Panel(){
        iniciarPanel();
        iniciarComponentes();
    }
    
    public void iniciarPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    
    public void iniciarComponentes(){
        
        b1 = new JButton("B1");
        b1.add(this);
        b2 = new JButton("B2");
        b2.add(this);
        b3 = new JButton("B3");
        b3.add(this);
        b4 = new JButton("B4");
        b4.add(this);
        
    }
}

