package org.example;

import org.example.controller.StudentController;
import org.example.hibernate.HibernateUtil;
import org.example.models.*;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

        StudentController studentController = new StudentController();
        List<Student> studentList = studentController.findAllStudents();

        for (Student s:studentList) {
            System.out.println("---------------"+s.getName());
        }

        //session.save(course);
        session.save(permanentInstructor);
        session.save(visitingResearcher);
        transaction.commit();
        session.close();

    }
    
}