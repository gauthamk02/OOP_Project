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
            System.out.println("\n-------------------------------------");
            System.out.println("Donation Menu     @User");
            System.out.println("-------------------------------------\n");
            System.out.println("1. Donate");
            System.out.println("2. Donation Log");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int c = in.nextInt();
            if (c==1){
                System.out.print("Enter amount: ");
                int amt= in.nextInt();
                Donation donation = new Donation(Menu.user.getUserId(),amt,LocalDate.now());
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
            System.out.println("4. Total Donated Amount");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int c = in.nextInt();
            if (c==1){
                System.out.print("Enter donated user's ID: ");
                int user_id= in.nextInt();
                System.out.print("Enter amount: ");
                int amt = in.nextInt();
                Donation donation = new Donation(user_id,amt,LocalDate.now());
                donationList.add(donation);
                System.out.println("Donation Sucessful.");
            }
            else if(c==2){
                System.out.print("Enter user id: ");
                int uid = in.nextInt();
                for(Donation dn : donationList)
                {
                    if(dn.getuserid() == uid)
                    {
                        dn.setwithdrawn(true);
                        System.out.println(dn);
                    }
                }
            }
            else if (c==3){
                donation_log();
            }
            else if (c == 4){
                int total = 0;
                int withdrawn = 0;
                for(Donation don : donationList){
                    total += don.getamount();
                    if(don.getwithdrawn()) withdrawn += don.getamount();
                }
                System.out.println("\nTotal Amount Donated: " + total);
                System.out.println("Amount left to withdraw: " + (total - withdrawn));
                System.out.println("Amount withdrawn: " + withdrawn);
            }
            else if (c==5){
                loop = false;
            }
            else {
                System.out.println("Wrong input try again.");
            }
        }
    }
}
