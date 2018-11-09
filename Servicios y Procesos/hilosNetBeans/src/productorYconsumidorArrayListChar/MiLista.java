/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorYconsumidorArrayListChar;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class MiLista {

    ArrayList<String> miLista = new ArrayList<String>(10);
    //Sin constructor
    //ArrayList

    public synchronized void ponerPalabra(String palabra) {
        miLista.add(palabra);
        notify();
    }

    public synchronized String quitarPalabra() {
        String palabraRetirada = "";
        if(miLista.isEmpty()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MiLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            palabraRetirada = miLista.get(miLista.size()-1);
            miLista.remove(palabraRetirada);
        }
        return palabraRetirada;
    }
    //ponerDatos();
    //quitarDatos();
}
