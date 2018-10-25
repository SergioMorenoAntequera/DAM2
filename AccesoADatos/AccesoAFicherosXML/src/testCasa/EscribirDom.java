/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCasa;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
/**
 *
 * @author seran
 */
public class EscribirDom {
    
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document document;
            
    public static void main(String[] args){
        File xml = new File("src/testCasa/1.xml");
        
        try {
            
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(xml);
            
            //Concesionario
            Element eRaiz = document.createElement("concesionario");
            document.appendChild(eRaiz);
            
            //Coche
            Element eCoche = document.createElement("coche");
            eRaiz.appendChild(eCoche);
            Attr atributoCoche = document.createAttribute("id"); //Atributo de coche
            atributoCoche.setValue("1");
            eCoche.setAttributeNode(atributoCoche);
            
            //Marca, modelo, cilindrada
            Element eMarca = document.createElement("marca");
            eMarca.appendChild(document.createTextNode("Renault"));
            eCoche.appendChild(eMarca);
            
            Element eModelo = document.createElement("modelo");
            eModelo.appendChild(document.createTextNode("Megano"));
            eCoche.appendChild(eModelo);
            
            Element eCilindrada = document.createElement("cilindrada");
            eCilindrada.appendChild(document.createTextNode("1.5"));
            eCoche.appendChild(eCilindrada);
            
            
            
  
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        
        
        
    }
    
}
