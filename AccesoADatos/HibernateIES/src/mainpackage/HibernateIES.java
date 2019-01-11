/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import com.sun.xml.internal.ws.api.server.Module;
import entity.Alumno;
import entity.Modulo;
import java.util.Iterator;
import java.util.Scanner;
import org.hibernate.*;
import util.HibernateUtil;

/**
 *
 * @author windiurno
 */
public class HibernateIES {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        //Sesiones establecidas
        SessionFactory sfactory = HibernateUtil.getSessionFactory();
        Session session = sfactory.openSession();
        
        //----------------------------------------------------------------------
        
        System.out.println("===============================================");
        Modulo modulo = new Modulo();
        
        //consulta con HQL
        Query q = session.createQuery("select avg(horas) from Modulo group by Alumno.dni");

        //Obtiene un iterador para recorrer el resultado de la consulta
        Iterator<Double> iter = q.iterate();
        
        //mientras haya resultados
        
        while (iter.hasNext()) {
        // extraer el siguiente objeto
            Double d = iter.next();
            System.out.println(d+"");
        }
        
        System.out.println("====================================================");
        
        //cierra sesión
        session.close();
    }
}
