package mainpackage;
import java.awt.*;
import javax.swing.BoxLayout;
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
				
		this.setBackground(new Color(147, 211, 243));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200, 50));
		
		
		etNombre = new JLabel("Nombre: ");
		etNombre.setBounds(50, 10, 200, 20);
		etNombre.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etNombre);
		tfNombre = new JTextField();
		tfNombre.setBounds(10, 40, 170, 30);
		tfNombre.setPreferredSize(new Dimension(30, 30));
		add(tfNombre);
		
		etApellido = new JLabel("Apellido: ");
		etApellido.setBounds(50, 100, 200, 20);
		etApellido.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etApellido);
		tfApellido = new JTextField();
		tfApellido.setBounds(10, 130, 170, 30);
		tfApellido.setPreferredSize(new Dimension(30, 30));
		add(tfApellido);
		
		etDireccion = new JLabel("Direccion: ");
		etDireccion.setBounds(50, 190, 200, 20);
		etDireccion.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etDireccion);
		tfDireccion = new JTextField();
		tfDireccion.setBounds(10, 220, 170, 30);
		tfDireccion.setPreferredSize(new Dimension(30, 30));
		add(tfDireccion);
		
		etTelefono = new JLabel("Telefono: ");
		etTelefono.setBounds(50, 280, 200, 20);
		etTelefono.setFont(new Font("Calibri", Font.PLAIN, 25));
		add(etTelefono);
		tfTelefono = new JTextField();
		tfTelefono.setBounds(10, 310, 170, 30);
		tfTelefono.setPreferredSize(new Dimension(30, 30));
		add(tfTelefono);
		
	}
}
