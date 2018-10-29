package practicaspropuestas2;
import java.awt.*;
import javax.swing.*;

public class CalculadoraSergioMoreno {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Calculadora calcu = new Calculadora();
	}
}

//Ventana main
class Calculadora extends JFrame{
	private static final long serialVersionUID = 1L;
	panelResultado pr; PanelBotones pb;
	
	public Calculadora() {
		iniciarComponentes();
		setVisible(true);
	}
	private void iniciarComponentes() {
		setTitle("Calculadora");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		pr = new panelResultado();
		pb = new PanelBotones();
		this.add(pr, BorderLayout.NORTH);
		this.add(pb, BorderLayout.CENTER);
	}
}

//Panel resultado
class panelResultado extends JPanel {
	private static final long serialVersionUID = 1L;
	static JLabel resultado;
	
	public panelResultado() { 
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		resultado = new JLabel(" ");
		
		add(resultado);
	}
}

//Panel botones
class PanelBotones extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelBotones() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setLayout(new GridLayout(4, 4));
		
		JButton siete = new JButton("7");
		siete.addActionListener(e->siete());
		add(siete);
		JButton ocho = new JButton("8");
		ocho.addActionListener(e->ocho());
		add(ocho);
		JButton nueve = new JButton("9");
		nueve.addActionListener(e->nueve());
		add(nueve);
		JButton div = new JButton("/");
		div.addActionListener(e->div());
		add(div);
		JButton cuatro = new JButton("4");
		cuatro.addActionListener(e->cuatro());
		add(cuatro);
		JButton cinco = new JButton("5");
		cinco.addActionListener(e->cinco());
		add(cinco);
		JButton seis = new JButton("6");
		seis.addActionListener(e->seis());
		add(seis);
		JButton por = new JButton("x");
		por.addActionListener(e->por());
		add(por);
		JButton uno = new JButton("1");
		uno.addActionListener(e->uno());
		add(uno);
		JButton dos = new JButton("2");
		dos.addActionListener(e->dos());
		add(dos);
		JButton tres = new JButton("3");
		tres.addActionListener(e->tres());
		add(tres);
		JButton menos = new JButton("-");
		menos.addActionListener(e->menos());
		add(menos);
		JButton cero = new JButton("0");
		cero.addActionListener(e->cero());
		add(cero);
		JButton punto = new JButton(".");
		punto.addActionListener(e->punto());
		add(punto);
		JButton igual = new JButton("=");
		igual.addActionListener(e->igual());
		add(igual);
		JButton mas = new JButton("+");
		mas.addActionListener(e->mas());
		add(mas);
	}

	private void siete() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "7");
	}
	private void ocho() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "8");
	}
	private void nueve() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "9");
	}
	private void div() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "/");
	}
	private void cuatro() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "4");
	}
	private void cinco() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "5");
	}
	private void seis() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "6");
	}
	private void por() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "x");
	}
	private void uno() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "1");
	}
	private void dos() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "2");
	}
	private void tres() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "3");
	}
	private void menos() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "-");
	}
	private void cero() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "0");
	}
	private void punto() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + ".");
	}
	private void igual() {
		panelResultado.resultado.setText(" ");
	}
	private void mas() {
		panelResultado.resultado.setText(panelResultado.resultado.getText() + "+");
	}
	
	

}