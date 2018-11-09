/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej05CrearObjetosconXStream;

import ej04CrearXMLconXStream.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author seran
 */
public class Main {

    public static void main(String[] args) {

        XStream xStream = new XStream(new DomDriver());

        Departamento dep1, dep2, dep3;
        File archivo = new File("Departamentos.dat");

        //Almacenamos los tipos de datos en distintos Arrays
        //(porque sabemos hay 3 registros no tiene que ser listas)
        String[] IDs = new String[3];
        String[] tipos = new String[3];
        String[] nombres = new String[3];
        String[] domicilios = new String[3];
        String[] ciudades = new String[3];
        String[] cps = new String[3];
        String[] provincias = new String[3];
        String[] paises = new String[3];

        //==========================================//
        //Leemos el .txt para rellenar los arrays   //
        //Volcamos los datos según los vamos leyendo//
        //==========================================//
        FileReader fr;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            int cont = 0;
            String linea = br.readLine();
            while (linea != null) {
                IDs[cont] = linea;
                linea = br.readLine();
                tipos[cont] = linea;
                linea = br.readLine();
                nombres[cont] = linea;
                linea = br.readLine();
                domicilios[cont] = linea;
                linea = br.readLine();
                ciudades[cont] = linea;
                linea = br.readLine();
                cps[cont] = linea;
                linea = br.readLine();
                provincias[cont] = linea;
                linea = br.readLine();
                paises[cont] = linea;
                linea = br.readLine();
                cont++;
            }
            //Arrays rellenado con los datos debidos//
            //Y ahora usamos los datos para crear los objetos
            dep1 = new Departamento(IDs[0], tipos[0], nombres[0], domicilios[0], ciudades[0], cps[0], provincias[0], paises[0]);
            dep2 = new Departamento(IDs[1], tipos[1], nombres[1], domicilios[1], ciudades[1], cps[1], provincias[1], paises[1]);
            dep3 = new Departamento(IDs[2], tipos[2], nombres[2], domicilios[2], ciudades[2], cps[2], provincias[2], paises[2]);
            //Ya se han creado 3 objetos Departamentos con los datos de ejemplo

            fr.close();
            xStream.alias("departamento", Departamento.class);
            String sDep1 = (String) xStream.fromXML(archivo);
            System.out.println(sDep1);
            String sDep2 = xStream.toXML(dep2);
            String sDep3 = xStream.toXML(dep3);
            
            //Ahora que ya tenemos la estructura de los departamentos montados queda crear el documento .xml
            File nuevoXML = new File("Departamentos.xml");
            nuevoXML.createNewFile();
            PrintWriter out = new PrintWriter(new FileWriter(nuevoXML));
            
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<Departamentos>");
            out.println(sDep1);
            out.println(sDep2);
            out.println(sDep3);
            out.println("</Departamentos>");
            
            out.close();
        } catch (IOException e) {
            System.out.println("");
        }
    }
    
    public Departamento convertirXmlToDepartamento (String xmlDepartamentos) {
        //Creamos un objeto del tipo departamento que después devolveremos
        Departamento departamento = null;
        try {
            //HAcemos uso de las distintas clases de esta API para poder iniciarlizar los contructores
            JAXBContext contextSession = JAXBContext.newInstance(Departamento.class);
            Unmarshaller unSession = contextSession.createUnmarshaller();
            //En el constructor de readerResultado metemos como parametro el XML
            //Al cual hemos llamado como parametro en el metodo que se encargará del proceso
            StringReader readerResultado = new StringReader(xmlDepartamentos);
            //Finalmente guardamos el Object creado haciendoles un cast en una variable Departamento
            departamento = (Departamento) unSession.unmarshal(readerResultado);
        } catch (JAXBException ex) {         
            System.out.println("Ha surgido un error: " + ex.toString());
        }
        //finalmente lo devolvemos para tener nuestro objeto
        return departamento;
    }
    
}
