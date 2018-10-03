package Tarea01;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class BottomPanel extends JPanel {
        
    JButton bottomButton0, bottomButton1, bottomButton2;
    
    public BottomPanel(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        bottomButton0 = new JButton("Vamos que ya queda poco");
        bottomButton1 = new JButton("EL ULTIMO");
        bottomButton2 = new JButton("ESTA SI QUE SI");
        
        add(bottomButton0);
        bottomButton0.setVisible(false);
        add(bottomButton1);
        bottomButton1.setVisible(false);
        add(bottomButton2);
        bottomButton2.setVisible(false);
    }

    public JButton getBottomButton0() {
        return bottomButton0;
    }

    public JButton getBottomButton1() {
        return bottomButton1;
    }

    public JButton getBottomButton2() {
        return bottomButton2;
    }

  
}
