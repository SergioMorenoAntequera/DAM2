package ej05;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelSliders extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	
	JSlider s1, s2, s3, s4, s5;

	public PanelSliders() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		s1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		s1.addChangeListener(this);
		
		this.add(s1);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}
}
