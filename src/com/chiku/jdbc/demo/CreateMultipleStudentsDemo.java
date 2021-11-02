package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMultipleStudentsDemo {
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
            Student student1 = new Student("Melvin", "Mataka", "melvin@gmail.com");
            Student student2 = new Student("Gabriel", "Mkandawire", "gaby@gmail.com");
            Student student3 = new Student("Chishimba", "Bwembya", "chishimba@gmail.com");
            System.out.println("creating students...");

            // begin transaction
            session.beginTransaction();
            System.out.println("starting transaction...");

            // save students
            session.save(student1);
            session.save(student2);
            session.save(student3);
            System.out.println("saving students...");

            // persist students to database
            session.getTransaction().commit();
            System.out.println("persisting students...");
        }
        finally {
            session.close();
        }
    }
}
