package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Course;
import com.bo.hibernate.demo.entity.Instructor;
import com.bo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses " + "where i.id =:theInstructorId", Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId", id);

            //execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + tempInstructor);
            //commit transaction
            session.getTransaction().commit();

            session.close();

            //get course for the instructor
            System.out.println("Courses: " + tempInstructor.getCourses());

            System.out.println("Luv2code Done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
