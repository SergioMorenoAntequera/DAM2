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
        
        btnStart = mainPanel.getbStart();
        btnStart.addActionListener(control);
        
        btnStop = mainPanel.getbStop();
       
        
        
       
        lienzo.add(mainPanel);
        pack();
    }
}
