package ui;
/********************************************************************************
 ** Form generated from reading ui file 'VentanaModal.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import static com.trolltech.qt.QVariant.Date;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;

public class Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label_2;
    public QLabel label_3;
    public QWidget widget;
    public QLabel label;
    public QPushButton bAceptar;
    public QPushButton bCancelar;
    public QWidget widget_3;
    public QLineEdit tfNombre;
    public QLineEdit tfDireccion;
    public QLabel label_6;
    public QLabel label_5;
    public QLabel label_4;
    public QLabel label_7;
    public QLineEdit tfTelefono;
    public QLineEdit tfApellidos;
    public QLineEdit lineEdit_6;
    public QLineEdit lineEdit_7;
    public QLabel label_15;
    public QLabel label_16;
    public QLineEdit lineEdit_8;
    public QWidget widget_4;
    public QLabel label_12;
    public QCheckBox cbNinios;
    public QDateEdit deSalida;
    public QLabel label_11;
    public QLabel label_8;
    public QSpinBox sbNDias;
    public QWidget widget_2;
    public QLabel label_14;
    public QSpinBox sbEdad;
    public QLineEdit tfEdad;
    public QLabel label_10;
    public QComboBox cbTHab;
    public QLabel label_9;
    public QSpinBox sbNHab;
    public QDateEdit deLlegada;
    public QLabel label_13;
    public QLabel label_17;
    public QPushButton bAtras;

    public Dialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(511, 433).expandedTo(Dialog.minimumSizeHint()));
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
        label_3.setGeometry(new QRect(260, 90, 128, 18));
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
        label.setGeometry(new QRect(140, 20, 229, 36));
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
        bAceptar.clicked.connect(this, "comprobar()");
        
        
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
        tfNombre = new QLineEdit(widget_3);
        tfNombre.setObjectName("tfNombre");
        tfNombre.setGeometry(new QRect(10, 30, 113, 20));
        tfNombre.setStyleSheet("background-color: rgb(255, 255, 255);");
        tfDireccion = new QLineEdit(widget_3);
        tfDireccion.setObjectName("tfDireccion");
        tfDireccion.setGeometry(new QRect(10, 150, 113, 20));
        tfDireccion.setStyleSheet("background-color: rgb(255, 255, 255);");
        label_6 = new QLabel(widget_3);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(10, 130, 59, 16));
        QFont font5 = new QFont();
        font5.setFamily("Calibri");
        font5.setPointSize(11);
        font5.setBold(true);
        font5.setWeight(75);
        label_6.setFont(font5);
        label_5 = new QLabel(widget_3);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(10, 70, 60, 18));
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
        label_7 = new QLabel(widget_3);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(10, 190, 55, 18));
        QFont font8 = new QFont();
        font8.setFamily("Calibri");
        font8.setPointSize(11);
        font8.setBold(true);
        font8.setWeight(75);
        label_7.setFont(font8);
        tfTelefono = new QLineEdit(widget_3);
        tfTelefono.setObjectName("tfTelefono");
        tfTelefono.setGeometry(new QRect(10, 210, 113, 20));
        tfTelefono.setStyleSheet("background-color: rgb(255, 255, 255);");        
        tfApellidos = new QLineEdit(widget_3);
        tfApellidos.setObjectName("tfApellidos");
        tfApellidos.setGeometry(new QRect(10, 90, 113, 20));
        tfApellidos.setStyleSheet("background-color: rgb(255, 255, 255);");
        lineEdit_6 = new QLineEdit(Dialog);
        lineEdit_6.setObjectName("lineEdit_6");
        lineEdit_6.setGeometry(new QRect(490, 620, 113, 20));
        lineEdit_7 = new QLineEdit(Dialog);
        lineEdit_7.setObjectName("lineEdit_7");
        lineEdit_7.setGeometry(new QRect(490, 680, 113, 20));
        label_15 = new QLabel(Dialog);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(490, 660, 59, 16));
        QFont font9 = new QFont();
        font9.setFamily("Calibri");
        font9.setPointSize(11);
        font9.setBold(true);
        font9.setWeight(75);
        label_15.setFont(font9);
        label_16 = new QLabel(Dialog);
        label_16.setObjectName("label_16");
        label_16.setGeometry(new QRect(490, 720, 55, 18));
        QFont font10 = new QFont();
        font10.setFamily("Calibri");
        font10.setPointSize(11);
        font10.setBold(true);
        font10.setWeight(75);
        label_16.setFont(font10);
        lineEdit_8 = new QLineEdit(Dialog);
        lineEdit_8.setObjectName("lineEdit_8");
        lineEdit_8.setGeometry(new QRect(490, 740, 113, 20));
        widget_4 = new QWidget(Dialog);
        widget_4.setObjectName("widget_4");
        widget_4.setGeometry(new QRect(180, 110, 321, 301));
        widget_4.setStyleSheet("background-color: rgb(185, 255, 238);");
        label_12 = new QLabel(widget_4);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(20, 140, 134, 18));
        QFont font11 = new QFont();
        font11.setFamily("Calibri");
        font11.setPointSize(11);
        font11.setBold(true);
        font11.setWeight(75);
        label_12.setFont(font11);
        cbNinios = new QCheckBox(widget_4);
        cbNinios.setObjectName("cbNinios");
        cbNinios.setGeometry(new QRect(190, 160, 31, 17));
        cbNinios.stateChanged.connect(this, "mostrarPanel()");
        QFont font12 = new QFont();
        font12.setFamily("Calibri");
        font12.setPointSize(11);
        font12.setBold(true);
        font12.setWeight(75);
        cbNinios.setFont(font12);
        deSalida = new QDateEdit(widget_4);
        deSalida.setObjectName("deSalida");
        deSalida.setGeometry(new QRect(190, 40, 110, 22));
        deSalida.setStyleSheet("background-color: rgb(255, 255, 255);");
        deSalida.setDate(QDate.currentDate());
        label_11 = new QLabel(widget_4);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(190, 80, 98, 18));
        QFont font13 = new QFont();
        font13.setFamily("Calibri");
        font13.setPointSize(11);
        font13.setBold(true);
        font13.setWeight(75);
        label_11.setFont(font13);
        label_8 = new QLabel(widget_4);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(20, 20, 84, 18));
        QFont font14 = new QFont();
        font14.setFamily("Calibri");
        font14.setPointSize(11);
        font14.setBold(true);
        font14.setWeight(75);
        label_8.setFont(font14);
        sbNDias = new QSpinBox(widget_4);
        sbNDias.setObjectName("sbNDias");
        sbNDias.setGeometry(new QRect(20, 100, 51, 22));
        sbNDias.setStyleSheet("background-color: rgb(255, 255, 255);");
        sbNDias.setMinimum(1);
        sbNDias.setMaximum(14);
        widget_2 = new QWidget(widget_4);
        widget_2.setObjectName("widget_2");
        widget_2.setEnabled(false);
        widget_2.setGeometry(new QRect(120, 190, 191, 101));
        widget_2.setStyleSheet("background-color: rgb(93, 234, 255);");
        label_14 = new QLabel(widget_2);
        label_14.setObjectName("label_14");
        label_14.setGeometry(new QRect(40, 20, 34, 18));
        QFont font15 = new QFont();
        font15.setFamily("Calibri");
        font15.setPointSize(11);
        font15.setBold(true);
        font15.setWeight(75);
        label_14.setFont(font15);
        sbEdad = new QSpinBox(widget_2);
        sbEdad.setObjectName("sbEdad");
        sbEdad.setGeometry(new QRect(80, 20, 51, 22));
        sbEdad.setStyleSheet("background-color: rgb(255, 255, 255);");
        sbEdad.setMinimum(1);
        sbEdad.setMaximum(14);
        sbEdad.valueChanged.connect(this, "ponerCama()");
        tfEdad = new QLineEdit(widget_2);
        tfEdad.setObjectName("tfEdad");
        tfEdad.setGeometry(new QRect(30, 50, 113, 20));
        tfEdad.setStyleSheet("background-color: rgb(255, 255, 255);");
        tfEdad.setText("Cuna");
        label_10 = new QLabel(widget_4);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(20, 80, 84, 18));
        QFont font16 = new QFont();
        font16.setFamily("Calibri");
        font16.setPointSize(11);
        font16.setBold(true);
        font16.setWeight(75);
        label_10.setFont(font16);
        cbTHab = new QComboBox(widget_4);
        cbTHab.setObjectName("cbTHab");
        cbTHab.setGeometry(new QRect(190, 100, 91, 22));
        cbTHab.setStyleSheet("background-color: rgb(255, 255, 255);");
        label_9 = new QLabel(widget_4);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(190, 20, 77, 18));
        QFont font17 = new QFont();
        font17.setFamily("Calibri");
        font17.setPointSize(11);
        font17.setBold(true);
        font17.setWeight(75);
        label_9.setFont(font17);
        sbNHab = new QSpinBox(widget_4);
        sbNHab.setObjectName("sbNHab");
        sbNHab.setGeometry(new QRect(20, 160, 51, 22));
        sbNHab.setStyleSheet("background-color: rgb(255, 255, 255);");
        sbNHab.setMinimum(1);
        sbNHab.setMaximum(5);
        deLlegada = new QDateEdit(widget_4);
        deLlegada.setObjectName("deLlegada");
        deLlegada.setEnabled(true);
        deLlegada.setGeometry(new QRect(20, 40, 110, 22));
        deLlegada.setStyleSheet("background-color: rgb(255, 255, 255);");
        deLlegada.setDate(QDate.currentDate());
        label_13 = new QLabel(widget_4);
        label_13.setObjectName("label_13");
        label_13.setGeometry(new QRect(190, 140, 51, 18));
        QFont font18 = new QFont();
        font18.setFamily("Calibri");
        font18.setPointSize(11);
        font18.setBold(true);
        font18.setWeight(75);
        label_13.setFont(font18);
        label_17 = new QLabel(widget_4);
        label_17.setObjectName("label_17");
        label_17.setGeometry(new QRect(10, 190, 101, 101));
        label_17.setPixmap(new QPixmap(("src/source/logoHotel.png")));
        label_17.setScaledContents(true);
        bAtras = new QPushButton(Dialog);
        bAtras.setObjectName("bAtras");
        bAtras.setGeometry(new QRect(10, 400, 75, 23));
        QFont font19 = new QFont();
        font19.setFamily("Calibri");
        font19.setPointSize(11);
        font19.setBold(true);
        font19.setWeight(75);
        bAtras.setFont(font19);
        QWidget.setTabOrder(tfNombre, tfApellidos);
        QWidget.setTabOrder(tfApellidos, tfDireccion);
        QWidget.setTabOrder(tfDireccion, tfTelefono);
        QWidget.setTabOrder(tfTelefono, deLlegada);
        QWidget.setTabOrder(deLlegada, deSalida);
        QWidget.setTabOrder(deSalida, sbNDias);
        QWidget.setTabOrder(sbNDias, cbTHab);
        QWidget.setTabOrder(cbTHab, sbNHab);
        QWidget.setTabOrder(sbNHab, cbNinios);
        QWidget.setTabOrder(cbNinios, sbEdad);
        QWidget.setTabOrder(sbEdad, tfEdad);
        QWidget.setTabOrder(tfEdad, bAceptar);
        QWidget.setTabOrder(bAceptar, bCancelar);
        QWidget.setTabOrder(bCancelar, bAtras);
        QWidget.setTabOrder(bAtras, lineEdit_7);
        QWidget.setTabOrder(lineEdit_7, lineEdit_8);
        QWidget.setTabOrder(lineEdit_8, lineEdit_6);
        retranslateUi(Dialog);
        bAtras.clicked.connect(Dialog, "close()");
        bCancelar.clicked.connect(tfNombre, "clear()");
        bCancelar.clicked.connect(tfApellidos, "clear()");
        bCancelar.clicked.connect(tfDireccion, "clear()");
        bCancelar.clicked.connect(tfTelefono, "clear()");
        bCancelar.clicked.connect(cbNinios, "setChecked(boolean)");

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Realizar reserva", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Informaci\u00f3n Personal", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p>Informaci\u00f3n Reserva</p></body></html>", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Hotel Antequera", null));
        bAceptar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Mandar informaci\u00f3n", null));
        bAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Aceptar", null));
        bCancelar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Borrar los datos actuales", null));
        bCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cancelar", null));
        tfNombre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su nombre", null));
        tfNombre.setText("");
        tfDireccion.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su direcci\u00f3n", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Direcci\u00f3n", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Apellidos", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Nombre", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tel\u00e9fono", null));
        tfTelefono.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su tel\u00e9fono", null));
        tfApellidos.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca sus apellidos", null));
        label_15.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Direcci\u00f3n", null));
        label_16.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tel\u00e9fono", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "N\u00famero habitaciones", null));
        cbNinios.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Indica si se va a asistir con ni\u00f1os", null));
        cbNinios.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "S\u00ed", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo Habitaci\u00f3n", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha llegada", null));
        label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Edad:", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "N\u00famero d\u00edas", null));
        cbTHab.clear();
        cbTHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Simple", null));
        cbTHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Doble", null));
        cbTHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Suite", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha Salida", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "\u00bfNi\u00f1os?", null));
        label_17.setText("");
        bAtras.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Regeresar a la ventana principal", null));
        bAtras.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Atr\u00e1s", null));
    } // retranslateUi

    void mostrarPanel(){
        if(cbNinios.isChecked()){
          widget_2.setEnabled(true);
        } else {
            widget_2.setEnabled(false);
        }
    }
    
    void ponerCama(){
        if(sbEdad.value()<5){
            tfEdad.setText("Cuna");
        } else {
            if(sbEdad.value()<11){
                tfEdad.setText("Cama pequeña");
            } else {
                if(sbEdad.value()<15){
                    tfEdad.setText("Cama normal");
                }
            }
        }
             
    }
    
    void comprobar(){
        boolean valido = true;
        if(tfNombre.text().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Introduce el nombre");
            valido = false;
        }
        if(tfApellidos.text().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Introduce el apellido");
            valido = false;
        }
        if(tfDireccion.text().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Introduce el direccion");
            valido = false;
        }
        if(tfTelefono.text().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Introduce el telefono");
            valido = false;
        }
        if(valido){
            JOptionPane.showMessageDialog(null, "Datos recogidos correctamente");
            tfNombre.clear();
            tfApellidos.clear();
            tfDireccion.clear();
            tfTelefono.clear();
        }
    }
    
}

