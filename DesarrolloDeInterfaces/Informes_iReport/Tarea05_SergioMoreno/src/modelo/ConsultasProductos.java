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
public class ConsultasProductos extends Conexion {
    
    public boolean registrar(Productos productos){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO productos (referencia, nombre, descripcion, precio, descuento) VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, productos.getReferencia());
            ps.setString(2, productos.getNombre());
            ps.setString(3, productos.getDescripcion());
            ps.setDouble(4, productos.getPrecio());
            ps.setDouble(5, productos.getDescuento());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Llave primaria duplicada");
            //System.err.println("ERROR: " + e.getMessage());
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
    
    public boolean modificar(Productos producto){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, descuento = ? "
                + "WHERE referencia = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setDouble(4, producto.getDescuento());
            ps.setString(5, producto.getReferencia());
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
    
    public boolean eliminar(Productos producto){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM productos WHERE referencia = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getReferencia());
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
    
    public boolean buscar(Productos producto){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con2 = new Conexion();
        Connection con = con2.getConexion();
        
        String sql = "SELECT * FROM productos WHERE referencia = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getReferencia());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                producto.setReferencia(rs.getString("referencia"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setDescuento(rs.getDouble("descuento"));
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
