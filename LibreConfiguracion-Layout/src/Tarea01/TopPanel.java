package Tarea01;
import java.awt.Color;
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
        
        titulo = new JLabel("Haz click en el boton");
        Font fuente = new Font("Consolas", BOLD, 18);
        
        titulo.setFont(fuente);
        add(titulo);
        
        setBackground(new Color(51, 153, 255));
    }

    public JLabel getTitulo() {
        return titulo;
    }
}
