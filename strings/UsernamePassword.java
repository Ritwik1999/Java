package strings;

import java.util.Scanner;

public class UsernamePassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username, password, confirmPassword;
        boolean valid = true;

        System.out.print("Username: ");
        username = input.nextLine().trim();

        System.out.print("Password: ");
        password = input.nextLine();

        System.out.print("Re enter password: ");
        confirmPassword = input.nextLine();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty");
            valid = false;
        }

        if (valid) {
            if (password.length() < 8) {
                System.out.println("Password has to be a minimum of 8 characters");
            }

            if (password.contains(username.toLowerCase())) {
                System.out.println("Password cannot contain username");
            }

            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match");
            }
        }

        input.close();
    }
}
