 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;
import controlador.CtrlProducto;
import modelo.ConsultasLibro;
import modelo.Libro;
import vista.FrmLibro;

/**
 *
 * @author seran
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro mod = new Libro();
        ConsultasLibro con = new ConsultasLibro();
        FrmLibro frm = new FrmLibro();
        
        CtrlProducto ctrl = new CtrlProducto(mod, con, frm);
        ctrl.iniciar();
        frm.setVisible(true);
                
    }
    
}
