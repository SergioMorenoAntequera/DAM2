/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asimetrico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author windiurno
 */
public class Descifrar {
    public static void main(String[] args) throws FileNotFoundException{
        
        File archivo = new File("C:\\Users\\windiurno\\Desktop\\Sergio-clave.txt");
        File almacen = new File("C:\\Users\\windiurno\\.keystore");
        
        String pAlmacen="contrasenia";
        char [] passStore = pAlmacen.toCharArray();
        
        try (FileInputStream fis = new FileInputStream(almacen)){
            
            byte[] archivoBytes = Files.readAllBytes(archivo.toPath());
            
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(fis, passStore);
            
            PrivateKey privKey=(PrivateKey)ks.getKey("-sergio", passStore);
            
            Cipher cifrado = Cipher.getInstance(privKey.getAlgorithm());
            cifrado.init(Cipher.DECRYPT_MODE, privKey);

            byte[] archivoDescifrado = cifrado.doFinal(archivoBytes);
        
            FileOutputStream salida = new FileOutputStream(archivo.toPath() + "descifrado.txt");
            salida.write(archivoDescifrado);
            
            salida.close();
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Descifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
