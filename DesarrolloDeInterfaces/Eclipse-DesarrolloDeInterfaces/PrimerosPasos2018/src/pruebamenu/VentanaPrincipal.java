package pruebamenu;

import javax.swing.*;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = 1L;
	private JMenuBar barra;
	private JMenu archivo, edicion, herramientas, opciones;
	private JMenuItem guardar, guardarComo, cortar, copiar, pegar, opcion1, opcion2, itemEmergente1, itemEmergente2;
	private JPopupMenu menuEmergente;
	private JPanel miPanel;
	
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
		
		
		
		//JMenuItems de Archivo
		guardar = new JMenuItem("Guardar");
		guardarComo = new JMenuItem("Guardar como...");
		archivo.add(guardar);
		archivo.add(guardarComo);
		barra.add(archivo); //Añadimos archivo a la barra
		
		
		//JMenuItems de Edicion
		copiar = new JMenuItem("copiar");
		cortar = new JMenuItem("Cortar");
		pegar = new JMenuItem("Pegar");
		edicion.add(copiar);
		edicion.add(cortar);
		edicion.add(pegar);
		edicion.addSeparator();
		opciones = new JMenu("Opciones");
		edicion.add(opciones);
		opcion1 = new JMenuItem("Opcion1");
		opcion2 = new JMenuItem("Opcion2");
		opciones.add(opcion1);
		opciones.add(opcion2);
		barra.add(edicion); //Añadimos edicion a la barra
		
		
		//JMenuItems de Herramientas
		//vacio
		barra.add(herramientas); //Añadimos herramientas a la barra
		
		
		//Colocamos la BARRA YA TERMINADA
		this.setJMenuBar(barra);		
		
		//-----------------------------------------//
		//Creamos el menu emergente (CLICK DERECHO)//
		//-----------------------------------------//
		menuEmergente = new JPopupMenu();
		miPanel = new JPanel();
		itemEmergente1 = new JMenuItem("Emergente1");
		itemEmergente2 = new JMenuItem("Emergente2");
		menuEmergente.add(itemEmergente1);
		menuEmergente.add(itemEmergente2);
		miPanel.setComponentPopupMenu(menuEmergente);
		add(miPanel);
		
		
	}
}
