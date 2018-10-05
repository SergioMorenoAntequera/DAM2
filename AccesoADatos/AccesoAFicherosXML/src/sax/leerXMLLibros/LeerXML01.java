package sax.leerXMLLibros;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

//Que muestre el titulo de los libros que tienen ISBN par o impar y decirlo
public class LeerXML01 {
    public static void main (String arg[]){
        XMLReader procesadorXML;
        try{
            //Inicializamos lo necesario
            procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido( ) ;
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

class GestionContenido extends DefaultHandler{
    
    boolean mostrar = false, par = false;
    int isbn;
    
    GestionContenido(){
        super();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Evento que indica que empiezaa leer un elemento
        if(qName.equalsIgnoreCase("libro")){
            isbn = Integer.parseInt(attributes.getValue("ISBN"));
            if(isbn % 2 == 0){
                par = true;
            } else {
                par = false;
            }
        }
        if(qName.equalsIgnoreCase("titulo")){
            mostrar = true;
        }
    }
    
    @Override
    public void characters( char[] arg0, int start, int length) throws SAXException {
        String contenido = new String(arg0, start, length);
        if(mostrar && par){
            System.out.println("Libro con ISBN Par: " + contenido);
        } else {
            if(mostrar && !par){
                System.out.println("Libro con ISBN Impar: " + contenido);
            }
        }
        mostrar = false;
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
    }
    
}