package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

//   Select * from laptop where ram=32 ->SQL
//        from Laptop where ram=32 -> HQL


        Query query = session.createQuery("from Laptop where ram=32",Laptop.class);
        List<Laptop> laptops = query.getResultList();


//        Laptop l1=session.get(Laptop.class, 3);
        System.out.println(laptops);
        session.close();

        sf.close();


    }

}