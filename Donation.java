//donation.java
import java.io.Serializable;
import java.time.LocalDate;

public class Donation implements Serializable{
    int userid;
    int amount;
    LocalDate donationdate = LocalDate.now();
    boolean withdrawn;

    public Donation(int user_id, int amount,LocalDate donationdate){
        this.userid=user_id;
        this.amount=amount;
        this.donationdate=donationdate;
        this.withdrawn = false;
    }
    public int getuserid(){
        return userid;
    }
    public int getamount(){
        return amount;
    }
    public LocalDate getdd(){
        return donationdate;
    }
    public boolean getwithdrawn()
    {
        return withdrawn;
    }
    public void setwithdrawn(boolean wd)
    {
        this.withdrawn = wd;
    }
    public String toString()
    {
        return "User ID: " + userid + "\nAmount: " + amount + "\nDate: " + donationdate + "\nWithdrawn: " + withdrawn + "\n";
    }
}