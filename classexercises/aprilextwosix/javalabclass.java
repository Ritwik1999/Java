package classexercises.aprilextwosix;

import java.util.*;

public class javalabclass {
    public static void main(String[] args) {
        try {
            calculator c = new calculator();
            c.add();
            c.divide();
            c.display_namelength();
        } catch (Exception e) {
            System.out.println("--------------------\nException occurred");
            System.out.println(e.getClass());
            System.out.println("--------------------");
        } finally {
            System.out.println("Thanks for using Our Software");
        }
    }
}

class calculator {
    String name;
    int num1;
    int num2;

    public calculator() throws InputMismatchException {
        System.out.println("\nEnter the name");
        Scanner input = new Scanner(System.in);
        this.name = input.nextLine();
        System.out.println("Enter the first number");
        this.num1 = input.nextInt();
        System.out.println("Enter the second number");
        this.num2 = input.nextInt();
        input.close();
    }

    public void add() {
        System.out.println(num1 + num2);
    }

    public void divide() throws ArithmeticException {
        System.out.println(num1 / num2);
    }

    public void display_namelength() {
        System.out.println(name.length());
    }
}