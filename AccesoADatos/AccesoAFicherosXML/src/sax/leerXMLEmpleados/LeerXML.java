package sax.leerXMLEmpleados;
import java.io.File;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class LeerXML {
    
    public static void main(String[] args){
        
        XMLReader procesadorXML;
        
        try {
            //PROCESADOR DEL XML
            procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido();
            //***************ERROR********************
            //procesadorXML.setContentHandler(gestor);
            
            //ARCHIVO XML
            File file = new File("Empleados.xml");
            InputSource fileXML = new InputSource("src\\sax\\leerXMLEmpleados/Empleados.xml");
            
            //SE VINCULAS LOS 2
            procesadorXML.parse(fileXML);
            
        } catch(SAXException ex){
            System.out.println( "No se pudo crear el procesador XML");
        }catch(IOException exs){
            System.out.println( "Error de acceso al fichero origen" );
        }
         
    }

    
}
