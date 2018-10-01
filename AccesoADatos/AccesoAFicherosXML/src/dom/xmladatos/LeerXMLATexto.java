
package dom.xmladatos;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.xml.parsers.*;
import org.w3c.dom.*;


public class LeerXMLATexto {
    public static void main(String[] args){
        
        File fileIn = new File("C:\\Users\\seran\\Desktop/prueba.xml");
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileIn);
            
            doc.getDocumentElement().normalize();
            
            //destino
            fichero = new FileWriter("C:\\Users\\seran\\Desktop/prueba2.txt");
            pw = new PrintWriter(fichero);
            
            NodeList nList = doc.getElementsByTagName("empleado");
            pw.println("Total de empleados: " + nList.getLength());
            
            for(int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    pw.println("ID: " + element.getElementsByTagName("id").item(0).getTextContent());
                    pw.println("Apellido: " + element.getElementsByTagName("Apellido").item(0).getTextContent());
                    pw.println("Departamento: " + element.getElementsByTagName("Departamento").item(0).getTextContent());
                    pw.println("Salario: " + element.getElementsByTagName("Salario").item(0).getTextContent());
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
