package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        //create session
        Session session = sessionFactory.openSession();

        try {

            int studentId = 4;

            //now get a new session and start transaction
            //session = sessionFactory.getCurrentSession();
            session.beginTransaction();


            //My new CODE

            //find out the student's id: primary
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            //retrieve student based on the id: primary key
            System.out.println("Updating student...");
            myStudent.setFirstName("suntong");

//            //commit the transaction
//            session.getTransaction().commit();
//
//            //New Code
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();

            //update email for all students
            System.out.println("update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
