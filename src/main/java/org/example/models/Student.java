package org.example.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
    @SequenceGenerator(name = "student",
            sequenceName = "STUDENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "student",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME",length = 25)
    private String name;
    @Column(name="SURNAME",length = 25)
    private String surname;
    @Column(name = "GENDER",length = 10)
    private String gender;
    @Column(name="ADDRESS",length = 100)
    private String address;
    @Column(name="BIRTHDAY")
    private LocalDate birthday;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Student.class
    )
    private List<Course> studentCourses;


    public Student(String name, String surname, String gender, String address, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Student [address=" + address + ", birthday=" + birthday + ", gender=" + gender + ", id=" + id
                + ", name=" + name + ", surname=" + surname + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Student other = (Student) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

}
