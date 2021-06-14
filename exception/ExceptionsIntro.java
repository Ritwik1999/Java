package exception;

import java.util.Scanner;

public class ExceptionsIntro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int num = input.nextInt();

            if (num == 13) {
                throw new Number13Exception("I don't like 13");
            }

            else if (num == 15) {
                throw new Number15Exception("15 not allowed");
            }
        }
        // In case when multiple catch blocks qualify to handle a single type of
        // exception, it is the first catch block that catches it
        // A base class exception can handle all child class exceptions
        catch (Exception e) {
            if (e instanceof Number13Exception) {
                System.out.println("Please don't enter 13 again");
            }

            if (e instanceof Number15Exception) {
                System.out.println("15 is not allowed");
            }
        } finally {
            input.close();
        }
    }
}

class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}

class Number13Exception extends MyException {
    public Number13Exception(String S) {
        super(S);
    }
}

class Number15Exception extends MyException {
    public Number15Exception(String S) {
        super(S);
    }
}