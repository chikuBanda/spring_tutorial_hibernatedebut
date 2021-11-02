package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();

        // get current session
        Session session = sessionFactory.getCurrentSession();

        try {
            // create student object
            Student student = new Student("chiku", "banda", "chikubanda@gmail.com");
            System.out.println("Creating student...");

            // begin transaction
            session.beginTransaction();
            System.out.println("Starting transaction...");

            // save student object
            session.save(student);
            System.out.println("saving student...");

            // persist student object to database
            session.getTransaction().commit();
            System.out.println("persisting student to database...");
            System.out.println("Done!!");
        }
        finally {
            session.close();
        }
    }
}
