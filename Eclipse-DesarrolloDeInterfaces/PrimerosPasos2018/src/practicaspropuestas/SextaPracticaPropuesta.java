package practicaspropuestas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SextaPracticaPropuesta {
	
	//Crea una ventana en la que se muestre un boton con e titulo "saludo" y otro Con el 
	//titulo despedida al pulsar el primero aparecerá un JOptionPane.ShomessageDialog
	//Diciendo hola y en el otro al conrario.
 	
	public static void main(String[] args) {
		Ventana6 miVentana = new Ventana6();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class Ventana6 extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana6() {
		setTitle("PracticaPropuesta6");
		setBounds(200, 200, 300, 300);
		
		Panel6 miPanel = new Panel6();
		add(miPanel);
	}
}

class Panel6 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	JButton bSaludo = new JButton("SALUDO");
	JButton bDespedida = new JButton("DESPEDIDA");
	
	public Panel6() {
		bSaludo.addActionListener(this);
		bDespedida.addActionListener(this);
		
		add(bSaludo);
		add(bDespedida);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bSaludo) 
			JOptionPane.showMessageDialog(null, "HOLA");
		
		if(e.getSource()==bDespedida) 
			JOptionPane.showMessageDialog(null, "ADIOS");	
	}
}