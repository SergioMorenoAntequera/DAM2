package sax.leerXMLLibros;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

//Mostrar todos los datos de los libros con más de 150 páginas
public class LeerXML02 {
    public static void main (String arg[]){
        XMLReader procesadorXML;
        try{
            //Inicializamos lo necesario
            procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido2 gestor = new GestionContenido2( ) ;
            procesadorXML.setContentHandler(gestor);
            
            //Seleccionamos el fichero
            InputSource fileXML = new InputSource("src\\sax\\leerXMLLibros/Libros.xml");
            
            //Unimos los 2
            procesadorXML.parse(fileXML);
            
        }catch(SAXException ex){
            System.out.println( "No se pudo crear el procesador XML");
        }catch(IOException exs){
            System.out.println( "Error de acceso al fichero origen" );
        } 
    }
}

class GestionContenido2 extends DefaultHandler{
    
    int isbn, paginas; 
    String titulo, editorial;
    
    GestionContenido2(){
        super();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("libro")){
            isbn = Integer.parseInt(attributes.getValue("ISBN"));
        }
    }
    
    @Override
    public void characters( char[] arg0, int start, int length) throws SAXException {
        
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
    }
    
}