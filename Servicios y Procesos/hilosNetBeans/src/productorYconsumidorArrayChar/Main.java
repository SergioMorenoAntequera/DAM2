/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidorArrayChar;
/**
 *
 * @author windiurno
 */
public class Main {
    
    public static void main(String[] args){
        
        /*Contenedor c = new Contenedor();
        
        Productor productor = new Productor(c);
        Consumidor consumidor = new Consumidor(c);
        
        productor.start();
        consumidor.start();*/
        
        for (int i = 0; i < 10; i++) {
            int  n = (int) (Math.random() * 25) + 97;
            System.out.println(n);
            char c = (char) n;
            System.out.println(c);
        }
    }
    
}
