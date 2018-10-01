package Tarea01;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class BottomPanel extends JPanel {
        
    JButton BottomButton;
    
    public BottomPanel(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        BottomButton = new JButton();
        
        add(BottomButton);
    }

    public JButton getBottomButton() {
        return BottomButton;
    }
}
