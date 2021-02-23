package oops;

import java.util.Scanner;

public class ClassDemo {
    public static void main(String[] args) {
        // how to create a new student object
        Student ritwik = new Student();
        
        ritwik.register_profile_information();
        ritwik.view_profile_information();
    }
}

class Student // define template for the student
{
    String name;
    String address;
    String phone;

    // define methods for behaviour of a student
    public void register_profile_information() {
        System.out.print("Enter your name: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.print("Enter your address: ");
        address = input.nextLine();
        System.out.print("Enter your phone: ");
        phone = input.nextLine();

        input.close();
    }

    public void view_profile_information()
    {
        System.out.println("Your name is: " + name);
        System.out.println("Your address is: " + address);
        System.out.println("Your phone is: " + phone);
    }
}
