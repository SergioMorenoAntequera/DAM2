package pack01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultas {    
    
    public static void main(String[] args){
        
        ResultSet result = null;
        
        try {
            //Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionUrl = "jdbc:mysql://localhost/empresaz?" + "user=root&password=admin&useSSL=false";
            Connection conexion = DriverManager.getConnection(connectionUrl);
            
            Statement sentencia = conexion.createStatement();
            
            String consultaDepartamentos = "SELECT * FROM departamentos";
            result = sentencia.executeQuery(consultaDepartamentos);
            
            while(result.next()){
                System.out.printf("%2d  %-15s  %s\n", result.getInt(1),
                        result.getString("dNombre"), result.getString(3));
            }
            
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }

}
