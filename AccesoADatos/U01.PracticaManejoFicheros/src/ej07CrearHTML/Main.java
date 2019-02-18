/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej07CrearHTML;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author windiurno
 */
public class Main {

    public static void main(String[] args) {
        //Creamos los distintos archivos que vamos a usar
        File depXSL, depXML, depHTML;
        depXSL = new File("Departamentos.xsl");
        depXML = new File("Departamentos.xml");
        depHTML = new File("Departamentos.html");
        
        //Para este ejercicio utilizaremos la clase de JAVAX
        try {
            //Creamos las clases necesarias y le introducimos los archivos a modificar
            TransformerFactory tff = TransformerFactory.newInstance();
            //Introducimos el xsl que hemos creado a mano para este ejrcicio con 
            //la estructura de nuestro documento Departamentos.xml
            Transformer trasFormer = tff.newTransformer(new StreamSource(depXSL));
            StreamSource streamSource = new StreamSource(depXML);
            StreamResult streamResults = new StreamResult(depHTML);
            trasFormer.transform(streamSource, streamResults);
        } catch (Exception ex) {
            System.out.println("Ha surgido un error: " + ex.toString());
        }
    }
}
