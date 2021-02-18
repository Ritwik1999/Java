import java.util.Scanner;

public class EmpBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean choice = true;

        long phone_number;
        int years_of_exp;
        float bonus = 0;

        do {
            
            System.out.println("Enter name, number, and years of experience: ");

            sc.next();
            phone_number = sc.nextLong();
            years_of_exp = sc.nextInt();

            if (years_of_exp < 3)
            {
                System.out.println("Not eligible for bonus");
            }

            else
            {
                bonus = 500 * (years_of_exp - 3);
                System.out.println("Bonus is: " + bonus);
                System.out.println("Phone number: " + phone_number);
            }

            System.out.print("Would you like to continue? (True/False): ");
            choice = sc.nextBoolean();

        } while (choice);

        System.out.println("Thank you for using this software.");
        
        sc.close();
    }
}
