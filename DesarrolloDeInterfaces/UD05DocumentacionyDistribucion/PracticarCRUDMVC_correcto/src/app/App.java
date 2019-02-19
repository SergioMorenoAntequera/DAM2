
package app;

import controlador.CtrlProducto;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.frmProducto;

/**
 * Clase principal del programa
 * 
 * @author Sergio Moreno Antequera
 * @since 19/02/2019
 * @version 1.0
 */
public class App {
    
    public static void main(String[] args){
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        
        frm.setVisible(true);
    }
    
}
