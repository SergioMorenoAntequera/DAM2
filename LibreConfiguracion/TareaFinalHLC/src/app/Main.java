/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import javax.swing.JOptionPane;
import vista.Frame;

/**
 *
 * @author seran
 */
public class Main {

    public static void main(String[] args) {
        mostrarInstrucciones();
        Frame frame = new Frame();     
    }
    public static void mostrarInstrucciones(){
        JOptionPane.showMessageDialog(null, "¡¡Se aceerca un ataque enemigo y debes detenerlos!!\n"
                + "Moverse: Fechas de direción (<- ->)\n"
                + "Disparar: Barra espaciadora\n\n"
                + "No dejes que se acerquen! Buena suerte", "¡¡¡Instrucciones!!!", JOptionPane.WARNING_MESSAGE);
    }
}
