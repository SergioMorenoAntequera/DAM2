/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

/**
 *
 * @author Juanra
 */
public class Soda {
    
    static ObjectContainer db;
    static Query query;
    static ObjectSet res;
    
    public static void main(String[] args0){
        
        db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba.db4o");

        query=db.query();
        
        //Seleccionamos la clase con la que vaomos a trabajar
        
        query.constrain(Ponente.class);
        
        res=query.execute();
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        //Reseteamos los objetos
        
        res.reset();
        
        query=db.query();
        
        //Seleccionamos la clase con la que vaomos a trabajar
        
        query.constrain(Charla.class);
        
        res=query.execute();
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        //Trabajamos con condiciones
        
        query=db.query();

        query.constrain(Charla.class);
                
        query.descend("ponente").descend("cache").constrain(300);
        
        res=query.execute();
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        //Buscamos una cadena que contenta tal
        
        query=db.query();

        query.constrain(Charla.class);
                
        query.descend("ponente").descend("email").constrain("@mixmail").contains();
        
        res=query.execute();
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        //Buscamos una cadena igual
        
        query=db.query();

        query.constrain(Charla.class);
                
        query.descend("ponente").descend("email").constrain("acamacho@gmail.es").equal();
        
        res=query.execute();
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        db.close();
    }
    
}
