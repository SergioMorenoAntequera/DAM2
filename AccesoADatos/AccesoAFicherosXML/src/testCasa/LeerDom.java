package testCasa;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author seran
 */
public class LeerDom {
    
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document document;
            
    public static void main(String[] args){
        File xml = new File("src/testCasa/1.xml");
        
        try {
            
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(xml);
            
            NodeList coches = document.getElementsByTagName("coche");
            System.out.println("Numero de coches: " + coches.getLength());
            
            for (int i = 0; i < coches.getLength(); i++) {
                Element coche = (Element) coches.item(i);
                //Node elemento = coches.item(i)
                
                System.out.println("ID del doche: " + coche.getAttribute("id"));
                System.out.println("Marca: " + coche.getElementsByTagName("marca").item(0).getTextContent());
            }
  
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        
        
        
    }
}
