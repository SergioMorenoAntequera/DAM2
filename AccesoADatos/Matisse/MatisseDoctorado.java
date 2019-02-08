/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matissedoctorado;

import com.matisse.*;

/**
 *
 * @author windiurno
 */
public class MatisseDoctorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MtDatabase db = new MtDatabase("localhost", "doctorado");

        //se abre la base de datos y la transaccion comienza dentro del try catch
        try {
            db.open();
            db.startTransaction();
            insertarObjetos(db);
            
        } catch (MtException mt) {
            System.out.println("Error con la conexion a la base de datos " + mt.getMessage());
        } finally {
            //si la transaccion esta en progreso, se hace  el commit
            if (db.isTransactionInProgress()) {
                db.commit();
            }

            //se cierra la conexion
            db.close();
            System.out.println("Cerrada");
        }
        
    }

    //insertar objetos
    private static void insertarObjetos(MtDatabase db) {
      
        Departamento d1 = new Departamento(db);
        d1.setNombre("Lenguajes");
        
        Tesis t1 = new Tesis(db);
        t1.setTitulo("Persistencia");
        t1.setTema("BD de objetos");

        Profesor p1 = new Profesor(db);
        p1.setNombre("Antonio barea");
        p1.setEmail("antonio@gmail.com");
        p1.setIngreso(16);
        p1.setPertenece(d1);
        p1.appendDirige(t1); 
        t1.setEs_dirigida(p1);
        
        
        
    }
    
}
