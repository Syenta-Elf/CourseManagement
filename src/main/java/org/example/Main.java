package org.example;

import org.example.hibernate.HibernateUtil;
import org.example.model.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        Course course = new Course();
        course.setCourseName("Math");
        course.setCreditPoint(5);
        course.setCourseStudents(null);
        //course.setInstractor(null);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);
        transaction.commit();
        session.close();

    }
    
}