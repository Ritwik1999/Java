package exception;

import java.util.Scanner;

public class UsingThrows {
    public static void main(String[] args) {
        // If a nested try doesn't have a catch, it searches in the outer try block, if not found, it terminates the program
        try {
            try {
                DivideByZero d = new DivideByZero();
                d.divideNumbers();
            } finally {
                System.out.println("Inner finally executed");
            }
        } catch (ArithmeticException e) {
            System.out.println("Caught!");
        }
    }
}

class DivideByZero {
    private int a;
    private int b;

    public DivideByZero() {
        System.out.println("Enter two numbers:");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        input.close();
    }

    // One might as well omit the throws clause, it is included in the signature so
    // as to help developers understand what exception might occur and thus needs
    // handling
    public void divideNumbers() throws ArithmeticException {
        System.out.println(a / b);
    }
}