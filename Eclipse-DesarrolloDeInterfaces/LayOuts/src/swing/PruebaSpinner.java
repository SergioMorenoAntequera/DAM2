package swing;

import java.awt.*;
import javax.swing.*;

public class PruebaSpinner {
	public static void main(String[] args) {
		MarcoSpinner miMarco = new MarcoSpinner();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}

class MarcoSpinner extends JFrame {
	private static final long serialVersionUID = 1L;

	public MarcoSpinner() {
		setTitle("Probando Spinner");
		setBounds(500, 300, 500, 350);
		add(new laminaSpinner());
	}
}

class laminaSpinner extends JPanel {
	private static final long serialVersionUID = 1L;

	public laminaSpinner() {
		// por defecto
		// JSpinner control=new JSpinner();
		// Sineer de fechas
		JSpinner control = new JSpinner(new SpinnerDateModel());
		// Spinner con listas
		String lista[] = { "Enero", "Febrero", "Marzo" };
		JSpinner control1 = new JSpinner(new SpinnerListModel(lista));
		// para cambiar el tamaño del spinner
		Dimension d = new Dimension(100, 20);
		Dimension d2 = new Dimension(250, 20);
		@SuppressWarnings("unused")
		Dimension d3 = new Dimension(50, 20);
		control1.setPreferredSize(d);
		// Todas las fuentes que estan disponibles en nuestro equipo
		String listaF[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JSpinner control2 = new JSpinner(new SpinnerListModel(listaF));
		control2.setPreferredSize(d2);
		// acotar los valores numericos
		// empieza en 5, min 0, max 10 y aumenta en 1
		JSpinner control3 = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));
		control3.setPreferredSize(d2);
		add(control);
		add(control1);
		add(control2);
		add(control3);
	}
}
	