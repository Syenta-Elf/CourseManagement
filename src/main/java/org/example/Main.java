package org.example;

import org.example.hibernate.HibernateUtil;
import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.PermanentInstructor;
import org.example.models.VisitingResearcher;
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
        course.setCourseCode("5325");
        course.setCourseStudents(null);
        course.setInstructor(null);

        PermanentInstructor permanentInstructor = new PermanentInstructor();
        permanentInstructor.setSalary(10);
        permanentInstructor.setInstractorAddress("aaa");
        permanentInstructor.setTelephoneNumber("55555555");
        permanentInstructor.setInstractorName("name");

        VisitingResearcher visitingResearcher = new VisitingResearcher();
        visitingResearcher.setHour(10);
        visitingResearcher.setInstractorAddress("adres");
        visitingResearcher.setInstractorName("visiting");
        visitingResearcher.setTelephoneNumber("1111111111");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        //session.save(course);
        session.save(permanentInstructor);
        session.save(visitingResearcher);
        transaction.commit();
        session.close();

    }
    
}