//donation.java
import java.io.Serializable;
import java.time.LocalDate;

public class donation implements Serializable{
    String userid;
    int amount;
    LocalDate donationdate = LocalDate.now();
    boolean withdrawn;
    //if the donation is withdrawn set withdrawn equal to true
    public donation(String userid, int amount,LocalDate donationdate){
        this.userid=userid;
        this.amount=amount;
        this.donationdate=donationdate;
        this.withdrawn = false;
    }
    public String getuserid(){
        return userid;
    }
    public int getamount(){
        return amount;
    }
    public LocalDate getdd(){
        return donationdate;
    }
    public String toString()
    {
        return "User ID: " + userid + "\nAmount: " + amount + "\nDate: " + donationdate;
    }
}