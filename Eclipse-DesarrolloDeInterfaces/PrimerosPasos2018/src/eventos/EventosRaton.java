package eventos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class EventosRaton {

	public static void main(String[] args) {
		VentanaEventosR miVentana = new VentanaEventosR();

		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
		

	}

}

class VentanaEventosR extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	int c = 0;
	public VentanaEventosR() {
		setTitle("Ventana respondiendo");
		setBounds(200, 200, 400, 400);
		addMouseListener(this);
		
	}

	//********** METOS DE LA INTERFAZ MouseListener ***********
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Has hecho click: ");
		System.out.println("Coordenada x: " + e.getX() + " / Coordenada y: " + e.getY());
		System.out.println("Numero de clicks: " + (++c));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

