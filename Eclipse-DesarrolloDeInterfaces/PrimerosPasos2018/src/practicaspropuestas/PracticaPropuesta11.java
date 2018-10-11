package practicaspropuestas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PracticaPropuesta11 {

	/*
	 * Crea una ventana que contenga 2 botones, el boton “Curso de Java Inicial” y el boton 
	 * “Curso de Java avanzado”, al pulsar en cada uno de ellos en el título de la ventan 
	 * aparacera el nombre del botón. Utiliza clases internas anónimas para implementar las 
	 * interfaces de eventos.
	 */
	static Ventana11 miVentana;
	
	public static void main(String[] args) {
		miVentana = new Ventana11();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}


class Ventana11 extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana11() {
		setTitle("PracticaPropuesta11");
		setBounds(200, 200, 350, 100);
		
		Panel11 miPanel = new Panel11();
		add(miPanel);
	}
}

class Panel11 extends JPanel{
	private static final long serialVersionUID = 1L;

	static JButton bBasico = new JButton("Curso de java Inicial");
	static JButton bAvanzado = new JButton("Curso de java avanzado");
		
	//Constructor del panel
	public Panel11() {
		
		//Añadimos el actios luisytener desde una clase interna y anonima
		bBasico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PracticaPropuesta11.miVentana.setTitle(Panel11.bBasico.getText());				
			}
		});
		
		//Añadimos el actios luisytener desde una clase interna y anonima
		bAvanzado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PracticaPropuesta11.miVentana.setTitle(Panel11.bAvanzado.getText());				
			}
		});
			
		add(bBasico);
		add(bAvanzado);
	}
}
