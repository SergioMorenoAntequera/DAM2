package mainpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel01 extends JPanel{
	private static final long serialVersionUID = 1L;
	VentanaModal vm = null;
	
	public Panel01(VentanaModal vm) {
		this.vm = vm;
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBackground(new Color(253, 219, 212));
		//this.setPreferredSize(new Dimension(vm.getWidth(), 100));
		
	}
	
	public void paint (Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 70));
        g.drawString("Hotel Antequera", 700, 100);
	}
}
