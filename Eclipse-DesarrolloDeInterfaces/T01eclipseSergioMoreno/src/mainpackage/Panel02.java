package mainpackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel02 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	VentanaModal vm = null;
	JLabel etNombre, etApellido, etDireccion, etTelefono;
	JTextField tfNombre, tfApellido, tfDireccion, tfTelefono;
	
	public Panel02(VentanaModal vm) {
		this.vm = vm;
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBackground(new Color(191, 164, 158));
		//this.setSize(vm.getWidth());
		//JLABELS y JTEXTFIELDS
		etNombre = new JLabel("Nombre: ");
		etNombre.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etNombre);
		tfNombre = new JTextField();
		tfNombre.setPreferredSize(new Dimension(200, 30));
		add(tfNombre);
		
		etApellido = new JLabel(" // Apellido: ");
		etApellido.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etApellido);
		tfApellido = new JTextField();
		tfApellido.setPreferredSize(new Dimension(200, 30));
		add(tfApellido);
		
		etDireccion = new JLabel(" // Direccion: ");
		etDireccion.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etDireccion);
		tfDireccion = new JTextField();
		tfDireccion.setPreferredSize(new Dimension(200, 30));
		add(tfDireccion);
		
		etTelefono = new JLabel(" // Telefono: ");
		etTelefono.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etTelefono);
		tfTelefono = new JTextField();
		tfTelefono.setPreferredSize(new Dimension(200, 30));
		add(tfTelefono);
		
	}
}
