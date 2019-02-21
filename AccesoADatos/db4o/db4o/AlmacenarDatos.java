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
public class AlmacenarDatos {
    
    static ObjectContainer db;
    
    public static void main(String[] args){
        
        db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba.db4o");
        
        //Creamos los objetos
        
        Ponente p1=new Ponente("11A", "Antonio Camaco", "acamacho@gmail.es", 300);
        Ponente p2=new Ponente("22B", "Isabel Perez", "iperez@hotmail.es", 100);
        Ponente p3=new Ponente("33C", "Ana Navarro", "anavarro@yahoo.com", 200);
        Ponente p4=new Ponente("44D", "Pedro Sanchez", "psanchez@mixmail.com", 90);
        
        Charla c1=new Charla("Coches", 2, p1);
        Charla c2=new Charla("Drogas", 3, p4);
        //Guardamos los objetos
        
        /*db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        
        db.store(c1);
        db.store(c2);*/
        
        annadir(db, p1);
        annadir(db, p2);
        annadir(db, p3);
        annadir(db, p4);
        
        annadir(db, c1);
        annadir(db, c2);
        
        db.close();
        
    }
    
    //Para revisar que no existen copias
    
    public static void annadir(ObjectContainer db,String nif,String nombre, String email, float cache){
        
        Ponente p = new Ponente(nif, nombre, email, cache);
        ObjectSet<Ponente> ob = db.queryByExample(new Ponente(p.getNif(), null, null, 0));
        if(ob.size() <= 0){
             db.store(p);
        }else{
            System.out.println("ya existe alguien con ese nif");
        }
       
    }
    
    public static void annadir(ObjectContainer db, Ponente p){
        
        //Ponente p = new Ponente(nif, nombre, email, cache);
        ObjectSet<Ponente> ob = db.queryByExample(new Ponente(p.getNif(), null, null, 0));
        if(ob.size() <= 0){
             db.store(p);
        }else{
            System.out.println("ya existe alguien con ese nif");
        }
       
    }
    
    public static void annadir(ObjectContainer db,String titulo,int numero,Ponente ponente){
        
        Charla charla = new Charla(titulo,numero, ponente);
        ObjectSet<Charla> ob = db.queryByExample(new Charla(charla.getTitulo(), 0, null));
        if(ob.size() <= 0){
             db.store(charla);
        }else{
            System.out.println("ya existe una charla con ese nombre");
        }
       
    }
    
    public static void annadir(ObjectContainer db, Charla c){
        
        //Charla charla = new Charla(titulo,numero, ponente);
        ObjectSet<Charla> ob = db.queryByExample(new Charla(c.getTitulo(), 0, null));
        if(ob.size() <= 0){
             db.store(c);
        }else{
            System.out.println("ya existe una charla con ese nombre");
        }
       
    }
    
}
