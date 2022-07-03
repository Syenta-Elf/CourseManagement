package org.example.service;

import org.example.hibernate.HibernateUtil;
import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.Student;
import org.example.repository.CourseRepository;
import org.example.repository.CrudRepository;
import org.hibernate.Session;

import java.util.List;

public class CourseService implements CrudRepository<Course>,CourseRepository{

    Session session = HibernateUtil.getSessionFactory().openSession();
    @Override
    public List<Course> findAll() {
        List<Course> courseList = session.createQuery("from Course ",Course.class).getResultList();
        session.close();
        return courseList;
    }

    @Override
    public Course findById(int id) {
        Course course = session.find(Course.class,id);
        session.close();
        return course;
    }

    @Override
    public void saveToDatabase(Course course) {
        try {
            session.getTransaction().begin();
            session.persist(course);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDatabase(Course course) {
        try {
            session.getTransaction().begin();
            session.remove(course);
            session.getTransaction().commit();
            session.close();
            System.out.println("Deleted...");
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            session.getTransaction().begin();
            Course course = findById(id);
            session.remove(course);
            session.getTransaction().commit();
            session.close();
            System.out.println("Deleted...");
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void updateOnDatabase(Course course, int id) {
        try {
            session.getTransaction().begin();
            session.merge(course);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            session.getTransaction().begin();
            Course course = session.createQuery("from Course c WHERE c.id =:courseId",Course.class)
                    .setParameter("courseId",id)
                    .getSingleResult();
            session.remove(course);
            session.getTransaction().commit();
            System.out.println("Deleted....");
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public Instructor getCourseInstructor(Course course) {
        Course foundCourse = session.find(Course.class,course.getId());
        session.close();
        return foundCourse.getInstructor();
    }

    @Override
    public List<Student> getCourseStudentList(Course course) {
        Course foundCourse = session.find(Course.class,course.getId());
        session.close();
        return foundCourse.getCourseStudents();
    }
}
