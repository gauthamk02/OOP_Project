import java.util.*;
public class Main 
{
    static void displayMenu()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n\n-------------------------------------");
        System.out.println("Quarantine Management     @Admin");
        System.out.println("-------------------------------------\n");
        System.out.println("1. View Quarantined Users");
        System.out.println("2. Modify Personal Details");
        System.out.println("3. Sort Users");
        System.out.println("4. Add Users");
        System.out.println("5. Modify User Details");
        System.out.println("6. Back");
        System.out.print("\nEnter the choice: ");
        in.next();
    }
    public static void main(String[] args)
    {
        displayMenu();
    }

}
