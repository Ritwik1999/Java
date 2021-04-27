package classexercises.aprilextwosix;

import java.util.*;
import java.io.*;

public class Course {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String id;
        String name;
        String by;
        String slot;

        File obj = new File("course.txt");
        FileOutputStream fout = new FileOutputStream(obj);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        Course2 courses[] = new Course2[4];
        for (int i = 0; i < courses.length; i++) {
            System.out.println("------------------------------------------\nEnter details: ");
            id = input.nextLine();
            name = input.nextLine();
            by = input.nextLine();
            slot = input.nextLine();

            courses[i] = new Course2(id, name, by, slot);
            objout.writeObject(courses[i]);
        }
        input.close();
        objout.writeObject(new endoffile2());
        objout.close();

        FileInputStream fin = new FileInputStream(obj);
        ObjectInputStream objin = new ObjectInputStream(fin);

        Object myobj = null;
        int count = 0;
        System.out.println("------------------------------------------");
        while (true) {
            myobj = objin.readObject();

            if (myobj instanceof endoffile2) {
                break;
            } else {
                Course2 course = (Course2) myobj;

                if (course.courseOfferedBy.equals("SCOPE") && course.courseName.equals("Java Programming") && course.courseSlot.equals("C1")) {
                    count += 1;
                    course.display();
                }
            }
        }

        objin.close();

        if (count == 0) {
            System.out.println("No Such Courses Match the Criteria");
        }
    }
}

class Course2 implements Serializable {
    String courseID;
    String courseName;
    String courseOfferedBy;
    String courseSlot;

    Course2 (String id, String name, String by, String slot) {
        courseID = id;
        courseName = name;
        courseOfferedBy = by;
        courseSlot = slot;
    }

    public void display() {
        System.out.println(courseID + "\n" + courseName + "\n" + courseOfferedBy + "\n" + courseSlot);
    }
}

class endoffile2 implements Serializable {

}