package ui;
/********************************************************************************
 ** Form generated from reading ui file 'MainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import javax.swing.JOptionPane;

public class MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionAlta_Reserva;
    public QAction actionBaja_Reserva;
    public QAction actionSalir;
    public QAction actionAcerca_de;
    public QWidget centralwidget;
    public QPushButton bNuevo;
    public QLabel label;
    public QPushButton bSalir;
    public QMenuBar menuBar;
    public QMenu menuArchivo;
    public QMenu menuCoche;
    public QMenu menuAyuda;

    public MainWindow() { super(); }

    public void setupUi(QMainWindow vConcesionario)
    {
        vConcesionario.setObjectName("vConcesionario");
        vConcesionario.resize(new QSize(312, 254).expandedTo(vConcesionario.minimumSizeHint()));
        actionAlta_Reserva = new QAction(vConcesionario);
        actionAlta_Reserva.setObjectName("actionAlta_Reserva");
        actionBaja_Reserva = new QAction(vConcesionario);
        actionBaja_Reserva.setObjectName("actionBaja_Reserva");
        actionSalir = new QAction(vConcesionario);
        actionSalir.setObjectName("actionSalir");
        actionAcerca_de = new QAction(vConcesionario);
        actionAcerca_de.setObjectName("actionAcerca_de");
        centralwidget = new QWidget(vConcesionario);
        centralwidget.setObjectName("centralwidget");
        bNuevo = new QPushButton(centralwidget);
        bNuevo.setObjectName("bNuevo");
        bNuevo.setGeometry(new QRect(40, 20, 231, 131));
        QFont font = new QFont();
        font.setFamily("Calibri");
        font.setPointSize(22);
        font.setBold(true);
        font.setWeight(75);
        bNuevo.setFont(font);
        bNuevo.clicked.connect(this, "crearModal()");
        
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(240, 170, 151, 151));
        label.setPixmap(new QPixmap(("../../../Repositorios2/DAM2/DesarrolloDeInterfaces/QtDesigner/Posible examen/ico_Taller.png")));
        label.setScaledContents(true);
        bSalir = new QPushButton(centralwidget);
        bSalir.setObjectName("bSalir");
        bSalir.setGeometry(new QRect(130, 180, 75, 23));
        bSalir.clicked.connect(this, "salir()");
        vConcesionario.setCentralWidget(centralwidget);
        menuBar = new QMenuBar(vConcesionario);
        menuBar.setObjectName("menuBar");
        menuBar.setGeometry(new QRect(0, 0, 312, 21));
        menuArchivo = new QMenu(menuBar);
        menuArchivo.setObjectName("menuArchivo");
        menuCoche = new QMenu(menuBar);
        menuCoche.setObjectName("menuCoche");
        menuAyuda = new QMenu(menuBar);
        menuAyuda.setObjectName("menuAyuda");
        vConcesionario.setMenuBar(menuBar);

        menuBar.addAction(menuArchivo.menuAction());
        menuBar.addAction(menuCoche.menuAction());
        menuBar.addAction(menuAyuda.menuAction());
        menuArchivo.addAction(actionSalir);
        actionSalir.triggered.connect(this, "salir()");
        menuCoche.addAction(actionAlta_Reserva);
        actionAlta_Reserva.triggered.connect(this, "crearModal()");
        menuCoche.addAction(actionBaja_Reserva);
        actionBaja_Reserva.triggered.connect(this, "crearAviso()");
        menuAyuda.addAction(actionAcerca_de);
        retranslateUi(vConcesionario);

        vConcesionario.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow vConcesionario)
    {
        vConcesionario.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Concesionario", null));
        actionAlta_Reserva.setText(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Alta Vehiculo", null));
        actionBaja_Reserva.setText(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Baja Vehiculo", null));
        actionSalir.setText(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Salir", null));
        actionSalir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Pulsa para salir de lla aplicaci\u00f3n", null));
        actionAcerca_de.setText(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Acerca de...", null));
        bNuevo.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Pulsa para pedir cita", null));
        bNuevo.setText(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Nuevo veh\u00edculo", null));
        label.setText("");
        bSalir.setText(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Salir", null));
        menuArchivo.setTitle(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Archivo", null));
        menuCoche.setTitle(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Coche", null));
        menuAyuda.setTitle(com.trolltech.qt.core.QCoreApplication.translate("vConcesionario", "Ayuda", null));
    } // retranslateUi

    void salir(){
        System.exit(0);
    }
    
    void crearModal(){
        ModalWindow vModal = new ModalWindow();
        QDialog qd = new QDialog();
        vModal.setupUi(qd);
        qd.show();
    }
    
    void crearAviso(){
        JOptionPane.showMessageDialog(null, "No está desarrollada la aplicación");
    }
    
    
    
}

