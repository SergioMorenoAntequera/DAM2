package ejemplo1c;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Calculadora extends JFrame implements KeyListener{
    
     PanelTitulo pt;
     PanelLateral pli;
     PanelLateral pld;
     PanelCentral pc;
     PanelResultado pr;
     JButton btnReset;
     JButton btnCalcular;
     JTextField casilla1, casilla2, resultado;
    
    public Calculadora(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        setSize(500, 200);
        pt = new PanelTitulo();
        pli = new PanelLateral();
        pld = new PanelLateral();
        pc = new PanelCentral();
        pr = new PanelResultado();
        resultado = pr.getTfResultado();
        btnReset = pli.getBtnReset();
        btnReset.addActionListener(e->reset());
        btnCalcular = pli.getBtnCalcular();
        btnCalcular.addActionListener(e-> calcular());
        casilla1 = pc.getTfPrimeraCasilla();
        casilla2 = pc.getTfSegundaCasilla();
        casilla1.addKeyListener(this);
        casilla2.addKeyListener(this);
        
        Container lienzo = this.getContentPane();
        
        //Colocamos toas las cosas
        BorderLayout bl = new BorderLayout();
        lienzo.setLayout(bl);
        
        lienzo.add(pt, BorderLayout.PAGE_START);
        lienzo.add(pli, BorderLayout.LINE_START);
        pli.add(btnReset);
        lienzo.add(pld, BorderLayout.LINE_END);
        pld.add(btnCalcular);
        lienzo.add(pc, BorderLayout.CENTER);
        lienzo.add(pr, BorderLayout.PAGE_END);
        
    }

    public void reset(){
        casilla1.setText("");
        casilla2.setText("");
        resultado.setText("");
    }
    
    public void calcular(){
        int resultadoint = (Integer.parseInt(casilla1.getText()) + Integer.parseInt(casilla2.getText()));
        resultado.setText("" + resultadoint);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    
        if(e.getSource() == casilla1 || e.getSource() == casilla2){
            char c = e.getKeyChar();
            if(c < '0' || c > '9'){
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
    
}
