package reloj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Control implements ActionListener{
    
    /*private JButton bStart;
    private JButton bStop;
    private JButton bExit;
    private String min, sec, msec;*/
    //Botones panelBotones = new Botones();
    
    Ventana v;
    public Control(Ventana v){
        this.v = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.btnStart){
            v.btnStart.setEnabled(false);
            v.btnStop.setEnabled(true);
            
        }
        if(e.getSource() == v.btnStop){
            v.btnStop.setEnabled(false);
            v.btnStart.setEnabled(true);
            
        }
        
    }
}
