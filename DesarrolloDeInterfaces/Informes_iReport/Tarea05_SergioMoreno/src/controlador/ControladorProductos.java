package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasProductos;
import modelo.Productos;
import vista.MainFrame;
import vista.VistaProductos;


public class ControladorProductos implements ActionListener{
    
    private Productos producto;
    private ConsultasProductos productoC;
    private VistaProductos productoV;

    //--------------------------------------------------------------------------
    
    public ControladorProductos(Productos mod, ConsultasProductos modC, VistaProductos frm) {
        this.producto = mod;
        this.productoC = modC;
        this.productoV = frm;
        
        this.productoV.bBuscar.addActionListener(this);
        this.productoV.bEliminar.addActionListener(this);
        this.productoV.bGuardar.addActionListener(this);
        this.productoV.bLimpiar.addActionListener(this);
        this.productoV.bModificar.addActionListener(this);
        
        KeyListener filtrarCaracteres = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        };
        
        this.productoV.tfPrecio.addKeyListener(filtrarCaracteres);
        this.productoV.tfDescuento.addKeyListener(filtrarCaracteres);
    }

    //--------------------------------------------------------------------------
    
    public void iniciar(){
        productoV.setTitle("Productos");
        productoV.setLocationRelativeTo(null);
        productoV.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    public void limpiar(){
        productoV.tfDescuento.setText("");
        productoV.tfReferencia.setText("");
        productoV.tfNombre.setText("");
        productoV.tfDescripcion.setText("");
        productoV.tfPrecio.setText("");
    }
    
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == productoV.bGuardar) {//------------------------------
            if (!productoV.tfReferencia.getText().equalsIgnoreCase("") && !productoV.tfDescripcion.getText().equalsIgnoreCase("") && !productoV.tfPrecio.getText().equalsIgnoreCase("") && !productoV.tfNombre.getText().equalsIgnoreCase("") && !productoV.tfDescuento.getText().equalsIgnoreCase("")) {
                producto.setReferencia(productoV.tfReferencia.getText());
                producto.setNombre(productoV.tfNombre.getText());
                producto.setDescripcion(productoV.tfDescripcion.getText());
                producto.setPrecio(Integer.parseInt(productoV.tfPrecio.getText()));
                producto.setDescuento(Double.parseDouble(productoV.tfDescuento.getText()));

                if (productoC.registrar(producto)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                    //limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
            }
        }

        if (e.getSource() == productoV.bModificar) {//---------------------------
            if (!productoV.tfReferencia.getText().equalsIgnoreCase("") && !productoV.tfDescripcion.getText().equalsIgnoreCase("") && !productoV.tfPrecio.getText().equalsIgnoreCase("") && !productoV.tfNombre.getText().equalsIgnoreCase("") && !productoV.tfDescuento.getText().equalsIgnoreCase("")) {
                producto.setReferencia(productoV.tfReferencia.getText());
                producto.setNombre(productoV.tfNombre.getText());
                producto.setDescripcion(productoV.tfDescripcion.getText());
                producto.setPrecio(Double.parseDouble(productoV.tfPrecio.getText()));
                producto.setDescuento(Double.parseDouble(productoV.tfDescuento.getText()));

                if (productoC.modificar(producto)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
            }
        }

        
        
        if (e.getSource() == productoV.bEliminar) {//----------------------------

            if (!productoV.tfReferencia.getText().equalsIgnoreCase("")) {
                producto.setReferencia(productoV.tfReferencia.getText());
                
                if (productoC.eliminar(producto)) {
                    JOptionPane.showMessageDialog(null, "Registro elimnado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene el campo 'codigo'");
            }
            
        }
        
        if(e.getSource() == productoV.bBuscar){//------------------------------
            
            if (!productoV.tfReferencia.getText().equalsIgnoreCase("")) {
                producto.setReferencia(productoV.tfReferencia.getText());

                if(productoC.buscar(producto)){
                productoV.tfNombre.setText(producto.getNombre());
                productoV.tfReferencia.setText(producto.getReferencia()+"");
                productoV.tfDescripcion.setText(producto.getDescripcion()+"");
                productoV.tfPrecio.setText(producto.getPrecio()+"");
                productoV.tfDescuento.setText(producto.getDescuento()+"");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
            }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene el campo 'codigo'");
            }
            
            
        }
        
        if(e.getSource() == productoV.bLimpiar){//-----------------------------
            limpiar();
        }
        
    }
    
}
