package practicaspropuestas;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class SegundaBisPracticaPropuesta {

	public static void main(String[] args) {
		//Crea una ventana cuyo titutlo sea SegundaBis Practica Propuesta, el tamaño sea la 
		//resolucion de la pantalla donde se ejecute y el icono la imagen que tu quieras
		@SuppressWarnings("unused")
		MiMarco3 ventana = new MiMarco3();
	}

}

class MiMarco3 extends JFrame{
	private static final long serialVersionUID = 1L;

	//Creamos el constructor
	public MiMarco3() {
		setTitle("SegundaBis practica propuesta");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tamaño
		Toolkit tk = Toolkit.getDefaultToolkit();
		setSize(tk.getScreenSize());
		
		//Para añadir una imagen de icono
		//Versión en una linea
		setIconImage(tk.getImage("src/practicaspropuestas/ILibre.png"));
		
		
		setVisible(true);
	}
}