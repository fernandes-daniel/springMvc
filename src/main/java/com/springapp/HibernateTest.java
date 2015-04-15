package com.springapp;

import com.springapp.entity.Embassy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateTest {


    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Embassy embassy = new Embassy(1, "Embassy of UK in PT", "Portugal");
        session.save(embassy);

        session.getTransaction().commit();


        sessionFactory.close();
    }

}
