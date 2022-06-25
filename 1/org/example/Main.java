package org.example;
/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        Course course = new Course();
        course.setCourseName("Matematik");
        course.setCourseCode("A2213");
        course.setCreditPoint(30);
        
        Course course1 = new Course();
        course1.setCourseName("Fizik");
        course1.setCourseCode("A3213");
        course1.setCreditPoint(30);


        VisitingResearcher visitingResearcher = new VisitingResearcher("instractorName", "instractorAddress", "telephoneNumber", 3);
        VisitingResearcher visitingResearcher2 = new VisitingResearcher("instractorName1", "instractorAddress1", "telephoneNumber1", 3);
        System.out.println(visitingResearcher.toString());
        System.out.println(visitingResearcher.hashCode());
        System.out.println(visitingResearcher2.toString());
        System.out.println(visitingResearcher2.hashCode());
        // CTRL + Ö comment aç kapa

        System.out.println(course.toString());
        System.out.println(course.hashCode());

        System.out.println(course1.toString());
        System.out.println(course1.hashCode());
    }
    
}