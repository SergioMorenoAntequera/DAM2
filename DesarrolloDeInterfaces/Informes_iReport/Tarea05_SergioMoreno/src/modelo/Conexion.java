package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private final String base = "empresa";
    private final String user = "root";
    private final String password = "admin";
    private final String url = "jdbc:mysql://localhost:3306/" + base + "?autoReconnect=true&useSSL=false";
    private Connection con = null;
    
    //--------------------------------------------------------------------------
    
    public Connection getConexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 

        return con;
    }
}
