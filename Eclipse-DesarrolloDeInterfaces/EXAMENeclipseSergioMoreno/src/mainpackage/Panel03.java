package mainpackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Panel03 extends JPanel{
	private static final long serialVersionUID = 1L;
	VentanaModal v;
	Font fuente = new Font("New Times Roman", Font.BOLD, 15);
	public JLabel etFechaEntrada, etNombreProveedor, etNumContacto, etPrecioCoste, etPVP;
	public JTextField tfFechaEntrada, tfNombreProveedor, tfNumContacto, tfPrecioCoste, tfPVP;
    JSpinner sFechaAlta;
    
	JPanel pImgHotel;
	JLabel imgHotel, imgLogo;
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
		
		//FECHA DE ENTRADA
		etFechaEntrada = new JLabel("Fecha de entrada: ");
		etFechaEntrada.setBounds(10, 10, 150, 15);
		etFechaEntrada.setFont(fuente);
		this.add(etFechaEntrada);
		
		SpinnerModel modeloFecha = new SpinnerDateModel();
		sFechaAlta = new JSpinner(modeloFecha);
	    sFechaAlta.setBounds(150, 7, 150, 25);
	    sFechaAlta.setFont(fuente);
	    this.add(sFechaAlta);

	    //NOMBRE DEL PROVEEDOR
	    etNombreProveedor = new JLabel("Nombre proveedor: ");
	    etNombreProveedor.setBounds(10, 40, 150, 15);
	    etNombreProveedor.setFont(fuente);
		this.add(etNombreProveedor);
		
		tfNombreProveedor = new JTextField();
		tfNombreProveedor.setBounds(150, 37, 150, 25);
		this.add(tfNombreProveedor);
		
		//TELEFONO DE CONTACTO
		etNumContacto = new JLabel("Telefono contacto: ");
		etNumContacto.setBounds(10, 70, 150, 15);
		etNumContacto.setFont(fuente);
		this.add(etNumContacto);
		tfNumContacto = new JTextField();
		tfNumContacto.setBounds(150, 67, 150, 25);
		this.add(tfNumContacto);
		
		//PRECIO DE COSTE
		etPrecioCoste = new JLabel("Precio coste: ");
		etPrecioCoste.setBounds(10, 100, 150, 15);
		etPrecioCoste.setFont(fuente);
		this.add(etPrecioCoste);
		tfPrecioCoste = new JTextField();
		tfPrecioCoste.setBounds(150, 97, 150, 25);
		this.add(tfPrecioCoste);
		
		//PVP
		etPVP = new JLabel("P.V.P: ");
		etPVP.setBounds(10, 130, 150, 15);
		etPVP.setFont(fuente);
		this.add(etPVP);
		tfPVP = new JTextField();
		tfPVP.setBounds(150, 127, 150, 25);
		this.add(tfPVP);
		tfPVP.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				try{
					int pvp = Integer.parseInt(tfPVP.getText());
					if(pvp > 50000) {
						tfPVP.setText("50000€");
					} else {
						tfPVP.setText(pvp + "€");
					}
				} catch (Exception e) {
					tfPVP.setText("");
				}

			}
			public void focusGained(FocusEvent arg0) {}
		});
		
		/*
		 * Foto y resultado
		 */
		pImgHotel = new JPanel();
		pImgHotel.setBackground(Color.WHITE);
		pImgHotel.setBounds(325, 20, 300, 300);
		this.add(pImgHotel);
		imgHotel = new JLabel(new ImageIcon("hotel.jpg"));
		imgLogo =  new JLabel(new ImageIcon("logoHotel.jpg"));
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
				//calcularPrecio();
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
	}
	
	
	public void AceptarClick() {
		v.Panel02.tfCodigo.setText("");
		v.Panel02.tfMarca.setText("");
		v.Panel02.rbGasolina.setSelected(true);
		v.Panel02.cbTipoVehiculo.setSelectedIndex(0);
				
		v.panel03.sFechaAlta.setValue(new Date());
		v.panel03.tfNombreProveedor.setText("");
		v.panel03.tfNumContacto.setText("");
		v.panel03.tfPrecioCoste.setText("");
		v.panel03.tfPVP.setText("");
		JOptionPane.showMessageDialog(this, "Datos guardados correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void reiniciarDatos() {
		v.Panel02.tfCodigo.setText("");
		v.Panel02.tfMarca.setText("");
		v.Panel02.rbGasolina.setSelected(true);
		v.Panel02.cbTipoVehiculo.setSelectedIndex(0);
				
		v.panel03.sFechaAlta.setValue(new Date());
		v.panel03.tfNombreProveedor.setText("");
		v.panel03.tfNumContacto.setText("");
		v.panel03.tfPrecioCoste.setText("");
		v.panel03.tfPVP.setText("");
	}
}
