/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author Juanra
 */
public class CrearBD {
    
    static ObjectContainer db;
    
    public static void main(String[] args){
        
        db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba.db4o");
        db.close();
        
    }
}
