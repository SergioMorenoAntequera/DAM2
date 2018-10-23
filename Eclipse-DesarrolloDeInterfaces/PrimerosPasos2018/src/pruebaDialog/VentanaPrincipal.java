package pruebaDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton boton;
	private VentanaConfirmacion vc;
	
	public VentanaPrincipal() {
		iniciarComponentes();
		setTitle("Pruba con Dialog");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes() {
		JPanel panel = new JPanel();
		
		boton = new JButton("Abrir ventana");
		boton.addActionListener(this);
		
		panel.add(boton);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton) {
			vc = new VentanaConfirmacion(this, true);
			vc.setVisible(true);
		}
	}

}
