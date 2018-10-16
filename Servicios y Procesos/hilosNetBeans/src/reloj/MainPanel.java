package reloj;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    
    Reloj pReloj;
    Botones pBotones;
    
    public MainPanel(){
        iniciarComponentes();
    }
    
    
    private void iniciarComponentes(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        pReloj = new Reloj();
        pBotones = new Botones();
        
        add(pReloj);
        add(pBotones);
    }
}
