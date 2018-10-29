 package eventos;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class EventoFoco {
	
	
	
	public static void main(String[] args) {
		VentanaEventosFoco miVentana = new VentanaEventosFoco();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class VentanaEventosFoco extends JFrame {
	private static final long serialVersionUID = 1L;
	public VentanaEventosFoco() {
		setTitle("Ventana respondiendo");
		setBounds(200, 200, 400, 400);
		LaminaFoco lamina = new LaminaFoco();
		add(lamina);
	}
}

class LaminaFoco extends JPanel implements FocusListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel etiquetaEmail;
	JLabel etiquetaComprobacion;
	JTextField campoEmail;
	JTextField campoComprobacion;
	
	public LaminaFoco() {
		setLayout(null);
		etiquetaEmail = new JLabel("eMail: ");
		etiquetaComprobacion = new JLabel("¿eMail correcto?");
		campoEmail  = new JTextField();
		campoComprobacion = new JTextField();
		
		etiquetaEmail.setBounds(10, 10, 150, 20);
		campoEmail.setBounds(120, 10, 150, 20);
		
		etiquetaComprobacion.setBounds(10, 40, 150, 20);
		campoComprobacion.setBounds(120, 40, 150, 20);
		
		add(campoEmail);
		add(campoComprobacion);
		add(etiquetaEmail);
		add(etiquetaComprobacion);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		@SuppressWarnings("unused")
		String email = campoEmail.getText();
		
	}
	
}
