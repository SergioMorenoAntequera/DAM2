package practica;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener{
   
    private JLabel texto;
    private JButton boton;
    
    public Panel() {
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        texto = new JLabel("CUENTA ATRAS");
        boton = new JButton("GO");
        
        add(texto);
        boton.addActionListener(this);
        add(boton);
        
    }

    
    public JLabel getTexto() {
        return texto;
    }
    public JButton getBoton() {
        return boton;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){
            texto.setText("AAAAAA");
        }
    }
}
