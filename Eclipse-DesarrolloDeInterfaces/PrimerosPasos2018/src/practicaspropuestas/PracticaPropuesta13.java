package practicaspropuestas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticaPropuesta13 {

	/*
	 * Crea una calculadora que sume los dos valores introducidos en dos campos de texto y ponga el resultado
en un tercer campo de texto al hacer clic sobre un botón llamado suma y cuando se presione la
combinación de teclas “ctrl + s”. Indica con un cuadro emergente la función del botón. Incluye en el boton
un icono. Trata el posible error que se pueda generar al convertir String en Float.
	 */
	public static void main(String[] args) {
		Ventana13 miVentana = new Ventana13();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class Ventana13 extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana13() {
		setTitle("Practica Propuesta 13");
		setBounds(200, 200, 400, 300);
		Panel13 panel = new Panel13();
		add(panel);
	}
}

class Panel13 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JTextField tfNum1, tfNum2, tfRes;
	JLabel lNum1, lNum2, lRes, lerror;
	JButton bSumar;
	int num1, num2;
	
	Panel13(){
		
		//****JLabel*****
		setLayout(null);
		lNum1 = new JLabel("Numero 1: ");
		lNum2 = new JLabel("Numero 2: ");
		lRes = new JLabel("Resultado: ");
		//lerror = new JLabel("****");
		
		lNum1.setBounds(10, 10, 70, 30);
		lNum2.setBounds(10, 50, 70, 30);
		lRes.setBounds(190, 30, 70, 30);
		//lerror.setBounds(120, 90, 200, 30);
		
		add(lNum1);
		add(lNum2);
		add(lRes);
		//add(lerror);
		
		
		//****JTextField****
		tfNum1 = new JTextField();
		tfNum2 = new JTextField();
		tfRes = new JTextField();
		
		tfNum1.setBounds(80, 10, 100, 30);
		tfNum2.setBounds(80, 50, 100, 30);
		tfRes.setBounds(260, 30, 100, 30);
		
		
		tfRes.setEditable(false);
		add(tfNum1);
		add(tfNum2);
		add(tfRes);
		
		//*****JButtons*****
		ImageIcon icono = new ImageIcon("src/practicaspropuestas/ILibre.png");
		bSumar = new JButton("Sumar", icono);
		
		bSumar.setBounds(180, 100, 125, 40);
		bSumar.setMnemonic(KeyEvent.VK_X);
		
		add(bSumar);
		bSumar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bSumar) {
					try {
						num1 = Integer.parseInt(tfNum1.getText());
						num2 = Integer.parseInt(tfNum2.getText());
						JOptionPane.showMessageDialog(null,"Resultado: " + num1 + num2);
						} catch (Exception e2) {
					}
				}
			}
		});
		
		
		
	}

	

}
