package ejemplo1c;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelResultado extends JPanel{
    
    private JLabel jbResultado;
    private JTextField tfResultado;
    private JButton btnSalir;
    
    public PanelResultado(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        jbResultado = new JLabel("Tu resultado es: ");
        tfResultado = new JTextField();
        btnSalir = new JButton("SALIR");
        
        tfResultado.setPreferredSize(new Dimension(80, 30));
        
        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
        setLayout(fl);
        
        add(jbResultado);
        add(tfResultado);
        add(Box.createRigidArea(new Dimension(70, 20)));
        add(btnSalir);
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setTfResultado(JTextField tfResultado) {
        this.tfResultado = tfResultado;
    }

    public void setJbResultado(JLabel jbResultado) {
        this.jbResultado = jbResultado;
    }

    public JLabel getJbResultado() {
        return jbResultado;
    }
}
