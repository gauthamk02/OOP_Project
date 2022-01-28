import java.io.*;
import java.util.*;

public class Menu {
	static Scanner sc = new Scanner(System.in);
    static boolean admin;
    static User user;

    static User login(int userID, String passwd) throws UserNotFoundException
    {
        for(User usr : UserManagement.UserData)
        {
            if(userID == usr.getUserId())
            {
                if(passwd.equals(usr.getPassword())) return usr;
                else throw new UserNotFoundException("Invalid Credentials");
            }
        }
        for(QuarantineUser usr : QuarantineManagement.quarantineUserList)
        {
            if(userID == usr.getUserId())
            {
                if(passwd.equals(usr.getPassword())) return usr;
                else throw new UserNotFoundException("Invalid Credentials");
            }
        }
        throw new UserNotFoundException("User not found with userID " + userID);
    }
    static void admin_menu() {
        boolean loop = true;
        while(loop)
        {
            System.out.println("\n\n\n-------------------------------------");
            System.out.print("Covid Management System\n-------------------------------------\n");
            System.out.println("Main Menu     @Admin");
            System.out.println("-------------------------------------\n");
            System.out.println("1. User Management");
            System.out.println("2. Quarantine Management");
            System.out.println("3. Donations");
            System.out.println("4. Manage help Requests");
            System.out.println("5. Quit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                // usermanagement(username,passwrd);
                UserManagement.adminMenu();
            } else if (choice == 2) {
                //quarantine_management(username,passwrd);
                QuarantineManagement.admin_menu();
            } else if (choice == 3) {
                //Donation(username,passwrd);
                DonationMenu.menu_admin();
            } else if (choice == 4) {
                help.mng_hlp_requests();
            } else if (choice == 5) {
                System.out.println("\n\nThank you");
                System.out.println("The Program is being closed");
                loop = false;
            } else {
                System.out.println("Please Enter A Valid Input");
                admin_menu();
            }
        }
    }

    static void user_menu() {
        boolean loop = true;
        while(loop)
            {
            System.out.println("\n\n\n-------------------------------------");
            System.out.println("Covid Management System\n------------------------------------");
            System.out.println("Main Menu     @User");
            System.out.println("-------------------------------------\n");
            
            System.out.println("1. User Management");
            System.out.println("2. Quarantine Management");
            System.out.println("3. Donate");
            System.out.println("4. Request Help");
            System.out.println("5. Quit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                //usermanagement(username,passwrd);
                UserManagement.userMenu();
            } else if (choice == 2) {
                //quarantinemanagement(username,passwrd);
                QuarantineManagement.user_menu();
            } else if (choice == 3) {
                //Donation(username,passwrd);
                DonationMenu.menu_user();
            } else if (choice == 4) {
                help.requesthelp();
            } else if (choice == 5) {
                System.out.println("Thank you ");
                System.out.println("The program is being closed");
            } else {
                System.out.println("Please Enter A Valid Input");
                user_menu();
            }
        }
    }

    public static void main(String[] args) {
        /*fillList();
        try
        {
            saveToFile(QuarantineManagement.quarantineUserList, "Qusers.dat");
            saveToFile(UserManagement.UserData, "User.dat");
            saveToFile(DonationMenu.donationList, "Donations.dat");
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }*/

        try
        { 
            QuarantineManagement.quarantineUserList = loadFromFile("Qusers.dat");
            UserManagement.UserData = loadFromFile("User.dat");
            DonationMenu.donationList = loadFromFile("Donations.dat");
            
            //UserManagement.fillUsers();

            Scanner sc = new Scanner(System.in);
            //input username
            System.out.print("Enter your userID : ");
            int userID = sc.nextInt();

            //input password
            System.out.print("Enter your password : ");
            String passwd = sc.next();

            user = login(userID, passwd);
            if(user.isAdmin())
            {
                admin_menu();
            }
            else
            {
                user_menu();
            }
            sc.close();

            saveToFile(QuarantineManagement.quarantineUserList, "Qusers.dat");   
            saveToFile(UserManagement.UserData, "User.dat");
            saveToFile(DonationMenu.donationList, "Donations.dat");
        }
        catch(UserNotFoundException unfe)
        {
            System.out.println(unfe);
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }
    }
    public static  <T> T loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Object obj =  in.readObject();
        in.close();
        return (T) obj;    
    }

    public static <T> void saveToFile(T list, String filename) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
    }

    static void fillList()
    {
        User user1 = new User();
		User user2 = new User();
		user1.setUserID(1);
		user1.setName("vijay");
		user1.setAddress("chirala");
		 user1.setPhoneNo("81236789087");
		 user1.setEmailId("@gmail.com");
		 user1.setPassword("qwerty");
		 user1.setCovidstatus("n");
         user1.setAge(18);
         user1.setVaccinateddoses(2);
         user1.setAdmin(true);
         user2.setUserID(2);
 		user2.setName("Ajay");
 		user2.setAddress("chirala");
 		 user2.setPhoneNo("9876543210");
 		 user2.setEmailId("@gmail.com");
 		 user2.setPassword("asdfghjkl");
 		 user2.setCovidstatus("n");
          user2.setAdmin(false);
          user2.setAge(21);
          user2.setVaccinateddoses(2);
 		 UserManagement.UserData.add(user1);
 		 UserManagement.UserData.add(user2);

        QuarantineUser qu = new QuarantineUser();
        qu.setAddress("Kollam");
        qu.setUserID(4);
        qu.setAge(18);
        qu.setQuarantineDays(14);
        qu.setCovidstatus("Negative");
        qu.setEmailId("email@gmail.com");
        qu.setPassword("1234");
        qu.setName("Rohan");
        qu.setPhoneNo("123456789");
        qu.setAdmin(true);

        QuarantineManagement.quarantineUserList.add(qu);
    }
}

class help {
    private String username;
    private String passwd;
    static Scanner sc =new Scanner(System.in);
    static boolean requesthelp() {
        System.out.println("\n\n\n-------------------------------------");
        System.out.println("Requesting Help     @User");
        System.out.println("-------------------------------------\n");
        
        System.out.print("Enter your details \nEnter your name: ");
        String name = null;
        try {
            name = sc.next();
        } catch (InputMismatchException ie) {
            System.out.println("You Have Entered Invalid Details!!");
            requesthelp();
        }
        System.out.print("Enter The Bugs or uncomfortabilities you are feeling in the program :");
        String Message = sc.next();
        Message+=sc.nextLine();
        Date date = Calendar.getInstance().getTime();

        try {
            File f = new File("help.txt");
            FileWriter fw = new FileWriter(f, true);
            if (!f.exists()) {
                f.createNewFile();
            }
            fw.write("Name :"+name + "\t"+"\t"+"Message :" + Message +"\t"+ "\t"+"Date :" +date+"\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    static void mng_hlp_requests() {
        System.out.println("\n\n\n-------------------------------------");
        System.out.println("Help Requests Management     @Admin");
        System.out.println("-------------------------------------\n");
        System.out.println("Welcome to the Help Requests Management Software :\nwhat would you like to do ?");
        System.out.println("1.Delete All Help Requests");
        System.out.println("2.Get Help Request Data");
        System.out.print("Enter your choice : ");
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

class UserNotFoundException extends Exception
{
    UserNotFoundException(String str)
    {
        super(str);
    }
}