package main;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import ui.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seran
 */
public class Main {
    public static void main(String[] args){
        QApplication.initialize(args);
        
        MainWindow v =  new MainWindow();
        QMainWindow qMV = new QMainWindow();
        
        v.setupUi(qMV);
        qMV.show();
        QApplication.execStatic();
        
    }
}
