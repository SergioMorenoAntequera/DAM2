package pruebamenu;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	private JMenu archivo, edicion, herramientas, opciones;
	private JMenuItem guardar, guardarComo, cortar, copiar, pegar;
	
	public VentanaPrincipal() {
		iniciarcomponentes();
		setTitle("Menus y menus emergentes");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void iniciarcomponentes() {
		//Inicializamos la barra
		barra = new JMenuBar();
		//Inicializamos las cosas que an a la barra
		archivo = new JMenu("Arcivo");
		edicion = new JMenu("Edicion");
		herramientas = new JMenu("Herramientas");
		//opciones = new JMenu("Opciones");
		
		//Inicializamos los JMenuItem
		guardar = new JMenuItem("Guardar");
		guardarComo = new JMenuItem("Guardar como...");
		guardarComo = new JMenuItem("Guardar como...");
		guardarComo = new JMenuItem("Guardar como...");
		guardarComo = new JMenuItem("Guardar como...");
		
		
		//La añadimos a la ventana
		this.setJMenuBar(barra);
		barra.add(archivo);
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		barra.add(edicion);
		
		
		barra.add(herramientas);
		//barra.add(opciones);
		
		
	}
}
