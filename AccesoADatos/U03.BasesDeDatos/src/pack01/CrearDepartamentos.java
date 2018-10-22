package pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class CrearDepartamentos {
    //private static final String url = "jdbc:mysql://localhost/empresa";
    //private static final String user = "root";
    //private static final String password = "admin";
    
    static private Statement sentencia;
    
    private static final String crearDepartamentos
            = ("CREATE TABLE departamentos("
            + "dept_no TINYINT(2) NOT NULL PRIMARY KEY,"
            + "dnombre VARCHAR(15),"
            + "loc VARCHAR(15)"
            + ")");
    
    private static final String crearDepartamentosApuntes = 
            ("CREATE  TABLE IF NOT EXISTS `empresaz`.`departamentos` (\n"
            + " `dept_no` TINYINT(2) NOT NULL ,\n"
            + " `dnombre` VARCHAR(15) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,\n"
            + " `loc` VARCHAR(15) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,\n"
            + " PRIMARY KEY (`dept_no`) )\n"
            + "ENGINE = InnoDB\n"
            + "DEFAULT CHARACTER SET = utf8\n"
            + "COLLATE = utf8_spanish_ci;");

    
    private static final String insertarDepartamentos = 
            "INSERT INTO departamentos VALUES"
            + "(10, `CONTABILIDAD`, `SEVILLA`)"
            + "(20, `INVESTIGACION`, `MADRID`)"
            + "(30, `VENTAS`, `BARCELONA`)"
            + "(40, `PRODUCCION`, `BILBAO`)";
   
    private static final String insertarDepartamentosApuntes = 
            ("INSERT INTO departamentos VALUES\n"
            + "(10,'CONTABILIDAD','SEVILLA'),\n"
            + "(20,'INVESTIGACIÓN','MADRID'),\n"
            + "(30,'VENTAS','BARCELONA'),\n"
            + "(40,'PRODUCCIÓN','BILBAO');");


    /*private static final String crearDepartamentos
            = ("CREATE TABLE `empresa`.`departamentos` ("
            + "`emp_no` INT NOT NULL,"
            + "`apellido` VARCHAR(10) NULL,"
            + "`oficio` VARCHAR(10) NULL"
            + "`fecha_alt` DATE NULL,"
            + "");*/
    
    public static void main(String[] args){
        try{
            //Lo de la clase TestConectar
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionUrl = "jdbc:mysql://localhost/empresaz?" + "user=root&password=admin&useSSL=false";
            Connection con = DriverManager.getConnection(connectionUrl);
            
            sentencia = con.createStatement();
            sentencia.execute(crearDepartamentosApuntes);
            //Tabla creada
            sentencia.execute(insertarDepartamentosApuntes);
            //Rellenar tabla
            
            System.out.println("Conexión realizada correctamente");
            
        }catch(SQLException e){
            System.out.println("SQL Exception: " + e.toString());
        } catch(ClassNotFoundException cE){
            System.out.println("Exception: " + cE.toString());
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TestConectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
