/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seran
 */
public class Sleep {
    
    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
