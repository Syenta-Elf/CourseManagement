package org.example.service;

import org.example.hibernate.HibernateUtil;
import org.example.models.Course;
import org.example.models.Student;
import org.example.repository.CrudRepository;
import org.example.repository.StudentRepository;
import org.hibernate.Session;

import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Student> findAll() {
        List<Student> studentList = session.createQuery("from Student ", Student.class).getResultList();
        session.close();
        return studentList;
    }

    @Override
    public Student findById(int id) {

        Student student =  session.find(Student.class,id);
        session.close();
        return student;
    }

    @Override
    public void saveToDatabase(Student student) {
        try {
            session.getTransaction().begin();
            session.persist(student);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDatabase(Student student) {
        try {
            session.getTransaction().begin();
            session.remove(student);
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
            Student student = findById(id);
            session.remove(student);
            session.getTransaction().commit();
            session.close();
            System.out.println("Deleted...");
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void updateOnDatabase(Student student, int id) {
        try {
            session.getTransaction().begin();
            session.merge(student);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        try {
            session.getTransaction().begin();
            Student student = session.createQuery("from Student s WHERE s.id =:stuId",Student.class)
                    .setParameter("stuId",id)
                    .getSingleResult();
            session.remove(student);
            session.getTransaction().commit();
            System.out.println("Deleted....");
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Course> getStudentCourseList(Student student) {
        Student foundStudent = session.find(Student.class,student.getId());
        session.close();
        return foundStudent.getStudentCourses();
    }
}
