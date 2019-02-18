/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConsultasProductos;
import modelo.ConsultasVehiculos;
import modelo.Productos;
import modelo.Vehiculos;
import vista.MainFrame;
import vista.VistaProductos;
import vista.VistaVehiculos;

/**
 *
 * @author seran
 */
public class ControladorMainFrame implements ActionListener {
    
    MainFrame mainFrame;
            
    public ControladorMainFrame(MainFrame mf){
        
        this.mainFrame = mf;
        
        this.mainFrame.bProductos.addActionListener(this);
        this.mainFrame.bVehiculos.addActionListener(this);
        this.mainFrame.miVehiculos.addActionListener(this);
        this.mainFrame.miProductos.addActionListener(this);
        
    }
    
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == mainFrame.bProductos || e.getSource() == mainFrame.miProductos) {
            Productos mod = new Productos();
            ConsultasProductos con = new ConsultasProductos();
            VistaProductos frm = new VistaProductos();

            ControladorProductos ctrl = new ControladorProductos(mod, con, frm);
            ctrl.iniciar();
            frm.setVisible(true);
        }
        
        //----------------------------------------------------------------------
        
        if (e.getSource() == mainFrame.bVehiculos || e.getSource() == mainFrame.miVehiculos) {
            Vehiculos mod = new Vehiculos();
            ConsultasVehiculos con = new ConsultasVehiculos();
            VistaVehiculos frm = new VistaVehiculos();

            ControladorVehiculos ctrl = new ControladorVehiculos(mod, con, frm);
            ctrl.iniciar();
            frm.setVisible(true);
        }
        
        

    }
    
}
