package ej01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelCheck extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public JCheckBox cbNegrita, cbCursiva;
	public boolean negrita, cursiva;
	
	public PanelCheck(Container lienzo, PanelTexto pt) {
	}
	
	public void iniciarComponentes(Container lienzo, PanelTexto pt) {
		
		cbNegrita = new JCheckBox("Negrita");
		cbCursiva = new JCheckBox("Cursiva");
		
		this.cbNegrita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbNegrita.isSelected()) {
					negrita = true;
				} else {
					negrita = false;
				}
				pt = new PanelTexto(negrita, cursiva);
				lienzo.add(pt, BorderLayout.NORTH);
			}
		});
		
		this.add(cbNegrita);
		this.add(cbCursiva);
		
		
	}
}
