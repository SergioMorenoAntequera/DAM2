package pack01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlDeErrores {    
    
    public static void main(String[] args){
        
        ResultSet result = null;
        
        try {
            //Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionUrl = "jdbc:mysql://localhost/empresaz?" + "user=root&password=admin&useSSL=false";
            Connection conexion = DriverManager.getConnection(connectionUrl);
            
            Statement sentencia = conexion.createStatement();
            
            //Si cambiamos el codigo y le metemos errores el resultado nos avisará cambiando
            //de 0 a 1 pero no nos dice cual es el error
            //LAS CONSULTAS TIENEN QUE TENER SQLException
            int resultado = sentencia.executeUpdate(
                    "CREATE OR REPLACE VIEW totales(dep, dnombre, nemp, media) AS "
                    + "SELECT d.dept_no, dnombre, COUNT(emp_no), AVG(salario) "
                    + "FROM departamentos d LEFT JOIN empleados e "
                    + "ON e.dept_no = d.dept_no "
                    + "GROUP BY d.dept_no, dnombre");
            //Mensaje de conformacion
            System.out.println("Vista creada con resultado: " + resultado);
            
        } catch (SQLException sql){
            System.out.println("ERROR");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlDeErrores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlDeErrores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlDeErrores.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ControlDeErrores.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }

}
