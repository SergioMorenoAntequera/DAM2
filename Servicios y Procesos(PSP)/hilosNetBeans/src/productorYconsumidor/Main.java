/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidor;

/**
 *
 * @author windiurno
 */
public class Main {
    
    public static void main(String[] args){
        
        Contenedor c = new Contenedor();
        
        Productor productor = new Productor(c);
        Consumidor consumidor = new Consumidor(c);
        
        productor.start();
        consumidor.start();
    }
    
}
