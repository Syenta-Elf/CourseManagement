package org.example;
public abstract class Instractor {
    private static final int PAYMENT = 0;
    private String instractorName;
    private String instractorAddress;
    private String telephoneNumber;
    
    protected Instractor(String instractorName, String instractorAddress, String telephoneNumber) {
        this.instractorName = instractorName;
        this.instractorAddress = instractorAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public String getInstractorName() {
        return instractorName;
    }

    public void setInstractorName(String instractorName) {
        this.instractorName = instractorName;
    }

    public String getInstractorAddress() {
        return instractorAddress;
    }

    public void setInstractorAddress(String instractorAddress) {
        this.instractorAddress = instractorAddress;
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
        Instractor other = (Instractor) obj;
        if (telephoneNumber == null) {
            if (other.telephoneNumber != null)
                return false;
        } else if (!telephoneNumber.equals(other.telephoneNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Instractor [instractorAddress=" + instractorAddress + ", instractorName=" + instractorName
                + ", telephoneNumber=" + telephoneNumber + "]";
    }

}
