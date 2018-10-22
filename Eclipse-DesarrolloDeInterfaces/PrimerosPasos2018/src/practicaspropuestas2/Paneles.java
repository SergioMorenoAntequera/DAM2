package practicaspropuestas2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//VENTANA
public class Paneles extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton bMostrar, bOcultar, bReset, bGo;
	JLabel titulo;
	
	public Paneles() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setTitle("Paneles");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		Panel01 panel01 = new Panel01();
		Panel02 panel02 = new Panel02();
		
		titulo = new JLabel("JPanel principal");
		bMostrar = new JButton("Mostrar Panel2");
		bOcultar = new JButton("Ocultar Panel2");
		bReset = new JButton("Reiniciar datos");
		bGo = new JButton("Aceptar");
		
		titulo.setBounds(250, 10, 200, 30);
		bMostrar.setBounds(80, 270, 150, 25);
		bOcultar.setBounds(80, 310, 150, 25);
		bReset.setBounds(340, 270, 150, 25);
		bGo.setBounds(340, 310, 150, 25);
		
		//Fuincionalidad botones
		bMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel02.setVisible(true);
			}
		});
		bOcultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel02.setVisible(false);
			}
		});
		bReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel01.tfNombre.requestFocus();
				panel01.tfApellidos.setText("");
				panel01.tfNombre.setText("");
			}
		});
		bGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(panel01.tfNombre.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Falta el nombre");
				} else {
					if(panel01.tfApellidos.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Faltan los Apellidos");
					} else {
					JOptionPane.showMessageDialog(null, "Datos guardados");
					panel01.tfApellidos.setText("");
					panel01.tfNombre.setText("");
					}
				}
				if(panel01.tfApellidos.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Faltan los Apellidos");
				}
			}
		});

		
		add(titulo);
		add(bMostrar);
		add(bOcultar);
		add(bReset);
		add(bGo);
		
		add(panel01);
		add(panel02);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Paneles paneles = new Paneles();
	}
}

//Panel de la izquierda
class Panel01 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JLabel titulo, etNombre, etApellidos;
	JTextField tfNombre, tfApellidos; 
	
	public Panel01() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setBounds(80, 50, 200, 200);
		this.setBackground(Color.GRAY);
		
		titulo = new JLabel("Titulo Panel 1");
		etNombre = new JLabel("Nombre:");
		etApellidos = new JLabel("Apellidos:");
		tfNombre = new JTextField();
		tfApellidos = new JTextField();
		
		titulo.setBounds(20, 20, 100, 20);
		etNombre.setBounds(20, 70, 50, 20);
		etApellidos.setBounds(20, 120, 60, 20);
		tfNombre.setBounds(90, 70, 100, 20);
		tfApellidos.setBounds(90, 120, 100, 20);
		
		this.add(titulo);
		this.add(etNombre);
		this.add(etApellidos);
		this.add(tfNombre);
		this.add(tfApellidos);
	}
}

//Panel de la derecha
class Panel02 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JLabel titulo;
	JButton boton;
	
	public Panel02() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setLayout(null);
		this.setBounds(320, 50, 200, 200);
		this.setBackground(Color.GREEN);
		
		titulo = new JLabel("Titulo Panel 2");
		boton = new JButton("Boton");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Este botón no hace nada");
			}
		});
		
		titulo.setBounds(20, 20, 100, 20);
		boton.setBounds(60, 80, 80, 30);
		
		this.add(titulo);
		this.add(boton);
	}
	
}
