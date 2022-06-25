package org.example;
public class Course {
    
    private String courseName;
    private String courseCode;
    private int creditPoint;
    public Course(String courseName, String courseCode, int creditPoint) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditPoint = creditPoint;
    }
    public Course() {
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public int getCreditPoint() {
        return creditPoint;
    }
    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
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
        return true;
    }
    @Override
    public String toString() {
        return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", creditPoint=" + creditPoint + "]";
    }

}
