package practicaspropuestas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class OctavaPracticaPropuesta {
	
	/*
	 * Hacer ventana que te diga con que boton haces click
	 */
	public static void main(String[] args) {
		VentanaEventosR1 miVentana = new VentanaEventosR1();

		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class VentanaEventosR1 extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	int c1 = 0, c2= 0;
	public VentanaEventosR1() {
		setTitle("Octaba practica");
		setBounds(200, 200, 400, 400);
		addMouseListener(this);


}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == 1) {
			System.out.println("Pulsado el izquierdo");
		} else {
			if(e.getButton() == 3) {
				System.out.println("Pulsado el derecho");
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}

