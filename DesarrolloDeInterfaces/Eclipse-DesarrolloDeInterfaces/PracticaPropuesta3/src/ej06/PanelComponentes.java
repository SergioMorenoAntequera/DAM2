package ej06;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelComponentes extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel etUsuario, etContrasenia, etTelefono, etFecha;
	private JTextField tfUsuario, tfPass, tfTelefono, tfFecha;
	private JTextArea result;
	private JButton enviar;
	
	public PanelComponentes() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
	}
}
