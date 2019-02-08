package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author seran
 */
public class ConsultasProducto extends Conexion {
    
    public boolean registrar(Producto pro){
        
        PreparedStatement ps = null;
        Connection con = getConecction();
        
        String sql = "INSERT INTO Producto (codigo, nombre, precio, cantidad) VALUES(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
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
    
    public boolean modificar(Producto pro){
        
        PreparedStatement ps = null;
        Connection con = getConecction();
        
        String sql = "UPDATE Producto SET codigo = ?, nombre = ?, precio = ?, cantidad = ? "
                + "WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
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
    
    public boolean eliminar(Producto pro){
        
        PreparedStatement ps = null;
        Connection con = getConecction();
        
        String sql = "DELETE FROM Producto WHERE ID = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
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
    
    public boolean buscar(Producto pro){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConecction();
        
        String sql = "SELECT * FROM Producto WHERE codigo = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
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
