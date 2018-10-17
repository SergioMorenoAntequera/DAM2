package componentesAtomicos;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaPrinicipal extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel contenedor;
	private JLabel labelTitulo, etiquetaLabel, etiquetaBoton, etiquetaTongleButton, etiquetaCheckBox;
	private JButton boton;
	private JCheckBox checkBox1, checkBox2;
	private JRadioButton radio1, radio2; private ButtonGroup grupoRadios;
	
	
	public VentanaPrinicipal() {
		iniciarComponentes();
		setTitle("Swing : Componentes Atomicos");
		setSize(630, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	private void iniciarComponentes() {
		
		contenedor = new JPanel();
		contenedor.setLayout(null);
		labelTitulo = new JLabel("Componentes Atomicos");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelTitulo.setBounds(180, 5, 380, 40);
		
		etiquetaLabel = new JLabel("Esto es una etiqueta");
		etiquetaLabel.setBounds(20, 50, 280, 23);
		
		etiquetaBoton = new JLabel("JButton: ");
		etiquetaBoton.setBounds(20, 80, 280, 23);
		
		etiquetaCheckBox = new JLabel("CheckBox: ");
		etiquetaCheckBox.setBounds(20, 110, 280, 23);
		
		etiquetaTongleButton = new JLabel("TongleButton: ");
		etiquetaTongleButton.setBounds(20, 180, 280, 23);
		
		boton = new JButton("Boton");
		boton.setBounds(80, 80, 80, 23);
		
		checkBox1 = new JCheckBox("Check1");
		checkBox1.setBounds(100, 110, 80, 20);
		checkBox2 = new JCheckBox("Check2");
		checkBox2.setBounds(180, 110, 80, 20);
		
		radio1 = new JRadioButton("Radio1");
		radio1.setBounds(100, 140, 80, 23);
		radio2 = new JRadioButton("Radio2");
		radio2.setBounds(190, 140, 80, 23);
		grupoRadios = new ButtonGroup();
		grupoRadios.add(radio1);
		grupoRadios.add(radio2);
		
		
		//Añadimos los componentes, el texto al JPanel y el JPanel al JFrame
		contenedor.add(labelTitulo);
		contenedor.add(etiquetaLabel);
		contenedor.add(etiquetaBoton);
		contenedor.add(etiquetaCheckBox);
		contenedor.add(etiquetaTongleButton);
		contenedor.add(boton);
		contenedor.add(checkBox1); contenedor.add(checkBox2);
		contenedor.add(radio1); contenedor.add(radio2);
		
		this.add(contenedor);
		
		
	}
}
