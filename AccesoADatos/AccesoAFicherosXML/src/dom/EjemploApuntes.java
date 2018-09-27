package dom;
import java.io.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static jdk.nashorn.internal.runtime.Debug.id;
import jdk.nashorn.internal.runtime.Source;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class EjemploApuntes {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        //Ruta de los ficheros origen y destino
        File ficheroIn = new File("C:\\Users\\seran\\Desktop/In.dat");
        File ficheroOu = new File("C:\\Users\\seran\\Desktop/Out.xml");
        
        RandomAccessFile file = new RandomAccessFile(ficheroIn, "r"); //Fichero de acceso aleatorio
        
        Source source;
        Result result;
        
        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        
        //Para la creación del parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //Obtenemos un proceso o parer XML
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Obtenemos una implementacion para DOM
            DOMImplementation implementation = builder.getDOMImplementation( ) ;
            //Creamos un documento vacio con el nodo raiz de nombre Empleados
            
            //Creamos un documento vacío de nombre document con el nodo raíz de nombre Empleados y asignamos la versión del XML
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); //Asignamos la version de XML
            
            /*//Creamos un eleento raiz Empleados por cada registro
            raiz = document.createElement("empleado"); //Creamos nodo empleado
            document.getDocumentElement().appendChild(raiz); //Lo pegamos a la raiz
            */
            
            posicion = 0; //PAra situarnos al principo del fichero y comenzar la lectura
            while(posicion <= file.length()){
                file.seek(posicion);    //Nos posicionamos
                id = file.readInt();    //Obtengo id de empleado
                for(int i = 0; 1 < apellido.length; i++){
                    aux = file.readChar();  //Recorro 1 a uno los caracteres del apellido
                    apellido[i] = aux;      //Los voy guardadndo en el array
                }
                
                String apellidoS = new String(apellido);    //Convierto a String el array
                dep = file.readInt();           //Obtengo dep
                salario = file.readDouble();    //Obtengo salario
                if(id > 0) { //ID válido a partir de 1
                    //Crea un elemento de nodo empleado
                    Element raiz = document.createElement("empleado");
                    //Lo pegamos a la raiz
                    document.getDocumentElement().appendChild(raiz);
                    //Añadimos los subelementos y sus valores
                    
                    /*
                    CrearElemento("id", Integer.toString(id), raiz, document);          // añadir id
                    CrearElemento("apellido", apellidoS.trim(), raiz, document);        // añadir apellido
                    CrearElemento("dep", Integer.toString(dep), raiz, document);        // añadir dep
                    CrearElemento("salario", Double.toString(salario), raiz, document); // añadir salario
                    */
                }
                posicion = posicion +36;    //Obtengo posicion de acceso del siguiente empleado
                //Fin del while que recore el fichero
            }
            
            //Una vez ccreada en memoria la estructura del arbol XML
            //Creamos la fuente y el resultado de la trasnformacion XML
           
            /************ ERROR
            source = new DOMSource(document);
            result = new StreamResult(ficheroOut);
            
            //Objeto para realizar la ppransformacion
            Transformer transformer = TransformerFactory.newInstance().newTransformer( ) ;
            transformer.transform(source, result);
            *****************ERROR/

            /*
            //Para crear el nodo hijo (<id> o <apellido> o <dep> o <salario>) se escribe:
            Elementelem = document.createElement(datoEmple);
            
            //Para añadir su valor o su texto se usa el método createTextNode(String);
            Text text = document.createTextNode(valor);
            
            //A continuación se añade el nodo hijo a la raiz (empleado) y su texto o valor al nodo hijo.
            raiz.appendChild(elem);     //Pegamos el elemento hijo a la raiz
            raiz.appendChild(text);     //Pegamos el valor
            */
            
        } catch (Exception ex) { //CCapturar excepciones
            System.err.println("Error : " + ex);
        }
        file.close();
    }
    
    //Insercion de los datos del empleado
    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document){
        Element elem = document.createElement(datoEmple); // creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem) ;    // pegamos el el emento hijo a la raiz
        elem.appendChild(text);     // pegamos el valor
    }
}   // fin de la clase
