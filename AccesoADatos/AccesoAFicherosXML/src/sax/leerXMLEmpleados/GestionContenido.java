package sax.leerXMLEmpleados;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

class GestionContenido extends DefaultHandler {
    
    public GestionContenido(){
        super();
    }
    
    /*@Override
    public void startDocument() throws SAXException {
        System.out.println("Empezando a leer el documento");
    }*/
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Evento que indica que empiezaa leer un elemento
        if(attributes.getValue(0).length()>1){
            System.out.println("El elemento: " + qName);
            System.out.println("Tiene un atributo: " + attributes.getQName(0) 
                + " con valor: " + attributes.getValue(0));
        } else {
            System.out.println("El elemento: " + qName + " no tiene atributos");
        }
    }
    
    /*@Override
    public void characters(char[] arg0, int start, int length) throws SAXException {
        //Nos pasa la información
        String car = new String(arg0, start, length);
        car = car.replaceAll ( "[\t \n]" , "" );
        if(car.length()>0)
            System.out.print(car+"\n") ;
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Evento que nos indica que ha terminado de leer un elemento
        System.out.println("Siguiente elemento...\n");
    }
    
    @Override
    public void endDocument() throws SAXException {
        //Evento que nos indica el fin de la lectura del documento
        System.out.println("Fin del documento");
    }*/
}
