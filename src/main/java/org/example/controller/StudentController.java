package org.example.controller;

import org.example.models.Course;
import org.example.models.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentController {
    StudentService studentService = new StudentService();

        public List<Student> findAllStudents(){
            return studentService.findAll();
        }

        public Student findStudentById(int id){
            return studentService.findById(id);
        }

        public void saveStudent(Student student){
            studentService.saveToDatabase(student);
        }

        public void deleteStudent(Student student){
            studentService.deleteFromDatabase(student);
        }

        public void deleteStudent(int id){
            studentService.deleteFromDatabase(id);
        }

        public void deleteStudentByPrimaryId(Long id){
            studentService.deleteStudentById(id);
        }

        public void updateStudent(Student student,int id){
            studentService.updateOnDatabase(student,id);
        }

        public List<Course> getStudentCourseList(Student student){
            return studentService.getStudentCourseList(student);
        }
}
