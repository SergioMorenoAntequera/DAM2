package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para realizar las consultas a la base de datos tienda
 * @author Sergio Moreno Antequera
 */
public class ConsultasProducto extends Conexion {

    /**
     * Método que añade un un nuevo cliente que le llega como parametro 
     * @param pro objeto producto
     * @return true si se ha realizado bien la insercion
     */
    public boolean registrar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO producto (codigo, nombre, precio, cantidad) VALUES(?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    
    public boolean modificar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE producto SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM producto WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Producto pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM producto WHERE codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());

            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
