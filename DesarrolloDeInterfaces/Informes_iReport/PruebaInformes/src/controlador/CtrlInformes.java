package controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.DialogoInformes;

/**
 * @author Angel Salas Calvo
 */
public class CtrlInformes implements ActionListener{
    private DialogoInformes view;
    private JasperPrint jasPrint; //Objeto donde se carga el informe
    private JasperViewer jasView; //Objeto para cargar la visualización del print
    private JDialog jasperDialog; //Dialogo donde se mostrará el jasView
    
    public CtrlInformes(DialogoInformes view){
        this.view=view;
        
        this.view.jbInforme1.addActionListener(this);
        this.view.jbPDF.addActionListener(this);
        this.view.jbPDF2.addActionListener(this);
        this.view.jbInforme2.addActionListener(this);
    }
    
    /**
     * METODO PARA INICIAR 
     */
    public void iniciar(){
        view.setTitle("Informes Jasper_bdd");
    }
    
    /**
     * SOBRESCRITURA DEL METODO actionPerformed
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Comprobar el boton pulsado
        if(e.getSource() == view.jbInforme1){
            //llamamos a la conexión
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            //Ruta del informe del proyecto
            String path="src/informes/informe1.jasper";
            try {
                //Generamos el llenado del informe
                jasPrint = JasperFillManager.fillReport(path, null, conn);
                //Crear objeto vista
                jasView = new JasperViewer(jasPrint);
                //jasView.setVisible(true);
                
                //Crear dialogo grafico
                jasperDialog = new JDialog();
                jasperDialog.setContentPane(jasView.getContentPane());
                jasperDialog.setSize(jasView.getSize());
                jasperDialog.setModal(true);
                jasperDialog.setVisible(true);
                
            } catch (JRException ex) {
                Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else if(e.getSource() == view.jbPDF){
            //llamamos a la conexión
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            //Ruta del informe del proyecto
            String path="src/informes/informe1.jasper";
            try {
                //Generamos el llenado del informe
                jasPrint = JasperFillManager.fillReport(path, null, conn);
                //Exportar a un archivo pdf
                JasperExportManager.exportReportToPdfFile(jasPrint, "src/pdf/informe1.pdf");
                //Abrir el archivo PDF generado
                File pathPDF = new File("src/pdf/informe1.pdf");
                try {
                    Desktop.getDesktop().open(pathPDF); //Metodo para abrir archivo con aplicacion predeterminada del sistema
                } catch (IOException ex) {
                    Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (JRException ex) {
                Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        //Comprobar el boton pulsado
        else if(e.getSource() == view.jbInforme2){
            //llamamos a la conexión
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            //Ruta del informe del proyecto
            String path="src/informes/informe2.jasper";
            try {
                //Generamos el llenado del informe
                jasPrint = JasperFillManager.fillReport(path, null, conn);
                //Crear objeto vista
                jasView = new JasperViewer(jasPrint);
                //jasView.setVisible(true);
                
                //Crear dialogo grafico
                jasperDialog = new JDialog();
                jasperDialog.setContentPane(jasView.getContentPane());
                jasperDialog.setSize(jasView.getSize());
                jasperDialog.setModal(true);
                jasperDialog.setVisible(true);
                
            } catch (JRException ex) {
                Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else if(e.getSource() == view.jbPDF2){
            //llamamos a la conexión
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            //Ruta del informe del proyecto
            String path="src/informes/informe2.jasper";
            try {
                //Generamos el llenado del informe
                jasPrint = JasperFillManager.fillReport(path, null, conn);
                //Exportar a un archivo pdf
                JasperExportManager.exportReportToPdfFile(jasPrint, "src/pdf/informe2.pdf");
                //Abrir el archivo PDF generado
                File pathPDF = new File("src/pdf/informe2.pdf");
                try {
                    Desktop.getDesktop().open(pathPDF); //Metodo para abrir archivo con aplicacion predeterminada del sistema
                } catch (IOException ex) {
                    Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (JRException ex) {
                Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}