/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenew;

import empresaz.entity.Departamentos;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author windiurno
 */
public class Ejemplos {

    public static void main(String[] args) {
        //inicializa el entorno Hibernate
        Configuration cfg = new Configuration().configure();
        //crea el ejemplar de SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //obtiene un objeto session
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        try {
            //comienza la transacción
            //código de persistencia (/get/load/delete/save/update)
            Departamentos dep = new Departamentos();
            dep = (Departamentos) session.load(Departamentos.class, (byte)10);
            System.out.println("Nombre Dep: " + dep.getDnombre());
            System.out.println("Localidad: " + dep.getLoc());
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
