package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.frmProducto;

/**
 * Logica de la aplicacion
 * Donde se implementa la funcionalidad
 * @author Sergio Moreno Antequera
 */
public class CtrlProducto implements ActionListener {

    /**
     * Variables de la clase
     */
    private Producto mod;
    private ConsultasProducto modC;
    private frmProducto frm;

    /**
     * 
     * @param mod
     * @param modC
     * @param frm 
     */
    public CtrlProducto(Producto mod, ConsultasProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;

        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);

    }
    
    public void iniciar(){
        frm.setTitle("CRUDMVC");
        frm.setLocationRelativeTo(null);
        frm.tfID.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnBuscar){
            mod.setCodigo(frm.tfCodigo.getText());            
            if(modC.buscar(mod)){
                frm.tfID.setText(String.valueOf(mod.getId()));
                frm.tfCodigo.setText(mod.getCodigo());
                frm.tfNombre.setText(mod.getNombre());
                frm.tfPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.tfCantidad.setText(String.valueOf(mod.getCantidad()));                
            }else{
                JOptionPane.showMessageDialog(null, "Fallo al buscar", "Error", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }
        if(e.getSource()==frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.tfID.getText()));            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Fallo al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
        if(e.getSource()==frm.btnGuardar){
            mod.setCodigo(frm.tfCodigo.getText());
            mod.setNombre(frm.tfNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.tfPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.tfCantidad.getText()));
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Fallo al registrar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
        if(e.getSource()==frm.btnModificar){
            mod.setId(Integer.parseInt(frm.tfID.getText()));
            mod.setCodigo(frm.tfCodigo.getText());
            mod.setNombre(frm.tfNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.tfPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.tfCantidad.getText()));
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Modificación completada", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Fallo al modificar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
        if(e.getSource()==frm.btnLimpiar){
            limpiar();
        }
    }
    
    public void limpiar(){
        frm.tfCantidad.setText("");
        frm.tfCodigo.setText("");
        frm.tfID.setText("");
        frm.tfNombre.setText("");
        frm.tfPrecio.setText("");
    }
}
