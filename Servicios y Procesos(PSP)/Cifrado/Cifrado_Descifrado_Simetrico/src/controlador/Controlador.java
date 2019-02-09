/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import static java.util.Arrays.copyOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import vista.Vista;

/**
 *
 * @author seran
 */
public class Controlador implements ActionListener {

    Vista v;
    
    JFileChooser fileChooser;
    File fichero = null;
    
    //Clave
    String claveSinCifrar;
    byte[] byteClaveSinCifrar;
    Cipher cifrar;
    int longitudCifrado;
    

    public Controlador(Vista v) {
        this.v = v;
        
        v.bAbrirArchivo.addActionListener(this);
        v.bCifrar.addActionListener(this);
        v.bDescifrar.addActionListener(this);
        v.bSalir.addActionListener(this);
        
        if(v.rbAES128.isSelected()){
            longitudCifrado = 18;
        } else {
            if(v.rbAES256.isSelected()){
                longitudCifrado = 32;
            }
        }
        //longitudCifrado = v.rbAES128.isSelected() ? 18 : 0; 
       // longitudCifrado = v.rbAES256.isSelected() ? 32 : 0; 
        
        
        //La clave y el Cipher la conseguimos aquí
        try {
            claveSinCifrar = v.tfClave.getText();
            byteClaveSinCifrar = claveSinCifrar.getBytes("UTF8");
            byteClaveSinCifrar = copyOf(byteClaveSinCifrar, longitudCifrado);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == v.bAbrirArchivo){
            fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(v);
            
            
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero = fileChooser.getSelectedFile();
                v.tfRuta.setText(fichero.getAbsolutePath());
                
                // Aquí ya tenemos el fichero para cifrar
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al leer al seleccionar el fichero");
            }
        }
        
        if(e.getSource() == v.bSalir){
            System.out.println(longitudCifrado);
            System.out.println(byteClaveSinCifrar.length);
            System.exit(-1);
        }
        
    }
    
}
