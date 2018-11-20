package mainpackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Panel02 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	VentanaModal vm = null;
	JLabel etCodigo, etMarca, etTipoMotor, etTipoVehiculo, etTipoCambio;
	JTextField tfCodigo, tfMarca;
	ButtonGroup gpTipoMotor;
	JRadioButton rbGasolina, rbDiesel, rbHibrido, rbElectricos;
	JComboBox<String> cbTipoMotor, cbTipoVehiculo, cbTipoCambio;
	
	public Panel02(VentanaModal vm) {
		this.vm = vm;
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
				
		this.setBackground(new Color(147, 211, 243));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200, 50));
		
		etCodigo = new JLabel("Codigo: ");
		etCodigo.setBounds(50, 10, 200, 20);
		Font fuente = new Font("Calibri", Font.PLAIN, 25);
		etCodigo.setFont(fuente);
		add(etCodigo);
		tfCodigo = new JTextField();
		tfCodigo.setBounds(10, 40, 170, 30);
		tfCodigo.setPreferredSize(new Dimension(30, 30));
		add(tfCodigo);
		
		etMarca = new JLabel("Marca: ");
		etMarca.setBounds(50, 100, 200, 20);
		etMarca.setFont(fuente);
		add(etMarca);
		tfMarca = new JTextField();
		tfMarca.setBounds(10, 130, 170, 30);
		tfMarca.setPreferredSize(new Dimension(30, 30));
		add(tfMarca);
		
		etTipoMotor = new JLabel("Tipo de motor: ");
		etTipoMotor.setBounds(10, 190, 200, 20);
		etTipoMotor.setFont(fuente);
		add(etTipoMotor);
		gpTipoMotor = new ButtonGroup();
		rbGasolina = new JRadioButton("Gasolina");
		rbDiesel = new JRadioButton("Diesel");
		rbHibrido = new JRadioButton("Hibrido");
		rbElectricos = new JRadioButton("Electrico");
		rbGasolina.setOpaque(false);
		rbDiesel.setOpaque(false);
		rbHibrido.setOpaque(false);
		rbElectricos.setOpaque(false);
		gpTipoMotor.add(rbGasolina);
		gpTipoMotor.add(rbDiesel);
		gpTipoMotor.add(rbHibrido);
		gpTipoMotor.add(rbElectricos);
		rbGasolina.setBounds(10, 220, 80, 15);
		rbDiesel.setBounds(90, 220, 70, 15);
		rbHibrido.setBounds(10, 240, 70, 15);
		rbElectricos.setBounds(90, 240, 80, 15);
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbGasolina.isSelected() && cbTipoVehiculo.getSelectedIndex()==0 || 
						rbDiesel.isSelected() && cbTipoVehiculo.getSelectedIndex()==1) {
					cbTipoCambio.setEnabled(true);
				} else {
					cbTipoCambio.setEnabled(false);
				}
			}
		};
		rbGasolina.addActionListener(al);
		rbDiesel.addActionListener(al);
		rbHibrido.addActionListener(al);
		rbElectricos.addActionListener(al);
		rbGasolina.setSelected(true);
		this.add(rbGasolina);
		this.add(rbDiesel);
		this.add(rbHibrido);
		this.add(rbElectricos);
		
		etTipoVehiculo = new JLabel("Tipo de vehiculo");
		etTipoVehiculo.setBounds(10, 280, 200, 20);
		etTipoVehiculo.setFont(fuente);
		add(etTipoVehiculo);
		cbTipoVehiculo = new JComboBox<String>();
		cbTipoVehiculo.addItem("Turismo");
		cbTipoVehiculo.addItem("Monovolumen");
		cbTipoVehiculo.addItem("SUV");
		cbTipoVehiculo.addItem("Todoterreno");
		cbTipoVehiculo.setBounds(10, 310, 170, 30);
		cbTipoVehiculo.setPreferredSize(new Dimension(30, 30));
		cbTipoVehiculo.addActionListener(al);
		add(cbTipoVehiculo);
		
		etTipoCambio = new JLabel("Tipo de Cambio");
		etTipoCambio.setBounds(10, 360, 200, 20);
		etTipoCambio.setFont(fuente);
		add(etTipoCambio);
		cbTipoCambio = new JComboBox<String>();
		cbTipoCambio.addItem("Manual");
		cbTipoCambio.addItem("Automatico");
		cbTipoCambio.setBounds(10, 390, 170, 30);
		cbTipoCambio.setPreferredSize(new Dimension(30, 30));
		add(cbTipoCambio);
		
		
	}
}
