/********************************************************************************
 ** Form generated from reading ui file 'dialogo.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label;
    public QLabel label_DNI;
    public QLabel label_Nombre;
    public QLabel label_direccion;
    public QLabel label_Provincia;
    public QLabel label_Localidad;
    public QLineEdit lineEdit_Direccion;
    public QLineEdit lineEdit_DNI;
    public QLineEdit lineEdit_Nombre;
    public QLineEdit lineEdit_Localidad;
    public QLineEdit lineEdit_Provincia;
    public QLabel label_2;
    public QLabel label_3;
    public QLabel label_4;
    public QCalendarWidget calendar_Llegada;
    public QCalendarWidget calendar_Salida;
    public QLabel label_5;
    public QLabel label_6;
    public QCheckBox checkBox_fumador;
    public QSpinBox spinBox_NHabitaciones;
    public QComboBox comboBox_tipoHabitacion;
    public QGroupBox groupBox_Regimen;
    public QRadioButton radioButton_Alojamiento;
    public QRadioButton radioButton_completa;
    public QRadioButton radioButton_Media;
    public QLabel label_fumadores;
    public QPushButton pushButton_Enviar;
    public QPushButton pushButton_Aceptar;
    public QPushButton pushButton_Cancelar;

    public Dialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(601, 563).expandedTo(Dialog.minimumSizeHint()));
        label = new QLabel(Dialog);
        label.setObjectName("label");
        label.setGeometry(new QRect(30, 20, 110, 19));
        label_DNI = new QLabel(Dialog);
        label_DNI.setObjectName("label_DNI");
        label_DNI.setGeometry(new QRect(70, 50, 25, 13));
        label_Nombre = new QLabel(Dialog);
        label_Nombre.setObjectName("label_Nombre");
        label_Nombre.setGeometry(new QRect(250, 50, 44, 13));
        label_direccion = new QLabel(Dialog);
        label_direccion.setObjectName("label_direccion");
        label_direccion.setGeometry(new QRect(50, 80, 50, 13));
        label_Provincia = new QLabel(Dialog);
        label_Provincia.setObjectName("label_Provincia");
        label_Provincia.setGeometry(new QRect(280, 110, 50, 13));
        label_Localidad = new QLabel(Dialog);
        label_Localidad.setObjectName("label_Localidad");
        label_Localidad.setGeometry(new QRect(80, 110, 51, 13));
        lineEdit_Direccion = new QLineEdit(Dialog);
        lineEdit_Direccion.setObjectName("lineEdit_Direccion");
        lineEdit_Direccion.setGeometry(new QRect(110, 80, 371, 20));
        lineEdit_DNI = new QLineEdit(Dialog);
        lineEdit_DNI.setObjectName("lineEdit_DNI");
        lineEdit_DNI.setGeometry(new QRect(110, 50, 131, 20));
        lineEdit_Nombre = new QLineEdit(Dialog);
        lineEdit_Nombre.setObjectName("lineEdit_Nombre");
        lineEdit_Nombre.setGeometry(new QRect(300, 50, 181, 20));
        lineEdit_Localidad = new QLineEdit(Dialog);
        lineEdit_Localidad.setObjectName("lineEdit_Localidad");
        lineEdit_Localidad.setGeometry(new QRect(140, 110, 131, 20));
        lineEdit_Provincia = new QLineEdit(Dialog);
        lineEdit_Provincia.setObjectName("lineEdit_Provincia");
        lineEdit_Provincia.setGeometry(new QRect(342, 110, 141, 20));
        label_2 = new QLabel(Dialog);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(30, 160, 118, 19));
        label_3 = new QLabel(Dialog);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(120, 200, 66, 13));
        label_4 = new QLabel(Dialog);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(420, 200, 60, 13));
        calendar_Llegada = new QCalendarWidget(Dialog);
        calendar_Llegada.setObjectName("calendar_Llegada");
        calendar_Llegada.setGeometry(new QRect(20, 220, 281, 141));
        calendar_Salida = new QCalendarWidget(Dialog);
        calendar_Salida.setObjectName("calendar_Salida");
        calendar_Salida.setGeometry(new QRect(310, 220, 281, 141));
        label_5 = new QLabel(Dialog);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(50, 380, 115, 13));
        label_6 = new QLabel(Dialog);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(250, 380, 96, 13));
        checkBox_fumador = new QCheckBox(Dialog);
        checkBox_fumador.setObjectName("checkBox_fumador");
        checkBox_fumador.setGeometry(new QRect(510, 380, 65, 17));
        checkBox_fumador.setChecked(false);
        spinBox_NHabitaciones = new QSpinBox(Dialog);
        spinBox_NHabitaciones.setObjectName("spinBox_NHabitaciones");
        spinBox_NHabitaciones.setGeometry(new QRect(170, 380, 42, 22));
        spinBox_NHabitaciones.setMinimum(1);
        spinBox_NHabitaciones.setMaximum(15);
        comboBox_tipoHabitacion = new QComboBox(Dialog);
        comboBox_tipoHabitacion.setObjectName("comboBox_tipoHabitacion");
        comboBox_tipoHabitacion.setGeometry(new QRect(360, 380, 131, 22));
        comboBox_tipoHabitacion.setEditable(true);
        groupBox_Regimen = new QGroupBox(Dialog);
        groupBox_Regimen.setObjectName("groupBox_Regimen");
        groupBox_Regimen.setGeometry(new QRect(30, 410, 158, 97));
        radioButton_Alojamiento = new QRadioButton(groupBox_Regimen);
        radioButton_Alojamiento.setObjectName("radioButton_Alojamiento");
        radioButton_Alojamiento.setGeometry(new QRect(10, 20, 138, 17));
        radioButton_completa = new QRadioButton(groupBox_Regimen);
        radioButton_completa.setObjectName("radioButton_completa");
        radioButton_completa.setGeometry(new QRect(10, 60, 106, 17));
        radioButton_Media = new QRadioButton(groupBox_Regimen);
        radioButton_Media.setObjectName("radioButton_Media");
        radioButton_Media.setGeometry(new QRect(10, 40, 91, 17));
        label_fumadores = new QLabel(Dialog);
        label_fumadores.setObjectName("label_fumadores");
        label_fumadores.setGeometry(new QRect(370, 420, 143, 48));
        pushButton_Enviar = new QPushButton(Dialog);
        pushButton_Enviar.setObjectName("pushButton_Enviar");
        pushButton_Enviar.setGeometry(new QRect(30, 530, 75, 23));
        pushButton_Aceptar = new QPushButton(Dialog);
        pushButton_Aceptar.setObjectName("pushButton_Aceptar");
        pushButton_Aceptar.setGeometry(new QRect(410, 530, 75, 23));
        pushButton_Cancelar = new QPushButton(Dialog);
        pushButton_Cancelar.setObjectName("pushButton_Cancelar");
        pushButton_Cancelar.setGeometry(new QRect(490, 530, 75, 23));
        QWidget.setTabOrder(lineEdit_DNI, lineEdit_Nombre);
        QWidget.setTabOrder(lineEdit_Nombre, lineEdit_Direccion);
        QWidget.setTabOrder(lineEdit_Direccion, lineEdit_Localidad);
        QWidget.setTabOrder(lineEdit_Localidad, lineEdit_Provincia);
        QWidget.setTabOrder(lineEdit_Provincia, calendar_Llegada);
        QWidget.setTabOrder(calendar_Llegada, calendar_Salida);
        QWidget.setTabOrder(calendar_Salida, spinBox_NHabitaciones);
        QWidget.setTabOrder(spinBox_NHabitaciones, comboBox_tipoHabitacion);
        QWidget.setTabOrder(comboBox_tipoHabitacion, checkBox_fumador);
        QWidget.setTabOrder(checkBox_fumador, radioButton_Alojamiento);
        QWidget.setTabOrder(radioButton_Alojamiento, radioButton_Media);
        QWidget.setTabOrder(radioButton_Media, radioButton_completa);
        QWidget.setTabOrder(radioButton_completa, pushButton_Enviar);
        QWidget.setTabOrder(pushButton_Enviar, pushButton_Aceptar);
        QWidget.setTabOrder(pushButton_Aceptar, pushButton_Cancelar);
        retranslateUi(Dialog);

        comboBox_tipoHabitacion.setCurrentIndex(0);


        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p><span style=\" font-size:12pt; font-weight:600;\">Datos Cliente</span></p></body></html>", null));
        label_DNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&DNI", null));
        label_Nombre.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&Nombre", null));
        label_direccion.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&Direccion", null));
        label_Provincia.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&Provincia", null));
        label_Localidad.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&Localidad", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p><span style=\" font-size:12pt; font-weight:600;\">Datos Reserva</span></p></body></html>", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha llegada", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha Salida", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "N\u00famero de habitaciones", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo de habitaciones", null));
        checkBox_fumador.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fumador", null));
        comboBox_tipoHabitacion.clear();
        comboBox_tipoHabitacion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Simple", null));
        comboBox_tipoHabitacion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Doble", null));
        comboBox_tipoHabitacion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Suite", null));
        groupBox_Regimen.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Regimen", null));
        radioButton_Alojamiento.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Alojamineto y desayuno", null));
        radioButton_completa.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Pensi\u00f3n completa", null));
        radioButton_Media.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Media Pension", null));
        label_fumadores.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p align=\"center\"><span style=\" font-size:11pt; font-weight:600;\">Solo se fuma en las</span></p><p align=\"center\"><span style=\" font-size:11pt; font-weight:600;\"> area de fumadores</span></p></body></html>", null));
        pushButton_Enviar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Enviar", null));
        pushButton_Aceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Aceptar", null));
        pushButton_Cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cancelar", null));
    } // retranslateUi

}

