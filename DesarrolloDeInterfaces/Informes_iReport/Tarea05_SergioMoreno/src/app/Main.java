/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controlador.ControladorMainFrame;
import vista.MainFrame;

/**
 *
 * @author seran
 */
public class Main {
    
    public static void main(String[] args){
        
        
        MainFrame mf = new MainFrame();
        ControladorMainFrame cmf = new ControladorMainFrame(mf);
        
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
    
}
