import java.util.ArrayList;
import java.util.Scanner;


public class UserManagement {
	static ArrayList<User> UserData = new ArrayList();
    static Scanner in = new Scanner(System.in);
	
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
				int userid = in.nextInt();
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

		System.out.print(" Enter your choice: ");
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
    	System.out.print("Enter ID of the user to get the details: ");
		int id = Integer.parseInt(in.next());
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
		System.out.print("Enter UserID to details: ");
		int id = Integer.parseInt(in.next());
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
		System.out.println("ALL USER DETAILS");
		for (User user : UserData) 
		{
			System.out.println(user.toString()+"\n");
		}
	}
    public static void addUser() {

        User user = new User();
       
		System.out.print(" Enter userId: ");
		int userId = in.nextInt();
		user.setUserID(userId);
		in.nextLine();
		
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
		
		UserData.add(user);
		System.out.println(user.toString());
	
    }


    public static void DeleteUser() 
    {
	    int id;
	    System.out.print("Enter id to be deleted:");
	    id = in.nextInt();
		in.nextLine();
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

