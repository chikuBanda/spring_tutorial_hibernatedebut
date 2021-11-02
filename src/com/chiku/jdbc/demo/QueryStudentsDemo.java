package com.chiku.jdbc.demo;

import com.chiku.jdbc.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentsDemo  {
    public static void printStudents(List<Student> students){
        for(Student student: students){
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure()
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();

        // get current session from session factory
        Session session = sessionFactory.getCurrentSession();

        // do operations in try/finally
        try {
            // begin transaction
            session.beginTransaction();

            // return list of students using query
            List<Student> students = session
                    .createQuery("from Student").getResultList();

            // display students
            printStudents(students);

            // find students: lastname = 'Doe
            System.out.println("\nStudents with last name 'Doe': ");
            students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

            // display students
            printStudents(students);

            // query students: lastname = 'Doe' or firstname = 'Gaby'
            System.out.println("\nStudents with last name 'Doe' or firstname = 'Gaby': ");
            students =
                    session.createQuery("from Student s where "
                    + "s.lastName = 'Doe' OR "
                    + "s.firstName = 'Gabriel'").getResultList();

            // display students
            printStudents(students);

            students =
                    session.createQuery("from Student s WHERE " +
                            "s.email LIKE '%banda%'").getResultList();

            // display students
            printStudents(students);

            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
