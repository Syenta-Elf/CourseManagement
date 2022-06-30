package org.example.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COURSE")
public class Course  implements Serializable {

    @SequenceGenerator(name = "course",
            sequenceName = "COURSE_ID_SEQ")
    @Id
    @GeneratedValue(generator = "course",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "COURSE_CODE")
    private String courseCode;
    @Column(name = "COURSE_NAME")
    private String courseName;

    @ManyToMany
    private List<Student> courseStudents ;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name= "INSTRUCTOR",nullable = false)
    private Instructor instructor;
    private int creditPoint;
    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    public void setCourseStudents(List<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public List<Student> getCourseStudents() {
        return courseStudents;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Long getId() {
        return id;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (courseCode == null) {
            if (other.courseCode != null)
                return false;
        } else if (!courseCode.equals(other.courseCode))
            return false;
        return false;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseStudents=" + courseStudents +
                ", instructor=" + instructor +
                ", creditPoint=" + creditPoint +
                '}';
    }
}


    

