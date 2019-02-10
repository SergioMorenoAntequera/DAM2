/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import static java.util.Arrays.copyOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jdk.internal.org.xml.sax.InputSource;
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
    String clave;
    byte[] claveByte;
    Cipher cifrar;
    int longitudCifrado;
    String tipoCifrado;
    SecretKey claveSimetrica;
    
    //Fichero
    FileInputStream entrada;
    FileOutputStream salida;
    
    CipherInputStream entradaCipher;
    
    
    
    //--------------------------------------------------------------------------
    
    public Controlador(Vista v) {
        this.v = v;
        
        v.bAbrirArchivo.addActionListener(this);
        v.bCifrar.addActionListener(this);
        v.bDescifrar.addActionListener(this);
        v.bSalir.addActionListener(this);
        
        
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        conseguirTipoCifrado(v);
        
        //Boton abrir Archivo---------------------------------------------------
        if(e.getSource() == v.bAbrirArchivo){
            
            fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(v);
            
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero = fileChooser.getSelectedFile();
                v.tfRuta.setText(fichero.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "Error al seleccionar el fichero");
            }
        }
        
        //Ciframmos el archivo recogido arriba---------------------------------
        if(e.getSource() == v.bCifrar && v.tfClave.getText().length() > 0){
            //La clave y el Cipher la conseguimos aquí
            try {
                clave = v.tfClave.getText();
                claveByte = clave.getBytes("UTF8");
                claveByte = copyOf(claveByte, longitudCifrado);
                
                //Usamos la clave que tenemos arriba para crear nuestra secret Key
                claveSimetrica = new SecretKeySpec(claveByte, tipoCifrado);
                
                cifrar = Cipher.getInstance(tipoCifrado);
                cifrar.init(Cipher.ENCRYPT_MODE, claveSimetrica);
                //Ahora tenemos el Cipher completado
                
                entrada = new FileInputStream(fichero);
                salida = new FileOutputStream(fichero.getPath()+"cifrado");
                
                entradaCipher = new CipherInputStream(entrada, cifrar);
                
                
                
                
            } catch (UnsupportedEncodingException ex) {
                System.err.println("ERROR: " + ex.toString());
            } catch (FileNotFoundException ex) {
                System.err.println("ERROR: " + ex.toString());
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("ERROR: " + ex.toString());
            } catch (NoSuchPaddingException ex) {
                System.err.println("ERROR: " + ex.toString());
            } catch (InvalidKeyException ex) {
                System.err.println("ERROR: " + ex.toString());
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No has selecionado ningun archivo");
            }
        }
        
        //Boton Salir-----------------------------------------------------------
        if(e.getSource() == v.bSalir){
            System.exit(-1);
        }
        
    }
    
    //--------------------------------------------------------------------------
    
    private void conseguirTipoCifrado(Vista v1) {
        //mover al boton de cifrar y descifrar
        if (v1.rbAES128.isSelected()) {
            longitudCifrado = 16;
            tipoCifrado = "AES";
        } else {
            if (v1.rbAES256.isSelected()) {
                longitudCifrado = 24;
                tipoCifrado = "DESede";
            }
        }
    }
        
}
