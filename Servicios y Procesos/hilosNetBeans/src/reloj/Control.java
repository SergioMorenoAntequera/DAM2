package reloj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Control implements ActionListener{
    
    /*private JButton bStart;
    private JButton bStop;
    private JButton bExit;
    private String min, sec, msec;*/
    Botones panelBotones = new Botones();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelBotones.bStart){
            System.out.println("QAAAAAAA");
        }
        
    }
}
