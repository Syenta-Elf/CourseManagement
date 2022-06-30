package org.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VisitingResesearcher")
public class VisitingResearcher extends Instructor {

    @Column(name = "HOUR")
    private int hour;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String instractorName, String instractorAddress, String telephoneNumber,
                              int hour) {
        super(instractorName, instractorAddress, telephoneNumber);
        this.hour = hour;
    }

    @Column(name = "SALARY")
    @Override
    public int getPayment(){
        return hour * 10;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + hour;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        VisitingResearcher other = (VisitingResearcher) obj;
        return hour != other.hour;
            
    }

    @Override
    public String toString() {
        return "VisitingResearcher [hour=" + hour + "]";
    }
}
