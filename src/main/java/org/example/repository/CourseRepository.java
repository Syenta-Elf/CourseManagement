package org.example.repository;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.Student;

import java.util.List;

public interface CourseRepository {
    void deleteCourseById(Long id);
    Instructor getCourseInstructor(Course course);
    List<Student> getCourseStudentList(Course course);
}
