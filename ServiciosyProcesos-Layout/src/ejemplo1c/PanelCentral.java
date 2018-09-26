package ejemplo1c;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelCentral extends JPanel {
    
    private JTextField tfPrimeraCasilla;
    private JTextField tfSegundaCasilla;
    private JLabel jlSigno;
    
    
    public PanelCentral(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        tfPrimeraCasilla = new JTextField();
        tfSegundaCasilla = new JTextField();
        jlSigno = new JLabel("+");
        
        
        tfPrimeraCasilla.setPreferredSize(new Dimension(80, 30));
        tfSegundaCasilla.setPreferredSize(new Dimension(80, 30));
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        add(tfPrimeraCasilla);
        add(jlSigno);
        add(tfSegundaCasilla);
        
    }

    public JTextField getTfPrimeraCasilla() {
        return tfPrimeraCasilla;
    }

    public JTextField getTfSegundaCasilla() {
        return tfSegundaCasilla;
    }
    
}
