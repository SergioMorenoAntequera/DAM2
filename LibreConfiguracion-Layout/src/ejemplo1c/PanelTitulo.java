package ejemplo1c;
import java.awt.FlowLayout;
import javax.swing.*;


public class PanelTitulo extends JPanel{
    
    private JLabel jbTitulo;
    
    public PanelTitulo(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        jbTitulo = new JLabel("****CALCULADORA****");
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        
        add(jbTitulo);
    }
}
