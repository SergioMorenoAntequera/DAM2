package dom.datosaxml.ejercicioClaseTexto;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

//Esta clase CREA el XML 
public class CreacionDeXMLnumeros {

    public static void main(String[] args) {
        //Ruta de salida y entrada
        File ficheroIn = new File("C:/Users/windiurno/Desktop/e1.dat");
        File ficheroOut = new File("C:/Users/windiurno/Desktop/e2.xml");
        //File ficheroIn = new File("C:\\Users\\windiurno\\Desktop/e1.dat");
        //File ficheroOut = new File("C:\\Users\\windiurno\\Desktop/e2.xml");
        
        //Declaraciones
        Source source;  //Origen
        Result result;  //Resultado final
        int numero;
        FileReader fr;
        BufferedReader br;
        
        try{
            //Instaciamos el parser
            DocumentBuilderFactory parser = DocumentBuilderFactory.newInstance();
            //Creamos el Builder
            DocumentBuilder builder = parser.newDocumentBuilder();
            //Creamos el DOM
            DOMImplementation dom = builder.getDOMImplementation();
            //Creamos el documento
            //Que la implementacion o el paso a XML será utilzando el método DOM
            Document document = dom.createDocument(null, "Numeros", null);
            document.setXmlVersion("1.0"); //Versión del XML

            //Creamos el flujo
            fr = new FileReader(ficheroIn);
            br = new BufferedReader(fr);
            
            String dato;
            while((dato = br.readLine())!= null){ //Para recorrer el archivo
                //Leemos datos
                numero = Integer.parseInt(dato);
                
                //Creamos los elementos
                CrearElemento("numero", Integer.toString(numero), document);
            }
            //******ESTRUCTURA HECHA******
            
            source = new DOMSource(document);       //De aquí salen los datos
            result = new StreamResult(ficheroOut);  //Llegan aquí
            
            //Realizar transformacion
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            br.close();

        }catch(IOException io){
            System.out.println("Dentro del IOException");
            System.out.println("HA SURGIDO UN ERROR");
        }catch(Exception ex){
            System.out.println("Dentro del exception");
            System.out.println("HA SURGIDO UN ERROR");
        } 
    }
    
    //Creacion de elementos
    private static void CrearElemento(String nombre, String valor, Document documento){
        
        Element raiz = documento.createElement(nombre);     //Creamos el campo
        documento.getDocumentElement().appendChild(raiz);   //Lo ponemos en la raiz
        Text text = documento.createTextNode(valor);        //Se le da valor                           
        raiz.appendChild(text);                             //Se pone el valor

    }
}