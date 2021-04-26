package classexercises.aprilextwosix;

import java.util.*;
import java.io.*;

public class Project implements Serializable {

    String name;
    String id;
    int budget;
    String location;

    Project(String name, String id, int budget, String location) {
        this.name = name;
        this.id = id;
        this.budget = budget;
        this.location = location;
    }

    void display() {
        System.out.println(name + ", " + id + ", " + budget + ", " + location);
    }

    public static void main(String[] args) throws Exception {
        int choice;
        Scanner input = new Scanner(System.in);
        File obj = new File("project.txt");
        FileOutputStream fout = new FileOutputStream(obj);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        FileInputStream fin = new FileInputStream(obj);
        ObjectInputStream objin = new ObjectInputStream(fin);

        String name;
        String id;
        int budget;
        String location;
        int projectCount = 0;

        do {
            int option;
            System.out.print("Enter 1 to add project, and 2 to view all projects: ");
            option = Integer.parseInt(input.nextLine());
            switch (option) {
            case 1:
                System.out.println("Enter project details:");
                name = input.nextLine();
                id = input.nextLine();
                budget = Integer.parseInt(input.nextLine());
                location = input.nextLine();

                Project p = new Project(name, id, budget, location);
                objout.writeObject(p);
                projectCount++;
                break;

            case 2:
                System.out.println("-------------------------------------------");
                for (int i = 0; i < projectCount; i++) {
                    Project p1 = (Project) (objin.readObject());
                    p1.display();
                }
                System.out.println("-------------------------------------------");
                break;

            default:
                System.out.println("Bad input");
                break;
            }
            System.out.println("Enter 1 if you want to continue: ");
            choice = Integer.parseInt(input.nextLine());
        } while (choice == 1);

        input.close();
        objout.close();
        objin.close();
    }
}