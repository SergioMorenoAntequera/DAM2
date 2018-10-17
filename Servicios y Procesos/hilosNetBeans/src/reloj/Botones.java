package reloj;
import java.awt.FlowLayout;
import javax.swing.*;

public class Botones extends JPanel {
    
    public JButton bStart, bStop, bExit;    
    
    public Botones(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Inicializamos los botones
        
        bStart = new JButton("START");
        bStop = new JButton("STOP");
        bExit = new JButton("EXIT");
        bExit.addActionListener(e->salir());
        
        add(bStart);
        add(bStop);
        add(bExit);
    }

    public void salir(){
        System.exit(0);
    }
    
    //***********GETTER DE LOS BOTONES**********
    public JButton getbStart() {
        return bStart;
    }
    public JButton getbStop() {
        return bStop;
    }
    public JButton getbExit() {
        return bExit;
    }
}
