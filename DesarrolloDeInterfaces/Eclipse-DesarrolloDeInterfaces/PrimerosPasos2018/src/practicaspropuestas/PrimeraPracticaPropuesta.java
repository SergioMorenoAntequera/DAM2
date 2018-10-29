package practicaspropuestas;

import javax.swing.JFrame;

public class PrimeraPracticaPropuesta {

	public static void main(String[] args) {
		//Crea una venta cuyo titutlo sea Primera practica propuesta y el tamaño 500, 300 y 
		//la posicion 200, 300
		@SuppressWarnings("unused")
		MiMarco marco = new MiMarco();
	}
}

class MiMarco extends JFrame{
	private static final long serialVersionUID = 1L;

	//Creamos el constructor
	public MiMarco() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 300, 500, 300);
		setTitle("Primera practica propuesta");
		setVisible(true);
	}
}