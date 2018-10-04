package practicaspropuestas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SextaPracticaPropuestaBis {
	
	//Crea una ventana en la que se muestre un boton con e titulo "saludo" y otro Con el 
	//titulo despedida al pulsar el primero aparecerá un JOptionPane.ShomessageDialog
	//Diciendo hola y en el otro al conrario.
 	
	public static void main(String[] args) {
		Ventana6Bis miVentana = new Ventana6Bis();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
		
		Ventana6Bis2 miVentana2 = new Ventana6Bis2();
		miVentana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana2.setVisible(true);
	}
}

class Ventana6Bis extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ventana6Bis() {
		setTitle("PracticaPropuesta6");
		setBounds(200, 200, 300, 300);

	}
}

class Ventana6Bis2 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ventana6Bis2() {
		setTitle("PracticaPropuesta6");
		setBounds(550, 200, 300, 300);

	}
}