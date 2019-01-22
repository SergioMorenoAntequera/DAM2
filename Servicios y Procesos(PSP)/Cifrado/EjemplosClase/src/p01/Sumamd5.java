package p01;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sumamd5{
        
    public static void main(String [] args){
        String frase="Hola Mundo";
        byte [] suma=null;
        MessageDigest md = null;
        byte [] cadena=frase.getBytes();
        try{
            md = MessageDigest.getInstance("MD5"); //SHA2-256
            suma = md.digest(cadena);
        }catch(NoSuchAlgorithmException e){
            System.err.println("Error de algoritmo: " + e.getMessage());
        }
        //pasamos a hexadecimal al array de bytes
        System.out.println("La suma es : " + pasarHexadecimal(suma) );
    }
    
    //--------------------------------------------------------------------------
    
    private static String pasarHexadecimal(byte[] codigo){
        
        String cad = "";
        for(byte aux : codigo) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) cad += "0"; // Los numeros de 0 a F los pone 00, 01, ...., 0F
            cad += Integer.toHexString(b);
        }
        return cad;
    }
}