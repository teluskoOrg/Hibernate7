package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();


//        s1.setRollNo(103);
//        s1.setsName("Harsh");
//        s1.setsAge(23);

//        s1.setRollNo(109);
//        s1.setsName("Anvit");
//        s1.setsAge(29);

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Student.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        s1 = session.find(Student.class, 109);
        Transaction transaction = session.beginTransaction();
        session.remove(s1);
        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);

    }

}