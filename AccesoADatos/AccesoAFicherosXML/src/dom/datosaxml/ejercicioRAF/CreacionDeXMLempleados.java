package dom.datosaxml.ejercicioRAF;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

//Esta clase CREA el XML 
public class CreacionDeXMLempleados {

    public static void main(String[] args) {
        //Ruta de salida y entrada
        //File ficheroIn = new File("C:/Users/windiurno/Desktop/e1.dat");
        //File ficheroOut = new File("C:/Users/windiurno/Desktop/e2.xml");
        File ficheroIn = new File("C:/Users/windiurno/seran/e1.dat");
        File ficheroOut = new File("C:/Users/windiurno/seran/e2.xml");
        
        //Declaraciones
        Source source;  //Origen
        Result result;  //Resultado final
        int id, salario, posicion = 0;
        String apellido, departamento;

        try{
            //Instaciamos el parser
            DocumentBuilderFactory parser = DocumentBuilderFactory.newInstance();
            //Creamos el Builder
            DocumentBuilder builder = parser.newDocumentBuilder();
            //Creamos el DOM
            DOMImplementation dom = builder.getDOMImplementation();
            //Creamos el documento
            //Que la implementacion o el paso a XML será utilzando el método DOM
            Document document = dom.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); //Versión del XML

            //Creamos el RAF
            RandomAccessFile raf = new RandomAccessFile(ficheroIn, "r");
            
            while(posicion < raf.length()){ //Para recorrer el archivo
                raf.seek(posicion); //Ponemos el "cursor"

                //Leemos datos
                id = raf.readInt();
                apellido = raf.readUTF();
                departamento = raf.readUTF();
                salario = raf.readInt();
                
                // Creamos Raiz 
                Element raiz = document.createElement("Empleado");
                document.getDocumentElement().appendChild(raiz);

                //Creamos los elementos
                CrearElemento("id", Integer.toString(id), raiz, document);
                CrearElemento("apellido", apellido, raiz, document);
                CrearElemento("departamento", departamento, raiz, document);
                CrearElemento("salario", Integer.toString(salario), raiz, document);
                
                //Siguiente registro
                posicion += 122;
            }
            //******ESTRUCTURA HECHA******
            
            
            source = new DOMSource(document);       //De aquí salen los datos
            result = new StreamResult(ficheroOut);  //Llegan aquí
            
            //Realizar transformacion
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            raf.close();

        }catch(IOException io){
            System.out.println("Dentro del IOException");
            System.out.println("HA SURGIDO UN ERROR");
        }catch(Exception ex){
            System.out.println("Dentro del exception");
            System.out.println("HA SURGIDO UN ERROR");
        }
    }
    
    //Creacion de elementos
    private static void CrearElemento(String nombre, String valor, Element raiz, Document documento){
        
        Element elem = documento.createElement(nombre);     //Se crea elemento
        Text text = documento.createTextNode(valor);        //Se le da valor
        raiz.appendChild(elem);                             //Lo ponemos en la raiz
        elem.appendChild(text);                             //Se pone el valor

    }
}