package eventos;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EventosTeclado {
	
	public static void main(String[] args) {
		MarcoTeclado miVentana = new MarcoTeclado();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}

}

class MarcoTeclado extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;

	public MarcoTeclado() {
		setBounds(300, 200, 500, 350);
		setVisible(true);
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int codigo = e.getKeyCode();
		char letra = e.getKeyChar();
		System.out.println("Codigo: " + codigo  + " / Letra: " + letra);
	}
}