package dom.xmladatos.EmpleadosATexto;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.xml.parsers.*;
import org.w3c.dom.*;


public class LeerXMLATexto {
    public static void main(String[] args){
        
        File fileIn = new File("C:\\Users\\windiurno\\Desktop\\e2.xml");
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileIn);
            
            doc.getDocumentElement().normalize();
            
            //destino
            fichero = new FileWriter("C:\\Users\\windiurno\\Desktop\\prueba.txt");
            pw = new PrintWriter(fichero);
            
            NodeList nList = doc.getElementsByTagName("Empleado");
            pw.println("Total de empleados: " + nList.getLength());
            pw.println("");
            
            for(int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    pw.println("ID: " + element.getElementsByTagName("id").item(0).getTextContent());
                    pw.println("Apellido: " + element.getElementsByTagName("apellido").item(0).getTextContent());
                    pw.println("Departamento: " + element.getElementsByTagName("departamento").item(0).getTextContent());
                    pw.println("Salario: " + element.getElementsByTagName("salario").item(0).getTextContent());
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
