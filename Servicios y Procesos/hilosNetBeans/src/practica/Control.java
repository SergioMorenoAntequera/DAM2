package practica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
    
    public Panel p;
    Hilo h;
    
    public Control(Panel p){
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == p.boton) {
            h = new Hilo(p, 200);
            h.start();
        }
     }
    
}
