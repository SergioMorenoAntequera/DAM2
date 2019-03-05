package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que nos proporciona la conexion con la base de datos.
 * @author seran
 */
public class Conexion {
    
    private final String base = "empresa";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base + "?autoReconnect=true&useSSL=false";
    private Connection con = null;
    
    //--------------------------------------------------------------------------
    
    /**
     * Metodo que nos devuelve la conexion con los datos que se le hayan introducido 
     * en la misma clase.
     * @return conexion ya realizada con la que trabajar
     */
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
