package ejemplo1c;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PanelLateral extends JPanel{
    
    private JButton btnReset;
    private JButton btnCalcular;
    
    public PanelLateral(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        btnReset = new JButton("RESET");
        btnCalcular = new JButton("CALCULAR");
        btnReset.setPreferredSize(new Dimension(100, 80));
        btnCalcular.setPreferredSize(new Dimension(100, 80));
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }
}
