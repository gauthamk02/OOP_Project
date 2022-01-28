import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;

class QuarantineUser extends User implements Serializable 
{
    
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
		String details = "\nName: " + super.getName() + "\nUserID: " + super.getUserId() +"\nAddress: " + super.getAddress() +
        "\nEmailID: " + super.getEmailId() + "\nCovid Status: "+ super.covidstatus +"\nVaccinated Doses: " +
		vaccinateddoses + "\nAge: " + age + "\nPhone No: " + super.getPhoneNo() + "\nQuarantine Begin Date: " + qurantineBeginDate +
        "\nQuarantine End Date: " + qurantineEndDate + "\nQuarantine Days: " + quarantineDays + "\nPrimary Contact: " + primaryContact; 
		if(Menu.user.isAdmin()) details += "\nPassword: " + super.getPassword();
        return details; 
    }
}
