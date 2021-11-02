package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // get current session
        Session session = sessionFactory.getCurrentSession();

        try {
            // create student objects
            Student student1 = new Student("John", "Doe", "melvin@gmail.com");
            System.out.println("creating students...");

            // begin transaction
            session.beginTransaction();
            System.out.println("starting transaction...");

            // save students
            session.save(student1);
            System.out.println("saving students...");

            // persist students to database
            session.getTransaction().commit();
            System.out.println("persisting students...");

            /***************/

            // find out the student's id: primary key
            System.out.println("Saved student, Generatedd id: " + student1.getId());

            // now get a new session and start a transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting stuudent with id: " + student1.getId());

            Student myStudent = session.get(Student.class, student1.getId());

            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
