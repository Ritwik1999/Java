package oops;

import java.util.Scanner;

public class FacultyLeave {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FacultyTwo faculties[] = new FacultyTwo[3];

        System.out.println("\nEnter names and ids for " + faculties.length + " faculties:");

        for (int i = 0; i < faculties.length; i++) {
            String name = input.nextLine();
            String id = input.nextLine();

            faculties[i] = new FacultyTwo(name, id);
        }

        for (int i = 0; i < faculties.length; i++) {
            System.out.println("--------------------------");
            faculties[i].display_faculty_details();
            FacultyTwo.Leave.leave_categories();
        }

        input.close();
    }
}

class FacultyTwo {
    String name;
    String empid;

    public FacultyTwo(String name, String empid) {
        this.name = name;
        this.empid = empid;
    }

    public void display_faculty_details() {
        System.out.println("Faculty name: " + name + "\nID: " + empid);
    }

    public static class Leave {
        public static int el = 12;
        public static int ml = 20;
        public static int cl = 10;

        public static void leave_categories() {
            System.out.println("Categories: EL=" + el + "; ML=" + ml + "; CL=" + cl);
        }
    }
}
