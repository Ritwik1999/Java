package oops;

import java.util.Scanner;

public class EmployeeAddress {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter Employee name, and address count:");
        String name = input.nextLine();
        int n = Integer.parseInt(input.nextLine());

        Employee e1 = new Employee(name);

        e1.display_employee_data();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Street, city, district, state, country, and zip code:");
            String street = input.nextLine();
            String city = input.nextLine();
            String district = input.nextLine();
            String state = input.nextLine();
            String country = input.nextLine();
            String zipCode = input.nextLine();

            e1.new Address(street, city, district, state, country, zipCode).display_address_details();
        }

        input.close();
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void display_employee_data() {
        System.out.println("\n----------------------");
        System.out.println("Employee name: " + name);
        System.out.println("----------------------\n");
    }

    public class Address {
        String street;
        String city;
        String district;
        String state;
        String country;
        String zipCode;

        public Address(String street, String city, String district, String state, String country, String zipCode) {
            this.street = street;
            this.city = city;
            this.district = district;
            this.state = state;
            this.country = country;
            this.zipCode = zipCode;
        }

        public void display_address_details() {
            System.out.println("\n----------------------");
            System.out.println(street + " " + city + " " + district + " " + state + " " + country + " " + zipCode);
            System.out.println("----------------------\n");
        }
    }
}