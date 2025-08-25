package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
//        s1.setRollNo(102);
//        s1.setsName("Kiran");
//        s1.setsAge(25);


//        s1.setRollNo(104);
//        s1.setsName("Sushil");
//        s1.setsAge(19);

        s1.setRollNo(105);
        s1.setsName("Gaurav");
        s1.setsAge(22);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.telusko.Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();
        System.out.println(s1);

    }

}