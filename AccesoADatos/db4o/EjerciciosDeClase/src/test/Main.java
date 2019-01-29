package test;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        
        ObjectContainer db = null;
       
        try {
                //Nombre de los ponentes que tienen cache + de 200 y dan la charla 1
            db = Db4oEmbedded.openFile("congreso.db4o");

            /*
             db.store(new Ponente("11A", "Ponente1", "ponente1@gmail.com", 200));
             db.store(new Ponente("22B", "Ponente2", "ponente2@hotmail.com", 50));
             db.store(new Ponente("33C", "Ponente3", "ponente3@yahoo.com", 90));
             db.store(new Ponente("44D", "Ponente4", "ponente4@mixmail.com", 500));
             db.store(new Ponente("55E", "Ponente5", "ponente5@outlook.com", 140));
             */
            
            Ponente p1 = new Ponente("55E", "Ponente5", "ponente5@outlook.com", 140);

            if (p1 instanceof Ponente) {
                
            }

        } catch (Exception e) {

        } finally {
            db.close();
        }

    }
}
