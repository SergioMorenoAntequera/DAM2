package jOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDialogos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana = new Ventana();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
	}

}

class Panel extends JPanel{
	
	public Panel() {
		JButton boton = new JButton("Aceptar");
		add(boton);
	}
	
}

class Ventana extends JFrame{
	
	public Ventana() {
		setTitle("Prueba de dialogos con botones");
		setBounds(200, 200, 400, 400);
		Panel panel = new Panel();
		add(panel);
	}
}

