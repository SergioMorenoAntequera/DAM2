package dom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EjemploApuntes {
    public static void main(String[] args){
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            //Obtenemos una implementacion para DOM
            DOMImplementation implementation = builder.getDOMImplementation( ) ;
            
            //Creamos un documento vacío de nombre document con el nodo raíz de nombre Empleados y asignamos la versión del XML
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); //Asignamos la version de XML
            
            //Creamos un eleento raiz Empleados por cada registro
            Element raiz = document.createElement("empleado"); //Creamos nodo empleado
            document.getDocumentElement().appendChild(raiz);
            
        } catch (Exception e) {
        }
        
    }
}
