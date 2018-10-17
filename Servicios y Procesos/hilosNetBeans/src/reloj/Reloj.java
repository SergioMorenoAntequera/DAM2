package reloj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Reloj extends JPanel {
    
    JLabel clock;
    public String min = "00", sec = "00", msec = "00";
    
    public Reloj(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){

        clock = new JLabel(min + ":" + sec + ":" + msec);
        clock.setPreferredSize(new Dimension(200, 50));
        clock.setBackground(Color.BLACK);
        clock.setForeground(Color.GREEN);
        clock.setFont(new Font("Consolas", 0, 25));
        clock.setBorder(new LineBorder(Color.BLACK));
        
        
        add(clock);
    }

    public JLabel getClock() {
        return clock;
    }

    public void setClock(JLabel clock) {
        this.clock = clock;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getMsec() {
        return msec;
    }

    public void setMsec(String msec) {
        this.msec = msec;
    }
    
}
