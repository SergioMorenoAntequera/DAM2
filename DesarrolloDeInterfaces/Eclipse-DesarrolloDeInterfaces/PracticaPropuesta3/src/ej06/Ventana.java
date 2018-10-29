package ej06;
import java.awt.Container;
import javax.swing.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public boolean negrita = false, cursiva = false;
	
	 public Ventana() {
		 iniciarComponentes();
	 }
	 
	 public void iniciarComponentes() {
		 Container lienzo = this.getContentPane();

		 
		 setSize(600, 200);
	 } 
}
