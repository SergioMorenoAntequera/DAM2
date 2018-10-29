package graficos;

import javax.swing.JFrame;

public class CreandoMarcos {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MiMarco marco = new MiMarco();
		@SuppressWarnings("unused")
		MiMarco2 marco2 = new MiMarco2();
	}
	
}

//*****Diferentes plantillas para marcos***


//Plantilla 1
class MiMarco extends JFrame{
	private static final long serialVersionUID = 1L;

	//Creamos el constructor
	public MiMarco() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50, 200, 500, 300);
		//Para que salga maximizada
		//setExtendedState(MAXIMIZED_BOTH);
		setTitle("Mi primera ventana");
		setVisible(true);
	}
}

//Plantilla 2
class MiMarco2 extends JFrame {
	private static final long serialVersionUID = 1L;

	public MiMarco2() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		//Para que salga maximizada
		//setExtendedState(MAXIMIZED_BOTH);
		setTitle("Mi segunda ventana");
		setVisible(true);
	}
}