package Tarea01;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MiddlePanel extends JPanel{
    
    JButton MidButton;
    
    public MiddlePanel(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        MidButton = new JButton("PULSAR");
        
        add(MidButton);
    }

    public JButton getMidButton() {
        return MidButton;
    }
}
