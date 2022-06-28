package org.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course  implements Serializable {
    @SequenceGenerator(name = "course",
            sequenceName = "COURSE_ID_SEQ")
    @Id
    @GeneratedValue(generator = "course",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "COURSE_CODE")
    private Long courseCode;
    private String courseName;

    @ManyToMany
    private List<Student> courseStudents ;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name= "wtf")
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

    public void setInstractor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getInstractor() {
        return instructor;
    }

    public Long getCourseCode() {
        return courseCode;
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
        return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", creditPoint=" + creditPoint
                +"]";
    }

}


    

