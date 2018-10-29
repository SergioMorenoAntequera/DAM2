package einicial;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	Ventana ventana;
	
	public Ventana() {
		
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setPreferredSize(new Dimension(400, 200));
		ventana.setTitle("Evaluacion inicial Sergio Moreno");
		ventana.setVisible(true);
	}
}
