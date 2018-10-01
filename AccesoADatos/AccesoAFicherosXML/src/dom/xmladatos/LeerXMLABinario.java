package dom.xmladatos;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LeerXMLABinario {
    public static void main(String[] args){
        
        File fileIn = new File("C:\\Users\\seran\\Desktop/prueba.xml");
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileIn);
            
            doc.getDocumentElement().normalize();
            
            //destino
            fos = new FileOutputStream("C:\\Users\\seran\\Desktop/prueba2.txt");
            salida = new DataOutputStream(fos);
            
            NodeList nList = doc.getElementsByTagName("numeros");
            
            for(int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    salida.writeChars(element.getElementsByTagName("numero").item(0).getTextContent());
                 }
            }
        } catch(Exception e){
           System.out.println ("El error es: " + e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
     }
}
