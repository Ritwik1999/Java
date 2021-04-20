package exception;

import java.util.Scanner;

public class StudentException {

    String name;
    String regno;
    String phone;

    void getInfo(Scanner input) {
        System.out.println("Enter name, regno, and phone number:");

        name = input.nextLine();
        regno = input.nextLine();
        phone = input.nextLine();

        System.out.println();
    }

    static void sortObj(StudentException students[]) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < (students.length - 1 - i); j++) {
                if (students[j].name.compareTo(students[j + 1].name) > 0) {
                    StudentException temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < students.length; i++) {
            students[i].displayInfo();
        }
    }

    void displayInfo() {
        System.out.println("----------");
        System.out.println("Name: " + name);
        System.out.println("Registration number: " + regno);
        System.out.println("Phone: " + phone);
        System.out.println("----------");
    }

    public static void main(String[] args) throws NullPointerException {
        Scanner input = new Scanner(System.in);
        System.out.println();
        try {
            StudentException students[] = new StudentException[3];

            System.out.println();
            for (int i = 0; i < students.length; i++) {
                students[i] = new StudentException(); // Line (*)
                students[i].getInfo(input);
            }

            StudentException.sortObj(students);
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}