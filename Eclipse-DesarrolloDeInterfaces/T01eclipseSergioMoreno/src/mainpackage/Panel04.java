package mainpackage;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Panel04 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JFrame v;
	JTabbedPane paneles;
	JPanel panel1, panel2;
	JTextArea area1, area2;
	
	public Panel04(JFrame v) {
		this.v = v;
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.setBackground(new Color(147, 211, 243));
		this.setPreferredSize(new Dimension(200, 50));
		panel1 = new JPanel();
		panel2 = new JPanel();
		paneles = new JTabbedPane();
		
		area1 = new JTextArea();
		area1.setBounds(0, 0, 200, 50);
		panel1.add(area1);
		area2 = new JTextArea();
		area2.setBounds(0, 0, 200, 50);
		panel2.add(area2);
		
		paneles.add("Cliente", panel1);
		paneles.add("Reserva", panel2);
		
		
		
		
		paneles.setPreferredSize(new Dimension(195, 595));
	
		this.add(paneles);
		
	}
	
}
