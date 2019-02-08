/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradoSimetrico;
import static cifradoSimetrico.Simetrico2.codBase64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import static java.util.Arrays.copyOf;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author windiurno
 */
public class Cifrar {
    
        static Frase fraseObj = new Frase("Frase a descifrar", "Password de la flase");
        static String pass = fraseObj.getPassword();
        static String frase = fraseObj.getFrase();
        
        static byte[] fraseBytes;
        static byte[] passByteProv = null;
        static byte[] passByteBuena;
        static byte[] fraseCifrada;
        static SecretKey claveSimetrica;
        static Cipher cifrar;

    //----------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("----------   CIFRANDO CON DESEDE (3DES o TRIPLEDES)   ------------");
        try {
            //Esto para generar la clave secreta
            passByteProv = pass.getBytes("UTF8");
            //Copyof completa un array hasta una longitud de 24
            passByteBuena = copyOf(passByteProv, 24); //DESede espera una clave de 24
            //Esto es siempre igual    (Arraya de bits para pasar, metodo de enciptar)
            claveSimetrica = new SecretKeySpec(passByteBuena, "DESede");
            //esto para poner el cipher en modo DESede
            cifrar = Cipher.getInstance("DESede");
            //pasamos la frase a cifrar a array de bits 
            fraseBytes = frase.getBytes("UTF8");
            //ponemos cipher en MODO cifrar y le indicamos la clave de cifrado
            cifrar.init(Cipher.ENCRYPT_MODE, claveSimetrica);
            //Ciframos y guardamos array de byts normal en arrayy de bytes cifrados    
            fraseCifrada = cifrar.doFinal(fraseBytes);
            // Ya estaria cifrado codificamos a base64 el array de bits para poder verlo como string
            //mostramos el array de bytes codificado en DESede (3des)
            System.out.println("Frase Original: " + frase);
            String frasecifradacod64 = codBase64(fraseCifrada);
            System.out.println("Frase Cifrada: " + frasecifradacod64);

        } catch (UnsupportedEncodingException ex) {
            System.err.println("Codificación NO soportada!!!!");
            System.exit(-1);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("ERROR!!!!: " + ex.getMessage());
            System.exit(-1);
        } catch (NoSuchPaddingException ex) {
            System.err.println("ERROR!!!!: " + ex.getMessage());
            System.exit(-1);
        } catch (IllegalBlockSizeException ex) {
            System.err.println("ERROR!!!!: " + ex.getMessage());
            System.exit(-1);
        } catch (BadPaddingException ex) {
            System.err.println("ERROR!!!!: " + ex.getMessage());
            System.exit(-1);
        } catch (InvalidKeyException ex) {
            System.err.println("ERROR!!!!: " + ex.getMessage());
            System.exit(-1);
        }
    }
}
