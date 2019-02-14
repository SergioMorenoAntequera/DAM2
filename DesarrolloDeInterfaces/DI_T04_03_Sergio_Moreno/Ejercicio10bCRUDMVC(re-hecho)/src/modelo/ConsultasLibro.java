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
public class ConsultasLibro extends Conexion {
    
    public boolean registrar(Libro libro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO Libro (codigo, nombre, autor, editorial, numPag) VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getCodigo());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getNumPag());
            ps.execute();
            return true;    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Llave primaria duplicada");
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
    public boolean modificar(Libro libro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE Libro SET nombre = ?, autor = ?, editorial = ?, numPag = ? "
                + "WHERE codigo = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getEditorial());
            ps.setInt(4, libro.getNumPag());
            ps.setInt(5, libro.getCodigo());
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
    
    public boolean eliminar(Libro libro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM Libro WHERE codigo = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getCodigo());
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
    
    public boolean buscar(Libro libro){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion con2 = new Conexion();
        Connection con = con2.getConexion();
        
        String sql = "SELECT * FROM Libro WHERE codigo = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getCodigo());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                libro.setCodigo(rs.getInt("codigo"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setNumPag(rs.getInt("numPag"));
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
