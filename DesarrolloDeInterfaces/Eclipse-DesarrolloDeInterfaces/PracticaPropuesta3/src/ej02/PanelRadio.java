package ej02;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelRadio extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JRadioButton rbPequeño, rbMediano, rbGrande, rbMuyGrande;
	private ButtonGroup botones;
	
	public PanelRadio() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		
		rbPequeño = new JRadioButton("Pequeño");
		rbMediano = new JRadioButton("Mediano");
		rbGrande = new JRadioButton("Grande");
		rbMuyGrande = new JRadioButton("Muy grande");
		botones = new ButtonGroup();
		
		botones.add(rbPequeño);
		botones.add(rbMediano);
		botones.add(rbGrande);
		botones.add(rbMuyGrande);
		
		rbMediano.setSelected(true);
		rbPequeño.addActionListener(this);
		rbMediano.addActionListener(this);
		rbGrande.addActionListener(this);
		rbMuyGrande.addActionListener(this);
		
		this.add(rbPequeño);
		this.add(rbMediano);
		this.add(rbGrande);
		this.add(rbMuyGrande);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(rbPequeño.isSelected()) {
			PanelTexto.texto.setFont(new Font("Ink Free", Font.PLAIN, 10));
		}
		if(rbMediano.isSelected()) {
			PanelTexto.texto.setFont(new Font("Ink Free", Font.PLAIN, 20));
		}
		if(rbGrande.isSelected()) {
			PanelTexto.texto.setFont(new Font("Ink Free", Font.PLAIN, 30));
		}
		if(rbMuyGrande.isSelected()) {
			PanelTexto.texto.setFont(new Font("Ink Free", Font.PLAIN, 40));
		}

	}
}
