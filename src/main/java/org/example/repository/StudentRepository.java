package org.example.repository;

import org.example.models.Course;
import org.example.models.Student;

import java.util.List;

public interface StudentRepository {
    void deleteStudentById(Long id);
    List<Course> getStudentCourseList(Student student);
}
