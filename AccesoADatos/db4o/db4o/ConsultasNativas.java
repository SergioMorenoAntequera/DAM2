/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.util.List;

/**
 *
 * @author Juanra
 */
public class ConsultasNativas {
    
    static ObjectContainer db;
    static ObjectSet auxres;
    static List res;
    
    
    public static void main(String[] args0){
        
        db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba.db4o");
        
        res=db.query(new Predicate(null) {
            
            public boolean match(Ponente p){
                return p.getNombre().length()==12;
            }

            @Override
            public boolean match(Object et) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        auxres=(ObjectSet)res;
        while(auxres.hasNext()){
            System.out.println(auxres.next().toString());
        }
        
        db.close();
    }
    
}
