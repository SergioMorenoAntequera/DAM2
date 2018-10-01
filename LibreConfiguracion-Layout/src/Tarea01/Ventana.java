package Tarea01;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    TopPanel PTop;
    MiddlePanel PMid;
    LateralPanel leftPLateral, rightPLateral;
    BottomPanel PBottom;
    
    JButton topButton, midButton, leftLateralButton, rightLateralButtom, bottomButon;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        
        setSize(500, 200);
        Container lienzo = this.getContentPane();
        BorderLayout bl = new BorderLayout();
        lienzo.setLayout(bl);
        
        PTop = new TopPanel();
        PMid = new MiddlePanel();
        leftPLateral = new LateralPanel();
        rightPLateral = new LateralPanel();
        PBottom = new BottomPanel();
        
        
        lienzo.add(PTop, BorderLayout.PAGE_START);
        lienzo.add(PMid, BorderLayout.CENTER);
        lienzo.add(leftPLateral, BorderLayout.LINE_START);
        lienzo.add(rightPLateral, BorderLayout.LINE_START);
        lienzo.add(rightPLateral, BorderLayout.PAGE_END);
        
        
        setVisible(true);
    }
    
}
