/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etst;

import cifrado.Cifrar;
import cifrado.DesCifrar;

/**
 *
 * @author windiurno
 */
public class a {
    public static void main(String[] args){
        
        String mensaje = "ciframeeeee";
        System.out.println("******Mensaje antes: " + mensaje);
        
        Cifrar c1 = new Cifrar(mensaje);
        String mensaje2 = c1.getFraseCifrada();
        System.out.println("******Mensaje cifrado: " + mensaje2);
        
        
        DesCifrar c2 = new DesCifrar(mensaje2);
        System.out.println("******Mensaje descifrado: " + c2.getFrase());
        
        
    }
}
