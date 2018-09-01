package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            Student tempStudent = new Student("Daffy", "Duck", "daffy@lv2Code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student..." + tempStudent);
            session.save(tempStudent);

            //My new CODE

            //find out the student's id: primary
            System.out.println("Save student. Generated id: " + tempStudent.getId());


            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student student = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + student);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
