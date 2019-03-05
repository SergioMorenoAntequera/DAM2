package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasProductos;
import modelo.Productos;
import vista.VistaProductos;

/**
 * ActionListener para la evntana en la cual se realizan distintas operaciones 
 * sobre los productos.
 * 
 * @author seran
 */
public class ControladorProductos implements ActionListener{
    
    private Productos producto;
    private ConsultasProductos productoC;
    private VistaProductos productoV;

    //--------------------------------------------------------------------------
    
    /**
     * Constructor de la clase. 
     * @param mod Modelo de producto
     * @param modC Consultas de productos
     * @param frm Vista de producto
     */   
    public ControladorProductos(Productos mod, ConsultasProductos modC, VistaProductos frm) {
        this.producto = mod;
        this.productoC = modC;
        this.productoV = frm;
        
        this.productoV.bBuscar.addActionListener(this);
        this.productoV.bEliminar.addActionListener(this);
        this.productoV.bGuardar.addActionListener(this);
        this.productoV.bLimpiar.addActionListener(this);
        this.productoV.bModificar.addActionListener(this);
        
        this.productoV.tfReferencia.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
                if(Character.isLowerCase(e.getKeyChar())){
                    e.consume();
                    productoV.tfReferencia.setText(productoV.tfReferencia.getText() + Character.toUpperCase(e.getKeyChar()));
                }
                
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        this.productoV.tfPrecio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.') {
                    e.consume();
                }
                if (productoV.tfPrecio.getText().indexOf(".") != -1 && e.getKeyChar() == '.') {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        this.productoV.tfDescuento.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.') {
                    e.consume();
                }
                if (productoV.tfDescuento.getText().indexOf(".") != -1 && e.getKeyChar() == '.') {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    //--------------------------------------------------------------------------
    
    /**
     * Inicializamos algunas caracteristicas de la ventana.
     */
    public void iniciar(){
        productoV.setTitle("Productos");
        productoV.setLocationRelativeTo(null);
        productoV.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    /**
     * Metodo que elimina los distintos datos de la interfaz gráfica.
     */
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
                producto.setPrecio(Double.parseDouble(productoV.tfPrecio.getText()));
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
                    JOptionPane.showMessageDialog(null, "Registro no encontrado");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene el campo 'Referencia'");
            }
        }
        
        if(e.getSource() == productoV.bLimpiar){//-----------------------------
            limpiar();
        }
        
    }
    
}
