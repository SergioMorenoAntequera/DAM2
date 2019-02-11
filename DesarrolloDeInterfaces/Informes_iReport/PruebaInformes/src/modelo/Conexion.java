package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Angel Salas Calvo
 */
public class Conexion {
    private final String baseDatos = "jasper_bdd";
    private final String usuario = "root";
    private final String pwd = "root";
    private final String url = "jdbc:mysql://localhost:3306/"+baseDatos+"?autoReconnect=true&useSSL=false";
    private Connection con = null;
    
    //--------------------------------------------------------------------------
    
    /**
     * METODO PARA OBTENER LA CONEXIÓN A LA BASE DE DATOS
     * @return 
     */
    public Connection getConexion(){
        try{
            //Crear conexión con la base de datos.
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, pwd); 
            
        }catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}