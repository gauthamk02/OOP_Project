import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuarantineManagement{
    static Scanner in;
    static ArrayList<QuarantineUser> quarantineUserList = new ArrayList<QuarantineUser>();

    QuarantineManagement()
    {
        in = new Scanner(System.in);
    }

    static void printQuarantineUsers()
    {
        for(QuarantineUser user : quarantineUserList)
        {
            System.out.println(user);
        }
    }
    
    public static Comparator<QuarantineUser> nameComparator = new Comparator<QuarantineUser>() {
        public int compare(QuarantineUser u1, QuarantineUser u2)
        {
            return String.valueOf(u1.getName()).compareTo(u2.getName());
        }
    };
    public static Comparator<QuarantineUser> ageComparator = new Comparator<QuarantineUser>() {
        public int compare(QuarantineUser u1, QuarantineUser u2)
        {
            return Integer.compare(u1.getAge(), u2.getAge());
        }
    };
    public static Comparator<QuarantineUser> beginDateComparator = new Comparator<QuarantineUser>() {
        public int compare(QuarantineUser u1, QuarantineUser u2)
        {
            if(u1.getQuarantineBeginDate().isBefore(u2.getQuarantineBeginDate())) return -1;
            else if(u1.getQuarantineBeginDate().isAfter(u2.getQuarantineBeginDate())) return 1;
            else return 0;
        }
    };
    public static Comparator<QuarantineUser> endDateComparator = new Comparator<QuarantineUser>() {
        public int compare(QuarantineUser u1, QuarantineUser u2)
        {
            if(u1.getQuarantineEndDate().isBefore(u2.getQuarantineEndDate())) return -1;
            else if(u1.getQuarantineEndDate().isAfter(u2.getQuarantineEndDate())) return 1;
            else return 0;
        }
    };
    public static Comparator<QuarantineUser> daysComparator = new Comparator<QuarantineUser>() {
        public int compare(QuarantineUser u1, QuarantineUser u2)
        {
            return Integer.compare(u1.getQuarantineDays(), u2.getQuarantineDays());
        }
    };

    public static void admin_menu()
    {
        /*QuarantineUser qu = new QuarantineUser();
        qu.setAddress("Kollam");
        qu.setUserName(4);
        qu.setAge(18);
        qu.setQuarantineDays(14);
        qu.setCovidstatus("Negative");
        qu.setEmailId("email@gmail.com");
        qu.setName("Rohan");
        qu.setPhoneNo("123456789");

        quarantineUserList.add(qu);*/

        Scanner in = new Scanner(System.in);

        boolean running = true;
        while(running){
            System.out.print("\n\n\n-------------------------------------\n" +
            "Quarantine Management     @Admin\n" +
            "-------------------------------------\n\n" +
            "1. View Quarantined Users\n" +
            "2. Modify Personal Details\n" +
            "3. Sort Users\n" +
            "4. Add Users\n" +
            "5. Modify User Details\n" +
            "6. Delete User\n" +
            "7. Back\n" +
            "Enter the choice: ");
        int choice = in.nextInt();

        switch(choice)
        {
            case 1:
                printQuarantineUsers();
                break;
            
            case 2:
                System.out.print("Enter the UserID of the user: ");
                int id = in.nextInt();
                for(QuarantineUser user : quarantineUserList)
                {
                    if(menu.user.getUserId() == id)
                    {
                        updateUserDetails(user);
                        break;
                    } 
                }
                System.out.print("User not Found!");
                break;
            
            case 3:
                System.out.println("1.Name\n" +
                                "2.Age\n" +
                                "3.Quarantine Begin Date" +
                                "4.Quarantine End Date" +
                                "5.Quarantine Days");
                System.out.print("Enter the number of the field to sort on:");
                int sortChoice = in.nextInt();
                switch(sortChoice)
                {
                    case 1:
                        quarantineUserList.sort(nameComparator);
                        printQuarantineUsers();
                        break;  
                    case 2:
                        quarantineUserList.sort(ageComparator);
                        printQuarantineUsers();
                        break;
                    case 3:
                        quarantineUserList.sort(beginDateComparator);
                        printQuarantineUsers();
                        break;
                    case 4:
                        quarantineUserList.sort(endDateComparator);
                        printQuarantineUsers();
                        break;
                    case 5:
                        quarantineUserList.sort(daysComparator);
                        printQuarantineUsers();
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
            case 4:
                QuarantineUser user = new QuarantineUser();

                System.out.print(" Enter userId: ");
                int userId = in.nextInt();
                user.setUserName(userId);
                
                if(in.hasNextLine()) in.nextLine();
                System.out.print(" Enter Name: ");
                String Name = in.nextLine();
                user.setName(Name);
                
                System.out.print(" Enter address: ");
                String address = in.nextLine();
                user.setAddress(address);

                System.out.print(" Enter phoneNo: ");
                String phoneNo = in.nextLine();
                user.setPhoneNo(phoneNo);

                System.out.print(" Enter emailId: ");
                String emailId = in.nextLine();
                user.setEmailId(emailId);
                
                System.out.print(" Enter password: ");
                String password = in.nextLine();
                user.setPassword(password);
                

                System.out.print(" Enter covidstatus: ");
                String covidstatus = in.nextLine();
                user.setCovidstatus(covidstatus);
                
                System.out.print(" Enter age: ");
                int age = in.nextInt();
                user.setAge(age);
                
                System.out.print(" Enter vaccinateddoses: ");
                int vaccinateddoses = in.nextInt();
                user.setVaccinateddoses(vaccinateddoses);

                System.out.print(" Enter Quarantine Begin Date(yyyy-mm-dd): ");
                LocalDate quarantineBeginDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(quarantineBeginDate);

                System.out.print(" Enter Quarantine End Date(yyyy-mm-dd): ");
                LocalDate quarantineEndDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(quarantineEndDate);

                System.out.print(" Enter if Primary Contact: ");
                boolean primaryContact = in.nextBoolean();
                user.setPrimaryContact(primaryContact);
                quarantineUserList.add(user);
                
                break;
            case 5:
                System.out.print("Enter the UserID of the user: ");
                int userid = in.nextInt();
                for(QuarantineUser User : quarantineUserList)
                {
                    if(User.getUserId() == userid)
                    {
                        updateUserDetails(User);
                    } 
                }
                break;
            case 6:
                System.out.print("Enter the UserID of the user: ");
                int usrid = in.nextInt();
                for(int i = 0; i < quarantineUserList.size(); i++)
                {
                    QuarantineUser User = quarantineUserList.get(i);
                    if(User.getUserId() == usrid)
                    {
                        quarantineUserList.remove(i);
                        System.out.println("Removed User");
                    } 
                }
                break;
            case 7:
                running = false;
                break;
            default:
                System.out.println("Undefined choice!");
        }

    }
    }
    public static void user_menu()
    {
        QuarantineUser qu = new QuarantineUser();
        qu.setAddress("Kollam");
        qu.setUserName(4);
        qu.setAge(18);
        qu.setQuarantineDays(14);
        qu.setCovidstatus("Negative");
        qu.setEmailId("email@gmail.com");
        qu.setName("Rohan");
        qu.setPhoneNo("123456789");
        quarantineUserList.add(qu);


        System.out.print("\n\n\n-------------------------------------\n" +
        "Quarantine Management     @Admin\n" +
        "-------------------------------------\n\n" +
        "1. View Quarantined Users\n" +
        "2. Modify Personal Details\n" +
        "3. Sort Users\n" +
        "4. Back\n" +
        "Enter the choice: ");

        Scanner in = new Scanner(System.in);
        while(true){
        int choice = in.nextInt();

        switch(choice)
        {
            case 1:
                printQuarantineUsers();
                break;
            
            case 2:
                System.out.print("Enter the UserID of the user: ");
                int id = in.nextInt();
                for(QuarantineUser user : quarantineUserList)
                {
                    if(menu.user.getUserId() == id)
                    {
                        updateUserDetails(user);
                        break;
                    } 
                }
                System.out.print("User not Found!");
                break;
            
            case 3:
                System.out.println("1.Name\n" +
                                "2.Age\n" +
                                "3.Quarantine Begin Date" +
                                "4.Quarantine End Date" +
                                "5.Quarantine Days");
                System.out.print("Enter the number of the field to sort on:");
                int sortChoice = in.nextInt();
                switch(sortChoice)
                {
                    case 1:
                        quarantineUserList.sort(nameComparator);
                        printQuarantineUsers();
                        break;  
                    case 2:
                        quarantineUserList.sort(ageComparator);
                        printQuarantineUsers();
                        break;
                    case 3:
                        quarantineUserList.sort(beginDateComparator);
                        printQuarantineUsers();
                        break;
                    case 4:
                        quarantineUserList.sort(endDateComparator);
                        printQuarantineUsers();
                        break;
                    case 5:
                        quarantineUserList.sort(daysComparator);
                        printQuarantineUsers();
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
            case 4:
                return;
            default:
                System.out.println("Invalid Choice!");
        }

        in.close();
        }
    }
    public static void main(String[] args)
    {
        QuarantineUser qu = new QuarantineUser();
        qu.setAddress("Kollam");
        qu.setUserName(4);
        qu.setAge(18);
        qu.setQuarantineDays(14);
        qu.setCovidstatus("Negative");
        qu.setEmailId("email@gmail.com");
        qu.setName("Rohan");
        qu.setPhoneNo("123456789");

        quarantineUserList.add(qu);

        Scanner in = new Scanner(System.in);
        while(true){
        System.out.print("\n\n\n-------------------------------------\n" +
        "Quarantine Management     @Admin\n" +
        "-------------------------------------\n\n" +
        "1. View Quarantined Users\n" +
        "2. Modify Personal Details\n" +
        "3. Sort Users\n" +
        "4. Add Users\n" +
        "5. Modify User Details\n" +
        "6. Back\n" +
        "Enter the choice: ");
        int choice = in.nextInt();

        switch(choice)
        {
            case 1:
                printQuarantineUsers();
                break;
            
            case 2:
                System.out.print("Enter the UserID of the user: ");
                int id = in.nextInt();
                for(QuarantineUser user : quarantineUserList)
                {
                    if(menu.user.getUserId() == id)
                    {
                        updateUserDetails(user);
                        break;
                    } 
                }
                System.out.print("User not Found!");
                break;
            
            case 3:
                System.out.println("1.Name\n" +
                                "2.Age\n" +
                                "3.Quarantine Begin Date" +
                                "4.Quarantine End Date" +
                                "5.Quarantine Days");
                System.out.print("Enter the number of the field to sort on:");
                int sortChoice = in.nextInt();
                switch(sortChoice)
                {
                    case 1:
                        quarantineUserList.sort(nameComparator);
                        printQuarantineUsers();
                        break;  
                    case 2:
                        quarantineUserList.sort(ageComparator);
                        printQuarantineUsers();
                        break;
                    case 3:
                        quarantineUserList.sort(beginDateComparator);
                        printQuarantineUsers();
                        break;
                    case 4:
                        quarantineUserList.sort(endDateComparator);
                        printQuarantineUsers();
                        break;
                    case 5:
                        quarantineUserList.sort(daysComparator);
                        printQuarantineUsers();
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
            case 4:
                QuarantineUser user = new QuarantineUser();
                System.out.print(" Enter userId: ");
                int userId = in.nextInt();
                user.setUserName(userId);
                
                if(in.hasNextLine()) in.nextLine();
                System.out.print(" Enter Name: ");
                String Name = in.nextLine();
                user.setName(Name);
                
                System.out.print(" Enter address: ");
                String address = in.nextLine();
                user.setAddress(address);

                System.out.print(" Enter phoneNo: ");
                String phoneNo = in.nextLine();
                user.setPhoneNo(phoneNo);

                System.out.print(" Enter emailId: ");
                String emailId = in.nextLine();
                user.setEmailId(emailId);
                
                System.out.print(" Enter password: ");
                String password = in.nextLine();
                user.setPassword(password);
                

                System.out.print(" Enter covidstatus: ");
                String covidstatus = in.nextLine();
                user.setCovidstatus(covidstatus);
                
                System.out.print(" Enter age: ");
                int age = in.nextInt();
                user.setAge(age);
                
                System.out.print(" Enter vaccinateddoses: ");
                int vaccinateddoses = in.nextInt();
                user.setVaccinateddoses(vaccinateddoses);
                
                System.out.print(" Enter Quarantine Begin Date(yyyy-mm-dd)): ");
                LocalDate quarantineBeginDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(quarantineBeginDate);

                System.out.print(" Enter Quarantine End Date(yyyy-mm-dd): ");
                LocalDate quarantineEndDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(quarantineEndDate);

                System.out.print(" Enter if Primary Contact: ");
                boolean primaryContact = in.nextBoolean();
                user.setPrimaryContact(primaryContact);
                quarantineUserList.add(user);
                break;
            case 5:
                System.out.print("Enter the UserID of the user: ");
                int userid = in.nextInt();
                for(QuarantineUser User : quarantineUserList)
                {
                    if(User.getUserId() == userid)
                    {
                        updateUserDetails(User);
                    } 
                }
                break;
            default:
                System.out.println("Undefined choice!");
        }

        in.close();
    }
    }
    
    static void updateUserDetails(QuarantineUser user)
    {
        System.out.println("1.Name\n" + 
                        "2.User ID\n" +
                        "3.Address\n" +
                        "4.Email ID\n" +
                        "5.Phone No\n" +
                        "6.Age\n" +
                        "7.Vaccinated Doses\n" +
                        "8.Covid Status\n" +
                        "9.Quarantine Begin Date\n" +
                        "10.Quarantine End Date\n" +
                        "11.Quarantine Days\n" +
                        "12.Primary Contact\n");

        System.out.print("\nEnter the Option to be changed: ");
        
        int upChoice = in.nextInt();

        switch(upChoice)
        {
            case 1:
                if(in.hasNextLine()) in.nextLine();
                System.out.println("Curent Name: " +  user.getName());
                System.out.println("Enter new Name: ");
                String newName = in.nextLine();
                user.setName(newName);
                break;
            case 2:
                System.out.println("Curent User ID: " +  user.getUserId());
                System.out.println("Enter new User ID: ");
                int newUserID = in.nextInt();
                user.setUserName(newUserID);
                break;
            case 3:
                System.out.println("Curent Address: " +  user.getAddress());
                System.out.println("Enter new Address: ");
                String newAddress = in.next();
                user.setAddress(newAddress);
                break;
            case 4:
                System.out.println("Curent Email ID: " +  user.getEmailId());
                System.out.println("Enter new Email ID: ");
                String newEmailID = in.next();
                user.setEmailId(newEmailID);
                break;
            case 5:
                System.out.println("Curent Phone No: " +  user.getPhoneNo());
                System.out.println("Enter new Phone No: ");
                String newPhoneNo = in.next();
                user.setPhoneNo(newPhoneNo);
                break;
            case 6:
                System.out.println("Curent Age: " +  user.getAge());
                System.out.println("Enter new Age: ");
                int newAge = in.nextInt();
                user.setAge(newAge);
                break;
            case 7:
                System.out.println("Curent Vaccinated Doses: " +  user.getVaccinateddoses());
                System.out.println("Enter new Vaccinated Doses: ");
                int newvaccinatedDoses = in.nextInt();
                user.setVaccinateddoses(newvaccinatedDoses);
                break;
            case 8:
                System.out.println("Curent Covid Status: " +  user.getCovidStatus());
                System.out.println("Enter new Covid Status: ");
                String newCoidStatus = in.next();
                user.setCovidstatus(newCoidStatus);
                break;
            case 9:
                System.out.println("Curent Quarantine Begin Date: " +  user.getQuarantineBeginDate());
                System.out.println("Enter new Quarantine Begin Date(yyyy-mm-dd): ");
                LocalDate newQuarantineBeginDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(newQuarantineBeginDate);
                break;
            case 10:
                System.out.println("Curent Quarantine End Date: " +  user.getQuarantineEndDate());
                System.out.println("Enter new Quarantine End Date(yyyy-mm-dd): ");
                LocalDate newQuarantineEndDate = LocalDate.parse(in.next());
                user.setQuarantineEndDate(newQuarantineEndDate);
                break;
            case 11:
                System.out.println("Curent Quarantine Days: " +  user.getQuarantineDays());
                System.out.println("Enter new Quarantine Days: ");
                int newQuarantineDays = in.nextInt();
                user.setQuarantineDays(newQuarantineDays);
                break;
            case 12:
                System.out.println("Curent Primary Contact: " +  user.getPrimaryContact());
                Boolean newPrimaryContact = in.nextBoolean();
                user.setPrimaryContact(newPrimaryContact);
                break;
            default:
                System.out.println("Invalid Entry!");
        }
    }
}
