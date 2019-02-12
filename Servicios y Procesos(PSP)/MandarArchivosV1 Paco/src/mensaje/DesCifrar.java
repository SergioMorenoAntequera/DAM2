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
public class DesCifrar {

    String pass = "secreto";
    byte[] passbyte;
    SecretKeySpec claveSimetrica;
    
    String fraseCifrada;
    byte[] fraseByteCifrada;
    byte[] fraseByte;
    String frase;
    
    Cipher cifrar;

    //--------------------------------------------------------------------------
    public DesCifrar(String frase) {
        this.pass = "secreto";
        this.frase = frase;
        
        fraseByteCifrada = decodBase64(frase);
        getClaveSimetrica();
        getCifrar();
        getFraseByte(frase);
        frase = new String(fraseByte);
    }

    private void getFraseByte(String frase1) {
        try {
            fraseByte = cifrar.doFinal(fraseByteCifrada);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(DesCifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(DesCifrar.class.getName()).log(Level.SEVERE, null, ex);
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
            cifrar.init(Cipher.DECRYPT_MODE, this.claveSimetrica);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static byte[] decodBase64(String a) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);
        return decodedByteArray;
    }   

    public String getFrase() {
        return frase;
    }
}
