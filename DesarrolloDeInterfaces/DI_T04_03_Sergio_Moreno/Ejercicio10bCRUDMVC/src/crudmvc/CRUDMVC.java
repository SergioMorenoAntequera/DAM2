 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import controlador.CtrlProducto;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.frmProducto;

/**
 *
 * @author seran
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto mod = new Producto();
        ConsultasProducto con = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod, con, frm);
        ctrl.iniciar();
        frm.setVisible(true);
                
    }
    
}
