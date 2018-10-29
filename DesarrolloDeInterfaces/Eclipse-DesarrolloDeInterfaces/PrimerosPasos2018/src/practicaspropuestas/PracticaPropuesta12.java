package practicaspropuestas;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class PracticaPropuesta12 {
	
	/*
	 * Crea una calculadora que sume los dos valores introducidos en dos campos de texto, 
	 * y el cálculo aparezca en un tercer campo en el momento que uno de los campos gane o
	 *  pierdan el foco. Trata el posible error que se pueda generar al convertir String en Float.
	 */
	public static void main(String[] args) {
		Ventana13 miVentana = new Ventana13();
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.setVisible(true);
	}
}

class Ventana12 extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana12() {
		setTitle("Practica Propuesta 12");
		setBounds(200, 200, 400, 400);
		Panel13 panel = new Panel13();
		add(panel);
	}
}

class Panel12 extends JPanel implements FocusListener{
	private static final long serialVersionUID = 1L;
	
	JTextField tfNum1, tfNum2, tfRes;
	JLabel lNum1, lNum2, lRes, lerror;
	int num1, num2;
	
	Panel12(){
		
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
		
		tfNum1.addFocusListener(this);
		tfNum2.addFocusListener(this);
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == tfNum1) {
			try {
				num1 = Integer.parseInt(tfNum1.getText());
				num2 = Integer.parseInt(tfNum2.getText());
				tfRes.setText((num1 + num2) + "");
			} catch (Exception e2) {
			}
		}
		if(e.getSource() == tfNum2) {
			try {
				num1 = Integer.parseInt(tfNum1.getText());
				num2 = Integer.parseInt(tfNum2.getText());
				tfRes.setText((num1 + num2) + "");
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == tfNum1) {
			try {
				num1 = Integer.parseInt(tfNum1.getText());
				num2 = Integer.parseInt(tfNum2.getText());
				tfRes.setText((num1 + num2) + "");
			} catch (Exception e2) {
			}
		}
		if(e.getSource() == tfNum2) {
			try {
				num1 = Integer.parseInt(tfNum1.getText());
				num2 = Integer.parseInt(tfNum2.getText());
				tfRes.setText((num1 + num2) + "");
			} catch (Exception e2) {
			}
		}		
	}
}
