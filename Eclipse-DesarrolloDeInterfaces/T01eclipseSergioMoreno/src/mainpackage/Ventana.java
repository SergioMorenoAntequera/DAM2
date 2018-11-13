package mainpackage;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	Container lienzo = this.getContentPane();
	
	 private JMenu mArchivo, mReservas, mAyuda;
	 private JMenuItem arcSalir, resAlta, resBaja, ayuAcerca;
	
	public Ventana() {
		iniciarComponentes();
		iniciarVentana();
	}
	
	public void iniciarComponentes() {
		mArchivo = new JMenu("Archivo");
			arcSalir = new JMenuItem("Salir");
		mReservas = new JMenu("Reservar");
			resAlta = new JMenuItem("Alta Reservas");
			resBaja = new JMenuItem("Baja Reservas");
		mAyuda = new JMenu("Ayuda");
			ayuAcerca = new JMenuItem("Acerca de...");
			
	}
	
	public void iniciarVentana() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int pantallaX = tk.getScreenSize().width;
		int pantallaY = tk.getScreenSize().height;
		
		this.setTitle("Gestion Hotel SergioMoreno");
		this.setSize(pantallaX/2, pantallaY/2);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = new ImageIcon("logoHotel.png").getImage();
		this.setIconImage(icon);
	}
}
