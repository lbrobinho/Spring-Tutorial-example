package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Course;
import com.bo.hibernate.demo.entity.Instructor;
import com.bo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        //create session
        Session session = sessionFactory.getCurrentSession();

        try {

            //create the objects
            Instructor instructor = new Instructor("Susan", "Public", "susan@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("" +
                    "http://www.luv2code.com/youtube", "Vedio games!!!");

            //associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving Instructor " + instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
