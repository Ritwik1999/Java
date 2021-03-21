package oops;

import java.util.Scanner;

public class Course {
    String name;
    String id;
    String type;
    String offeredBy;

    public void set_courseDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter course name, id, type, offered by: ");
        name = input.nextLine();
        id = input.nextLine();
        type = input.nextLine();
        offeredBy = input.nextLine();
    }

    public static void search_courseDetails(Course c[]) {
        int ue_count = 0, pe_count = 0, pc_count = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i].type.equals("UE")) {
                ue_count++;
            }

            else if (c[i].type.equals("PE")) {
                pe_count++;
            }

            else {
                pc_count++;
            }
        }

        Course.display_courseDetails(ue_count, pe_count, pc_count);
    }

    public static void display_courseDetails(int ue, int pe, int pc) {
        System.out.println("UE count: " + ue);
        System.out.println("PE count: " + pe);
        System.out.println("PC count: " + pc);
    }

    public static void main(String[] args) {
        Course courses[] = new Course[5];

        for (int i = 0; i < courses.length; i++) {
            courses[i] = new Course();
        }

        for (int i = 0; i < courses.length; i++) {
            courses[i].set_courseDetails();
        }

        Course.search_courseDetails(courses);
    }
}
