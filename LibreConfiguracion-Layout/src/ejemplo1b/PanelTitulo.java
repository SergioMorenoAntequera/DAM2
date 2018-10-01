package ejemplo1b;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelTitulo extends JPanel{
    
    private JLabel jbTitulo;
    
    public PanelTitulo(){
        
        iniciarComponentes();
        
    }
    
    public void iniciarComponentes(){
        
        jbTitulo = new JLabel("*** Ejemlpo de titulo ***");
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        
        add(jbTitulo);
    }
    
}
