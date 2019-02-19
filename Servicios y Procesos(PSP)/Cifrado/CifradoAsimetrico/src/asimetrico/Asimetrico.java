package asimetrico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author paco
 */
public class Asimetrico {

    public static void main(String[] args) {
       String frase="Frase Super secreta, el dia de la invasion es el 12";
       String pAlmacen="usuario1";
       String pAlmacen2="usuario2";
       
       char [] passStore=pAlmacen.toCharArray();
       char [] passStore2=pAlmacen2.toCharArray();
       
       File almacen=new File("/home/paco/.keystore");
       File almacen2=new File("/home/paco1/.keystore");
       byte [] fraseCifrada;
       
       try(
               FileInputStream fis = new FileInputStream(almacen);
               FileInputStream fis2 = new FileInputStream(almacen2);
               )
       {
           //1.- Abrimos almacen de claves
           KeyStore ks=KeyStore.getInstance("PKCS12");
           ks.load(fis, passStore);
           //2.- Cargamos la clave publica que vamos a usar (ya importada)
           PublicKey pubKey = ks.getCertificate("paco2").getPublicKey();
           //3.- Creamos cipher con esa key y lo ponemos en modo encriptar
           Cipher cifrar = Cipher.getInstance(pubKey.getAlgorithm());
           cifrar.init(Cipher.ENCRYPT_MODE, pubKey);
           //4.- Ciframos y mostramos cifrado;
           fraseCifrada=cifrar.doFinal(frase.getBytes());
           System.out.println(codBase64(fraseCifrada));
           ///------------------------------------------------------------------
           //descifraremos con la clave privada del usuario paco1----------
           //1.- Abrimos el almacen de claves de paco1
           //1.- Abrimos almacen de claves
           KeyStore ks2=KeyStore.getInstance(KeyStore.getDefaultType());
           ks2.load(fis2, passStore2);
           //2.- Cargamos la privatekey
           PrivateKey privKey=(PrivateKey)ks2.getKey("paco2", passStore2);
           //3.- Creamos cipher con esa privkey y lo ponemos en modo desencriptar
            Cipher cifrado = Cipher.getInstance(privKey.getAlgorithm());
            cifrado.init(Cipher.DECRYPT_MODE, privKey);
            //4.-desciframos
            byte [] lafrase= cifrado.doFinal(fraseCifrada);
            System.out.println("la frase descifrada con la key privada de paco1 es: \n" +new String(lafrase) );
           
           
       } catch (FileNotFoundException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(Asimetrico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //.........................................................................
    public  static String codBase64(byte [] a) {
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a);        
        return b;
    }
    //------------------------------------------------------------------------------------------
    public static byte [] decodBase64(String a){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);
        return decodedByteArray;
    }
}
