/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidorArrayListChar;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        
        MiLista ml = new MiLista();
        Productor productor = new Productor(ml);
        Consumidor consumidor = new Consumidor(ml);
        
        productor.start();
        consumidor.start();
    }
}
