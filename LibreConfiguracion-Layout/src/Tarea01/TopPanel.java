package Tarea01;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
    
    private JLabel titulo;
    
    public TopPanel(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        
        titulo = new JLabel("HAZ CLICK EN EL BOTON");
        Font fuente = new Font("Consolas", BOLD, 18);
        
        titulo.setFont(fuente);
        titulo.setPreferredSize(new Dimension(220, 50));
        add(titulo);
        
        setBackground(new Color(51, 153, 255));
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo.setText(titulo);
    }
    
}
