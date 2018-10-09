package jaxb_albaran;
import java.io.*;
import java.util.logging.*;
import javax.xml.bind.*;

public class ModificarAlbaPed {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.albaran");
            Unmarshaller u = jaxbContext.createUnmarshaller();
            JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("src/jaxb_albaran/albaran.xml"));
            
        } catch (JAXBException ex) {
            Logger.getLogger(ModificarAlbaPed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
