package layoutmanager;

import java.awt.*;
import javax.swing.*;

public class SimpleFlowLayout {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		MarcoFlowLayout marco = new MarcoFlowLayout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}

class MarcoFlowLayout extends JFrame {
	private static final long serialVersionUID = 1L;

	public MarcoFlowLayout() {
		setTitle("Simple FlowLayout");
		setBounds(600, 350, 400, 100);
		PanelFlowLayout lamina = new PanelFlowLayout();
		add(lamina);
	}
}

class PanelFlowLayout extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelFlowLayout() {
		setLayout(new FlowLayout());
		add(new JLabel("Primera"));
		add(new JLabel("Segunda"));
		add(new JLabel("Tercera"));
		add(new JLabel("Cuarta"));
		add(new JLabel("Quinta"));
		add(new JLabel("Sexta"));
	}
}