package org.example.controller;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.Student;
import org.example.service.CourseService;

import java.util.List;

public class CourseController {
    CourseService courseService = new CourseService();
    public List<Course> findAllCourses(){
        return courseService.findAll();
    }

    public Course findCourseById(int id){
        return courseService.findById(id);
    }

    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }

    public void deleteCourse(Course course){
        courseService.deleteFromDatabase(course);
    }

    public void deleteCourse(int id){
        courseService.deleteFromDatabase(id);
    }

    public void deleteCourseByPrimaryId(Long id){
        courseService.deleteCourseById(id);
    }

    public void updateCourse(Course course,int id){
        courseService.updateOnDatabase(course,id);
    }

    public Instructor getInstructor(Course course){
        return courseService.getCourseInstructor(course);
    }
    public List<Student> getCourseStudentList(Course course){
        return courseService.getCourseStudentList(course);
    }
}
