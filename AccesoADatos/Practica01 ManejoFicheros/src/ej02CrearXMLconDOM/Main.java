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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

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
        String[] provincias = new String[3];
        String[] paises = new String[3];
       
        //==========================================//
        //Leemos el .txt para rellenar los arrays   //
        //Volcamos los datos según los vamos leyendo//
        //==========================================//
        FileReader fr;
        try {
            fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            
            int cont = 0;
            String linea = br.readLine();
            while(linea != null){
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
                cps [cont] = linea;
                linea = br.readLine();
                provincias[cont] = linea;
                linea = br.readLine();
                paises[cont] = linea;
                linea = br.readLine();
                cont++;
            }
            //Arrays rellenado con los datos debidos//
            
            
            //=======================================//
            //Volvamos los datos anteriores en un XML//
            //=======================================//
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Departamentos", null);
            document.setXmlVersion("1.0");
            
            //Nodo raiz
            Element raiz = document.getDocumentElement();
            //Que haga un elemento Departamento por cada nodo IDs(o cualquiera)
            for(int i=0; i<IDs.length; i++){
                //>>>>> Nodo de Departamento
                Element nodeDepartamento = document.createElement("Departamento"); 
                //>>> Nodo de id
                Element idNode = document.createElement("ID");
                Text idNodeValor = document.createTextNode(IDs[i]);
                idNode.appendChild(idNodeValor);      
                //>>> Nodo de tipo
                Element tipoNode = document.createElement("Tipo"); 
                Text tipoNodeValor = document.createTextNode(tipos[i]);                
                tipoNode.appendChild(tipoNodeValor);
                //>>> Nodo de nombre
                Element nombreNode = document.createElement("Nombre"); 
                Text nombreNodeValor = document.createTextNode(nombres[i]);                
                nombreNode.appendChild(nombreNodeValor);
                //>>> Nodo de domicilio
                Element domicilioNode = document.createElement("Domicilio"); 
                Text domicilioNodeValor = document.createTextNode(domicilios[i]);                
                domicilioNode.appendChild(domicilioNodeValor);
                //>>> Nodo de ciudad
                Element ciudadNode = document.createElement("Ciudad"); 
                Text ciudadNodeValor = document.createTextNode(ciudades[i]);                
                ciudadNode.appendChild(ciudadNodeValor);
                //>>> Nodo de cp
                Element cpNode = document.createElement("CP"); 
                Text cpNodeValor = document.createTextNode(cps[i]);                
                cpNode.appendChild(cpNodeValor);
                //>>> Nodo de provincia
                Element provinciaNode = document.createElement("Provincia"); 
                Text provinciaNodeValor = document.createTextNode(provincias[i]);                
                provinciaNode.appendChild(provinciaNodeValor);
                //>>> Nodo de pais
                Element paisNode = document.createElement("Pais"); 
                Text paisNodeValor = document.createTextNode(paises[i]);                
                paisNode.appendChild(paisNodeValor);
                //Aqui falta poner todos los otros atributos de departamentos
                
                //append los nodos al nodo apartamento
                nodeDepartamento.appendChild(idNode);
                nodeDepartamento.appendChild(tipoNode);
                nodeDepartamento.appendChild(nombreNode);
                nodeDepartamento.appendChild(domicilioNode);
                nodeDepartamento.appendChild(ciudadNode);
                nodeDepartamento.appendChild(cpNode);
                nodeDepartamento.appendChild(provinciaNode);
                nodeDepartamento.appendChild(paisNode);
                //append el nodo apartamento al raiz(departamentos)
                raiz.appendChild(nodeDepartamento); //pegamos el elemento a la raiz "Documento"
            }
            //Generamos el XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("Departamentos"+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
