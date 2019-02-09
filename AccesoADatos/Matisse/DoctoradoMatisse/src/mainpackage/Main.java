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

    public static void insertarObjetos(MtDatabase db){
        //Crea objetos Departamento
        Departamento d1 = new Departamento(db);
        d1.setNombre("Bases de Datos");
        Departamento d2 = new Departamento(db);
        d2.setNombre("Lenguajes");
        
        Tesis t1 = new Tesis(db);
        t1.setTitulo("Persistencia de objetos");
        t1.setTema("Bases de datos");
        Tesis t2 = new Tesis(db);
        t2.setTitulo("Bases de Datos Nativas XML");
        t2.setTema("Bases de datos XML");
        Tesis t3 = new Tesis(db);
        t3.setTitulo("Mapeo Objeto-Relacional");
        t3.setTema("Bases de datos");
        Tesis t4 = new Tesis(db);
        t4.setTitulo("Multiproceso en Java");
        t4.setTema("Lenguajes de Programación");
        
        Profesor p1 = new Profesor(db);
        p1.setNombre("Ana Martos Gil");
        p1.setEmail("ana.martos@gmail.com");
        p1.setIngreso(1990);
        Profesor p2 = new Profesor(db);
        p2.setNombre("Isabel Ruz Granados");
        p2.setEmail("isabel.ruz@universi.es");
        p2.setIngreso(1986);
        Profesor p3 = new Profesor(db);
        p3.setNombre("Antonio Barea Navarro");
        p3.setEmail("antonio.bareanavarro@universi.es");
        p3.setIngreso(1995);
        
        p1.setPertenece(d1);
        p1.appendDirige(t1);
        p2.setPertenece(d1);
        p2.appendDirige(t2);
        p2.appendDirige(t3);
    }
}
