package reloj;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    
    Reloj pReloj;
    public int min, sec, msec;
    
    Botones pBotones;
    JButton bStart, bStop;
    
    public MainPanel(){
        iniciarComponentes();
    }
    
    
    private void iniciarComponentes(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     
        pReloj = new Reloj();
        min = pReloj.getMin();
        sec = pReloj.getSec();
        msec = pReloj.getMsec();
        
        pBotones = new Botones();
        bStart = pBotones.getbStart();
        bStop = pBotones.getbStop();
        
        add(pReloj);
        add(pBotones);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMsec() {
        return msec;
    }

    public void setMsec(int msec) {
        this.msec = msec;
    }

    public JButton getbStop() {
        return bStop;
    }
    public JButton getbStart() {
        return bStart;
    }
}
