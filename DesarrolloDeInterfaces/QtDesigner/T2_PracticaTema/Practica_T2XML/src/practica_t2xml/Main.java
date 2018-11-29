/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_t2xml;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;

/**
 *
 * @author windiurno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QApplication.initialize(args);
        QMainWindow mw =  new QMainWindow();
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setupUi(mw);
        mw.show();
        QApplication.execStatic();
    }
    
}
