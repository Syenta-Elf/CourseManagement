package org.example.repository;

import org.example.models.Course;
import org.example.models.Instructor;

import java.util.List;

public interface InstructorRepository {
    void deleteInstructorById(Long id);
    List<Course> getInstructorCourseList(Instructor instructor);
}
