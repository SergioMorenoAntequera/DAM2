package ej01;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTexto extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static JLabel texto;
	boolean negrita, cursiva;
	
	public PanelTexto() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		
		texto = new JLabel("En un lugar de la mancha del cual no...");
		texto.setFont(new Font("Ink Free", Font.PLAIN, 20));

		this.add(texto);
	}

	public static JLabel getTexto() {
		return texto;
	}

	public static void setTexto(JLabel texto) {
		PanelTexto.texto = texto;
	}
	
}
