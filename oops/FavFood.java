package oops;

import java.util.Scanner;

public class FavFood {
    public static void main(String[] args) {
        Customer c[] = new Customer[10];
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter names and favourite food for " + c.length + " people:");

        for (int i = 0; i < c.length; i++) {
            String name = input.nextLine();
            String food = input.nextLine();
            c[i] = new Customer(name, food);
        }

        System.out.print("\nEnter fav food: ");
        String favFood = input.nextLine();

        input.close();

        Customer.findCommons(c, favFood);
    }
}

class Customer {
    private String name;
    private String favFood;

    public Customer(String name, String favFood) {
        this.name = name;
        this.favFood = favFood;
    }

    public static void findCommons(Customer customers[], String food) {
        System.out.println("\nCustomers who have " + food + " as their favourite food:");

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].favFood.equals(food)) {
                System.out.println(customers[i].name);
            }
        }
    }
}