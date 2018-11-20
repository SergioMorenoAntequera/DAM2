package mainpackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Panel03 extends JPanel{
	private static final long serialVersionUID = 1L;
	VentanaModal v;
	Font fuente = new Font("New Times Roman", Font.BOLD, 15);
	public JLabel etFechaEntrada, etFechaSalida, etNumDias, etTipoHabit, etNumHabit, etNinios;
	public JTextField tfFechaEntrada, tfFechaSalida, tfNumDias;
	public JComboBox<String> cbTipoHabitacion;
	public JSpinner sNumHabit;
	DateTimeFormatter dtf;
	LocalDateTime now;
	String fechaAhora;
	
	JPanel ninios;
	public JCheckBox cbNinios;
	public JLabel etEdadNi, etExtras;
	public JSpinner sEdadNi;
	public JTextField tfExtras;
	int edad=0;
	
	JPanel pImgHotel;
	JLabel imgHotel;
	JTextField tfResultado;
	JButton bImprimir, bAceptar, bCancelar;
	int precio=0;
	
	public Panel03(VentanaModal v) {
		this.v= v;
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setBackground(new Color(147, 211, 243));
		
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
		
		dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		now = LocalDateTime.now();  
		fechaAhora = dtf.format(now);
		tfFechaEntrada.setText(fechaAhora); 
		int dia1 = Integer.parseInt(fechaAhora.substring(0,2));
		this.add(tfFechaEntrada);
		
		etFechaSalida = new JLabel("Fecha de salida: ");
		etFechaSalida.setBounds(10, 40, 150, 15);
		etFechaSalida.setFont(fuente);
		this.add(etFechaSalida);
		tfFechaSalida = new JTextField();
		tfFechaSalida.setBounds(150, 37, 150, 25);
		tfFechaSalida.setFont(fuente);
		int dia2 = dia1+1;
		System.out.println(dia1);
		System.out.println(dia2);
		if(dia2 < 10) {
			tfFechaSalida.setText(dia2 +  "/" + fechaAhora.substring(2));
		}  else {
			tfFechaSalida.setText(dia2 +  "/" + fechaAhora.substring(3));
		}
		
		this.add(tfFechaSalida);
		
		etNumDias = new JLabel("Numero de días: ");
		etNumDias.setBounds(10, 70, 150, 15);
		etNumDias.setFont(fuente);
		this.add(etNumDias);
		tfNumDias = new JTextField("1");
		tfNumDias.setEditable(false);
		tfNumDias.setBounds(150, 67, 150, 25);
		tfNumDias.setFont(fuente);
		this.add(tfNumDias);
		
		//ACCIONES
		tfFechaSalida.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				int auxDia1 = Integer.parseInt(tfFechaEntrada.getText().substring(0, 2));
				int auxDia2 = Integer.parseInt(tfFechaSalida.getText().substring(0, 2));
				tfNumDias.setText(auxDia2-auxDia1+"");
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		tfFechaEntrada.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				int auxDia1 = Integer.parseInt(tfFechaEntrada.getText().substring(0, 2));
				int auxDia2 = Integer.parseInt(tfFechaSalida.getText().substring(0, 2));
				tfNumDias.setText(auxDia2-auxDia1+"");
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		
		
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
		ninios.setVisible(false);
		cbNinios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbNinios.isSelected()) {
					ninios.setVisible(true);
				} else {
					ninios.setVisible(false);
				}
			}
		});
		
		ninios.setLayout(null);
		ninios.setBackground(Color.LIGHT_GRAY);
		ninios.setBounds(10, 190, 200, 150);
		this.add(ninios);
		etEdadNi = new JLabel("Edad del niño:");
		etEdadNi.setBounds(60, 10, 150, 15);
		ninios.add(etEdadNi);
		SpinnerNumberModel model2 = new SpinnerNumberModel(1, 1, 14, 1);
		sEdadNi = new JSpinner(model2);
		sEdadNi.setBounds(80, 37, 40, 20);
		sEdadNi.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// Ponemos el valor del JSpinner en el JTextField
				edad = Integer.parseInt(sEdadNi.getValue().toString());
				if(edad <= 4) {
					tfExtras.setText("Cuna");
				} else {
					if (edad <= 10) {
						tfExtras.setText("Cama supletoria pequeña");
					} else {
						if (edad <= 14) {
							tfExtras.setText("Cama supletoria Normal");
						}
					}
				}
			}
		});
		
		ninios.add(sEdadNi);
		
		etExtras = new JLabel("Tipo de cama:");
		etExtras.setBounds(60, 70, 150, 30);
		ninios.add(etExtras);
		tfExtras = new JTextField("Cuna");
		tfExtras.setEditable(false);
		tfExtras.setBounds(23, 100, 150, 30);
		ninios.add(tfExtras);
		
		/*
		 * Foto y resultado
		 */
		pImgHotel = new JPanel();
		pImgHotel.setBackground(Color.WHITE);
		pImgHotel.setBounds(325, 20, 300, 300);
		this.add(pImgHotel);
		imgHotel = new JLabel(new ImageIcon("hotel.jpg"));
		pImgHotel.add(imgHotel);
		
		//Casilla con el precio final y botones
		tfResultado = new JTextField();
		tfResultado.setBounds(325, 350, 300, 50);
		tfResultado.setEditable(false);
		tfResultado.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			@Override
			public void focusGained(FocusEvent e) {
				calcularPrecio();
			}
		});
		tfResultado.setFont(fuente);
		this.add(tfResultado);
		bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(325, 425, 125, 30);
		bAceptar.addActionListener(e -> AceptarClick());
		this.add(bAceptar);
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(500, 425, 125, 30);
		bCancelar.addActionListener(e -> reiniciarDatos());
		this.add(bCancelar);
		bImprimir = new JButton("Imprimir");
		bImprimir.setBounds(415, 470, 125, 30);
		bImprimir.addActionListener(e -> escribir());
		this.add(bImprimir);
		
	}
	public void escribir() {
		String cadena1, cadena2;
		cadena1 = "Nombre: " + v.Panel02.tfNombre.getText() +
				"\nApellido: " + v.Panel02.tfApellido.getText() +
				"\nDirección: " + v.Panel02.tfDireccion.getText() +
				"\nTeléfono: " + v.Panel02.tfTelefono.getText();
		v.panel04.area1.setText(cadena1);
		
		String aux = "";
		if (v.panel03.cbTipoHabitacion.getSelectedIndex() == 0) {
			aux = "Simple";
		}
		if (v.panel03.cbTipoHabitacion.getSelectedIndex() == 1) {
			aux = "Doble";
		}
		if (v.panel03.cbTipoHabitacion.getSelectedIndex() == 2) {
			aux = "Suit";
		}
		
		
		cadena2 = "Fecha entrada: " + v.panel03.tfFechaEntrada.getText() + 
				"\nFecha salida: " + v.panel03.tfFechaSalida.getText() + 
				"\nNumero dias: " + v.panel03.tfNumDias.getText() + 
				"\nOpcion tipo habitacion: " + aux + 
				"\nNumero habitaciones: " + v.panel03.sNumHabit.getValue().toString();
		v.panel04.area2.setText(cadena2);
			
	}
	
	public void calcularPrecio() {
		int numDias = Integer.parseInt(tfNumDias.getText());
		precio += numDias*50;
		if(cbTipoHabitacion.getSelectedIndex() == 0) {
			precio += 50;
		}
		if(cbTipoHabitacion.getSelectedIndex() == 1) {
			precio += 70;
		}
		if(cbTipoHabitacion.getSelectedIndex() == 2) {
			precio += 125;
		}
		if(tfExtras.getText().equalsIgnoreCase("Cuna") && tfExtras.getText().equalsIgnoreCase("Cama supletoria pequeña") && 
				tfExtras.getText().equalsIgnoreCase("Cama supletoria Normal")) {
			precio += 20;
		}
		tfResultado.setText(precio + "€");
	}
	
	public void AceptarClick() {
		if(!v.Panel02.tfNombre.getText().equalsIgnoreCase("") && !v.Panel02.tfApellido.getText().equalsIgnoreCase("") 
				&& !v.Panel02.tfDireccion.getText().equalsIgnoreCase("") && !v.Panel02.tfTelefono.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Informacion correcta", "Registro completado", JOptionPane.CANCEL_OPTION);
			reiniciarDatos();
		} else {
			JOptionPane.showMessageDialog(this, "Informacion mal introducida", "Fallo", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void reiniciarDatos() {
		v.Panel02.tfNombre.setText("");
		v.Panel02.tfApellido.setText("");
		v.Panel02.tfDireccion.setText("");
		v.Panel02.tfTelefono.setText("");
		
		v.panel03.tfFechaEntrada.setText(fechaAhora);
		v.panel03.tfFechaSalida.setText(fechaAhora);
			int dia1 = Integer.parseInt(fechaAhora.substring(0,2));
			int dia2 = dia1+1;
			System.out.println(dia1);
			System.out.println(dia2);
			if(dia2 < 10) {
				tfFechaSalida.setText(dia2 +  "/" + fechaAhora.substring(2));
			}  else {
				tfFechaSalida.setText(dia2 +  "/" + fechaAhora.substring(3));
			}
		v.panel03.tfNumDias.setText("1");
		v.panel03.cbTipoHabitacion.setSelectedIndex(0);
		v.panel03.sNumHabit.setValue(1);
		v.panel03.cbNinios.setSelected(false);
		v.panel03.ninios.setVisible(false);
		v.panel03.sEdadNi.setValue(1);
		v.panel03.tfExtras.setText("");
		
		v.panel04.area1.setText("");
		v.panel04.area2.setText("");
	}

	
}
