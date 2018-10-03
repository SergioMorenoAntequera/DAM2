package eventos;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class EventosVentana3 {

	public static void main(String[] args) {
		VentanaEventos miVentana = new VentanaEventos();
		VentanaEventos miVentana2 = new VentanaEventos(); 
		
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
		
		miVentana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana2.setVisible(true);
	}

}

class VentanaEventos3 extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaEventos3() {
		setTitle("Ventana respondiendo");
		setBounds(200, 200, 400, 400);
		addWindowListener(new Oyente());
	}

	class Oyente extends WindowAdapter {
		
		@Override
		public void windowActivated(WindowEvent arg0) {
			System.out.println("Ventana activada");
		}
		@Override
		public void windowIconified(WindowEvent arg0) {
			System.out.println("Venata minimizada");		
		}
	}
	
}

