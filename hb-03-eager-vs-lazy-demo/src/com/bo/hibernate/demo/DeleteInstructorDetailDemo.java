package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Instructor;
import com.bo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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
            //start a transaction
            session.beginTransaction();

           //find a instructor by primary id
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);

            //delete a instructor
            System.out.println("Deleting a instructor detail " + instructorDetail.getId());

            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
