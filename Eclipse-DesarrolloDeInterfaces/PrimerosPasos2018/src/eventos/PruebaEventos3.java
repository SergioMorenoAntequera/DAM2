package eventos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos3 {

	public static void main(String[] args) {
		Ventana3 miVentana = new Ventana3();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}

}

class Ventana3 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ventana3() {
		setTitle("El oyente es: Una clase anonima que iomplementa la interfaz de escucha");
		setBounds(200, 200, 400, 400);
		
		Panel3 miPanel = new Panel3();
		add(miPanel);
	}
	
}

class Panel3 extends JPanel{
	private static final long serialVersionUID = 1L;

	public Panel3() {
		//setBackground(Color.BLUE);
		JButton botonAzul = new JButton("Azul");
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonRojo = new JButton("Rojo");

		
		//***************CLASES INTERNAS ANONIMAS********************
		botonAzul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setBackground(Color.BLUE);
			}
		});
		botonAmarillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.yellow);
			}
		});
		botonRojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.RED);
			}
		});
		
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
	}
}

