package eventos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos2 {

	public static void main(String[] args) {
		Ventana miVentana = new Ventana();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}

}

class Ventana2 extends JFrame {
	
	public Ventana2() {
		setTitle("El oyente es: Un objeto de la clase que define el contenedor principal (panel), lo declara e imokementa");
		setBounds(200, 200, 400, 400);
		
		Panel1 miPanel = new Panel1();
		add(miPanel);
	}
	
}

class Panel2 extends JPanel implements ActionListener{
	public Panel2() {
		//setBackground(Color.BLUE);
		JButton botonAzul = new JButton("Azul");
		JButton botonAmarillo = new JButton("Amarillo");
		JButton botonRojo = new JButton("Rojo");
		
		botonAzul.addActionListener(null);
		botonAmarillo.addActionListener(null);
		botonRojo.addActionListener(null);
		
		/*
		 * botonAzul.addActionListener(fondoAzul);
		 * botonAmarillo.addActionListener(fondoAmarillo);
		 * botonRojo.addActionListener(fondoRojo);
		 */
		
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("Azul" == e.getSource().toString()) {
			setBackground(Color.BLUE);
		}
		if("Amarillo" == e.getSource().toString()) {
			setBackground(Color.YELLOW);
		}
		if("rojo" == e.getSource().toString()) {
			setBackground(Color.RED);
		}	
	}
}

