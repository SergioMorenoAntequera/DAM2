package practica1sergiomoreno;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LateralPanel extends JPanel{
    
    JButton leftButton, rightButton;
    
    public LateralPanel(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        leftButton = new JButton("En este boton");
        rightButton = new JButton("Ahora en este");
        
        //Modificamos los botones
        rightButton.setPreferredSize(new Dimension(120, 120));
        leftButton.setPreferredSize(new Dimension (120, 120));
        leftButton.setLocation(10, 10);
        
        //Para que uno vaya a la izq y otro a la der no los inicializamos aqui y le ponemos un get
        //Para llamarlos luego en cada lado desde la clase ventana
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }
    
    
}
