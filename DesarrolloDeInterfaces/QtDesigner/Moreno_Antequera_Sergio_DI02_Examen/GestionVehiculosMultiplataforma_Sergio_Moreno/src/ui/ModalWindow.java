package ui;
/********************************************************************************
 ** Form generated from reading ui file 'ModalWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;

public class ModalWindow implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label_2;
    public QLabel label_3;
    public QWidget widget;
    public QLabel label;
    public QPushButton bAceptar;
    public QPushButton bCancelar;
    public QWidget widget_3;
    public QLineEdit tfcodigo;
    public QLabel label_6;
    public QLabel label_5;
    public QLabel label_4;
    public QRadioButton rbGasolina;
    public QRadioButton rbDiesel;
    public QRadioButton rbHibrido;
    public QRadioButton rbElectrico;
    public QComboBox cbTVeh;
    public QCheckBox cbCambioManual;
    public QLabel etIncremento;
    public QLineEdit lineEdit_6;
    public QLineEdit lineEdit_7;
    public QLabel label_15;
    public QLabel label_16;
    public QLineEdit lineEdit_8;
    public QWidget widget_4;
    public QLabel label_11;
    public QLabel label_8;
    public QComboBox cbUbi;
    public QLabel label_9;
    public QDateEdit deAlta;
    public QLabel label_17;
    public QSpinBox sbPrecio;
    public QLabel label_7;
    public QTextEdit taAnotaciones;
    public QLabel label_10;
    public QPushButton bAtras;

    public ModalWindow() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(516, 439).expandedTo(Dialog.minimumSizeHint()));
        label_2 = new QLabel(Dialog);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(20, 90, 133, 18));
        QFont font = new QFont();
        font.setFamily("Calibri");
        font.setPointSize(11);
        font.setBold(true);
        font.setWeight(75);
        label_2.setFont(font);
        label_3 = new QLabel(Dialog);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(290, 90, 81, 18));
        QFont font1 = new QFont();
        font1.setFamily("Calibri");
        font1.setPointSize(11);
        font1.setBold(true);
        font1.setWeight(75);
        label_3.setFont(font1);
        widget = new QWidget(Dialog);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(10, 10, 491, 71));
        widget.setStyleSheet("background-color: rgb(34, 170, 255);");
        label = new QLabel(widget);
        label.setObjectName("label");
        label.setGeometry(new QRect(70, 10, 349, 36));
        label.setMinimumSize(new QSize(91, 31));
        QFont font2 = new QFont();
        font2.setFamily("Times New Roman");
        font2.setPointSize(24);
        font2.setBold(true);
        font2.setWeight(75);
        label.setFont(font2);
        label.setStyleSheet("color: rgb(255, 255, 255);");
        bAceptar = new QPushButton(Dialog);
        bAceptar.setObjectName("bAceptar");
        bAceptar.setGeometry(new QRect(90, 370, 75, 23));
        QFont font3 = new QFont();
        font3.setFamily("Calibri");
        font3.setPointSize(11);
        font3.setBold(true);
        font3.setWeight(75);
        bAceptar.setFont(font3);
        bCancelar = new QPushButton(Dialog);
        bCancelar.setObjectName("bCancelar");
        bCancelar.setGeometry(new QRect(90, 400, 75, 23));
        QFont font4 = new QFont();
        font4.setFamily("Calibri");
        font4.setPointSize(11);
        font4.setBold(true);
        font4.setWeight(75);
        bCancelar.setFont(font4);
        widget_3 = new QWidget(Dialog);
        widget_3.setObjectName("widget_3");
        widget_3.setGeometry(new QRect(10, 110, 161, 251));
        widget_3.setStyleSheet("background-color: rgb(185, 255, 238);");
        tfcodigo = new QLineEdit(widget_3);
        tfcodigo.setObjectName("tfcodigo");
        tfcodigo.setGeometry(new QRect(10, 30, 113, 20));
        tfcodigo.setStyleSheet("background-color: rgb(255, 255, 255);");
        label_6 = new QLabel(widget_3);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(10, 130, 105, 18));
        QFont font5 = new QFont();
        font5.setFamily("Calibri");
        font5.setPointSize(11);
        font5.setBold(true);
        font5.setWeight(75);
        label_6.setFont(font5);
        label_5 = new QLabel(widget_3);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(10, 60, 90, 18));
        QFont font6 = new QFont();
        font6.setFamily("Calibri");
        font6.setPointSize(11);
        font6.setBold(true);
        font6.setWeight(75);
        label_5.setFont(font6);
        label_4 = new QLabel(widget_3);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(10, 10, 52, 18));
        QFont font7 = new QFont();
        font7.setFamily("Calibri");
        font7.setPointSize(11);
        font7.setBold(true);
        font7.setWeight(75);
        label_4.setFont(font7);
        rbGasolina = new QRadioButton(widget_3);
        rbGasolina.setObjectName("rbGasolina");
        rbGasolina.setGeometry(new QRect(10, 80, 63, 17));
        rbGasolina.setChecked(true);
        rbDiesel = new QRadioButton(widget_3);
        rbDiesel.setObjectName("rbDiesel");
        rbDiesel.setGeometry(new QRect(80, 80, 51, 17));
        rbHibrido = new QRadioButton(widget_3);
        rbHibrido.setObjectName("rbHibrido");
        rbHibrido.setGeometry(new QRect(10, 100, 56, 17));
        rbElectrico = new QRadioButton(widget_3);
        rbElectrico.setObjectName("rbElectrico");
        rbElectrico.setGeometry(new QRect(80, 100, 63, 17));
        cbTVeh = new QComboBox(widget_3);
        cbTVeh.setObjectName("cbTVeh");
        cbTVeh.setGeometry(new QRect(10, 150, 91, 22));
        cbTVeh.setStyleSheet("background-color: rgb(255, 255, 255);");
        cbCambioManual = new QCheckBox(widget_3);
        cbCambioManual.setObjectName("cbCambioManual");
        cbCambioManual.setGeometry(new QRect(10, 190, 136, 22));
        QFont font8 = new QFont();
        font8.setFamily("Calibri");
        font8.setPointSize(11);
        font8.setBold(true);
        font8.setWeight(75);
        cbCambioManual.setFont(font8);
        cbCambioManual.stateChanged.connect(this, "mostrarMensaje()");
        
        etIncremento = new QLabel(widget_3);
        etIncremento.setObjectName("etIncremento");
        etIncremento.setGeometry(new QRect(10, 210, 130, 36));
        QFont font9 = new QFont();
        font9.setFamily("Calibri");
        font9.setPointSize(11);
        font9.setBold(true);
        font9.setWeight(75);
        etIncremento.setFont(font9);
        etIncremento.setVisible(false);
        lineEdit_6 = new QLineEdit(Dialog);
        lineEdit_6.setObjectName("lineEdit_6");
        lineEdit_6.setGeometry(new QRect(490, 620, 113, 20));
        lineEdit_7 = new QLineEdit(Dialog);
        lineEdit_7.setObjectName("lineEdit_7");
        lineEdit_7.setGeometry(new QRect(490, 680, 113, 20));
        label_15 = new QLabel(Dialog);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(490, 660, 59, 16));
        QFont font10 = new QFont();
        font10.setFamily("Calibri");
        font10.setPointSize(11);
        font10.setBold(true);
        font10.setWeight(75);
        label_15.setFont(font10);
        label_16 = new QLabel(Dialog);
        label_16.setObjectName("label_16");
        label_16.setGeometry(new QRect(490, 720, 55, 18));
        QFont font11 = new QFont();
        font11.setFamily("Calibri");
        font11.setPointSize(11);
        font11.setBold(true);
        font11.setWeight(75);
        label_16.setFont(font11);
        lineEdit_8 = new QLineEdit(Dialog);
        lineEdit_8.setObjectName("lineEdit_8");
        lineEdit_8.setGeometry(new QRect(490, 740, 113, 20));
        widget_4 = new QWidget(Dialog);
        widget_4.setObjectName("widget_4");
        widget_4.setGeometry(new QRect(180, 110, 321, 301));
        widget_4.setStyleSheet("background-color: rgb(185, 255, 238);");
        label_11 = new QLabel(widget_4);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(190, 80, 98, 18));
        QFont font12 = new QFont();
        font12.setFamily("Calibri");
        font12.setPointSize(11);
        font12.setBold(true);
        font12.setWeight(75);
        label_11.setFont(font12);
        label_8 = new QLabel(widget_4);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(20, 20, 81, 18));
        QFont font13 = new QFont();
        font13.setFamily("Calibri");
        font13.setPointSize(11);
        font13.setBold(true);
        font13.setWeight(75);
        label_8.setFont(font13);
        cbUbi = new QComboBox(widget_4);
        cbUbi.setObjectName("cbUbi");
        cbUbi.setGeometry(new QRect(190, 100, 91, 22));
        cbUbi.setStyleSheet("background-color: rgb(255, 255, 255);");
        label_9 = new QLabel(widget_4);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(190, 20, 77, 18));
        QFont font14 = new QFont();
        font14.setFamily("Calibri");
        font14.setPointSize(11);
        font14.setBold(true);
        font14.setWeight(75);
        label_9.setFont(font14);
        deAlta = new QDateEdit(widget_4);
        deAlta.setObjectName("deAlta");
        deAlta.setEnabled(true);
        deAlta.setGeometry(new QRect(20, 40, 110, 22));
        deAlta.setStyleSheet("background-color: rgb(255, 255, 255);");
        deAlta.setDate(QDate.currentDate());
        
        label_17 = new QLabel(widget_4);
        label_17.setObjectName("label_17");
        label_17.setGeometry(new QRect(10, 190, 101, 101));
        label_17.setPixmap(new QPixmap(("source.coche.png")));
        label_17.setScaledContents(true);
        sbPrecio = new QSpinBox(widget_4);
        sbPrecio.setObjectName("sbPrecio");
        sbPrecio.setGeometry(new QRect(190, 40, 91, 22));
        sbPrecio.setStyleSheet("background-color: rgb(255, 255, 255);");
        sbPrecio.setMinimum(9000);
        sbPrecio.setMaximum(50000);
        label_7 = new QLabel(widget_4);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(170, 160, 131, 131));
        label_7.setAutoFillBackground(false);
        label_7.setPixmap(new QPixmap(("../resources/coche.png")));
        label_7.setScaledContents(true);
        taAnotaciones = new QTextEdit(widget_4);
        taAnotaciones.setObjectName("taAnotaciones");
        taAnotaciones.setGeometry(new QRect(20, 110, 131, 181));
        taAnotaciones.setStyleSheet("background-color: rgb(255, 255, 255);");
        label_10 = new QLabel(widget_4);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(20, 90, 78, 18));
        QFont font15 = new QFont();
        font15.setFamily("Calibri");
        font15.setPointSize(11);
        font15.setBold(true);
        font15.setWeight(75);
        label_10.setFont(font15);
        bAtras = new QPushButton(Dialog);
        bAtras.setObjectName("bAtras");
        bAtras.setGeometry(new QRect(10, 400, 75, 23));
        QFont font16 = new QFont();
        font16.setFamily("Calibri");
        font16.setPointSize(11);
        font16.setBold(true);
        font16.setWeight(75);
        bAtras.setFont(font16);
        QWidget.setTabOrder(tfcodigo, rbGasolina);
        QWidget.setTabOrder(rbGasolina, rbDiesel);
        QWidget.setTabOrder(rbDiesel, rbHibrido);
        QWidget.setTabOrder(rbHibrido, rbElectrico);
        QWidget.setTabOrder(rbElectrico, cbTVeh);
        QWidget.setTabOrder(cbTVeh, cbCambioManual);
        QWidget.setTabOrder(cbCambioManual, deAlta);
        QWidget.setTabOrder(deAlta, sbPrecio);
        QWidget.setTabOrder(sbPrecio, cbUbi);
        QWidget.setTabOrder(cbUbi, bAceptar);
        QWidget.setTabOrder(bAceptar, bCancelar);
        QWidget.setTabOrder(bCancelar, bAtras);
        bAceptar.clicked.connect(this, "comprobar()");
        bCancelar.clicked.connect(this, "cancelar()");
        QWidget.setTabOrder(bAtras, taAnotaciones);
        QWidget.setTabOrder(taAnotaciones, lineEdit_6);
        QWidget.setTabOrder(lineEdit_6, lineEdit_7);
        QWidget.setTabOrder(lineEdit_7, lineEdit_8);
        retranslateUi(Dialog);
        bAtras.clicked.connect(Dialog, "close()");

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Realizar reserva", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Datos del veh\u00edculo", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p>Datos de alta</p></body></html>", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Concesionario Antequera", null));
        bAceptar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Mandar informaci\u00f3n", null));
        bAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Aceptar", null));
        bCancelar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Borrar los datos actuales", null));
        bCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cancelar", null));
        tfcodigo.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduce el c\u00f3digo", null));
        tfcodigo.setText("");
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo de Veh\u00edculo", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo de Motor", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Codigo", null));
        rbGasolina.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Gasolina", null));
        rbDiesel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Diesel", null));
        rbHibrido.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Hibrido", null));
        rbElectrico.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Electrico", null));
        cbTVeh.clear();
        cbTVeh.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Turismo", null));
        cbTVeh.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Monovolumen", null));
        cbTVeh.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "SUV", null));
        cbTVeh.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Todoterreno", null));
        cbCambioManual.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "El coche tendr\u00e1 cambios manuales?", null));
        cbCambioManual.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "\u00bfCambio Manual?", null));
        etIncremento.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p align=\"center\">Incrementa el precio<br/>en 500,00\u20ac</p></body></html>", null));
        label_15.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Direcci\u00f3n", null));
        label_16.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tel\u00e9fono", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Ubicaci\u00f3n", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha de alta", null));
        cbUbi.clear();
        cbUbi.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Almacen", null));
        cbUbi.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tienda", null));
        cbUbi.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Taller", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Precio", null));
        label_17.setText("");
        label_7.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Representaci\u00f3n gr\u00e1fica del coche", null));
        label_7.setText("");
        taAnotaciones.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p>Este area existe para dejar un mensaje que quiere que se lea por el vendedor</p></body></html>", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Anotaciones", null));
        bAtras.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Regeresar a la ventana principal", null));
        bAtras.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Atr\u00e1s", null));
    } // retranslateUi

    void mostrarMensaje() {
        if (cbCambioManual.isChecked()) {
            etIncremento.setVisible(true);
        } else {
            etIncremento.setVisible(false);
        }
    }
    
    void cancelar(){
        tfcodigo.setText("");
        rbGasolina.setChecked(true);
        cbTVeh.setCurrentIndex(0);
        cbCambioManual.setChecked(false);
        etIncremento.setVisible(false);
        
        deAlta.setDate(QDate.currentDate());
        sbPrecio.setValue(sbPrecio.minimum());
        cbUbi.setCurrentIndex(0);
        taAnotaciones.setText("");
    }
    
    void comprobar(){
        boolean valido = true;
        if(tfcodigo.text().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Introduce el codigo");
            valido = false;
        }
        if(deAlta.date() == QDate.currentDate()){
            JOptionPane.showMessageDialog(null, "Hoy no puede ser el alta");
            valido = false;
        }
        if(valido){
            JOptionPane.showMessageDialog(null, "Todo recogido correctamente");
            cancelar();
        }
        
    }
}

