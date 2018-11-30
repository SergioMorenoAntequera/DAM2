package pack01;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConectar {
    //Para hacer la conexión de la segunda forma sacar las declaraciones aquí
    
    public static void main(String[] args){
        try{
            //Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            //Cadena de conexiones para conectar con MySQL en localhost
            //Seleccionar la base de datos
            
            //********UN MODO**********(Me funciona)
            String connectionUrl = "jdbc:mysql://localhost/empresaz?" + "user=root&password=admin&useSSL=false";
            Connection con = DriverManager.getConnection(connectionUrl);
            
            //********OTRO MODO*******(No me funciona)
            //Sacar las declaraciones fuera del main
            //private static final String url = "jdbc:mysql://localhost/colegio";
            //private static final String user = "root";
            //private static final String password = "admin";
            //Connection con = DriverManager.getConnection(url, user, password);
            
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
