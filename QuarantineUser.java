import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;

class QuarantineUser extends User implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    LocalDate qurantineBeginDate;
    LocalDate qurantineEndDate;
    int quarantineDays;
    boolean primaryContact;

    public LocalDate getQuarantineBeginDate()
    {
        return qurantineBeginDate;
    }
    public void setQuarantineBeginDate(LocalDate date)
    {
        this.qurantineBeginDate = date;
    }
    public LocalDate getQuarantineEndDate()
    {
        return qurantineEndDate;
    }
    public void setQuarantineEndDate(LocalDate date)
    {
        this.qurantineEndDate = date;
    }
    public int getQuarantineDays()
    {
        return quarantineDays;
    }
    public void setQuarantineDays(int days)
    {
        this.quarantineDays = days;
    }
    public boolean getPrimaryContact()
    {
        return primaryContact;
    }
    public void setPrimaryContact(boolean contact)
    {
        this.primaryContact = contact;
    }
    public String getCovidStatus()
    {
        return covidstatus;
    }
    public void setCovidStatus(String status)
    {
        this.covidstatus = status;
    }
    @Override
    public String toString() {
        return "\nName: " + getName() + "\nAddress: " + getAddress() + "\nUserId: " + getUserId() +
        "\nEmailId: " + getEmailId() + "\nCovid Status: "+covidstatus +" \nVaccinated Doses: "+vaccinateddoses+"\nAge: "+age+"\nPhoneNo=" + getPhoneNo() +
        "\nQuarantine Days: " + getQuarantineDays();
    }
}
