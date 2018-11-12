package mainpackage;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {
	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Ventana ventana = new Ventana();
		ventana.setLocationRelativeTo(null); //Centrada
		ventana.setTitle("Gestion Hotel SergioMoreno");
		
		
		
	}
}
