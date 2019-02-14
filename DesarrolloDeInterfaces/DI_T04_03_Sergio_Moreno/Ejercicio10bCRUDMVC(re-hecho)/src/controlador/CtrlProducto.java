package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ConsultasLibro;
import modelo.Libro;
import vista.FrmLibro;

public class CtrlProducto implements ActionListener{
    
    private Libro libro;
    private ConsultasLibro libroC;
    private FrmLibro vistaLibro;

    //--------------------------------------------------------------------------
    
    public CtrlProducto(Libro mod, ConsultasLibro modC, FrmLibro frm) {
        this.libro = mod;
        this.libroC = modC;
        this.vistaLibro = frm;
        
        this.vistaLibro.bBuscar.addActionListener(this);
        this.vistaLibro.bEliminar.addActionListener(this);
        this.vistaLibro.bGuardar.addActionListener(this);
        this.vistaLibro.bLimpiar.addActionListener(this);
        this.vistaLibro.bModificar.addActionListener(this);
        
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
        
        this.vistaLibro.tfCodigo.addKeyListener(filtrarCaracteres);
        this.vistaLibro.tfNumPaginas.addKeyListener(filtrarCaracteres);
    }

    //--------------------------------------------------------------------------
    
    public void iniciar(){
        vistaLibro.setTitle("Libros");
        vistaLibro.setLocationRelativeTo(null);
    }
    
    public void limpiar(){
        vistaLibro.tfNumPaginas.setText("");
        vistaLibro.tfCodigo.setText("");
        vistaLibro.tfNombre.setText("");
        vistaLibro.tfAutor.setText("");
        vistaLibro.tfEditorial.setText("");
    }
    
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaLibro.bGuardar) {//------------------------------
            if (!vistaLibro.tfCodigo.getText().equalsIgnoreCase("") && !vistaLibro.tfAutor.getText().equalsIgnoreCase("") && !vistaLibro.tfEditorial.getText().equalsIgnoreCase("") && !vistaLibro.tfNombre.getText().equalsIgnoreCase("") && !vistaLibro.tfNumPaginas.getText().equalsIgnoreCase("")) {
                libro.setCodigo(Integer.parseInt(vistaLibro.tfCodigo.getText()));
                libro.setNombre(vistaLibro.tfNombre.getText());
                libro.setAutor(vistaLibro.tfAutor.getText());
                libro.setEditorial(vistaLibro.tfEditorial.getText());
                libro.setNumPag(Integer.parseInt(vistaLibro.tfNumPaginas.getText()));

                if (libroC.registrar(libro)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
            }
        }

        if (e.getSource() == vistaLibro.bModificar) {//---------------------------
            if (!vistaLibro.tfCodigo.getText().equalsIgnoreCase("") && !vistaLibro.tfAutor.getText().equalsIgnoreCase("") && !vistaLibro.tfEditorial.getText().equalsIgnoreCase("") && !vistaLibro.tfNombre.getText().equalsIgnoreCase("") && !vistaLibro.tfNumPaginas.getText().equalsIgnoreCase("")) {
                libro.setCodigo(Integer.parseInt(vistaLibro.tfCodigo.getText()));
                libro.setNombre(vistaLibro.tfNombre.getText());
                libro.setAutor(vistaLibro.tfAutor.getText());
                libro.setEditorial(vistaLibro.tfEditorial.getText());
                libro.setNumPag(Integer.parseInt(vistaLibro.tfNumPaginas.getText()));

                if (libroC.modificar(libro)) {
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

        if (e.getSource() == vistaLibro.bEliminar) {//----------------------------

            if (!vistaLibro.tfCodigo.getText().equalsIgnoreCase("")) {
                libro.setCodigo(Integer.parseInt(vistaLibro.tfCodigo.getText()));
                
                if (libroC.eliminar(libro)) {
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
        
        if(e.getSource() == vistaLibro.bBuscar){//------------------------------
            
            
            if (!vistaLibro.tfCodigo.getText().equalsIgnoreCase("")) {
                libro.setCodigo(Integer.parseInt(vistaLibro.tfCodigo.getText()));
                if(libroC.buscar(libro)){
                vistaLibro.tfNombre.setText(libro.getNombre());
                vistaLibro.tfCodigo.setText(libro.getCodigo()+"");
                vistaLibro.tfAutor.setText(libro.getAutor()+"");
                vistaLibro.tfEditorial.setText(libro.getEditorial());
                vistaLibro.tfNumPaginas.setText(libro.getNumPag()+"");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
            }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene el campo 'codigo'");
            }
            
            
        }
        
        if(e.getSource() == vistaLibro.bLimpiar){//-----------------------------
            limpiar();
        }
        
    }
    
}
