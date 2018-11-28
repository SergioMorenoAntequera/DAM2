package mainpackage;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaModal extends JFrame{
	private static final long serialVersionUID = 1L;
	Panel01 panel01 = new Panel01();
	Panel02 Panel02 = new Panel02(this);
	Panel03 panel03 = new Panel03(this);
	//Panel04 panel04 = new Panel04(this);
	
	public VentanaModal() {
		iniciarVentana();
		iniciarComponentes();
	}
	
	public void iniciarVentana() {
		this.setAlwaysOnTop(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.setSize(new Dimension(900, 700));
		this.setLocationRelativeTo(null);
		this.setTitle("Comprar coche");
		@SuppressWarnings("unused")
		Image icon = new ImageIcon("logoHotel.png").getImage();
		this.setIconImage(icon);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniciarComponentes() {
		Container lienzo = getContentPane();
		lienzo.setLayout(new BorderLayout(10, 10));
		
		lienzo.add(panel01, BorderLayout.NORTH);
		lienzo.add(Panel02, BorderLayout.WEST);
		lienzo.add(panel03, BorderLayout.CENTER);
		//lienzo.add(panel04, BorderLayout.EAST);
		lienzo.add(new JPanel(), BorderLayout.SOUTH);
	}
}
