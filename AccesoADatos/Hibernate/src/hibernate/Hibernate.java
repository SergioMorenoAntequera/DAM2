/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;
import empresaz.entity.Departamentos;
import empresaz.util.hibernateutil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author windiurno
 */
public class Hibernate {
    public static void main(String[] args) {
        
        try {
            SessionFactory sFactory = hibernateutil.getSessionFactory();
            Session session = sFactory.openSession();
            
            Transaction tx = session.beginTransaction();
            System.out.println("Insertar una fila en la tabla Departamentos");
            Departamentos dep = new Departamentos();
            dep.setDeptNo((byte) 60);
            dep.setDnombre("VENTAS");
            dep.setLoc("MALAGA");
            //Añadir el objeto
            session.save(dep); //Si ya hay uno con la misma clave primaria el error salta aquí
            
            //Confirmamos los cambio
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
}
