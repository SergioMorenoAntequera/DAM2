package Tarea01;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LateralPanel extends JPanel{
    
    JButton LeftButton, RightButton;
    
    public LateralPanel(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        LeftButton = new JButton("En este boton");
        RightButton = new JButton("Aqui");
        
        //Parfa que uno vaya a la izq y otro a la der no los inicializamos aqui y le ponemos un get
        //Para llamarlos luego en cada lado desde la clase ventana
    }

    public JButton getLeftButton() {
        return LeftButton;
    }

    public JButton getRightButton() {
        return RightButton;
    }
    
    
}
