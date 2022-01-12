//donationmenu.java
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class donationmenu{

    static ArrayList<donation> donationList = new ArrayList<>();

    public static void donation_log(){
        for(donation don : donationList)
        {
            System.out.println(don);
        }
    }
    public static void menu_user(){
        Scanner s = new Scanner(System.in); 
        System.out.println("Enter 1 to donate.");
        System.out.println("Enter 2 to view donation log.");
        System.out.println("Enter 3 to exit.");
        System.out.println("Enter your choice: ");
        int c = s.nextInt();
        if (c==1){
            System.out.println("Enter user id: ");
            String user_id=s.next();
            System.out.println("Enter amount: ");
            int amt=s.nextInt();
            System.out.println("Enter date: ");
            //LocalDate dd= s.nextLocalDate();    //No function nextlocaldate
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
        System.out.println("Enter 1 to donate.");
        System.out.println("Enter 2 to withdraw money.");
        System.out.println("Enter 3 to view donation log.");
        System.out.println("Enter 4 to exit.");
        System.out.println("Enter your choice: ");
        int c = s.nextInt();
        if (c==1){
            System.out.println("Enter user id: ");
            String user_id=s.next();
            System.out.println("Enter amount: ");
            int amt=s.nextInt();
            System.out.println("Enter date: ");
            //LocalDate dd= s.nextLocalDate();    //No function nextlocaldate
            donation donation = new donation(user_id,amt,LocalDate.now());
            System.out.println("Transaction Sucessful.");
        }
        else if(c==2){
            //take the userid whose donation should be withdrawn and set the withdrawn variable to true of that donation
            System.out.println("Enter user id: ");
            int user_id=s.nextInt();
            System.out.println("Enter amount: ");
            int amt=s.nextInt();
            System.out.println("Enter date: ");
            //LocalDate dd= s.nextLocalDate();    //No function nextlocaldate
            //donationmenu withdraw = new donationmenu(user_id,amt,LocalDate.now());
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