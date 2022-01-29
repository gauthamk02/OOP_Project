import java.util.*;
import java.time.LocalDate;
import java.time.*;

public class QuarantineManagement{
    static Scanner in = new Scanner(System.in);
    static ArrayList<QuarantineUser> quarantineUserList = new ArrayList<QuarantineUser>();

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
                    if(Menu.user.getUserId() == id)
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
                user.setUserID(userId);
                
                if(in.hasNextLine()) in.nextLine();
                System.out.print(" Enter Name: ");
                String Name = in.nextLine();
                user.setName(Name);
                
                System.out.print(" Enter Address: ");
                String address = in.nextLine();
                user.setAddress(address);

                System.out.print(" Enter PhoneNo: ");
                String phoneNo = in.nextLine();
                user.setPhoneNo(phoneNo);

                System.out.print(" Enter Email-ID: ");
                String emailId = in.nextLine();
                user.setEmailId(emailId);
                
                System.out.print(" Enter Password: ");
                String password = in.nextLine();
                user.setPassword(password);
                

                System.out.print(" Enter Covid Status: ");
                String covidstatus = in.nextLine();
                user.setCovidstatus(covidstatus);
                
                System.out.print(" Enter Age: ");
                int age = in.nextInt();
                user.setAge(age);
                
                System.out.print(" Enter Vaccinated Doses: ");
                int vaccinateddoses = in.nextInt();
                user.setVaccinateddoses(vaccinateddoses);

                System.out.print(" Enter Quarantine Begin Date(yyyy-mm-dd): ");
                LocalDate quarantineBeginDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(quarantineBeginDate);

                System.out.print(" Enter Quarantine End Date(yyyy-mm-dd): ");
                LocalDate quarantineEndDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(quarantineEndDate);

                System.out.print(" Enter if Primary Contact(true/false): ");
                boolean primaryContact = in.nextBoolean();
                user.setPrimaryContact(primaryContact);

                System.out.print(" Enter if Admin(true/false): ");
                boolean admin = in.nextBoolean();
                user.setAdmin(admin);

                user.setQuarantineDays(Period.between(quarantineBeginDate, quarantineEndDate).getDays());

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
        boolean loop = true;
        while(loop){
        System.out.print("\n\n\n-------------------------------------\n" +
        "Quarantine Management     @User\n" +
        "-------------------------------------\n\n" +
        "1. View Personal Details\n" +
        "2. Modify Personal Details\n" +
        "3. Sort Users\n" +
        "4. Back\n" +
        "Enter the choice: ");
    
        int choice = in.nextInt();

        switch(choice)
        {
            case 1:
                printQuarantineUsers();
                break;
            
            case 2:
                boolean usrExist = false;
                for(QuarantineUser user : quarantineUserList)
                {
                    if(Menu.user.getUserId() == user.getUserId())
                    {
                        updateUserDetails(user);
                        usrExist = true;
                        break;
                    } 
                }
                if(!usrExist) System.out.print("\nUser not Found!");
                break;
            
            case 3:
                System.out.println("1.Name\n" +
                                "2.Age\n" +
                                "3.Quarantine Begin Date\n" +
                                "4.Quarantine End Date\n" +
                                "5.Quarantine Days");
                System.out.print("Enter the number of the field to sort on: ");
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
                break;
            case 4:
                loop = false;
                break;
            default:
                System.out.println("Invalid Choice!");
        }

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
                        "11.Primary Contact\n");

        System.out.print("\nEnter the Option to be changed: ");
        
        int upChoice = in.nextInt();

        switch(upChoice)
        {
            case 1:
                if(in.hasNextLine()) in.nextLine();
                System.out.println("Curent Name: " +  user.getName());
                System.out.print("Enter new Name: ");
                String newName = in.nextLine();
                user.setName(newName);
                break;
            case 2:
                System.out.println("Curent User ID: " +  user.getUserId());
                System.out.print("Enter new User ID: ");
                int newUserID = in.nextInt();
                user.setUserID(newUserID);
                break;
            case 3:
                System.out.println("Curent Address: " +  user.getAddress());
                System.out.print("Enter new Address: ");
                String newAddress = in.next();
                user.setAddress(newAddress);
                break;
            case 4:
                System.out.println("Curent Email ID: " +  user.getEmailId());
                System.out.print("Enter new Email ID: ");
                String newEmailID = in.next();
                user.setEmailId(newEmailID);
                break;
            case 5:
                System.out.println("Curent Phone No: " +  user.getPhoneNo());
                System.out.print("Enter new Phone No: ");
                String newPhoneNo = in.next();
                user.setPhoneNo(newPhoneNo);
                break;
            case 6:
                System.out.println("Curent Age: " +  user.getAge());
                System.out.print("Enter new Age: ");
                int newAge = in.nextInt();
                user.setAge(newAge);
                break;
            case 7:
                System.out.println("Curent Vaccinated Doses: " +  user.getVaccinateddoses());
                System.out.print("Enter new Vaccinated Doses: ");
                int newvaccinatedDoses = in.nextInt();
                user.setVaccinateddoses(newvaccinatedDoses);
                break;
            case 8:
                System.out.println("Curent Covid Status: " +  user.getCovidStatus());
                System.out.print("Enter new Covid Status: ");
                String newCoidStatus = in.next();
                user.setCovidstatus(newCoidStatus);
                break;
            case 9:
                System.out.println("Curent Quarantine Begin Date: " +  user.getQuarantineBeginDate());
                System.out.print("Enter new Quarantine Begin Date(yyyy-mm-dd): ");
                LocalDate newQuarantineBeginDate = LocalDate.parse(in.next());
                user.setQuarantineBeginDate(newQuarantineBeginDate);
                user.setQuarantineDays(Period.between(user.getQuarantineBeginDate(), user.getQuarantineEndDate()).getDays());
                break;
            case 10:
                System.out.println("Curent Quarantine End Date: " +  user.getQuarantineEndDate());
                System.out.print("Enter new Quarantine End Date(yyyy-mm-dd): ");
                LocalDate newQuarantineEndDate = LocalDate.parse(in.next());
                user.setQuarantineEndDate(newQuarantineEndDate);
                user.setQuarantineDays(Period.between(user.getQuarantineBeginDate(), user.getQuarantineEndDate()).getDays());
                break;
            case 11:
                System.out.println("Curent Primary Contact: " +  user.getPrimaryContact());
                System.out.print("Enter new Primary Contact: ");
                Boolean newPrimaryContact = in.nextBoolean();
                user.setPrimaryContact(newPrimaryContact);
                break;
            default:
                System.out.println("Invalid Entry!");
        }
    }
}
