package mainpackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Panel03 extends JPanel{
	private static final long serialVersionUID = 1L;
	VentanaModal v;
	Font fuente = new Font("New Times Roman", Font.BOLD, 15);
	public JLabel etFechaEntrada, etFechaSalida, etNumDias, etTipoHabit, etNumHabit, etNinios;
	public JTextField tfFechaEntrada, tfFechaSalida, tfNumDias;
	public JComboBox<String> cbTipoHabitacion;
	public JSpinner sNumHabit;
	
	JPanel ninios;
	public JCheckBox cbNinios;
	public JLabel etEdadNi, etExtras;
	public JSpinner sEdadNi;
	public JTextField tfExtras;
	
	JPanel pImgHotel;
	JLabel imgHotel;
	JTextField tfResultado;
	JButton bImprimir, bAceptar, bCancelar;
	
	
	public Panel03(VentanaModal v) {
		this.v= v;
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		/*
		 * JLabel y JTextField
		 */
		etFechaEntrada = new JLabel("Fecha de entrada: ");
		etFechaEntrada.setBounds(10, 10, 150, 15);
		etFechaEntrada.setFont(fuente);
		this.add(etFechaEntrada);
		tfFechaEntrada = new JTextField();
		tfFechaEntrada.setBounds(150, 7, 150, 25);
		tfFechaEntrada.setFont(fuente);
		this.add(tfFechaEntrada);
		
		etFechaSalida = new JLabel("Fecha de salida: ");
		etFechaSalida.setBounds(10, 40, 150, 15);
		etFechaSalida.setFont(fuente);
		this.add(etFechaSalida);
		tfFechaSalida = new JTextField();
		tfFechaSalida.setBounds(150, 37, 150, 25);
		tfFechaSalida.setFont(fuente);
		this.add(tfFechaSalida);
		
		etNumDias = new JLabel("Numero de días: ");
		etNumDias.setBounds(10, 70, 150, 15);
		etNumDias.setFont(fuente);
		this.add(etNumDias);
		tfNumDias = new JTextField();
		tfNumDias.setEditable(false);
		tfNumDias.setBounds(150, 67, 150, 25);
		tfNumDias.setFont(fuente);
		this.add(tfNumDias);
		
		/*
		 * JLabel y no JTextField
		 */
		etTipoHabit = new JLabel("Tipo de habitación: ");
		etTipoHabit.setBounds(10, 100, 150, 15);
		etTipoHabit.setFont(fuente);
		this.add(etTipoHabit);
		cbTipoHabitacion = new JComboBox<String>();
		cbTipoHabitacion.addItem("Simple");
		cbTipoHabitacion.addItem("Double");
		cbTipoHabitacion.addItem("Suite");
		cbTipoHabitacion.setBounds(150, 97, 150, 25);
		cbTipoHabitacion.setFont(fuente);
		this.add(cbTipoHabitacion);
		
		etNumHabit = new JLabel("Numero de habitaciones: ");
		etNumHabit.setBounds(10, 130, 180, 15);
		etNumHabit.setFont(fuente);
		this.add(etNumHabit);
		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 50, 1);
		sNumHabit = new JSpinner(model1);
		sNumHabit.setBounds(200, 127, 60, 25);
		this.add(sNumHabit);
		
		/*
		 * Panel de niños
		 */
		etNinios = new JLabel("¿Niños? ");
		etNinios.setBounds(10, 160, 150, 15);
		etNinios.setFont(fuente);
		this.add(etNinios);
		cbNinios = new JCheckBox();
		cbNinios.setOpaque(false);
		cbNinios.setBounds(80, 157, 20, 20);
		this.add(cbNinios);
		
		ninios = new JPanel();
		ninios.setLayout(null);
		ninios.setEnabled(false);
		ninios.setBackground(Color.LIGHT_GRAY);
		ninios.setBounds(10, 190, 200, 150);
		this.add(ninios);
		etEdadNi = new JLabel("Edad del niño:");
		etEdadNi.setBounds(60, 10, 150, 15);
		ninios.add(etEdadNi);
		SpinnerNumberModel model2 = new SpinnerNumberModel(1, 1, 14, 1);
		sEdadNi = new JSpinner(model2);
		sEdadNi.setBounds(80, 37, 40, 20);
		ninios.add(sEdadNi);
		
		etExtras = new JLabel("Tipo de cama:");
		etExtras.setBounds(60, 70, 150, 30);
		ninios.add(etExtras);
		tfExtras = new JTextField();
		tfExtras.setEditable(false);
		tfExtras.setBounds(23, 100, 150, 30);
		ninios.add(tfExtras);
		
		/*
		 * foto y resultado
		 */
		pImgHotel = new JPanel();
		pImgHotel.setBackground(Color.WHITE);
		pImgHotel.setBounds(325, 20, 300, 300);
		this.add(pImgHotel);
		imgHotel = new JLabel(new ImageIcon("hotel.jpg"));
		//imgHotel.setPreferredSize(new Dimension(20, 20));
		pImgHotel.add(imgHotel);
		
		//Casilla con el precio final y botones
		tfResultado = new JTextField();
		tfResultado.setBounds(325, 350, 300, 50);
		this.add(tfResultado);
		bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(325, 325, 50, 30);
		this.add(bAceptar);
		bCancelar = new JButton("Cancelar");
		bImprimir = new JButton("Imprimir");
		
	}
	
	public void activarNinios() {
		if(!cbNinios.isSelected()) {
			
		}
	}
	
}
