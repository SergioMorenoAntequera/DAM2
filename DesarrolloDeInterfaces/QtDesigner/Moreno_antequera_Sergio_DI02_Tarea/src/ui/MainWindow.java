/********************************************************************************
 ** Form generated from reading ui file 'VentanaPrincipal.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QLabel label;
    public QPushButton pushButton_reservas;
    public QPushButton pushButton_salir;
    public QMenuBar menubar;
    public QStatusBar statusbar;

    public MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(592, 476).expandedTo(MainWindow.minimumSizeHint()));
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(110, 100, 225, 225));
        label.setPixmap(new QPixmap(("recursos/logoHotel.png")));
        pushButton_reservas = new QPushButton(centralwidget);
        pushButton_reservas.setObjectName("pushButton_reservas");
        pushButton_reservas.setGeometry(new QRect(410, 180, 75, 23));
        pushButton_salir = new QPushButton(centralwidget);
        pushButton_salir.setObjectName("pushButton_salir");
        pushButton_salir.setGeometry(new QRect(410, 240, 75, 23));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 592, 21));
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);
        retranslateUi(MainWindow);
        pushButton_salir.clicked.connect(MainWindow, "close()");

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        label.setText("");
        pushButton_reservas.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reservas", null));
        pushButton_salir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Salir", null));
    } // retranslateUi

}

