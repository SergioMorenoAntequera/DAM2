package ej02;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ventana extends JFrame{

	//El texto(Utiliza una JLabel)  excrito en el panel se pondra en negrita si pulsamos 
	//la casilla de verificación “Negrita” y en cursiva si pulsamos en la casilla “cursiva”. 
	private static final long serialVersionUID = 1L;
	
	private PanelTexto pt;

	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 pt = new PanelTexto();

		
		 
		lienzo.add(pt, BorderLayout.CENTER);
		
		setSize(400, 400);
		//pack();
	 }

	public PanelTexto getPt() {
		return pt;
	}
	public void setPt(PanelTexto pt) {
		this.pt = pt;
	}

	 
	 
	 
}
