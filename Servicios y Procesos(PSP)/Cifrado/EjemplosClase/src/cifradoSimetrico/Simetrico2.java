package cifradoSimetrico;
import static java.util.Arrays.copyOf;
import java.security.InvalidKeyException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

// Cifrado Simetrico con Java algoritmo tripleDES
public class Simetrico2 {

    public static String codBase64(byte[] a) {
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a);
        return b;
    }

    //------------------------------------------------------------------------------------------

    public static byte[] decodBase64(String a) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);
        return decodedByteArray;
    }

    //------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        String pass = "Secreto";
        String frase = "Cifraremos esta frase de Ejemplo";

        byte[] fraseBytes;
        byte[] passbyteprov = null;
        byte[] passbytebuena;
        byte[] frasecifrada;
        SecretKey claveSimetrica;
        Cipher cifrar;

        //----------------------------------------------------------------------
        
        System.out.println("----------   CIFRANDO CON DESEDE (3DES o TRIPLEDES)   ------------");
        try {
            //Esto para generar la clave secreta
            passbyteprov = pass.getBytes("UTF8");
            //Copyof completa un array hasta una longitud de 24
            passbytebuena = copyOf(passbyteprov, 24); //DESede espera una clave de 24
            //Esto es siempre igual    (Arraya de bits para pasar, metodo de enciptar)
            claveSimetrica = new SecretKeySpec(passbytebuena, "DESede");
            //esto para poner el cipher en modo DESede
            cifrar = Cipher.getInstance("DESede");
            //pasamos la frase a cifrar a array de bits 
            fraseBytes = frase.getBytes("UTF8");
            //ponemos cipher en MODO cifrar y le indicamos la clave de cifrado
            cifrar.init(Cipher.ENCRYPT_MODE, claveSimetrica);
            //Ciframos y guardamos array de byts normal en arrayy de bytes cifrados    
            frasecifrada = cifrar.doFinal(fraseBytes);
            // Ya estaria cifrado codificamos a base64 el array de bits para poder verlo como string
            //mostramos el array de bytes codificado en DESede (3des)
            System.out.println("Frase Original: " + frase);
            String frasecifradacod64 = codBase64(frasecifrada);
            System.out.println("Frase Cifrada: " + frasecifradacod64);

            //AHORA HAREMOS LO CONTRARIO----------------------------------------
            //Decodificamos la frase de string en base64 la volvemos a pasar a array de bits;
            byte[] frasecifradabytes1 = decodBase64(frasecifradacod64);
            //ponemos el cipher en modo descifrar y la clava para hacerlo
            cifrar.init(Cipher.DECRYPT_MODE, claveSimetrica);
            //desciframos el array de bytes cifado y lo guardamos en un array de bites ya descifrado
            byte[] frasebytedescifrada = cifrar.doFinal(frasecifradabytes1);
            // mostramos el array de bytes descifrado como string
            String frasedeinicio = new String(frasebytedescifrada);
            //Mostramos todo otra vez
            System.out.println("Frase vuelta a descifrar: " + frasedeinicio);

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
    //------------------------------------------------------------------------------------------------------------------------------------
}
