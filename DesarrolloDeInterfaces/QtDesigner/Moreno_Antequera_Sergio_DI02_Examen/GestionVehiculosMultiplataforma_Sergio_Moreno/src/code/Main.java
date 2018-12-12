/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;
import ui.*;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;

/**
 *
 * @author windiurno
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        MainWindow vMain = new MainWindow();
        
        QApplication.initialize(args);
        QMainWindow qmw =  new QMainWindow();
        vMain.setupUi(qmw);
        qmw.show();
        QApplication.execStatic();
        
        
    }
}
