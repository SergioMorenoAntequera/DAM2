package jOptionPane;
import javax.swing.JOptionPane;

public class ShowMenssageDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Mensaje metodo con 2 argumentos");
		JOptionPane.showMessageDialog(null, "Mensaje ERROR MENSAGE", "Mensaje en la barra", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "Mensaje ERROR MENSAGE", "Mensaje en la barra", JOptionPane.INFORMATION_MESSAGE);
		
		
	}
}
