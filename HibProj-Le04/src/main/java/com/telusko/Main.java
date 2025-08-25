package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setRollNo(101);
        s1.setsName("Navin");
        s1.setsAge(30);
        Configuration cfg=new Configuration();
        SessionFactory sf=cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.persist(s1);

        System.out.println(s1);

    }

}