import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class UserManagement {
	static ArrayList<User> UserData = new ArrayList();
    static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
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
         user2.setUserID(2);
 		user2.setName("Ajay");
 		user2.setAddress("chirala");
 		 user2.setPhoneNo("9876543210");
 		 user2.setEmailId("@gmail.com");
 		 user2.setPassword("asdfghjkl");
 		 user2.setCovidstatus("n");
          user2.setAge(21);
          user2.setVaccinateddoses(2);
 		 UserData.add(user1);
 		 UserData.add(user2);
          mainMenu();
	}
	
	static void mainMenu() {
		Scanner sc = new Scanner(System.in);
		 int choice,c=0;
		 while(true) {
 		 System.out.println("\n\nMain Menu\n1.Admin");
 		 System.out.println("2.User");
 		 System.out.println("3.Exit");
 		 System.out.println("Enter your choice=");
 		 choice=in.nextInt();
 		 switch(choice) {
 		 case 1:
 			adminMenu();
 			break;
 		 
 		 case 2:
 			 System.out.print("Enter your id:");
 			 int id=Integer.parseInt(sc.nextLine());
 			 int flag=0;
 			for(User User : UserData)
			{
				if(User.getUserId()==id)
				{
					userMenu();
					flag=0;
				}
				else
					flag=1;
			}
 			if(flag==1)
 				System.out.println("User Not Found, Please check your user ID!");
 			break;
 		 case 3: System.out.println("App Closed");
 		 		c=1;
 			 		break;
 		default:
 			System.out.println("wrong choice");
		}
 		 if(c==1)
 			 	break;
		 }
	}
	
	static void adminMenu() {
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
		System.out.println("\n\nAdminMenu\n1.add user");
		System.out.println("2.modify user");		
		System.out.println("3.delete user");
		System.out.println("4.Print one user");     
		System.out.println("5.Print all users");
		System.out.println("6.Mainmenu");
		System.out.println("Enter your choice: ");
		choice=Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		case 1: 
            addUser();
				break;
		case 2: System.out.print("Enter the UserID of the user: ");
				int userid = Integer.parseInt(sc.next());
				for(User User : UserData)
				{
					if(User.getUserId()==userid)
					{
						updateUserDetails(User);
					} 
				}
				break;
		case 3: 
            DeleteUser();
				break;
		case 4: view_user();
				break;
		case 5: printUsers();
				break;
		case 6: mainMenu();
				break;
		default: System.out.println("Wrong choice");
         break;
		}
		}
	}

    static void userMenu()
	{
    	
		Scanner sc = new Scanner(System.in);
		int select;
		while(true) {
		System.out.println("\n\nUser Menu\n1. View USER DETAILS");
		System.out.println("2. Enter view own details");
		System.out.println("3. Main menu");

		System.out.println(" Enter your choice=");
		select=Integer.parseInt(sc.nextLine());
	switch(select)
	{
	case 1: userDetails();
			break;
	case 2: 
        System.out.println("Details of you:");
        System.out.println(menu.user.toString());
		break;
	case 3: 
		break;
	}
		}
	}
    
     
    
    static void userDetails() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter id of the user to get details:");
		int id = Integer.parseInt(sc.next());
		int flag=0;
		for (User user : UserData) 
		{
			if (user.getUserId() == id) 
			{
				System.out.println(user.toString());
				flag=0;
				break;
			}
			else 
			{
				flag=1;
			}
		}
		if(flag==1)
			System.out.println("ID not found, plz add your details");
	}

	static void view_user()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("View USER DETAILS");
		System.out.println("Enter your UserID to view your details");
		int id = Integer.parseInt(sc.next());
		int flag=0;
		for (User user : UserData) 
		{
			if (user.getUserId() == id) 
			{
				System.out.println(user.toString());
				flag=0;
				break;
			}
			else 
			{
				flag=1;
			}
		}
		if(flag==1)
			System.out.println("ID not found, plz add your details");
	}
	
	static void printUsers()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ALL USER DETAILS");
		for (User user : UserData) 
		{
			System.out.println(user.toString()+"\n");
		}
	}
    public static void addUser() {

        User user = new User();
    
         try (Scanner scanner = new Scanner(System.in)) {
               
               System.out.print(" Enter userId => ");
               int userId = scanner.nextInt();
               user.setUserID(userId);
               scanner.nextLine();
               
               System.out.print(" Enter Name => ");
               String Name = scanner.nextLine();
               user.setName(Name);
               
               System.out.print(" Enter address => ");
               String address = scanner.nextLine();
               user.setAddress(address);
   
               System.out.print(" Enter phoneNo => ");
               String phoneNo = scanner.nextLine();
               user.setPhoneNo(phoneNo);
   
               System.out.print(" Enter emailId => ");
               String emailId = scanner.nextLine();
               user.setEmailId(emailId);
               
               System.out.print(" Enter password => ");
               String password = scanner.nextLine();
               user.setPassword(password);
               
   
               System.out.print(" Enter covidstatus => ");
               String covidstatus = scanner.nextLine();
               user.setCovidstatus(covidstatus);
               
               System.out.print(" Enter age => ");
               int age = scanner.nextInt();
               user.setAge(age);
               
               System.out.print(" Enter vaccinateddoses => ");
               int vaccinateddoses = scanner.nextInt();
               user.setVaccinateddoses(vaccinateddoses);
               
               UserData.add(user);
               System.out.println(user.toString());
               adminMenu();
        }
    }


    public static void DeleteUser() 
    {
		Scanner ab = new Scanner(System.in);
	    int id;
	    System.out.println("Enter id to be deleted:");
	    id = ab.nextInt();
	    for (User user : UserData) 
		{
	    	User deluser = user;
	    	System.out.println("User = "+user.getUserId());
			if (user.getUserId() == id) 
			{
				System.out.println(user.toString());
				UserData.remove(deluser);
				System.out.println("Deleted UserId = "+user.getUserId());
			}
		}
	    adminMenu();
	}
   
    static void updateUserDetails(User user)
    {
    	Scanner in = new Scanner(System.in);
        System.out.println("1.Name\n" + 
                        "2.User ID\n" +
                        "3.Address\n" +
                        "4.Email ID\n" +
                        "5.Phone No\n" +
                        "6.Age\n" +
                        "7.Vaccinated Doses\n" +
                        "8.Covid Status\n");

        System.out.print("\nEnter the Option to be changed: ");
        
        int upChoice = in.nextInt();

        switch(upChoice)
        {
            case 1:
                System.out.println("Curent Name: " +  user.getName());
                System.out.println("Enter new Name: ");
                String newName = in.next();
                user.setName(newName);
                break;
            case 2:
                System.out.println("Curent User ID: " +  user.getUserId());
                System.out.println("Enter new User ID: ");
                int newUserID = in.nextInt();
                user.setUserID(newUserID);
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
                System.out.println("Curent Covid Status: " +  user.covidstatus());
                System.out.println("Enter new Covid Status: ");
                String newCoidStatus = in.next();
                user.setCovidstatus(newCoidStatus);
                break;
            default:
                System.out.println("Invalid Entry!");
        }
        System.out.println("Details are updated");
        adminMenu();
    }

    
}


class User implements Serializable
{
    private String address;
    private String Name;
    private int userId;
    private String password;
    private String emailId;
    private String phoneNo;
    public int age;
    public int vaccinateddoses;
    public String covidstatus;
    private boolean admin;

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String Name() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return this.Name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCovidstatus (String covidstatus  ) {
        this.covidstatus  =covidstatus ;
    }
    public String covidstatus () {
        return covidstatus ;
    }
    
    public int getVaccinateddoses() {
        return vaccinateddoses;
    }
    public void setVaccinateddoses(int vaccinateddoses) {
        this.vaccinateddoses = vaccinateddoses;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserID(int userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public boolean getAdmin()
    {
        return this.admin;
    }
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    } 
    @Override
    public String toString() {
        return  "\nName=" + Name + "\nuserId=" + userId +"\nAddress=" + address + "\npassword=" +
            password + "\nemailId=" + emailId + "\ncovidstatus ="+covidstatus +" \nvaccinateddoses="+vaccinateddoses+"\nage="+age+"\nphoneNo=" + phoneNo ;
    }
}