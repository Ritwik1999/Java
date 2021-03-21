package strings;

import java.util.Scanner;

public class WeakPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean weak = false;
        for (int i = 0; i < username.length() - 2; i++)
        {
            String subName = username.substring(i, i+3);
            if (password.contains(subName))
            {
                System.out.println("Weak Password\n");
                weak = true;
                break;
            }
        }

        if(!weak)
        {
            System.out.println("Strong Password\n");
        }

        input.close();
    }
}
