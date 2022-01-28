import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class DonationMenu{
    LocalDate donationdate = LocalDate.now();
    static ArrayList<Donation> donationList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void donation_log(){
        System.out.println();
        for(Donation don : donationList)
        {
            System.out.println(don);
        }
    }
    public static void menu_user(){
        boolean loop = true;
        while(loop)
        {
            System.out.println("\n-------------------------------\n");
            System.out.println("Donation Menu     @User");
            System.out.println("-------------------------------------\n");
            System.out.println("1. Donate");
            System.out.println("2. Donation Log");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int c = in.nextInt();
            if (c==1){
                System.out.println("Enter user id: ");
                int user_id= in.nextInt();
                System.out.println("Enter amount: ");
                int amt= in.nextInt();
                Donation donation = new Donation(user_id,amt,LocalDate.now());
                donationList.add(donation);
                System.out.println("Transaction Sucessful.");
            }
            else if (c==2){
                donation_log();
            } 
            else if (c==3) {
                loop = false;
            }
            else {
                System.out.println("Wrong input try again.");
            }
        }
    }
    public static void menu_admin(){
        boolean loop = true;
        while(loop)
        {
            System.out.println("\n------------------------------------");
            System.out.println("Donation Menu     @Admin");
            System.out.println("-------------------------------------\n");
            System.out.println("1. Donate");
            System.out.println("2. Withdraw");
            System.out.println("3. Donation Log");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int c = in.nextInt();
            if (c==1){
                System.out.print("Enter user id: ");
                int user_id= in.nextInt();
                System.out.print("Enter amount: ");
                int amt = in.nextInt();
                Donation donation = new Donation(user_id,amt,LocalDate.now());
                donationList.add(donation);
                System.out.println("Donation Sucessful.");
            }
            else if(c==2){
                System.out.println("Enter user id: ");
                int uid = in.nextInt();
                for(Donation dn : donationList)
                {
                    if(dn.getuserid() == uid)
                    {
                        dn.setwithdrawn(false);
                        System.out.println(dn);
                    }
                }
            }
            else if (c==3){
                donation_log();
            }
            else if (c==4){
                loop = false;
            }
            else {
                System.out.println("Wrong input try again.");
            }
        }
    }
}
