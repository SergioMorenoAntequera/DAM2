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
    
    
    JButton midButton0, midButton1, midButton2, midButton3, 
            leftButton, rightButton, 
            bottomButon0, bottomButon1, bottomButon2;
    
    public Ventana(){
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        setSize(500, 255);
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
        lienzo.add(rightPLateral, BorderLayout.LINE_END);
        lienzo.add(PBottom, BorderLayout.PAGE_END);
        
        
        //*************BOTONES**************
        //Botones medio
        midButton0 = PMid.getMidButton0();
        midButton0.addActionListener(e->a1());
        midButton1 = PMid.getMidButton1();
        midButton1.addActionListener(e->a4());
        midButton2 = PMid.getMidButton2();
        midButton2.addActionListener(e->a5());
        midButton3 = PMid.getMidButton3();
        midButton3.addActionListener(e->a6());

        //Botones abajo
        bottomButon0 = PBottom.getBottomButton0();
        bottomButon0.addActionListener(e->a7());
        bottomButon1 = PBottom.getBottomButton1();
        bottomButon1.addActionListener(e->a8());
        bottomButon2 = PBottom.getBottomButton2();
        bottomButon2.addActionListener(e->a9());
        
        //Boton izquierda
        leftButton = leftPLateral.getLeftButton();
        leftPLateral.add(leftButton);
        leftButton.addActionListener(e->a2());
        leftButton.setVisible(false);
        
        //Boton derecha
        rightButton = rightPLateral.getRightButton();
        rightPLateral.add(rightButton);
        rightButton.addActionListener(e->a3());
        rightButton.setVisible(false);
        
        setVisible(true);
    }
    
    public void a1(){
        midButton0.setVisible(false);
        leftButton.setVisible(true);
    }
    public void a2(){
        leftButton.setVisible(false);
        rightButton.setVisible(true);
    }
    public void a3(){
        rightButton.setVisible(false);
        midButton1.setVisible(true);
    }
    public void a4(){
        midButton1.setVisible(false);
        midButton2.setVisible(true);
    }
    public void a5(){
        midButton2.setVisible(false);
        midButton3.setVisible(true);
    }
    public void a6(){
        midButton3.setVisible(false);
        bottomButon0.setVisible(true);
    }
    public void a7(){
        bottomButon0.setVisible(false);
        bottomButon1.setVisible(true);
    }
    public void a8(){
        bottomButon1.setVisible(false);
        bottomButon2.setVisible(true);
    }
    public void a9(){
        bottomButon2.setVisible(false);
        PTop.setTitulo("APRUEBAME PORFA");
    }
    
}
