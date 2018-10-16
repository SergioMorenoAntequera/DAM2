/*package dom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jdk.internal.org.xml.sax.InputSource;

public class ComprobarEstructura {
    public static void main(String[] args){
        
        
        
        try {
            String rutaXML = "src/dom/contacts.xml";
            DocumentBuilderFactory factory;
            
            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler());
            builder.parse(new InputSource(rutaXML));
            
            
        } catch (Exception e) {
        }
    }
}
*/