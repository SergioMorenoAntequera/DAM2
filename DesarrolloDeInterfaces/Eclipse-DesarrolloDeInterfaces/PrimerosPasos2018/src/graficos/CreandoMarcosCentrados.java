package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;


public class CreandoMarcosCentrados {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MiMarco3 marco = new MiMarco3();
		
	}
}

class MiMarco3 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Se instancia asi porque es una clase abstracta
	Toolkit miPantalla = Toolkit.getDefaultToolkit();
	//Para obtener el tamaño de la pantalla
	Dimension tamañoPantalla = miPantalla.getScreenSize();
	
	public MiMarco3() {
		//Ponemos la pantalla como la mitad de ancho y de alto
		setSize((tamañoPantalla.width / 2), tamañoPantalla.height / 2 );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Para ponerle un icono también se hace con ToolKit
		Image icono = miPantalla.getImage("src/graficos/icono.png");
		setIconImage(icono);
		setTitle("Ventana de mitad de tamanio");
		
		setVisible(true);
	}
	
}
