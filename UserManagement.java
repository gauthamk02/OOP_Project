import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class UserManagement {
	static ArrayList<User> UserData = new ArrayList();
    static Scanner in = new Scanner(System.in);

	public static void fillUsers() {
        
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
 		User user4 = new User();
 		User user5 = new User();
 		User user6 = new User();
 		
		user1.setUserID(1001);
		user1.setName("Vijay");
		user1.setAddress("chirala");
		user1.setPhoneNo("81236789087");
		user1.setEmailId("vijay451@gmail.com");
		user1.setPassword("qwerty");
		user1.setCovidstatus("Positive");
		user1.setAge(18);
		user1.setAdmin(true);
		user1.setVaccinateddoses(2);

		user2.setUserID(1002);
 		user2.setName("Ajay");
 		user2.setAddress("chirala");
 		user2.setPhoneNo("9876543210");
 		user2.setEmailId("ajay2@gmail.com");
 		user2.setPassword("ajay123");
 		user2.setCovidstatus("Recovered");
		user2.setAge(21);
		user2.setVaccinateddoses(2);
 		
 	
 		user3.setUserID(1003);
 		user3.setName("Hemanth");
 		user3.setAddress("Mumbai");
 		user3.setPhoneNo("9289033333");
 		user3.setEmailId("Hemanth1024@gmail.com");
 		user3.setPassword("qwerty123");
 		user3.setCovidstatus("Positive");
		user3.setAge(19);
		user3.setVaccinateddoses(2);
          
        user4.setUserID(1004);
		user4.setName("Karthik");
		user4.setAddress("Delhi");
		user4.setPhoneNo("98765432310");
		user4.setEmailId("Karthik00@gmail.com");
		user4.setPassword("karthik123");
		user4.setCovidstatus("n");
		user4.setAge(31);
		user4.setAdmin(true);
        user4.setVaccinateddoses(1);
  		
		user5.setUserID(1005);
		user5.setName("Devi");
		user5.setAddress("Chennai");
		user5.setPhoneNo("812367821334");
		user5.setEmailId("deviiii0101@gmail.com");
		user5.setPassword("devi123");
		user5.setCovidstatus("n");
        user5.setAge(38);
        user5.setVaccinateddoses(2);
          
        user6.setUserID(1006);
		user6.setName("Phani");
		user6.setAddress("Palkad");
		user6.setPhoneNo("9876543340");
		user6.setEmailId("Phani6@gmail.com");
		user6.setPassword("phani123");
		user6.setCovidstatus("n");
		user6.setAge(27);
		user6.setAdmin(true);
        user6.setVaccinateddoses(2);
        
        UserData.add(user1);
 		UserData.add(user2);
        UserData.add(user3);
  		UserData.add(user4);
        UserData.add(user5);
        UserData.add(user6);
	}
	
	/*static void mainMenu() {
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
	}*/
	
	static void adminMenu() {
		int choice;
		boolean loop = true;
		while(loop) {

		System.out.println("\n\n-------------------------------------\nUser Management   @Admin\n-------------------------------------\n");
		System.out.println("1.Add user");
		System.out.println("2.Modify user");		
		System.out.println("3.Delete user");
		System.out.println("4.Print one user");     
		System.out.println("5.Print all users");
		System.out.println("6.Back");
		System.out.println("Enter your choice: ");
		choice=Integer.parseInt(in.nextLine());
		
		switch(choice) {
		case 1: 
            addUser();
				break;
		case 2: System.out.print("Enter the UserID of the user: ");
				int userid = Integer.parseInt(in.next());
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
		case 6: loop = false;
				break;
		default: System.out.println("Wrong choice");
         break;
		}
		}
	}

    static void userMenu()
	{
		int select;
		boolean loop = true;
		while(loop) {

		System.out.println("\n\n-------------------------------------\nUser Management   @User\n-------------------------------------\n");
		System.out.println("1. View User Details");
		System.out.println("2. View own Details");
		System.out.println("3. Back");

		System.out.println(" Enter your choice=");
		select=Integer.parseInt(in.nextLine());
	switch(select)
	{
	case 1: userDetails();
			break;
	case 2: 
        System.out.println("Details of you:");
        System.out.println(Menu.user.toString());
		break;
	case 3: loop = false;
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
		System.out.print("Enter UserID to details: ");
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
               
               System.out.print(" Enter userId: ");
               int userId = scanner.nextInt();
               user.setUserID(userId);
               scanner.nextLine();
               
               System.out.print(" Enter Name: ");
               String Name = scanner.nextLine();
               user.setName(Name);
               
               System.out.print(" Enter address: ");
               String address = scanner.nextLine();
               user.setAddress(address);
   
               System.out.print(" Enter phoneNo: ");
               String phoneNo = scanner.nextLine();
               user.setPhoneNo(phoneNo);
   
               System.out.print(" Enter emailId: ");
               String emailId = scanner.nextLine();
               user.setEmailId(emailId);
               
               System.out.print(" Enter password: ");
               String password = scanner.nextLine();
               user.setPassword(password);
               
   
               System.out.print(" Enter covidstatus: ");
               String covidstatus = scanner.nextLine();
               user.setCovidstatus(covidstatus);
               
               System.out.print(" Enter age: ");
               int age = scanner.nextInt();
               user.setAge(age);
               
               System.out.print(" Enter vaccinateddoses: ");
               int vaccinateddoses = scanner.nextInt();
               user.setVaccinateddoses(vaccinateddoses);
               
               UserData.add(user);
               System.out.println(user.toString());
        }
    }


    public static void DeleteUser() 
    {
	    int id;
	    System.out.print("Enter id to be deleted:");
	    id = in.nextInt();
	    for (User user : UserData) 
		{
	    	User deluser = user;
	    	if (user.getUserId() == id) 
			{
				System.out.println(user.toString());
				System.out.println("Deleted UserId = "+user.getUserId());
				UserData.remove(deluser);
				break;
			}
		}
	}
   
    static void updateUserDetails(User user)
    {
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
    private boolean admin = false;

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
    public boolean isAdmin()
    {
        return this.admin;
    }
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    } 
    @Override
    public String toString() {
		String details = "\nName: " + Name + "\nUserID: " + userId +"\nAddress: " + address 
		+ "\nEmailID: " + emailId + "\nCovid Status: "+covidstatus +" \nVaccinated Doses: " +
		vaccinateddoses + "\nAge: " + age + "\nPhone No: " + phoneNo ; 
		if(Menu.user.isAdmin()) details += "\nPassword: " + password;
        return details; 
    }
}