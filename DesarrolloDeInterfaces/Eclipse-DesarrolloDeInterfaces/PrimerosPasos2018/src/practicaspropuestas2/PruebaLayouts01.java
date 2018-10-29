package practicaspropuestas2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class PruebaLayouts01 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Ventana ventana = new Ventana();
	}
}

//Ventana
class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana() {
		iniciarComponentes();
		this.setVisible(true);
	}
	
	private void iniciarComponentes(){
		setTitle("Ejercicio Clase");
		setSize(new Dimension(300, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		add(new Panel1(), BorderLayout.NORTH);
		add(new Panel2(), BorderLayout.SOUTH);
	}
}


//Panel de arriba
class Panel1 extends JPanel {
	private static final long serialVersionUID = 1L;
	public Panel1(){
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Blanco"));
		add(new JButton("Negro"));
	}
}

//Panel de abajo
class Panel2 extends JPanel{
	private static final long serialVersionUID = 1L;

	public Panel2() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setLayout(new BorderLayout());
		add(new JButton("Azul"), BorderLayout.EAST);
		add(new JButton("Rojo"), BorderLayout.CENTER);
		add(new JButton("Amarillo"), BorderLayout.WEST);
	}
}
