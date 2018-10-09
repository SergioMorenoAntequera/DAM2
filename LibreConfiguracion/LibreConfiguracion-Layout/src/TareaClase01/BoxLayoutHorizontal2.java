package TareaClase01;
import java.awt.Container;
import java.awt.Dimension;
import static java.awt.EventQueue.invokeLater;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutHorizontal2 extends JFrame {

    //Declaramos
    private JButton b1, b2, b3, b4;
        //b1 = new JButton("B1");
        //b2 = new JButton("B2");
        //b3 = new JButton("B3");
        //b4 = new JButton("B4");
    public BoxLayoutHorizontal2() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        

    }
    
    public static void mostrar(){
        BoxLayoutHorizontal2 miVentana = new BoxLayoutHorizontal2();
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setTitle("BoxLayoutHorizontal");
        miVentana.setVisible(true);
        miVentana.pack();
    }
    public static void main(String[] args){
            invokeLater (new Runnable(){
            @Override
            public void run(){
                mostrar();
            }
        });
    }
}


