package ej01;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCheck extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public JCheckBox cbNegrita, cbCursiva;
	public boolean negrita, cursiva;
	public JLabel texto = PanelTexto.getTexto();
	
	public PanelCheck() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		
		cbNegrita = new JCheckBox("Negrita");
		cbCursiva = new JCheckBox("Cursiva");
		
		cbNegrita.addActionListener(this);
		cbCursiva.addActionListener(this);
		
		
		this.add(cbNegrita);
		this.add(cbCursiva);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cbNegrita.isSelected() || cbCursiva.isSelected()) {
			
			if(cbNegrita.isSelected() && !cbCursiva.isSelected()) {
				System.out.println("Solo negrita");
				texto.setFont(new Font("Ink Free", Font.BOLD, 20));
			}
			
			if (cbCursiva.isSelected() && !cbNegrita.isSelected()) {
			System.out.println("Solo cursiva");
			texto.setFont(new Font("Ink Free", Font.ITALIC, 20));
			}
			
			if (cbCursiva.isSelected() && cbNegrita.isSelected()) {
				System.out.println("Ambas");
				texto.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
			}
			
		} else {
			texto.setFont(new Font("Ink Free", Font.PLAIN, 20));
		}
		
		PanelTexto.setTexto(texto);
	}
}
