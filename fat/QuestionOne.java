package fat;

import java.util.*;

public class QuestionOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        char reply = 'y';
        try {
            ArrayList<Semester> semesters = new ArrayList<>();
            while (reply == 'y') {
                System.out.println("Menu:");
                System.out.println("1. Register a new Semester");
                System.out.println("2. All projects by a student");
                System.out.println("3. Students part of a project");
                System.out.println("4. Projects made by a student in one semester");
                System.out.println("\nEnter your choice: ");

                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter sem id and name");
                        String id = sc.nextLine();
                        String semesterName = sc.nextLine();
                        Semester s = new Semester(id, semesterName, sc);
                        semesters.add(s);
                        break;

                    case 2:
                        System.out.println("Enter student name:");
                        String studentName = sc.nextLine();
                        Student student = null;
                        for (int i = 0; i < semesters.size(); i++) {
                            student = semesters.get(i).searchStudent(studentName);
                            if (student != null) {
                                student.listProjects("");
                                break;
                            }
                        }

                        if (student == null) {
                            System.out.println("No such student");
                        }

                        break;

                    case 3:
                        System.out.println("Enter project name");
                        String projectName = sc.nextLine();
                        Project p = Project.search(projectName);
                        if (p) {
                            p.listStudents();
                        } else {
                            System.out.println("Project not found");
                        }
                        break;

                    case 4:
                        System.out.println("Enter student name:");
                        String studentName = sc.nextLine();
                        Student s = Student.search(studentName);
                        if (s) {
                            System.out.println("Enter semester name");
                            String semName = sc.nextLine();
                            Semester sem = Semester.search(semName);
                            if (sem) {
                                s.listProjects(semName);
                            } else {
                                System.out.println("No such semester");
                            }
                        } else {
                            System.out.println("No such student");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }

                System.out.println("Would you like to continue (Enter y for yes)");
                reply = sc.nextLine().charAt(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}

class Student {
    public String name;
    private String regno;
    private String address;
    private String phone;

    private ArrayList<Project> projects = new ArrayList<>();

    Student(String name, String regno, String address, String phone, Scanner sc) {
        int numProjects;
        System.out.println("Enter number of projects in this sem for this student: ");
        numProjects = Integer.parseInt(sc.nextLine());

        System.out.println(
                "Enter project name, description, title for all projects to be done by this student in this semester:");

        for (int i = 0; i < numProjects; i++) {
            String projectName = sc.nextLine();
            String desc = sc.nextLine();
            String title = sc.nextLine();

            Project p = new Project(projectName, desc, title, this.name);
            projects.add(p);
        }

        this.name = name;
        this.regno = regno;
        this.address = address;
        this.phone = phone;
    }

    public void listProjects(String semName) {
        if (semName.length() == 0) {
            for (int i = 0; i < projects.size(); i++) {
                projects.get(i).display();
            }
        }
    }
}

class Project {
    public String pname;
    private String pdesc;
    private String ptitle;

    private ArrayList<String> studentNames = new ArrayList<>();

    Project(String name, String desc, String title, String studentName) {
        this.pname = name;
        this.pdesc = desc;
        this.ptitle = title;
        this.studentNames.add(studentName);
    }

    public void display() {
        System.out.println("Project Name: " + this.pname);
        System.out.println("Project Description: " + this.pdesc);
        System.out.println("Project Title: " + this.ptitle);
    }
}

class Semester {
    private String id;
    private String name;

    private ArrayList<Student> students = new ArrayList<>();

    Semester(String id, String name, Scanner sc) {
        int numStudents;
        System.out.println("Enter number of students in this sem: ");
        numStudents = Integer.parseInt(sc.nextLine());

        System.out.println("Enter name, regno, address, phone of all students in this semester:");

        for (int i = 0; i < numStudents; i++) {
            String studentName = sc.nextLine();
            String regno = sc.nextLine();
            String address = sc.nextLine();
            String phone = sc.nextLine();

            Student s = new Student(studentName, regno, address, phone, sc);
            students.add(s);
        }

        this.id = id;
        this.name = name;
    }

    public Student searchStudent(String sname) {
        Student s = null;

        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).name.equals(sname)) {
                return this.students.get(i);
            }
        }

        return s;
    }
}