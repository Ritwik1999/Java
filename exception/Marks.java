package exception;

import java.util.*;

public class Marks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int n;
            System.out.print("\nEnter size of marks array: ");
            n = input.nextInt();
            int marks[] = new int[n];
            System.out.println("Enter marks:");

            for (int i = 0; i < n; i++) {
                marks[i] = input.nextInt();
            }

            for (int mark : marks) {
                if (mark < 0 || mark > 100) {
                    throw new InvalidRangeException("Marks should be between 0 and 100");
                }
            }

            System.out.println("All marks are valid");

        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}

class InvalidRangeException extends Exception {
    InvalidRangeException(String s) {
        super(s);
    }
}