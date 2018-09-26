package ejemplo1c;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Calculadora extends JFrame{
    
     PanelTitulo pt;
     PanelLateral pli;
     PanelLateral pld;
     PanelCentral pc;
     PanelResultado pr;
     JButton btnReset;
     JButton btnCalcular;
    
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
        btnReset = pli.getBtnReset();
        btnCalcular = pli.getBtnCalcular();
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
    
    
    
    
}
