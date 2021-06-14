package oops;

import java.util.Scanner;

public class StudentGuardian {
    public static void main(String[] args) {

        Student s1 = new Student("Ritwik Neema", "18BCE2166");
        s1.setGuardianDetails(new Scanner(System.in));
        s1.displayDetails();
    }
}

class Guardian {
    String gName;
    String contactNo;

    public Guardian(String name, String phone) {
        gName = name;
        contactNo = phone;
    }

    public void displayGuardianDetails() {
        System.out.println(gName + " " + contactNo);
    }
}

class Student {
    String sName;
    String regNo;
    Guardian guardians[];

    public Student(String name, String id) {
        sName = name;
        regNo = id;
    }

    public void setGuardianDetails(Scanner input) {
        int n;
        System.out.print("\nEnter number of guradians (Max. 3): ");
        n = Integer.parseInt(input.nextLine());
        guardians = new Guardian[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter name and contact number for guardian " + (i + 1) + ":");
            String name = input.nextLine();
            String phone = input.nextLine();
            guardians[i] = new Guardian(name, phone);
        }
    }

    public void displayDetails() {
        System.out.println("\nStudent name: " + sName + "\nStudent id: " + regNo + "\n");

        for (int i = 0; i < guardians.length; i++) {
            System.out.print("Guardian " + (i + 1) + ": ");
            guardians[i].displayGuardianDetails();
        }
    }
}