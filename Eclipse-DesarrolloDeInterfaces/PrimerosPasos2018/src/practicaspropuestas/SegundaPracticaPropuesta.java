package practicaspropuestas;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class SegundaPracticaPropuesta {

	public static void main(String[] args) {
		//Crea una ventana cuyo titulo sea segunda practica propuesta define el tama�o yla posicion 
		//con un solo metodo, tama�o 500, 300 y posicion 200, 300 que la ventana no sea 
		//redimensionable Cambia el icono de la ventana por el logotipo del ies
		@SuppressWarnings("unused")
		MiMarco2 ventana = new MiMarco2();
	}

}

class MiMarco2 extends JFrame{
	private static final long serialVersionUID = 1L;

	//Creamos el constructor
	public MiMarco2() {
		setTitle("Segunda practica propuesta");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//La posicion y el tama�o
		setBounds(200, 300, 500, 300);
		//Para que no sea redimesionable
		setResizable(false);
		
		//Para a�adir una imagen de icono
		Toolkit tk = Toolkit.getDefaultToolkit();
			//Versi�n en una linea
		setIconImage(tk.getImage("src/practicaspropuestas/IAlandalus.jpg"));
		
		
		setVisible(true);
	}
}