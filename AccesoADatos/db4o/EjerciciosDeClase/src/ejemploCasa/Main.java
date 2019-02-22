/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploCasa;
import com.db4o.*;

/**
 *
 * @author seran
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Establecemos la conexion y creamos el fichero si es que no existe
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "animales.db4o");
        
        /*Gato g1 = new Gato("Marroncito", "Wiskhas", null);
        Gato g2 = new Gato("Verde", "Platanos", null);
        Gato g3 = new Gato("Amarillo", "Mercadona", null);
        Gato g4 = new Gato("Morado", "de lata(pijo)", null);
        
        Humano h1 = new Humano("Javi", 21, new Gato[]{g1, g2});
        Humano h2 = new Humano("Pedro", 25, new Gato[]{g3, g4});
        
        g1.setHumano(h1);
        g2.setHumano(h1);
        g3.setHumano(h2);
        g4.setHumano(h2);
        
        db.store(g1);
        db.store(g2);
        db.store(g3);
        db.store(g4);
        db.store(h1);
        db.store(h2);*/
        
        //Consultas Query by Example -------------------------------------------
        //Esto se basa basicamente en crear una plantilla de gato vacia y usar todo lo que esté en null
        //como libre y el resto como una pequenia restriccion que hay que cumplir
        Gato plantillaGato = new Gato(null, null, null);
        ObjectSet resultadoGato = db.queryByExample(plantillaGato);
        while(resultadoGato.hasNext()){
            System.out.println(resultadoGato.next().toString());
        }
        
        Humano plantillaHumano = new Humano(null, 0, null);
        ObjectSet resultadoHumano = db.queryByExample(plantillaHumano);
        while(resultadoHumano.hasNext()){
            System.out.println(resultadoHumano.next().toString());
        }
        
        
        //Consulta 
        
        
        db.close();
    }
}
