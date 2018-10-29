package ej03;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCombo extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel texto;
	private String[] letras = {"", "Serif", "Sans Serif", "Monospaced", "Dialog"};
	private JComboBox<String[]> letrasLista;
	
	public PanelCombo() {
		iniciarComponentes();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void iniciarComponentes() {
		letrasLista = new JComboBox(letras);
		
		
		letrasLista.addActionListener(this);
		
		this.add(letrasLista);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		texto = PanelTexto.getTexto();
		
		if (letrasLista.getSelectedIndex() == 0) {
			texto.setFont(new Font("Ink Free", Font.PLAIN, 20));
		}
		if (letrasLista.getSelectedIndex() == 1) {
			texto.setFont(new Font("Serif", Font.PLAIN, 20));
		}
		if (letrasLista.getSelectedIndex() == 2) {
			texto.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		}
		if (letrasLista.getSelectedIndex() == 3) {
			texto.setFont(new Font("Monospaced", Font.PLAIN, 20));
		}
		if (letrasLista.getSelectedIndex() == 4) {
			texto.setFont(new Font("Dialog", Font.PLAIN, 20));
		}
		PanelTexto.setTexto(texto);
	}
	
}
