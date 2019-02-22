/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author Juanra
 */
public class ByExample {
    
    static ObjectContainer db;
    static Ponente p;
    static Charla c;
    static ObjectSet res;
    
    public static void main(String[] args0){
        
        db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba.db4o");
        
        //Consulta generica, ya toca trabajar con objetos en java
        
        p=new Ponente(null, null, null, 0);
        res=db.queryByExample(p);
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        res.reset();
        
        c=new Charla(null, 0, null);
        res=db.queryByExample(c);
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        res.reset();
        
        //Busca un dni en concreto
        
        p=new Ponente("11A", null, null, 0);
        res=db.queryByExample(p);
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        res.reset();
        
        c=new Charla(null, 0, new Ponente("11A", null, null, 0));
        res=db.queryByExample(c);
        
        while(res.hasNext()){
            System.out.println(res.next().toString());
        }
        
        db.close();
        
    }
}
