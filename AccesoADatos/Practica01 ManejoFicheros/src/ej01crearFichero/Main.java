/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01crearFichero;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Main {

    public static void main(String[] args) {
        File archivo = new File("Departamentos.dat");
        try {
            PrintWriter out = new PrintWriter(new FileWriter(archivo));
            
            //introducimos los datos
            System.out.println("Introduciendo tres ejemplos de registros con datos por defecto");
            //Nuevo registro
            out.println("1");                   //ID
            out.println("Clientes");            //Tipo
            out.println("Atencion al cliente"); //Nombre
            out.println("C/ Lopan");            //Domicilio
            out.println("Almeria");             //Ciudad
            out.println("04007");               //CP
            out.println("Almeria");             //Provincia
            out.println("Espania");             //Pais
            
            //Nuevo registro
            out.println("2");                   //ID
            out.println("Clientes");            //Tipo
            out.println("Servicio al cliente"); //Nombre
            out.println("C/ Madrid");           //Domicilio
            out.println("Madrid");              //Ciudad
            out.println("03221");               //CP
            out.println("Madrid");              //Provincia
            out.println("Espania");             //Pais
            
            //Nuevo registro
            out.println("3");                   //ID
            out.println("Ventas");              //Tipo
            out.println("Venta al publico");    //Nombre
            out.println("C/ Murdia");           //Domicilio
            out.println("Berlin");              //Ciudad
            out.println("04044");               //CP
            out.println("Berlin");              //Provincia
            out.println("Alemania");            //Pais
            //8 filas por registro
            
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
