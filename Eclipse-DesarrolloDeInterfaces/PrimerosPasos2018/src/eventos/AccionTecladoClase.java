package eventos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccionTecladoClase {

	public static void main(String[] args) {
		VentanaTecladoClase miVentana = new VentanaTecladoClase();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}

}

class VentanaTecladoClase extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaTecladoClase() {
		setTitle("Probando los eventos");
		setBounds(200, 200, 400, 400);
		
		PanelaccionTeclado miPanel = new PanelaccionTeclado();
		add(miPanel);
	}
	
}

class PanelaccionTeclado extends JPanel{
	private static final long serialVersionUID = 1L;

	public PanelaccionTeclado() {
		//setBackground(Color.BLUE);
		
		JButton botonAzul = new JButton("Azul");
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonRojo = new JButton("Rojo");
		ColorFondo fondoAzul = new ColorFondo(Color.BLUE);
		ColorFondo fondoAmarillo = new ColorFondo(Color.YELLOW);
		ColorFondo fondoRojo = new ColorFondo(Color.RED);
		add(botonAzul);
		botonAzul.addActionListener(fondoAzul);
		botonAzul.setIcon(new ImageIcon("iAzul"));
		add(botonAmarillo);
		botonAmarillo.addActionListener(fondoAmarillo);
		botonAmarillo.setIcon(new ImageIcon("iAmarillo"));
		add(botonRojo);
		botonRojo.addActionListener(fondoRojo);
		botonRojo.setIcon(new ImageIcon("iRojo"));
	}
	
	class ColorFondo implements ActionListener {
		 
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

