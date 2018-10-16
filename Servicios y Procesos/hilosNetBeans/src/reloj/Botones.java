package reloj;
import java.awt.FlowLayout;
import javax.swing.*;

public class Botones extends JPanel {
    
    JButton bStart, bStop, bExit;    
    
    public Botones(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Inicializamos los botones
        
        bStart = new JButton("START");
        bStop = new JButton("STOP");
        bExit = new JButton("EXIT");
        add(bStart);
        add(bStop);
        add(bExit);
        
    }

    //Setter y getters(Por si acaso)
    public JButton getbStart() {
        return bStart;
    }

    public void setbStart(JButton bStart) {
        this.bStart = bStart;
    }

    public JButton getbStop() {
        return bStop;
    }

    public void setbStop(JButton bStop) {
        this.bStop = bStop;
    }

    public JButton getbExit() {
        return bExit;
    }

    public void setbExit(JButton bExit) {
        this.bExit = bExit;
    } 
}
