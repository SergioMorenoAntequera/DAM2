/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensaje;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import static java.util.Arrays.copyOf;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author windiurno
 */
public class Cifrar {
    
    String pass;
    byte[] passbyte;
    SecretKeySpec claveSimetrica;
    
    String frase;
    byte[] fraseByte;
    byte[] fraseByteCifrada;
    String fraseCifrada;
    
    Cipher cifrar;

    //--------------------------------------------------------------------------
    
    public Cifrar(String frase) {
        this.pass = "secreto";
        this.frase = frase;
        getFraseByte(frase);
        getClaveSimetrica();
        getCifrar();
        getFraseByteCifrada();
        fraseCifrada = codBase64(fraseByteCifrada);
    }

    private void getFraseByte(String frase1) {
        try {
            fraseByte = frase1.getBytes("UTF8");
        }catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //--------------------------------------------------------------------------
    
    public void getClaveSimetrica() {
        try {
            passbyte = pass.getBytes("UTF8");
            passbyte = copyOf(passbyte, 32);
            this.claveSimetrica = new SecretKeySpec(passbyte, "AES");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getCifrar() {
        try {
            cifrar = Cipher.getInstance("AES");
            cifrar.init(Cipher.ENCRYPT_MODE, this.claveSimetrica);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String codBase64(byte[] a) {
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a);
        return b;
    }

    private void getFraseByteCifrada() {
        try {
            fraseByteCifrada = cifrar.doFinal(fraseByte);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPass() {
        return pass;
    }

    public String getFrase() {
        return frase;
    }

    public String getFraseCifrada() {
        return fraseCifrada;
    }
    
}
