package practicaspropuestas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PracticaPropuesta10 {

	/*
	 * Crea una aplicación que utilize un campo de texto normal y un campo de texto de contraseña.
	 *  Cuando el usuario escribe un texto en uno de los campos y presiona la tecla intro,
	 *   la aplicación debe mostrar un cuadro de diálogo de mensaje que contiene el texto que
	 *    escribio el usuario. 
	 */
	public static void main(String[] args) {
		Ventana10 miVentana = new Ventana10();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class Ventana10 extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana10() {
		setTitle("Practica Propuesta 10");
		setBounds(200, 200, 400, 400);
		Panel10 panel = new Panel10();
		add(panel);
	}
}

class Panel10 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JLabel etiquetaEmail;
	JLabel etiquetaComprobacion;
	JTextField campoEmail;
	JTextField campoComprobacion;
	
	public Panel10() {
		setLayout(null);
		etiquetaEmail = new JLabel("Contraseña: ");
		etiquetaComprobacion = new JLabel("Resultado: ");
		campoEmail  = new JPasswordField();
		campoComprobacion = new JTextField();
		
		etiquetaEmail.setBounds(10, 10, 150, 20);
		campoEmail.setBounds(120, 10, 150, 20);
		
		etiquetaComprobacion.setBounds(10, 40, 150, 20);
		campoComprobacion.setBounds(120, 40, 150, 20);
		
		campoEmail.addActionListener(this);
		
		add(campoEmail);
		add(campoComprobacion);
		add(etiquetaEmail);
		add(etiquetaComprobacion);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == campoEmail) {
			String email = campoEmail.getText();
			this.campoComprobacion.setText(email);
		}
	}

	
}
