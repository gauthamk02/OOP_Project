import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class donationmenu{
    int userid;
    int amount;
    LocalDate donationdate = LocalDate.now();
    static ArrayList<Object> donationList = new ArrayList<>();
    public donationmenu(int userid, int amount, LocalDate donationdate){
        this.userid=userid;
        this.amount=amount;
        this.donationdate=donationdate;
    }
    public static void donation_log(){
        for(Object don : donationList)
        {
            System.out.println(don);
        }
    }
    public static void menu_user(){
        Scanner s = new Scanner(System.in); 
        System.out.println("\n\n\n-------------------------------------");
        System.out.print("Covid Management System\n-------------------------------\n");
        System.out.println("Main Menu     @Admin");
        System.out.println("-------------------------------------\n");
        System.out.println("1. Donate");
        System.out.println("2. Donation Log");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        int c = s.nextInt();
        if (c==1){
            System.out.println("Enter user id: ");
            String user_id=s.next();
            System.out.println("Enter amount: ");
            int amt=s.nextInt();
            donation donation = new donation(user_id,amt,LocalDate.now());
            donationList.add(donation);
            System.out.println("Transaction Sucessful.");
        }
        else if (c==2){
            donation_log();
        } 
        else if (c==3) {
            System.out.println("Thank you and have a wonderful day!");
        }
        else {
            System.out.println("Wrong input try again.");
        }
    }
    public static void menu_admin(){
        Scanner s = new Scanner(System.in);
        System.out.println("\n\n\n-------------------------------------");
        System.out.print("Covid Management System\n------------------------------------\n");
        System.out.println("Main Menu     @Admin");
        System.out.println("-------------------------------------\n");
        System.out.println("1. Donate");
        System.out.println("2. Withdraw");
        System.out.println("3. Donation Log");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int c = s.nextInt();
        if (c==1){
            System.out.println("Enter user id: ");
            int user_id=s.nextInt();
            System.out.println("Enter amt: ");
            int amt = s.nextInt();
            donationmenu donation = new donationmenu(user_id,amt,LocalDate.now());
            donationList.add(donation);
            System.out.println("Transaction Sucessful.");
        }
        else if(c==2){
            System.out.println("Enter user id: ");
            int user_id=s.nextInt();
            System.out.println("Enter amount: ");
            int amt=s.nextInt();
            System.out.println("Enter date: ");
            System.out.println("Transaction Sucessful.");
        }
        else if (c==3){
            donation_log();
        }
        else if (c==4){
            System.out.println("Thank you and have a wonderful day!");
        }
        else {
            System.out.println("Wrong input try again.");
        }
    }
}
