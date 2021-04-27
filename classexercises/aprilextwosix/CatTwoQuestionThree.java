package classexercises.aprilextwosix;

import java.util.*;
import java.io.*;

public class CatTwoQuestionThree {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String name;
        String email;
        String regno;
        String address;

        File obj = new File("student.txt");
        FileOutputStream fout = new FileOutputStream(obj);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        Student students[] = new Student[3];
        for (int i = 0; i < students.length; i++) {
            System.out.println("------------------------------------------\nEnter details: ");
            name = input.nextLine();
            regno = input.nextLine();
            email = input.nextLine();
            address = input.nextLine();

            students[i] = new Student(name, regno, email, address);
            objout.writeObject(students[i]);
        }
        input.close();
        objout.writeObject(new endoffile());
        objout.close();

        FileInputStream fin = new FileInputStream(obj);
        ObjectInputStream objin = new ObjectInputStream(fin);

        Object myobj = null;
        int count = 0;
        System.out.println("------------------------------------------");
        while (true) {
            myobj = objin.readObject();

            if (myobj instanceof endoffile) {
                break;
            } else {
                Student stud = (Student) myobj;

                if (stud.regno.contains("BCE") && stud.address.equals("vellore")) {
                    count += 1;
                    stud.display();
                }
            }
        }

        objin.close();

        if (count == 0) {
            System.out.println("No Such Students Match the Criteria");
        }
    }
}

class Student implements Serializable {
    String name;
    String regno;
    String emailid;
    String address;

    Student(String n, String r, String e, String a) {
        name = n;
        regno = r;
        emailid = e;
        address = a;
    }

    public void display() {
        System.out.println(name + "\n" + regno + "\n" + emailid + "\n" + address);
    }
}

class endoffile implements Serializable {

}