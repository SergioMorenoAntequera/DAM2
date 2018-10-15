package layoutmanager;

import java.awt.*;
import javax.swing.*;

public class SimpleGridLayout {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		MarcoGridLayout marco = new MarcoGridLayout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}
}

class MarcoGridLayout extends JFrame {
	private static final long serialVersionUID = 1L;

	public MarcoGridLayout() {
		setTitle("Simple GridLayout");
		setBounds(600, 350, 600, 600);
		PanelGridLayout lamina = new PanelGridLayout();
		add(lamina);
		
		//Cosas aniadidas
		PanelBorderLayout2 lamina2 = new PanelBorderLayout2();
		add(lamina2, BorderLayout.CENTER);
		add(lamina2, BorderLayout.SOUTH);
	}
}

class PanelGridLayout extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelGridLayout() {
		setLayout(new GridLayout(3, 2, 15, 15));
		add(new JLabel("Primera"));
		add(new JLabel("Segunda"));
		add(new JLabel("Tercera"));
		add(new JLabel("Cuarta"));
		add(new JLabel("Quinta"));
		add(new JLabel("Sexta"));
	}
}

class PanelBorderLayout2 extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelBorderLayout2() {
		setLayout(new BorderLayout());
		add(new JLabel("Norte", SwingConstants.CENTER), BorderLayout.NORTH);
		add(new JLabel("Sur", SwingConstants.CENTER), BorderLayout.SOUTH);
		add(new JLabel("Centro", SwingConstants.CENTER), BorderLayout.CENTER);
		add(new JLabel("Oeste", SwingConstants.CENTER), BorderLayout.WEST);
		add(new JLabel("Este", SwingConstants.CENTER), BorderLayout.EAST);
	}
}