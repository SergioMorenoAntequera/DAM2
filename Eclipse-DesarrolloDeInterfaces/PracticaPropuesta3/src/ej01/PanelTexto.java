package ej01;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTexto extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public JLabel texto;
	public Font fuente;
	boolean negrita, cursiva;
	
	public PanelTexto(boolean negrita, boolean cursiva) {
		iniciarComponentes(negrita, cursiva);
	}
	
	public void iniciarComponentes(boolean negrita, boolean cursiva) {
		
		texto = new JLabel("En un lugar de la mancha del cual no...");
		if(cursiva) {
			fuente = new Font("Ink Free", Font.ITALIC, 30);
		}
		if(negrita) {
			fuente = new Font("Ink Free", Font.BOLD, 30);
		}
		if(!negrita && !cursiva) {
			fuente = new Font("Ink Free", Font.PLAIN, 30);
		}
		
		
		texto.setFont(fuente);
		this.add(texto);
	}
}
