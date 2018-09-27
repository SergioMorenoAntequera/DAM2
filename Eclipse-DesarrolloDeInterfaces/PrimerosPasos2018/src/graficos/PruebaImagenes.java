package graficos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PruebaImagenes {

	
	public static void main(String[] args) {
		
		//instanciar la ventana
		VentanaImagen miMarco = new VentanaImagen();
		LaminaImagen panel = new LaminaImagen();
		
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setBackground(Color.RED);
		miMarco.add(panel);
		
		miMarco.setVisible(true);
	}
}

//Crear plantilla de la ventana
class VentanaImagen extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaImagen(){
		
		setBounds(100, 200, 400, 400);
		setTitle("Perimer texto en ventana");

	}
}

//Crer plantilla del panel con el texto
class LaminaImagen extends JPanel {
	private static final long serialVersionUID = 1L;

	//Utilizamos constructor po defecto
	//Vamos a sobreescribir e método paintComponent para escrbir dentro de la lámina
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 26));
		g2.setColor(Color.GREEN);
		g2.drawString("Trabajando Images", 50, 100);
		
		//Vamos a mepezar con ficheros para conseguir la imagen
		File fichero = new File("src/graficos/icono.png");
		try {
			
			Image miImagen = ImageIO.read(fichero);
			g2.drawImage(miImagen, 0, 0, null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Imagen no va");
		}
		
		
	}
}




