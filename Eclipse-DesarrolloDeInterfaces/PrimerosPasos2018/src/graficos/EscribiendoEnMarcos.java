package graficos;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EscribiendoEnMarcos {

	
	public static void main(String[] args) {
		
		//instanciar la ventana
		MarcoVentanaTexto miMarco = new MarcoVentanaTexto();
		LaminaTexto texto = new LaminaTexto();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		miMarco.add(texto);
		
	}
}

//Crear plantilla de la ventana
class MarcoVentanaTexto extends JFrame {
	
	public MarcoVentanaTexto(){
		
		setBounds(100, 200, 400, 400);
		setTitle("Perimer texto en ventana");
		
	}
}

//Crer plantilla del panel
class LaminaTexto extends JPanel {
	
	//Utilizamos constructor po defecto
	//Vamos a sobreescribir e método paintComponent para escrbir dentro de la lámina
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Primer texto en ventana", 50, 100);
		//setBackground(Color.red);
	}
	
}


