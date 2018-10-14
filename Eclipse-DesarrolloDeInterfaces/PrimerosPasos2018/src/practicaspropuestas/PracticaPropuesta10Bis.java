package practicaspropuestas;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PracticaPropuesta10Bis {

	/*
	 * Realiza una modificación sobre la aplicación anterior para que los cuadros de diálogo 
	 * de mensaje se muestren cuando el cuadro de texto pierda el foco. 
	 */
	public static void main(String[] args) {
		Ventana10Bis miVentana = new Ventana10Bis();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class Ventana10Bis extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana10Bis() {
		setTitle("Practica Propuesta 10Bis");
		setBounds(200, 200, 400, 400);
		Panel10Bis panel = new Panel10Bis();
		add(panel);
	}
}

class Panel10Bis extends JPanel implements FocusListener{
	private static final long serialVersionUID = 1L;
	
	JLabel etiquetaEmail;
	JLabel etiquetaComprobacion;
	JTextField campoEmail;
	JTextField campoComprobacion;
	
	public Panel10Bis() {
		setLayout(null);
		etiquetaEmail = new JLabel("Contraseña: ");
		etiquetaComprobacion = new JLabel("Resultado: ");
		campoEmail  = new JPasswordField();
		campoComprobacion = new JTextField();
		
		etiquetaEmail.setBounds(10, 10, 150, 20);
		campoEmail.setBounds(120, 10, 150, 20);
		
		etiquetaComprobacion.setBounds(10, 40, 150, 20);
		campoComprobacion.setBounds(120, 40, 150, 20);
		campoEmail.addFocusListener(this);
		
		add(campoEmail);
		add(campoComprobacion);
		add(etiquetaEmail);
		add(etiquetaComprobacion);
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == campoEmail) {
			String email = campoEmail.getText();
			this.campoComprobacion.setText(email);
		}
	}

}
