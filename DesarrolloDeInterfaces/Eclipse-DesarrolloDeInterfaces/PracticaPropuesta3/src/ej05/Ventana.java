package ej05;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private PanelSliders ps;
	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();
		
		 ps = new PanelSliders();
		 
		 lienzo.add(ps, BorderLayout.CENTER);
		
		 
		 setSize(600, 200);
	 } 
}
