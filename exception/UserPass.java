package exception;

import java.util.Scanner;

public class UserPass {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String username, password, confirmPassword;
        boolean valid = true;

        try {
            System.out.print("Username: ");
            username = input.nextLine().trim();

            System.out.print("Password: ");
            password = input.nextLine();

            System.out.print("Re enter password: ");
            confirmPassword = input.nextLine();

            if (username.isEmpty() || password.isEmpty()) {
                valid = false;
                throw new Exception("Username and password cannot be empty");                
            }

            if (valid) {
                if (password.length() < 8) {
                    throw new Exception("Password has to be a minimum of 8 characters");
                }

                if (password.contains(username)) {
                    throw new Exception("Password cannot contain username");
                }

                if (!password.equals(confirmPassword)) {
                    throw new Exception("Passwords do not match");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}