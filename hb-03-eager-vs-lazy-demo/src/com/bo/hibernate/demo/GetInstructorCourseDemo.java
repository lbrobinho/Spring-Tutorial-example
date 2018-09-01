package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Course;
import com.bo.hibernate.demo.entity.Instructor;
import com.bo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {

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

            //start a transaction
            session.beginTransaction();

            //get the instructor from db
            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Instructor: " + instructor);

            //get course for the instructor
            System.out.println("Courses: " + instructor.getCourses());


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
