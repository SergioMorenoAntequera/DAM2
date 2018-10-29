package practicaspropuestas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class NovenaPracticaPropuesta {
	
	/*
	 * HAcer una ventana que te diga si estas arrastrando o solo moviendo el raton
	 */
	public static void main(String[] args) {
		VentanaEventosR2 miVentana = new VentanaEventosR2();

		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class VentanaEventosR2 extends JFrame implements MouseMotionListener{
	private static final long serialVersionUID = 1L;
	
	int c1 = 0, c2= 0;
	public VentanaEventosR2() {
		setTitle("Arrastrar o moviendo");
		setBounds(200, 200, 400, 400);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Arrastrando " + "/ " + c1++);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Moviendo " + "/ " + c2++);
	}


}
