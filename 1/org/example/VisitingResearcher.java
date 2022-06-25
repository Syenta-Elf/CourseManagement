package org.example;

public class VisitingResearcher extends Instractor{

    private int hour;

    protected VisitingResearcher(String instractorName, String instractorAddress, String telephoneNumber, int hour) {
        super(instractorName, instractorAddress, telephoneNumber);
        setHour(hour);
    }

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
}
