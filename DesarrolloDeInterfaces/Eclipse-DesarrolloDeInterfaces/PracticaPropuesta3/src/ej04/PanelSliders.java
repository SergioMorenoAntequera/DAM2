package ej04;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelSliders extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	
	private final int TAM_MIN = 8;
	private final int TAM_INT = 28;
	private final int TAM_MAX = 48;
	JSlider tam;
	JLabel texto;
	
	public PanelSliders() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		tam = new JSlider(JSlider.HORIZONTAL, TAM_MIN, TAM_MAX, TAM_INT);
		tam.addChangeListener(this);
		
		this.add(tam);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		texto = PanelTexto.getTexto();
		JSlider source = (JSlider) e.getSource();

		if (!source.getValueIsAdjusting()) {
			int tamanio = (int) ((JSlider) e.getSource()).getValue();
			texto.setFont(new Font("Ink Free", Font.PLAIN, tamanio));
		}
		PanelTexto.setTexto(texto);
	}
}
