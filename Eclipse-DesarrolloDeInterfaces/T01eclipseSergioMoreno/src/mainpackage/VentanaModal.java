package mainpackage;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaModal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Panel01 panel01 = new Panel01(this);
	Panel02 Panel02 = new Panel02(this);
	
	
	public VentanaModal() {
		iniciarVentana();
		iniciarComponentes();
	}
	
	public void iniciarVentana() {
		this.setAlwaysOnTop(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.setSize(new Dimension(tk.getScreenSize().width, tk.getScreenSize().height));
		this.setTitle("Alta reserva");
		Image icon = new ImageIcon("logoHotel.png").getImage();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniciarComponentes() {
		Container lienzo = getContentPane();
		lienzo.setLayout(new BoxLayout(lienzo, BoxLayout.Y_AXIS));
		
		lienzo.add(panel01);
		lienzo.add(Panel02);
		
	}
}
