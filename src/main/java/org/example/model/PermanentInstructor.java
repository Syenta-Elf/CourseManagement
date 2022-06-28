package org.example.model;

import javax.persistence.Column;

public class PermanentInstructor extends Instructor {
    @Column(name="SALARY")
    private double salary;

    public PermanentInstructor(String instractorName, String instractorAddress, String telephoneNumber) {
        super(instractorName, instractorAddress, telephoneNumber);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        PermanentInstructor other = (PermanentInstructor) obj;
        return Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary);
            
    }

    @Override
    public String toString() {
        return "PermanentInstractor{" +
                "salary=" + salary +
                '}';
    }
}
