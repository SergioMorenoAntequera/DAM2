/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack01;

import java.sql.*;
import javax.sql.*;


/**
 *
 * @author windiurno
 */
public class TestConectar {
    public static void main(String[] args){
        try{
            //Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            
            //Cadena de conexiones para conectar con MySQL en localhost
            //Seleccionar la base de 
            String connectionUrl = "jdbc:mysql://localhost/colegio?" + "user=root&password=admin&useSSL=false";
            
            //Obtener la conexion
            Connection con = DriverManager.getConnection(connectionUrl);
            
        }catch(SQLException e){
            System.out.println("SQL Exception: " + e.toString());
        } catch(ClassNotFoundException cE){
            System.out.println("Exception: " + cE.toString());
        }
    }
}
