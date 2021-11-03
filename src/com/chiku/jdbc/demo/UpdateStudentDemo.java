package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // get current session
        Session session = sessionFactory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();
            System.out.println("starting transaction...");

            // get student to update
            Student student = session.get(Student.class, 6);

            // update student
            student.setEmail("cb@gmail.com");

            // commit the transaction
            session.getTransaction().commit();

            /**************************/
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='example@gmail.com'").executeUpdate();

            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
