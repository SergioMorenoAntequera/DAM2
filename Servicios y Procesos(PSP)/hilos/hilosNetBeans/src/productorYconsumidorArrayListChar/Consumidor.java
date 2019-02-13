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
public class Consumidor extends Thread {
    
    public MiLista ml;

    public Consumidor(MiLista ml) {
        this.ml = ml;
    }

    @Override
    public void run() {
        while (true) {
            if (ml.miLista.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {}
            } else {
                System.out.println("Se ha retirado la palabra: " + ml.quitarPalabra() + ", quedan " + ml.miLista.size());
            }
        }
    }


}
