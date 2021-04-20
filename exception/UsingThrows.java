package exception;

import java.util.Scanner;

public class UsingThrows {
    public static void main(String[] args) {
        // If a nested try doesn't have a catch, it searches in the outer try block, if
        // not found, it terminates the program
        Scanner input = new Scanner(System.in);
        try {   
            try {
                DivideByZero d = new DivideByZero(input);
                d.divideNumbers();
            } finally {
                System.out.println("Inner finally executed");
                DivideByZero d1 = new DivideByZero(input);
                d1.divideNumbers();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}

class DivideByZero {
    private int a;
    private int b;

    public DivideByZero(Scanner input) {
        System.out.println("Enter two numbers:");
        a = input.nextInt();
        b = input.nextInt();
    }

    // One might as well omit the throws clause, it is included in the signature so
    // as to help developers understand what exception might occur and thus needs
    // handling
    public void divideNumbers() throws ArithmeticException {
        System.out.println(a / b);
    }
}