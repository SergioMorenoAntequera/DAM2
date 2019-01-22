/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p01;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SumFichero{
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error, se esperaba el nombre del Fichero!!!!");
            System.exit(-1);
        }
        File fichero = new File(args[0]);
        int read = 0;
        MessageDigest md = null;
        byte[] text = new byte[1024]; //leeremos el ficger de 1024 en 1024
        byte[] suma = null;
        if (!fichero.exists()) {
            System.out.println("ERROR Imposible abrir archivo, verifique su ruta !!!!!");
            System.exit(-1);
        }
        try (
            InputStream is = new FileInputStream(fichero);
            BufferedInputStream bis = new BufferedInputStream(is);
        ) {
            
            md = MessageDigest.getInstance("SHA-256");
            while ((read = bis.read(text)) > 0) {
                md.update(text, 0, read);
            }
            
            suma = md.digest();
            
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error de algortitmo:  " + ex.getMessage());
            System.exit(-1);
        } catch (FileNotFoundException ex) {
            // error
        } catch (IOException ex) {
            //error
        }
        System.out.println("La suma SHA-256 del fichero: " + args[0] + " es:\n " + pasarHexadecimal(suma));
    }
    
    //-------------------------------------------------------
    
    private static String pasarHexadecimal(byte[] codigo) {
        String cad = "";
        for (byte aux : codigo) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                cad += "0"; // Los numeros de 0 a F los pone 00, 01, ...., 0F
            }
            cad += Integer.toHexString(b);
        }
        return cad;
    }
}
