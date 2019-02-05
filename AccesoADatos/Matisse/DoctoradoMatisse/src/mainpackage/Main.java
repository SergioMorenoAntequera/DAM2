/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import com.matisse.MtDatabase;
import com.matisse.MtException;
import doctoradomatisse.*;

/**
 *
 * @author windiurno
 */
public class Main {
    public static void main(String[] args){
        //Establecer la conexion
        MtDatabase bd = new MtDatabase("localhost", "doctorado");
        
        //Todo se hace dentro de un try
        try {
            //Conectamos con la bse de datos
        bd.open();
        //Empezamos una traansaccion(para hacer algo en la bd)
        bd.startTransaction();
        //En este caso vamos a insetar objetos
        insertarObjetos(bd);
        
        } catch (MtException e) {
            System.err.println("ERROR: " + e.getMessage());
        } finally {
            //confirma cualquier transaccion en proceso:
            if(bd.isTransactionInProgress()){
                bd.commit();
            }
            //Cerramos la conexion
            bd.close();
        }
        
        
    }

    private static void insertarObjetos(MtDatabase bd) {
        //Creamos los objetos tal cual y les añadimos sus atributos
        Departamento d1 = new Departamento(bd);
        d1.setNombre("Base de datos");
        
        Tesis t1 = new Tesis(bd);
        t1.setTitulo("Persistencia de objetos");
        t1.setTema("Bases de Objetos");
        
        Profesor p1 = new Profesor(bd);
        p1.setNombre("Ana Maria GIl");
        p1.setEmail("isabel.ruz@universi.es");
        p1.setIngreso(100);
        
        //Conexiones
        p1.appendDirige(t1);
        t1.setEs_dirigida(p1);
        
        d1.appendFormado_por(p1);
        p1.setPertenece(d1);
        
        
        
    }
}
