package reloj;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    MainPanel mainPanel;
    int min, sec, msec;
    
    Control control;
    JButton btnStart, btnStop;
    
    
    public Ventana(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        Container lienzo = this.getContentPane();
        mainPanel = new MainPanel();
        control = new Control(this);
        
        min = mainPanel.min;
        sec = mainPanel.sec;
        msec = mainPanel.msec;
        
        btnStart = mainPanel.getbStart();
        btnStart.addActionListener(control);
        btnStop = mainPanel.getbStop();
        btnStop.addActionListener(control);
        btnStop.setEnabled(false);

        lienzo.add(mainPanel);
        pack();
    }
}
