package mainpackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	Container lienzo = this.getContentPane();
	
	private JMenuBar menuBar;
	private JMenu mArchivo, mReservas, mAyuda;
	private JMenuItem arcSalir, resAlta, resBaja, ayuAcerca;
	private JButton bReservar;
	
	public Ventana() {
		iniciarVentana();
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		//Primero creamos las barras
		menuBar = new JMenuBar();
		mArchivo = new JMenu("Archivo");
			arcSalir = new JMenuItem("Salir");
		mReservas = new JMenu("Comprar");
			resAlta = new JMenuItem("Abrir formulario");
			resAlta.addActionListener(e -> generarVentanaModal());
			resBaja = new JMenuItem("Opcion en desarrollo");
		mAyuda = new JMenu("Ayuda");
			ayuAcerca = new JMenuItem("Acerca de...");
		//Añadimos las barras
		menuBar.add(mArchivo);
		mArchivo.add(arcSalir);
		arcSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mReservas);
		mReservas.setMnemonic('F');
		
		mReservas.add(resAlta);

		resAlta.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		resAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mReservas.add(resBaja);
		resBaja.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		resBaja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Función en desarrollo");
			}
		});
		menuBar.add(mAyuda);
		mAyuda.add(ayuAcerca);
		ayuAcerca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicacion la cual simulará una pequeña reserva en un hotel");
			}
		});
		this.add(menuBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		bReservar = new JButton("COMPRAR COCHE");
		bReservar.setFont(new Font("Calibri", Font.BOLD , 40));
		bReservar.addActionListener(e -> generarVentanaModal());
		panel.add(bReservar);
		this.add(panel);
		
	}
	
	public void iniciarVentana() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int pantallaX = tk.getScreenSize().width;
		int pantallaY = tk.getScreenSize().height;
		
		this.setTitle("Venta de coches Sergio Moreno");
		this.setSize(pantallaX/2, pantallaY/2);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = new ImageIcon("logoHotel.png").getImage();
		this.setIconImage(icon);
	}
	
	public void generarVentanaModal() {
		VentanaModal vm = new VentanaModal();
		vm.setVisible(true);
	}
}
