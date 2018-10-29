package graficos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {

	
	public static void main(String[] args) {
		
		//instanciar la ventana
		VentanaColor miMarco = new VentanaColor();
		panel01Color panel = new panel01Color();
		
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setBackground(Color.RED);
		miMarco.add(panel);
		
		miMarco.setVisible(true);
	}
}

//Crear plantilla de la ventana
class VentanaColor extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaColor(){
		
		setBounds(100, 200, 400, 400);
		setTitle("Perimer texto en ventana");

	}
}

//Crer plantilla del panel con el texto
class panel01Color extends JPanel {
	private static final long serialVersionUID = 1L;

	//Utilizamos constructor po defecto
	//Vamos a sobreescribir e método paintComponent para escrbir dentro de la lámina
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Empezamos el color", 50, 50);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.CYAN); //Al objeto g2 le cambiamos el color de dibujo
		g2.drawString("Ahora el texto el color cyan", 50, 70);
		
		//Instanciamos un color
		Color color1 = new Color(10, 100, 20);
		Rectangle2D rectangulo1 = new Rectangle2D.Double(100, 100, 200, 150); //Color verde claro
		g2.setPaint(color1);
		g2.draw(rectangulo1);
		g2.setPaint(new Color(155)); //Color azul oscuro
		g2.fill(rectangulo1);
		g2.setPaint(new Color(100).brighter().brighter());
		Ellipse2D elipse = new Ellipse2D.Double(200, 200, 150, 150);
		//Fill the dibuja el interior y draw el contorno
		//NO HACE FALTA DRAW PARA PONER FILL
		g2.fill(elipse);
		g2.setPaint(Color.RED.darker().darker());
		g2.draw(elipse);
		
	}
}




