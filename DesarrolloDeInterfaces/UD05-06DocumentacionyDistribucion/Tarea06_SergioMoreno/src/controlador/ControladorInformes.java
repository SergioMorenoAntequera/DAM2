/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import modelo.Conexion;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.VistaInformes;

/**
 *
 * @author seran
 */
public class ControladorInformes implements ActionListener {

    VistaInformes informesV;
    
    Conexion mod;
    Connection con;
    
    JasperPrint printer;
    JasperViewer viewer;
    JDialog jasperDialog;
    
    public ControladorInformes(VistaInformes infV){
        this.informesV = infV;
        
        informesV.bInforme1.addActionListener(this);
        informesV.bInforme2.addActionListener(this);
        informesV.bInforme3.addActionListener(this);
        
        iniciar();
        
        mod = new Conexion();
        con = mod.getConexion();
    }
    
    
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Primer informe--------------------------------------------------------
        if (e.getSource() == informesV.bInforme1) {
            mostrarInforme("src/informe/Reporte1.jasper");
        }
        
        //Segundo Informe-------------------------------------------------------
        if (e.getSource() == informesV.bInforme2) {
            mostrarInforme("src/informe/Reporte2.jasper");
        }
        
        //Tercer Informe--------------------------------------------------------
        if (e.getSource() == informesV.bInforme3) {
            mostrarInforme("src/informe/Reporte3.jasper");
        }
    }

    public void mostrarInforme(String informe1) {
        try{
            printer =  JasperFillManager.fillReport(informe1, null, con);
            viewer = new JasperViewer(printer);
            jasperDialog = new JDialog();
            jasperDialog.setContentPane(viewer.getContentPane());
            jasperDialog.setSize(viewer.getSize());
            jasperDialog.setModal(true);
            jasperDialog.setLocationRelativeTo(null);
            jasperDialog.setVisible(true);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void iniciar() {
        this.informesV.setLocationRelativeTo(null);
        this.informesV.setTitle("Informes");
        this.informesV.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
