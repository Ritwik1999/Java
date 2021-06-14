package oops;

import java.util.Scanner;

public class FacultyDegree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter faculty name, their id, and number of degrees:");
        String name = input.nextLine();
        String id = input.nextLine();
        int n = Integer.parseInt(input.nextLine());

        Faculty f1 = new Faculty(name, id);

        f1.display_faculty_data();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter degree name, awarded year, and by which university:");
            String dname = input.nextLine();
            String dyear = input.nextLine();
            String duni = input.nextLine();

            f1.new Degree(dname, dyear, duni).display_degree_details();
        }

        input.close();
    }
}

class Faculty {
    private String name;
    private String empid;

    public Faculty(String name, String empid) {
        this.name = name;
        this.empid = empid;
    }

    public void display_faculty_data() {
        System.out.println("\n----------------------");
        System.out.println("Faculty name: " + name + "\nFaculty id: " + empid);
        System.out.println("----------------------\n");
    }

    public class Degree {
        String degree_name;
        String awarded_year;
        String awarded_by_university;

        public Degree(String name, String year, String uni) {
            degree_name = name;
            awarded_year = year;
            awarded_by_university = uni;
        }

        public void display_degree_details() {
            System.out.println("\n----------------------");
            System.out.println(degree_name + " " + awarded_year + " " + awarded_by_university);
            System.out.println("----------------------\n");
        }
    }
}
