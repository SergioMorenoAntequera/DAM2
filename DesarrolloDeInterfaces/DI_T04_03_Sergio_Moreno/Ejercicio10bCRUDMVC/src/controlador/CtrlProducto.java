package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.frmProducto;

public class CtrlProducto implements ActionListener{
    
    private Producto mod;
    private ConsultasProducto modC;
    private frmProducto frm;

    //--------------------------------------------------------------------------
    
    public CtrlProducto(Producto mod, ConsultasProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        
        this.frm.bBuscar.addActionListener(this);
        this.frm.bEliminar.addActionListener(this);
        this.frm.bGuardar.addActionListener(this);
        this.frm.bLimpiar.addActionListener(this);
        this.frm.bModificar.addActionListener(this);
    }

    //--------------------------------------------------------------------------
    
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.tfID.setVisible(false);
    }
    
    public void limpiar(){
        frm.tfCantidad.setText("");
        frm.tfCodigo.setText("");
        frm.tfID.setText("");
        frm.tfNombre.setText("");
        frm.tfPrecio.setText("");
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frm.bBuscar){
            mod.setCodigo(frm.tfCodigo.getText());
            mod.setNombre(frm.tfNombre.getText());
            mod.setCantidad(Integer.parseInt(frm.tfCantidad.getText()));
            mod.setPrecio(Double.parseDouble(frm.tfPrecio.getText()));
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.bModificar){
            mod.setId(Integer.parseInt(frm.tfID.getText()));
            mod.setCodigo(frm.tfCodigo.getText());
            mod.setNombre(frm.tfNombre.getText());
            mod.setCantidad(Integer.parseInt(frm.tfCantidad.getText()));
            mod.setPrecio(Double.parseDouble(frm.tfPrecio.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.bEliminar){
            mod.setId(Integer.parseInt(frm.tfID.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro elimnado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.bBuscar){
            mod.setCodigo(frm.tfCodigo.getText());
            
            if(modC.buscar(mod)){
                frm.tfNombre.setText(mod.getNombre());
                frm.tfCodigo.setText(mod.getCodigo());
                frm.tfCantidad.setText(mod.getCantidad()+"");
                frm.tfPrecio.setText(mod.getPrecio()+"");
                frm.tfID.setText(mod.getId()+"");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.bLimpiar){
            limpiar();
        }
        
    }
    
}
