package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author seran
 */
public class ConsultasVehiculos extends Conexion {
    
    public boolean registrar(Vehiculos vehiculos){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO vehiculos (matricula, marca, modelo, nKilometros, fRevision) VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculos.getMatricula());
            ps.setString(2, vehiculos.getMarca());
            ps.setString(3, vehiculos.getModelo());
            ps.setInt(4, vehiculos.getnKilometros());
            ps.setString(5, vehiculos.getfRevision());
            ps.execute();
            return true;
        } catch(SQLException es) {
            JOptionPane.showMessageDialog(null, "Formato de datos incorrecto o matricula ya existente", "Error al guardar", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return false;
    }
    
    //--------------------------------------------------------------------------
    
    public boolean modificar(Vehiculos vehiculo){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE vehiculos SET marca = ?, modelo = ?, nKilometros = ?, fRevision = ? "
                + "WHERE matricula = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getnKilometros());
            ps.setString(4, vehiculo.getfRevision());
            ps.setString(5, vehiculo.getMatricula());
            ps.execute();
            return true;    
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
    //--------------------------------------------------------------------------
    
    public boolean eliminar(Vehiculos vehiculo){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Vehiculos WHERE matricula = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getMatricula());
            ps.execute();
            return true;    
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
    //--------------------------------------------------------------------------
    
    public boolean buscar(Vehiculos vehiculo){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con2 = new Conexion();
        Connection con = con2.getConexion();
        
        String sql = "SELECT * FROM Vehiculos WHERE matricula = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getMatricula());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                vehiculo.setMatricula(rs.getString("matricula"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setnKilometros(rs.getInt("nKilometros"));
                vehiculo.setfRevision(rs.getString("fRevision"));
                return true;
            }
            return false;
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
    }
}
