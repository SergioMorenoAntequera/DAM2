/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controlador.ControladorMainFrame;
import vista.MainFrame;

/**
 * clase principal
 * @author seran
 */
public class Main {
    
    /**
     * main con la única función de hacer la ventana e inicializar el constructor
     * @param args argumentos del main
     */
    public static void main(String[] args){
        
        MainFrame mf = new MainFrame();
        mf.setTitle("Practica oblgatoria 5");
        ControladorMainFrame cmf = new ControladorMainFrame(mf);
        
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
    
}
