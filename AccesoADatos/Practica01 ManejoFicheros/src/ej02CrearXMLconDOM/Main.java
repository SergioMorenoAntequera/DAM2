/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02CrearXMLconDOM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args) {
        File archivo = new File("Departamentos.dat");
        
        //Almacenamos los tipos de datos en distintos Arrays
        //(porque sabemos hay 3 registros no tiene que ser listas)
        String[] IDs = new String[3];
        String[] tipos = new String[3];
        String[] nombres = new String[3];
        String[] domicilios = new String[3];
        String[] ciudades = new String[3];
        String[] cps = new String[3];
        String[] pprovincias = new String[3];
        String[] paises = new String[3];
        
        //Leemos el txt para rellenar los arrays
        FileReader fr;
        try {
            fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            
            int i = 0;
            String linea = br.readLine();
            while(linea != null){
                IDs[i] = linea;
                linea = br.readLine();
                tipos[i] = linea;
                linea = br.readLine();
                tipos[i] = linea;
                linea = br.readLine();
                tipos[i] = linea;
                linea = br.readLine();
                tipos[i] = linea;
                linea = br.readLine();
                tipos[i] = linea;
                linea = br.readLine();
                tipos[i] = linea;
                linea = br.readLine();
                
                i++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
