package ej06CrearDATdeXML;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.xml.parsers.*;
import org.w3c.dom.*;


public class LeerXMLATexto {
    public static void main(String[] args){
        
        File fileIn = new File("Departamentos.xml");
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileIn);
            
            doc.getDocumentElement().normalize();
            
            //destino
            fichero = new FileWriter("Departamentos.dat");
            pw = new PrintWriter(fichero);
            
            NodeList nList = doc.getElementsByTagName("departamento");
            
            for(int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    pw.println("ID: " + element.getElementsByTagName("id").item(0).getTextContent());
                    pw.println("Tipo: " + element.getElementsByTagName("tipo").item(0).getTextContent());
                    pw.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    pw.println("Domicilio: " + element.getElementsByTagName("domicilio").item(0).getTextContent());
                    pw.println("Ciudad: " + element.getElementsByTagName("ciudad").item(0).getTextContent());
                    pw.println("cp: " + element.getElementsByTagName("cp").item(0).getTextContent());
                    pw.println("Provincia: " + element.getElementsByTagName("provincia").item(0).getTextContent());
                    pw.println("Pais: " + element.getElementsByTagName("pais").item(0).getTextContent());
                    pw.println("");
                }
            }
      
        } catch(Exception e){
           System.out.println ("El error es: " + e.getMessage());
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
     }
}
