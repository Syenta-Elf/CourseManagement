package org.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor  implements Serializable {

    @SequenceGenerator(name = "instructor",
            sequenceName = "STUDENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "instructor",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    private static final int PAYMENT = 0;
    @Column(name="NAME",length = 25)
    private String instructorName;
    @Column(name="ADDRESS",length = 100)
    private String instructorAddress;
    @Column(name = "PHONE",length = 11)// 0555 555 55 55 --> 05555555555
    private String telephoneNumber;
    @OneToMany(
            mappedBy = "instructor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Course> instructorCourses;

    public Instructor(String instructorName, String instructorAddress, String telephoneNumber) {
        this.instructorName = instructorName;
        this.instructorAddress = instructorAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public Instructor() {

    }

    public String getInstractorName() {
        return instructorName;
    }

    public void setInstractorName(String instractorName) {
        this.instructorName = instractorName;
    }

    public String getInstractorAddress() {
        return instructorAddress;
    }

    public void setInstractorAddress(String instractorAddress) {
        this.instructorAddress = instractorAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
        return result;
    }

    public int getPayment(){
        return PAYMENT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Instructor other = (Instructor) obj;
        if (telephoneNumber == null) {
            return other.telephoneNumber == null;
        } else return telephoneNumber.equals(other.telephoneNumber);
    }

    @Override
    public String toString() {
        return "Instructor [instructorAddress=" + instructorAddress + ", instructorName=" + instructorName
                + ", telephoneNumber=" + telephoneNumber + "]";
    }

}
