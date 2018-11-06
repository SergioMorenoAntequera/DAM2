/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearFichero;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seran
 */
public class Main {
    
    public static void main(String[] args){
        //Creamos el fichero serializable
        File archivo = new File("Departamentos.dat");
        FileOutputStream fos;
        ObjectOutputStream salida;
        
        try {
            //Creación del fichero vacío
            if(!archivo.createNewFile()){
                System.out.println("Archivo ya existente, sobreescribiendo.");
                archivo.delete();
                archivo.createNewFile();
            } else {
                System.out.println("Archivo creado satisfactoriamente.");
            }
            
            //Creación de los flujos para los datos.
            fos = new FileOutputStream(archivo);
            salida = new ObjectOutputStream(fos);
            
            Departamento dep1 = new Departamento(1, "Ventas", "Ventas", "Calle Luis", "Madrid", 01004, "Madrid", "España");
            salida.writeObject(dep1);
            Departamento dep2 = new Departamento(1, "Clientes", "Atencion al cliente", "Calle Lopan", "Almeria", 11111, "Almeria", "España");
            salida.writeObject(dep2);
            Departamento dep3 = new Departamento(3, "Compras", "Compras", "Calle Novena", "Berlin", 78765, "Berlin", "Alemania");
            salida.writeObject(dep3);
            
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
}
