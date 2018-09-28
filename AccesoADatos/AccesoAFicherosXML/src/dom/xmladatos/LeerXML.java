/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.xmladatos;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author windiurno
 */
public class LeerXML {
    public static void main(String[] args){
        
        File fileIn = new File("C:/Users/windiurno/Desktop/e2.xml");
        
        Document document;
        DocumentBuilder builder;
        NodeList numero;
        //Node numero;
        
        //Creacion del parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try{
            builder = factory.newDocumentBuilder();
            document = builder.parse(fileIn);
            document.getDocumentElement().normalize();
            //Con esto el elemento document ya sabe que es Numeros
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            
            numero = document.getElementsByTagName("Numero");
            
            //i es cero porque pilla una lista de nodos de abajo de Numero pero no hay(porque está el valor)
            for(int i = 0; i< numero.getLength(); i++){
                System.out.println("Dato: " + numero.item(0).getAttributes());
            }
            
        } catch(Exception e){
            System.out.println("Error");
        }
        
    }
}
