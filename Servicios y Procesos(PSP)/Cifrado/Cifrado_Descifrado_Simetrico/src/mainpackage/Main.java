/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import controlador.Controlador;
import javax.swing.JDialog;
import vista.Vista;

/**
 *
 * @author seran
 */
public class Main {
    
    public static void main(String[] args){
        
        Vista v = new Vista(null, true);
        Controlador con = new Controlador(v);
        
        v.setLocationRelativeTo(null);
        v.setTitle("Cifrar/Descifrar");
        v.setVisible(true);

    }
    
}
