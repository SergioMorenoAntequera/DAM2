package graficos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoFuentes {

	
	public static void main(String[] args) {
		
		//instanciar la ventana
		VentanaFuente miMarco = new VentanaFuente();
		panel01Fuente panel = new panel01Fuente();
		
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setBackground(Color.RED);
		miMarco.add(panel);
		
		miMarco.setVisible(true);
	}
}

//Crear plantilla de la ventana
class VentanaFuente extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaFuente(){
		
		setBounds(100, 200, 400, 400);
		setTitle("Perimer texto en ventana");

	}
}

//Crer plantilla del panel con el texto
class panel01Fuente extends JPanel {
	private static final long serialVersionUID = 1L;

	//Utilizamos constructor po defecto
	//Vamos a sobreescribir e método paintComponent para escrbir dentro de la lámina
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Empezamos la fuente", 50, 50);
		
		Graphics2D g2 = (Graphics2D) g;
		//Igual que los colores epro con Font 
		Font miFuente = new Font("Arial", Font.ITALIC, 20);
		g2.setFont(miFuente);
		g2.setColor(Color.GREEN);
		g2.drawString("Probando las fuentes", 50, 100);
		
		
		
		
		
	}
}




