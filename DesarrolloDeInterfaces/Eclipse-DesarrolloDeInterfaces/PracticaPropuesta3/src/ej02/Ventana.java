package ej02;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private PanelRadio pr;
	private PanelTexto pt;
	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 pr = new PanelRadio();
		 pt = new PanelTexto();
		 
		 
		 lienzo.add(pr, BorderLayout.NORTH);
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
