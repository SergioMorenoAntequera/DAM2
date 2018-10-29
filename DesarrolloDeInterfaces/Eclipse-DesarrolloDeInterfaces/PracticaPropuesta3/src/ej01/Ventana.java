package ej01;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ventana extends JFrame{

	//El texto(Utiliza una JLabel)  excrito en el panel se pondra en negrita si pulsamos 
	//la casilla de verificación “Negrita” y en cursiva si pulsamos en la casilla “cursiva”. 
	private static final long serialVersionUID = 1L;
	
	private PanelTexto pt;
	private PanelCheck pc;
	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 pt = new PanelTexto();
		 pc = new PanelCheck();
		
		 
		lienzo.add(pt, BorderLayout.NORTH);
		lienzo.add(pc, BorderLayout.SOUTH);
		
		setSize(400, 125);
		//pack();
	 }

	public PanelTexto getPt() {
		return pt;
	}
	public void setPt(PanelTexto pt) {
		this.pt = pt;
	}
	public PanelCheck getPc() {
		return pc;
	}
	public void setPc(PanelCheck pc) {
		this.pc = pc;
	}
	 
	 
	 
}
