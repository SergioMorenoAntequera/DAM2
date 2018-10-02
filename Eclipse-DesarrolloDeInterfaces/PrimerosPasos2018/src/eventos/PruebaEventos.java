package eventos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos {

	public static void main(String[] args) {
		Ventana miVentana = new Ventana();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}

}

class Ventana extends JFrame {
	
	public Ventana() {
		setTitle("Probando los eventos");
		setBounds(200, 200, 400, 400);
		
		Panel1 miPanel = new Panel1();
		add(miPanel);
	}
	
}

class Panel1 extends JPanel{
	public Panel1() {
		//setBackground(Color.BLUE);
		JButton botonAzul = new JButton("Azul");
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonRojo = new JButton("Rojo");
		
		ColorFondo fondoAzul = new ColorFondo(Color.BLUE);
		ColorFondo fondoAmarillo = new ColorFondo(Color.YELLOW);
		ColorFondo fondoRojo = new ColorFondo(Color.RED);
		add(botonAzul);
		botonAzul.addActionListener(fondoAzul);
		add(botonAmarillo);
		botonAmarillo.addActionListener(fondoAmarillo);
		add(botonRojo);
		botonRojo.addActionListener(fondoRojo);
	}
	
	class ColorFondo implements ActionListener{
		
		private Color colorFondo;
		public ColorFondo(Color c) {
			colorFondo = c;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setBackground(colorFondo);
		}
	}
}

