package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            /*// get student with id 6
            Student student = session.get(Student.class, 6);


            // delete student
            session.delete(student);*/

            session.createQuery("DELETE FROM Student WHERE id=10").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
