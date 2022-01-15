import java.io.*;
import java.util.*;

public class menu {
	//something
    static boolean admin;
    static User user;
    static final private String admin_name="Ananthan";
    static final private String admin_passwd="1234";
    static int admin(String username, String passwd){
        if(username.equals(admin_name)) {
            if (passwd.equals(admin_passwd)) {
                return 1;
            } else {
                return -1;
            }
        }else {
            return 0;
        }
    }
    static void admin_menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Covid Management System");
        System.out.println("1. User Management");
        System.out.println("2. Quarantine Management");
        System.out.println("3. Donations");
        System.out.println("4. Manage help Requests");
        System.out.println("5. Quit");
        System.out.println("Enter your choice :");
        int choice = sc.nextInt();
        if (choice == 1) {
            // usermanagement(username,passwrd);
            UserManagement.adminMenu();
        } else if (choice == 2) {
            //quarantine_management(username,passwrd);
            QuarantineManagement.admin_menu();
        } else if (choice == 3) {
            //Donation(username,passwrd);
            donationmenu.menu_admin();
        } else if (choice == 4) {
            help.mng_hlp_requests();
        } else if (choice == 5) {
            System.out.println("Thank you");
            System.out.println("The Program is being closed");
        } else {
            System.out.println("Please Enter A Valid Input");
            admin_menu();
        }
        sc.close();
    }

    static void user_menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Covid Management System");
        System.out.println("1. User Management");
        System.out.println("2. Quarantine Management");
        System.out.println("3. Donate");
        System.out.println("4. Request Help");
        System.out.println("5. Quit");
        System.out.println("Enter your choice :");
        int choice = sc.nextInt();
        if (choice == 1) {
            //usermanagement(username,passwrd);
            UserManagement.userMenu();
        } else if (choice == 2) {
            //quarantinemanagement(username,passwrd);
            QuarantineManagement.user_menu();
        } else if (choice == 3) {
            //Donation(username,passwrd);
            donationmenu.menu_user();
        } else if (choice == 4) {
            help.requesthelp();
        } else if (choice == 5) {
            System.out.println("Thank you ");
            System.out.println("The program is being closed");
        } else {
            System.out.println("Please Enter A Valid Input");
            user_menu();
        }
        sc.close();

    }

    public static void main(String[] args) {
        fillList();

        Scanner sc = new Scanner(System.in);
        //input username
        System.out.println("Enter your username :");
        String user = sc.next();

        //input password
        System.out.println("Enter your password :");
        String passwd = sc.next();
        if (menu.admin(user, passwd) == 1) {
            admin_menu();
        } else if (menu.admin(user, passwd) == -1) {
            System.out.println("Pls Enter Valid User Details !!");
            main(null);
        } else {
            user_menu();
        }
        sc.close();

    }

    static void fillList()
    {
        User user1 = new User();
		User user2 = new User();
		user1.setUserName(1);
		user1.setName("vijay");
		user1.setAddress("chirala");
		 user1.setPhoneNo("81236789087");
		 user1.setEmailId("@gmail.com");
		 user1.setPassword("qwerty");
		 user1.setCovidstatus("n");
         user1.setAge(18);
         user1.setVaccinateddoses(2);
         user2.setUserName(2);
 		user2.setName("Ajay");
 		user2.setAddress("chirala");
 		 user2.setPhoneNo("9876543210");
 		 user2.setEmailId("@gmail.com");
 		 user2.setPassword("asdfghjkl");
 		 user2.setCovidstatus("n");
          user2.setAge(21);
          user2.setVaccinateddoses(2);
 		 UserManagement.UserData.add(user1);
 		 UserManagement.UserData.add(user2);

        QuarantineUser qu = new QuarantineUser();
        qu.setAddress("Kollam");
        qu.setUserName(4);
        qu.setAge(18);
        qu.setQuarantineDays(14);
        qu.setCovidstatus("Negative");
        qu.setEmailId("email@gmail.com");
        qu.setName("Rohan");
        qu.setPhoneNo("123456789");

        QuarantineManagement.quarantineUserList.add(qu);
    }
}
    class help {
        private String username;
        private String passwd;
        static boolean requesthelp() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your details \nEnter your name:");
            String name = null;
            try {
                name = sc.next();
            } catch (InputMismatchException ie) {
                System.out.println("You Have Entered Invalid Details!!");
                requesthelp();
            }
            System.out.println("Enter The Bugs or uncomfortabilities you are feeling in the program ");
            String Message = sc.nextLine();
            Date date = Calendar.getInstance().getTime();

            try {
                File f = new File("help.txt");
                FileWriter fw = new FileWriter(f, true);
                if (!f.exists()) {
                    f.createNewFile();
                }
                fw.write(name + "\t" + Message + "\t" +date);
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        static void mng_hlp_requests() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Hel Requests Management Software :\nwhat would you like to do ?");
            System.out.println("1.Delete All Help Requests");
            System.out.println("2.Get Help Request Data");
            System.out.println("Enter your choice");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Enter Correct Datatype in the coloumn");
                mng_hlp_requests();
            }
            if(choice==1){
                del_help_req();
            }else if(choice==2){
                read_help_req();
            }
        }
        static boolean del_help_req(){
            try{
                FileWriter file=new FileWriter("help.txt",false);
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;

        }
        static boolean read_help_req(){
            try{
                File f = new File("help.txt");
                if(!f.exists()){
                    f.createNewFile();
                }
                FileReader fr =new FileReader(f);
                ArrayList<String> array =new ArrayList<>();
                String str = new String();
                while(str == String.valueOf(fr.read() != -1)){
                    array.add(str);
                }
                fr.close();
                for(String i:array){
                    System.out.println(i);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
