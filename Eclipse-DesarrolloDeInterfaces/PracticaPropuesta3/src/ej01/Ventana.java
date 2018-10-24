package ej01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ventana extends JFrame{

	//El texto(Utiliza una JLabel)  excrito en el panel se pondra en negrita si pulsamos 
	//la casilla de verificación “Negrita” y en cursiva si pulsamos en la casilla “cursiva”. 
	private static final long serialVersionUID = 1L;
	
	private PanelTexto pt;
	private PanelCheck pc;
	private boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 pt = new PanelTexto(negrita, cursiva);
		 pc = new PanelCheck(this, pt);
		
		
		
		
		pc.cursiva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {
				if (pc.cursiva.isSelected()) {
					cursiva = true;
				} else {
					cursiva = false;
				}
				pt = new PanelTexto(negrita, cursiva);
				lienzo.add(pt, BorderLayout.NORTH);
			}
		});
		 
		lienzo.add(pt, BorderLayout.NORTH);
		lienzo.add(pc, BorderLayout.SOUTH);
		 
		pack();
	 }
}
