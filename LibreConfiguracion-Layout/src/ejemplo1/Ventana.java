/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Ventana extends JFrame{
    
    //Declaramos
    private JButton btnSalir, btnSaludo;
    private JTextField txtSaludo;
    private JLabel ibSup, ibInf;
    
    
    public Ventana(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        //Inicializamos
        btnSalir = new JButton("Salir");
        btnSaludo = new JButton("Saludo");
        txtSaludo =  new JTextField("TEXTO");
        ibSup = new JLabel("Encabezado de mi ventana");
        ibInf = new JLabel("Pie de mi ventana");
        
        //Cambiar fondo
        btnSaludo.setBackground(Color.RED);
        btnSalir.setBackground(Color.BLUE);
        txtSaludo.setBackground(Color.BLACK);
        txtSaludo.setForeground(Color.GREEN);
        
        //creamos el lienzo y colocamos los objetos en el JFrame
        Container lienzo = this.getContentPane();
        lienzo.setPreferredSize(new Dimension(400, 200));
        lienzo.add(ibSup, BorderLayout.PAGE_START);
        lienzo.add(ibInf, BorderLayout.PAGE_END);
        lienzo.add(txtSaludo, BorderLayout.CENTER);
        lienzo.add(btnSaludo, BorderLayout.LINE_START);
        lienzo.add(btnSalir, BorderLayout.LINE_END);
        
        //Codigo para los botones
        //lo de e-> indica que se hará ese metodo al pulsar el boton
        btnSalir.addActionListener(e->salir());
        btnSaludo.addActionListener(e->saludo());
        
    } 
        
    public void salir(){
            System.exit(0);
        }
        
        public void saludo(){
            //Metodo trim() quita espacios en blanco al principio y al final
            if(txtSaludo.getText().trim().length() == 0){
                JOptionPane.showMessageDialog(this, "Debes escribir un mensaje");
            } else {
                JOptionPane.showMessageDialog(this, "Hola: " + txtSaludo.getText().trim());
                txtSaludo.setText("");
            }
        }
        
        
        
       
}
