package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Instructor;
import com.bo.hibernate.demo.entity.InstructorDetail;
import com.bo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        //create session
        Session session = sessionFactory.getCurrentSession();

        try {

            //create the objects
            Instructor instructor = new Instructor("Madhu", "Patel", "Madhu@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("" +
                    "http://www.luv2code.com/youtube", "Luv 2 code!!!");

            //associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving Instrucotr " + instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
