/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado;

/**
 *
 * @author seran
 */
public class test {
    
    public static void main(String[] args){
        String frase2 = "yoquesetio"+1;
        String frase3 = "[ cli2 ]> " + "holaaa";
        String frase = frase2 + frase3;
        
        Cifrar cifrar = new Cifrar(frase);
        
        System.out.println(cifrar.getFraseCifrada());
        
        DesCifrar descifrar = new DesCifrar(cifrar.getFraseCifrada());
        
        System.out.println(descifrar.getFrase());
        
    }
    
}
