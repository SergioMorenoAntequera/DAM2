package practicaspropuestas;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TerceraPracticaPropuesta {

	
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
	private static final long serialVersionUID = 1L;

	public MarcoVentanaTexto(){
		
		setBounds(100, 200, 400, 300);
		setTitle("Tercera Practica Propuesta");
		BorderLayout bl = new BorderLayout();
		
	}
}

//Crer plantilla del panel
class LaminaTexto extends JPanel {
	private static final long serialVersionUID = 1L;

	//Utilizamos constructor po defecto
	//Vamos a sobreescribir e m�todo paintComponent para escrbir dentro de la l�mina
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Cabecera", 150, 10);
		g.drawString("Pie", 150, 200);
		//setBackground(Color.red);
	}
	
}


