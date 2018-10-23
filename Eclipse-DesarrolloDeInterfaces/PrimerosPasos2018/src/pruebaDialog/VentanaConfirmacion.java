package pruebaDialog;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class VentanaConfirmacion extends JDialog {
	private static final long serialVersionUID = 1L;
	
	public VentanaConfirmacion(JFrame vp, boolean modal) {
		super(vp, modal);
		setTitle("Ventana confirmacion");
		setSize(new Dimension(550, 400));
		setLocationRelativeTo(null);
	}
	

}
