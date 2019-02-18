package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.input.KeyCharacterCombination;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasVehiculos;
import modelo.Vehiculos;
import vista.VistaVehiculos;


public class ControladorVehiculos implements ActionListener{
    
    private Vehiculos vehiculo;
    private ConsultasVehiculos vehiculoC;
    private VistaVehiculos vehiculoV;

    //--------------------------------------------------------------------------
    
    public ControladorVehiculos(Vehiculos mod, ConsultasVehiculos modC, VistaVehiculos frm) {
        this.vehiculo = mod;
        this.vehiculoC = modC;
        this.vehiculoV = frm;
        
        this.vehiculoV.bBuscar.addActionListener(this);
        this.vehiculoV.bEliminar.addActionListener(this);
        this.vehiculoV.bGuardar.addActionListener(this);
        this.vehiculoV.bLimpiar.addActionListener(this);
        this.vehiculoV.bModificar.addActionListener(this);
        
        KeyListener filtrarCaracteres = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar()) || vehiculoV.tfNumKm.getText().length() >= 8){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        };
        this.vehiculoV.tfNumKm.addKeyListener(filtrarCaracteres);
    }

    //--------------------------------------------------------------------------
    
    public void iniciar(){
        vehiculoV.setTitle("Vehiculo");
        vehiculoV.setLocationRelativeTo(null);
        vehiculoV.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    //--------------------------------------------------------------------------
    
    public void limpiar(){
        vehiculoV.tfMarca.setText("");
        vehiculoV.tfMatricula.setText("");
        vehiculoV.tfModelo.setText("");
        vehiculoV.tfNumKm.setText("");
        vehiculoV.tffRevision.setText("");
    }
    
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vehiculoV.bGuardar) {//------------------------------
            if (!vehiculoV.tfMatricula.getText().equalsIgnoreCase("") && !vehiculoV.tfMarca.getText().equalsIgnoreCase("") && !vehiculoV.tfModelo.getText().equalsIgnoreCase("") && !vehiculoV.tfNumKm.getText().equalsIgnoreCase("") && !vehiculoV.tffRevision.getText().equalsIgnoreCase("")) {
                vehiculo.setMatricula(vehiculoV.tfMatricula.getText());
                vehiculo.setMarca(vehiculoV.tfMarca.getText());
                vehiculo.setModelo(vehiculoV.tfModelo.getText());
                vehiculo.setnKilometros(Integer.parseInt(vehiculoV.tfNumKm.getText()));
                vehiculo.setfRevision(vehiculoV.tffRevision.getText());

                if (vehiculoC.registrar(vehiculo)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado satisfactoriamente");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar", "Error al guardar", JOptionPane.ERROR_MESSAGE);
                    //limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos para poder guardar el registro", "Error al guardar", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == vehiculoV.bModificar) {//---------------------------
            if (!vehiculoV.tfMatricula.getText().equalsIgnoreCase("") && !vehiculoV.tfMarca.getText().equalsIgnoreCase("") && !vehiculoV.tfModelo.getText().equalsIgnoreCase("") && !vehiculoV.tfNumKm.getText().equalsIgnoreCase("") && !vehiculoV.tffRevision.getText().equalsIgnoreCase("")) {
                vehiculo.setMatricula(vehiculoV.tfMatricula.getText());
                vehiculo.setMarca(vehiculoV.tfMarca.getText());
                vehiculo.setModelo(vehiculoV.tfModelo.getText());
                vehiculo.setnKilometros(Integer.parseInt(vehiculoV.tfNumKm.getText()));
                vehiculo.setfRevision(vehiculoV.tffRevision.getText());

                if (vehiculoC.modificar(vehiculo)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado satisfactoriamente");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar", "Error al modificar", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos para poder modificar el registro", "Error al modificar", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        
        if (e.getSource() == vehiculoV.bEliminar) {//----------------------------

            if (!vehiculoV.tfMatricula.getText().equalsIgnoreCase("")) {
                vehiculo.setMatricula(vehiculoV.tfMatricula.getText());
                
                if (vehiculoC.eliminar(vehiculo)) {
                    JOptionPane.showMessageDialog(null, "Registro elimnado satisfactoriamente");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, rellene el campo 'Matricula' para poder eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if(e.getSource() == vehiculoV.bBuscar){//------------------------------
            
            if (!vehiculoV.tfMatricula.getText().equalsIgnoreCase("")) {
                vehiculo.setMatricula(vehiculoV.tfMatricula.getText());

                if(vehiculoC.buscar(vehiculo)){
                vehiculoV.tfMatricula.setText(vehiculo.getMatricula());
                vehiculoV.tfMarca.setText(vehiculo.getMarca()+"");
                vehiculoV.tfModelo.setText(vehiculo.getModelo()+"");
                vehiculoV.tfNumKm.setText(vehiculo.getnKilometros() + "");
                vehiculoV.tffRevision.setText(vehiculo.getfRevision() + "");
                } else {
                    JOptionPane.showMessageDialog(null, "Vehiculo no encontrado", "Error al buscar", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog( null, "Por favor, rellene el campo 'Matricula' para poder realizar la busqueda", "Error al buscar", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
        if(e.getSource() == vehiculoV.bLimpiar){//-----------------------------
            limpiar();
        }
        
    }
    
}
