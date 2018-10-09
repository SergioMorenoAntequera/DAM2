package practicaspropuestas;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SextaPracticaPropuestaBis {
	
	//Crea una ventana en la que se muestre un boton con e titulo "saludo" y otro Con el 
	//titulo despedida al pulsar el primero aparecerá un JOptionPane.ShomessageDialog
	//Diciendo hola y en el otro al conrario.
 	
	public static void main(String[] args) {
		Ventana6Bis miVentana = new Ventana6Bis();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);

	}
}

class Ventana6Bis extends JFrame{
	private static final long serialVersionUID = 1L;

	
	public Ventana6Bis() {
		setTitle("PracticaPropuesta6");
		setBounds(200, 200, 300, 300);
		Panel6Bis panel = new Panel6Bis();
		
		add(panel);
	}
}

class Panel6Bis extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	
	JButton botonHola = new JButton("Saludo");
	JButton botonAdios = new JButton("Adios");
	JLabel texto = new JLabel("Prueba");
	
	public Panel6Bis() {
		add(botonHola);
		add(botonAdios);
		add(texto);
		
		botonHola.addActionListener(this);
		botonAdios.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonHola) {
			texto.setText("HOLA");
		}
		if(e.getSource() == botonAdios) {
			texto.setText("ADIOS");
		}
		
		
	}


	
}
