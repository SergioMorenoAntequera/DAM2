/********************************************************************************
 ** Form generated from reading ui file 'dialogo-copia.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget layoutWidget;
    public QGridLayout gridLayout_6;
    public QLabel label;
    public QGridLayout gridLayout;
    public QLabel label_DNI;
    public QLineEdit lineEdit_DNI;
    public QLabel label_Nombre;
    public QLineEdit lineEdit_Nombre;
    public QLabel label_direccion;
    public QLineEdit lineEdit_Direccion;
    public QSpacerItem horizontalSpacer;
    public QLabel label_Localidad;
    public QLineEdit lineEdit_Localidad;
    public QLabel label_Provincia;
    public QLineEdit lineEdit_Provincia;
    public QLabel label_2;
    public QGridLayout gridLayout_3;
    public QLabel label_3;
    public QLabel label_4;
    public QCalendarWidget calendar_Llegada;
    public QCalendarWidget calendar_Salida;
    public QGridLayout gridLayout_2;
    public QLabel label_5;
    public QSpinBox spinBox_NHabitaciones;
    public QLabel label_6;
    public QComboBox comboBox_tipoHabitacion;
    public QCheckBox checkBox_fumador;
    public QGridLayout gridLayout_5;
    public QGroupBox groupBox_Regimen;
    public QRadioButton radioButton_Alojamiento;
    public QRadioButton radioButton_completa;
    public QRadioButton radioButton_Media;
    public QSpacerItem verticalSpacer;
    public QLabel label_fumadores;
    public QSpacerItem horizontalSpacer_3;
    public QSpacerItem horizontalSpacer_2;
    public QSpacerItem horizontalSpacer_5;
    public QGridLayout gridLayout_4;
    public QPushButton pushButton_Enviar;
    public QSpacerItem horizontalSpacer_4;
    public QPushButton pushButton_Aceptar;
    public QPushButton pushButton_Cancelar;

    public Ui_Dialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(583, 584).expandedTo(Dialog.minimumSizeHint()));
        layoutWidget = new QWidget(Dialog);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(9, 20, 570, 551));
        gridLayout_6 = new QGridLayout(layoutWidget);
        gridLayout_6.setObjectName("gridLayout_6");
        label = new QLabel(layoutWidget);
        label.setObjectName("label");

        gridLayout_6.addWidget(label, 0, 0, 1, 1);

        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        label_DNI = new QLabel(layoutWidget);
        label_DNI.setObjectName("label_DNI");

        gridLayout.addWidget(label_DNI, 0, 0, 1, 1);

        lineEdit_DNI = new QLineEdit(layoutWidget);
        lineEdit_DNI.setObjectName("lineEdit_DNI");

        gridLayout.addWidget(lineEdit_DNI, 0, 1, 1, 2);

        label_Nombre = new QLabel(layoutWidget);
        label_Nombre.setObjectName("label_Nombre");

        gridLayout.addWidget(label_Nombre, 0, 3, 1, 1);

        lineEdit_Nombre = new QLineEdit(layoutWidget);
        lineEdit_Nombre.setObjectName("lineEdit_Nombre");

        gridLayout.addWidget(lineEdit_Nombre, 0, 4, 1, 3);

        label_direccion = new QLabel(layoutWidget);
        label_direccion.setObjectName("label_direccion");

        gridLayout.addWidget(label_direccion, 1, 0, 1, 1);

        lineEdit_Direccion = new QLineEdit(layoutWidget);
        lineEdit_Direccion.setObjectName("lineEdit_Direccion");

        gridLayout.addWidget(lineEdit_Direccion, 1, 1, 1, 6);

        horizontalSpacer = new QSpacerItem(68, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 2, 0, 1, 1);

        label_Localidad = new QLabel(layoutWidget);
        label_Localidad.setObjectName("label_Localidad");

        gridLayout.addWidget(label_Localidad, 2, 1, 1, 1);

        lineEdit_Localidad = new QLineEdit(layoutWidget);
        lineEdit_Localidad.setObjectName("lineEdit_Localidad");

        gridLayout.addWidget(lineEdit_Localidad, 2, 2, 1, 3);

        label_Provincia = new QLabel(layoutWidget);
        label_Provincia.setObjectName("label_Provincia");

        gridLayout.addWidget(label_Provincia, 2, 5, 1, 1);

        lineEdit_Provincia = new QLineEdit(layoutWidget);
        lineEdit_Provincia.setObjectName("lineEdit_Provincia");

        gridLayout.addWidget(lineEdit_Provincia, 2, 6, 1, 1);


        gridLayout_6.addLayout(gridLayout, 1, 0, 1, 1);

        label_2 = new QLabel(layoutWidget);
        label_2.setObjectName("label_2");

        gridLayout_6.addWidget(label_2, 2, 0, 1, 1);

        gridLayout_3 = new QGridLayout();
        gridLayout_3.setObjectName("gridLayout_3");
        label_3 = new QLabel(layoutWidget);
        label_3.setObjectName("label_3");

        gridLayout_3.addWidget(label_3, 0, 0, 1, 1);

        label_4 = new QLabel(layoutWidget);
        label_4.setObjectName("label_4");

        gridLayout_3.addWidget(label_4, 0, 1, 1, 1);

        calendar_Llegada = new QCalendarWidget(layoutWidget);
        calendar_Llegada.setObjectName("calendar_Llegada");

        gridLayout_3.addWidget(calendar_Llegada, 1, 0, 1, 1);

        calendar_Salida = new QCalendarWidget(layoutWidget);
        calendar_Salida.setObjectName("calendar_Salida");

        gridLayout_3.addWidget(calendar_Salida, 1, 1, 1, 1);


        gridLayout_6.addLayout(gridLayout_3, 3, 0, 1, 1);

        gridLayout_2 = new QGridLayout();
        gridLayout_2.setObjectName("gridLayout_2");
        label_5 = new QLabel(layoutWidget);
        label_5.setObjectName("label_5");

        gridLayout_2.addWidget(label_5, 0, 0, 1, 1);

        spinBox_NHabitaciones = new QSpinBox(layoutWidget);
        spinBox_NHabitaciones.setObjectName("spinBox_NHabitaciones");
        spinBox_NHabitaciones.setMinimum(1);
        spinBox_NHabitaciones.setMaximum(15);

        gridLayout_2.addWidget(spinBox_NHabitaciones, 0, 1, 1, 1);

        label_6 = new QLabel(layoutWidget);
        label_6.setObjectName("label_6");

        gridLayout_2.addWidget(label_6, 0, 2, 1, 1);

        comboBox_tipoHabitacion = new QComboBox(layoutWidget);
        comboBox_tipoHabitacion.setObjectName("comboBox_tipoHabitacion");
        comboBox_tipoHabitacion.setEditable(true);

        gridLayout_2.addWidget(comboBox_tipoHabitacion, 0, 3, 1, 1);

        checkBox_fumador = new QCheckBox(layoutWidget);
        checkBox_fumador.setObjectName("checkBox_fumador");
        checkBox_fumador.setChecked(false);

        gridLayout_2.addWidget(checkBox_fumador, 0, 4, 1, 1);


        gridLayout_6.addLayout(gridLayout_2, 4, 0, 1, 1);

        gridLayout_5 = new QGridLayout();
        gridLayout_5.setObjectName("gridLayout_5");
        groupBox_Regimen = new QGroupBox(layoutWidget);
        groupBox_Regimen.setObjectName("groupBox_Regimen");
        radioButton_Alojamiento = new QRadioButton(groupBox_Regimen);
        radioButton_Alojamiento.setObjectName("radioButton_Alojamiento");
        radioButton_Alojamiento.setGeometry(new QRect(10, 20, 138, 17));
        radioButton_completa = new QRadioButton(groupBox_Regimen);
        radioButton_completa.setObjectName("radioButton_completa");
        radioButton_completa.setGeometry(new QRect(10, 60, 106, 17));
        radioButton_Media = new QRadioButton(groupBox_Regimen);
        radioButton_Media.setObjectName("radioButton_Media");
        radioButton_Media.setGeometry(new QRect(10, 40, 91, 17));

        gridLayout_5.addWidget(groupBox_Regimen, 0, 0, 2, 2);

        verticalSpacer = new QSpacerItem(20, 78, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_5.addItem(verticalSpacer, 0, 2, 1, 1);

        label_fumadores = new QLabel(layoutWidget);
        label_fumadores.setObjectName("label_fumadores");

        gridLayout_5.addWidget(label_fumadores, 0, 3, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(138, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_5.addItem(horizontalSpacer_3, 1, 1, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(158, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_5.addItem(horizontalSpacer_2, 1, 2, 1, 1);

        horizontalSpacer_5 = new QSpacerItem(168, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_5.addItem(horizontalSpacer_5, 1, 3, 1, 1);


        gridLayout_6.addLayout(gridLayout_5, 5, 0, 1, 1);

        gridLayout_4 = new QGridLayout();
        gridLayout_4.setObjectName("gridLayout_4");
        pushButton_Enviar = new QPushButton(layoutWidget);
        pushButton_Enviar.setObjectName("pushButton_Enviar");

        gridLayout_4.addWidget(pushButton_Enviar, 0, 0, 1, 1);

        horizontalSpacer_4 = new QSpacerItem(280, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_4.addItem(horizontalSpacer_4, 0, 1, 1, 1);

        pushButton_Aceptar = new QPushButton(layoutWidget);
        pushButton_Aceptar.setObjectName("pushButton_Aceptar");

        gridLayout_4.addWidget(pushButton_Aceptar, 0, 2, 1, 1);

        pushButton_Cancelar = new QPushButton(layoutWidget);
        pushButton_Cancelar.setObjectName("pushButton_Cancelar");

        gridLayout_4.addWidget(pushButton_Cancelar, 0, 3, 1, 1);


        gridLayout_6.addLayout(gridLayout_4, 6, 0, 1, 1);

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
        pushButton_Enviar.clicked.connect(lineEdit_DNI, "clear()");
        pushButton_Enviar.clicked.connect(lineEdit_Nombre, "clear()");
        pushButton_Enviar.clicked.connect(lineEdit_Direccion, "clear()");
        pushButton_Enviar.clicked.connect(lineEdit_Localidad, "clear()");
        pushButton_Enviar.clicked.connect(lineEdit_Provincia, "clear()");
        pushButton_Enviar.clicked.connect(spinBox_NHabitaciones, "clear()");
        pushButton_Enviar.clicked.connect(groupBox_Regimen, "repaint()");
        groupBox_Regimen.clicked.connect(groupBox_Regimen, "close()");
        pushButton_Enviar.clicked.connect(radioButton_Alojamiento, "repaint()");
        pushButton_Enviar.clicked.connect(radioButton_Media, "repaint()");
        pushButton_Enviar.clicked.connect(radioButton_completa, "repaint()");
        pushButton_Enviar.clicked.connect(lineEdit_Localidad, "setFocus()");
        pushButton_Cancelar.clicked.connect(Dialog, "close()");
        pushButton_Aceptar.clicked.connect(Dialog, "showMaximized()");
        pushButton_Enviar.clicked.connect(checkBox_fumador, "setChecked(boolean)");

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
        label_Localidad.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&Localidad", null));
        label_Provincia.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "&Provincia", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p><span style=\" font-size:12pt; font-weight:600;\">Datos Reserva</span></p></body></html>", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha llegada", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha Salida", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "N\u00famero de habitaciones", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo de habitaciones", null));
        comboBox_tipoHabitacion.clear();
        comboBox_tipoHabitacion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Simple", null));
        comboBox_tipoHabitacion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Doble", null));
        comboBox_tipoHabitacion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Suite", null));
        checkBox_fumador.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fumador", null));
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

