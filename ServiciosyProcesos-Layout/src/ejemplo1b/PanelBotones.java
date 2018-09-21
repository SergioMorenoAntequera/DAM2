
package ejemplo1b;
import java.awt.*;
import javax.swing.*;


public class PanelBotones extends JPanel {
    
    private JButton btnSalir;
    private JButton btnSaludo;
    
    public PanelBotones() {
        iniciarComponentes();
    }
    
    public void iniciarComponentes() {
        
        //Creamos los botones y los ponemos monos
        btnSalir = new JButton("SALIR");
        btnSaludo = new JButton("SALUDO");
        
        btnSalir.setForeground(Color.red);
        btnSaludo.setForeground(Color.green);
        
        btnSalir.setPreferredSize(new Dimension(100, 60));
        btnSaludo.setPreferredSize(new Dimension(100, 60));
        
        //Creamos y aplicamos el layout para que salgan de laico
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);
        
        //Y metemos los botones y sus funciones
        add(btnSaludo);
        //Función en la clase Ventana
        
        add(btnSalir);
        btnSalir.addActionListener(e->salir());
        
        //Ahora vamos a separar los botones, de puede de dos maneras
        //De este modo crea una distancia fija entre los 2 cuando reescalemos
        add(Box.createRigidArea(new Dimension(15, 0)));
        //En este otro la distancia va variando
        add(Box.createGlue());
        
    }
    
    public void salir(){
        System.exit(0);
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }
    
}
