package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);


        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Navin");
        a1.setTech("Java");


        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");


        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("Kiran");
        a3.setTech("AI");


        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l2, l3));
        a3.setLaptops(Arrays.asList(l1));


        l1.setAliens(Arrays.asList(a1, a3));
        l2.setAliens(Arrays.asList(a1, a2));
        l3.setAliens(Arrays.asList(a2));


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Alien.class)
                .addAnnotatedClass(com.telusko.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();

        Alien a5 = session.find(Alien.class, 102);
        System.out.println(a5);
        session.close();
        sf.close();


    }

}