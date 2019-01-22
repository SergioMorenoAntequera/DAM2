package practica;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{
   
    public JLabel texto;
    public int numero;
    public JButton boton;

    public Panel() {
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.numero = 10;
        texto = new JLabel("PANEL1");
        boton = new JButton("GO");
        boton.addActionListener(new Control(this));
        
        add(texto);
        add(boton);
    }
    
    public JLabel getTexto() {
        return texto;
    }
    public JButton getBoton() {
        return boton;
    }
    public void setTexto(JLabel texto) {
        this.texto = texto;
    }
}
