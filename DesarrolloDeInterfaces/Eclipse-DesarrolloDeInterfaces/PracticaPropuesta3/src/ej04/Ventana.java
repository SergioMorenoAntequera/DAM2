package ej04;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private PanelSliders ps;
	private PanelTexto pt;
	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 ps = new PanelSliders();
		 pt = new PanelTexto();
		 
		 lienzo.add(ps, BorderLayout.NORTH);
		 lienzo.add(pt, BorderLayout.CENTER);
		
		 
		 setSize(600, 200);
	 }

	public PanelTexto getPt() {
		return pt;
	}
	public void setPt(PanelTexto pt) {
		this.pt = pt;
	}

	 
	 
	 
}
