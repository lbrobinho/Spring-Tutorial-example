package com.bo.hibernate.demo;

import com.bo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        //create session
        Session session = sessionFactory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();


            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display the students
            System.out.println("\n\nShow all Students");
            displayTheStudents(theStudents);



            //query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            //display the students
            System.out.println("\n\nShow students who have last name of Doe");
            displayTheStudents(theStudents);


            //query students: lastName='Doe' or firstName='Daffy'
            theStudents = session.createQuery("from Student s where" +
                    " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

            //display the students
            System.out.println("\n\nShow students who have last name of Doe or who have first name of Daffy");
            displayTheStudents(theStudents);



            //query student where email like '%luv2code.com
            theStudents = session.createQuery("from Student s where"
                    + " s.email LIKE '%lv2code.com'").getResultList();

            //display the students
            System.out.println("\n\nShow students where email like '%luv2code.com");
            displayTheStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }

    private static void displayTheStudents(List<Student> theStudents) {
        for(Student student: theStudents) {
            System.out.println(student);
        }
    }
}
