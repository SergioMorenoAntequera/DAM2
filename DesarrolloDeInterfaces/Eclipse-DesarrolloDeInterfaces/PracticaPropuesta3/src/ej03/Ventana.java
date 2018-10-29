package ej03;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private PanelCombo pc;
	private PanelTexto pt;
	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 pc = new PanelCombo();
		 pt = new PanelTexto();
		 
		 lienzo.add(pc, BorderLayout.NORTH);
		 lienzo.add(pt, BorderLayout.CENTER);
		
		 
		 setSize(600, 200);
		 //pack();
	 }

	public PanelTexto getPt() {
		return pt;
	}
	public void setPt(PanelTexto pt) {
		this.pt = pt;
	}

	 
	 
	 
}
