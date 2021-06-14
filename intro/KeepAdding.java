package intro;

import java.util.Scanner;

public class KeepAdding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        boolean choice = true;

        do {
            System.out.print("Enter the first number: ");
            num1 = sc.nextInt();

            System.out.print("Enter the second number: ");
            num2 = sc.nextInt();

            System.out.println("Sum of the two numbers is: " + (num1 + num2));

            System.out.print("Would you like to continue? (True/False): ");
            choice = sc.nextBoolean();
        } while (choice);

        System.out.println("Thank you for using this software.");

        sc.close();
    }
}
