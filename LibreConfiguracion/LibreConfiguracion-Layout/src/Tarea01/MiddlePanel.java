package Tarea01;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MiddlePanel extends JPanel {

    JButton midButton0, midButton1, midButton2, midButton3;

    public MiddlePanel() {
        iniciarComponentes();
    }

    void iniciarComponentes() {

        FlowLayout bl = new FlowLayout(FlowLayout.CENTER);
        setLayout(bl);
        
        midButton0 = new JButton("PULSAR");
        midButton1 = new JButton("UN");
        midButton2 = new JButton("POCO");
        midButton3 = new JButton("MAS");
        
        add(midButton0);
        add(midButton1);
        midButton1.setVisible(false);
        add(midButton2);
        midButton2.setVisible(false);
        add(midButton3);
        midButton3.setVisible(false);
        
    }

    public JButton getMidButton1() {
        return midButton1;
    }

    public JButton getMidButton2() {
        return midButton2;
    }

    public JButton getMidButton3() {
        return midButton3;
    }

    public JButton getMidButton0() {
        return midButton0;
    }
}
