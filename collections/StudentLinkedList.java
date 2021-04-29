package collections;

import java.util.*;

public class StudentLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter number of students: ");
        int n = Integer.parseInt(input.nextLine());
        String name;
        String regno;
        String school;

        LinkedList<Student> ll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of student " + (i+1));
            name = input.nextLine();
            regno = input.nextLine();
            school = input.nextLine();

            Student s = new Student(name, regno, school);
            ll.add(s);
        }

        System.out.println("------------------------------------\nDetails of SCOPE students");

        ListIterator<Student> litr = ll.listIterator();
        while(litr.hasNext()) {
            Student s1 = (Student) litr.next();
            if (s1.school.equals("SCOPE")) {
                s1.display();
            }
        }

        input.close();
    }
}

class Student {
    String name;
    String regno;
    String school;

    Student(String name, String regno, String school) {
        this.name = name;
        this.regno = regno;
        this.school = school;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Regno: " + regno);
        System.out.println("School: " + school);
    }
}
