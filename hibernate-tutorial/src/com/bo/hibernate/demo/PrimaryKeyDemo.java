package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        //create session
        Session session = sessionFactory.getCurrentSession();

        try {

            //use the session object to save Java  object
            System.out.println("Creating new Studeng object...");
            Student tempStudent1 = new Student("Devin", "Luke", "paul@lv2Code.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@lv2Code.com");
            Student tempStudent3 = new Student("John", "Doe", "john@lv2Code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
