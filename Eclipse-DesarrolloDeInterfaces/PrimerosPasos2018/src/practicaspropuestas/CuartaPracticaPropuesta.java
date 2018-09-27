package practicaspropuestas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class CuartaPracticaPropuesta {

	//Cra una ventana en la que se muestre un cartel de prohibido utilizar moviles en clase. 
	//Crea el texto con un tipo de letra grande visible y en un color destaca, crea un objeto tipo
	//rectangulo y tachalo con una linea (Hace un movil y TAL)
	public static void main(String[] args) {
		
		//instanciar la ventana
		VentanaFuente miMarco = new VentanaFuente();
		Dibujo dibujo = new Dibujo();
		
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setBackground(Color.RED);
		miMarco.add(dibujo);
		
		miMarco.setVisible(true);
	}	
}

//Crear plantilla de la ventana
class VentanaFuente extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaFuente(){
			
		setBounds(100, 200, 400, 600);
		setTitle("Prohibido usar el teléfono");
	}
}

//Creamos plantilla para el dibujo
class Dibujo extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//Texto
		Font miFuente = new Font("Impact", Font.ITALIC, 20);
		g.setFont(miFuente);
		g.setColor(Color.RED);
		g.drawString("NO USAR", 150, 50);
		
		//Telefono
		g2.setColor(Color.black);
		Rectangle2D marco = new Rectangle2D.Double(100, 75, 200, 400);
		g2.fill(marco);
		//Pantalla
		g2.setColor(Color.WHITE);
		Rectangle2D pantalla = new Rectangle2D.Double(110, 90, 180, 300);
		g2.fill(pantalla);
		//Boton
		g2.setColor(Color.CYAN);
		Ellipse2D boton = new Ellipse2D. Double(185, 425, 30, 30);
		g2.fill(boton);
		
		//Simbolo de prohibido
		g2.setColor(Color.RED);
		Ellipse2D prohibido = new Ellipse2D. Double(50, 100, 300, 300);
		g2.setStroke(new BasicStroke(50f));
		g2.draw(prohibido);
		
		g2.draw(new Line2D.Double(125, 150, 300, 350));
	}
}

