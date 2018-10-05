package sax.leerXMLNumeros;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class LeerXML {
    public static void main (String arg[]){
        XMLReader procesadorXML;
        try{
            //Inicializamos lo necesario
            procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido( ) ;
            procesadorXML.setContentHandler(gestor);
            
            //Seleccionamos el fichero
            InputSource fileXML = new InputSource("src\\sax\\leerXMLNumeros/Numeros.xml");
            
            //Unimos los 2
            procesadorXML.parse(fileXML);
            
        }catch(SAXException ex){
            System.out.println( "No se pudo crear el procesador XML");
        }catch(IOException exs){
            System.out.println( "Error de acceso al fichero origen" );
        }
    }
}

// Heredamso de DefaultHandler para tener los metodos que manejan la informacion
// Esto se encarga de hacerlo todo
class GestionContenido extends DefaultHandler{
    
    public GestionContenido(){
        super();
    }
    
    //Metodo que coge el valor de la etiqueta
    @Override
    public void characters( char[] ch, int inicio, int longitud) throws SAXException {
        
        String contenido = new String(ch, inicio, longitud);
        //Quitamos los tabulados y saltos de linea y lo dejamos todo linea a linea
        contenido = contenido.replaceAll("[\t \n]", "");
        
        //Si hay contenido lo escribimos
        if(contenido.length() >= 1)
            System.out.println("Numero: " + contenido);
        
    }
}