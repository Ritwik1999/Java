package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidRangeException extends Exception {
    private static final long serialVersionUID = 1L;

    InvalidRangeException(String s) {
        super(s);
    }
}

public class Marks {
    public static void main(String[] args) throws InputMismatchException, IndexOutOfBoundsException {
        Scanner input = new Scanner(System.in);
        try {
            int n;
            System.out.print("Enter size of marks array: ");
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
