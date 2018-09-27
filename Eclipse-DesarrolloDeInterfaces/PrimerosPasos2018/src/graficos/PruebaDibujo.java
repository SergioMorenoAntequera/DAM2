package graficos;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {

	
	public static void main(String[] args) {
		
		//instanciar la ventana
		Ventana miMarco = new Ventana();
		panel01 panel01 = new panel01();
		
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		miMarco.add(panel01);
		
	}
}

//Crear plantilla de la ventana
class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ventana(){
		
		setBounds(100, 200, 400, 400);
		setTitle("Perimer texto en ventana");
		
	}
}

//Crer plantilla del panel con el texto
class panel01 extends JPanel {
	private static final long serialVersionUID = 1L;

	//Utilizamos constructor po defecto
	//Vamos a sobreescribir e método paintComponent para escrbir dentro de la lámina
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*******Dibujos básicos con Graphics normal
		g.drawString("Primer texto en ventana", 10, 10);
		g.drawLine(10, 10, 00, 400);
		g.drawArc(50, 100, 200, 75, 120, 150);
		*********/
		
		//******A partir de aquí usaremos la clase Graphics2D para dibujar*******
		//Obtenemos un objeto grapich 2D a traves de casting
		Graphics2D g2 = (Graphics2D) g;
		//No podemos instaciar directamente la clase rectangulo 2D porque son abstractas
		//por el principio de Liskov instaciamos a traves de una subclase Rectangle2D
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.draw(rectangulo);
		
		//Creamos un objeto elipse 2D
		Ellipse2D elipse = new Ellipse2D. Double(100, 100, 200, 150);
		g2.draw(elipse);
		
		//Creamos una linea *** el resto también se puede hacer asi para escribir menos
		g2.draw(new Line2D.Double(100, 100, 300, 250));
	}
}




