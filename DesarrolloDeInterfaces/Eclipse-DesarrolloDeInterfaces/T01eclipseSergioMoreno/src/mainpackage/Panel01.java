package mainpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel01 extends JPanel{
	private static final long serialVersionUID = 1L;
	Toolkit tk = Toolkit.getDefaultToolkit();
	
	public Panel01() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBackground(new Color(63, 114, 139));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 100));
		panel.setBackground(new Color(63, 114, 139));
		this.add(panel);
	}
	
	public void paint (Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 70));
        g.drawString("Hotel Antequera", tk.getScreenSize().width/20, tk.getScreenSize().height/10);
	}
}
