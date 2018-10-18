package reloj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Reloj extends JPanel {
    
    JLabel clock;
    public int min = 23, sec = 0, msec = 0;
    
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

    
    //******GETTERS Y SETTERS*******
    public JLabel getClock() {
        return clock;
    }

    public void setClock(JLabel clock) {
        this.clock = clock;
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
    
}
