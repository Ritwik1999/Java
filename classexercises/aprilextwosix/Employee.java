package classexercises.aprilextwosix;

import java.util.*;

public class Employee {

    int id;
    String name;
    int age;
    String designation;
    int yearsOfExperience;
    String department;
    int salary;

    Employee(int id, String name, int age, String designation, int xp, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.yearsOfExperience = xp;
        this.department = dept;
        this.salary = salary;
    }

    void display() {
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        System.out.println(designation);
        System.out.println(yearsOfExperience);
        System.out.println(department);
        System.out.println(salary);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Employee employees[] = new Employee[3];

            int id;
            String name;
            int age;
            String designation;
            int yearsOfExperience;
            String department;
            int salary;

            System.out.println();

            for (int i = 0; i < employees.length; i++) {

                System.out.println("------------------------\nEnter details:");

                id = Integer.parseInt(input.nextLine());
                name = input.nextLine();
                age = Integer.parseInt(input.nextLine());
                designation = input.nextLine();
                yearsOfExperience = Integer.parseInt(input.nextLine());
                department = input.nextLine();
                salary = Integer.parseInt(input.nextLine());

                if (yearsOfExperience > 20 || yearsOfExperience < 5) {
                    throw new ExperienceException("Experience does not Match");
                }

                if (salary > 500000 || salary < 5000) {
                    throw new SalaryException("Salary does not fall within the range");
                }

                if (age > 60 || age < 25) {
                    throw new AgeException("Age not in the range");
                }

                employees[i] = new Employee(id, name, age, designation, yearsOfExperience, department, salary);
            }

            System.out.println("------------------------\nDone");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
            System.out.println("Thanks for using our Software");
        }
    }
}

class ExperienceException extends Exception {
    ExperienceException(String S) {
        super(S);
    }
}

class SalaryException extends Exception {
    SalaryException(String S) {
        super(S);
    }
}

class AgeException extends Exception {
    AgeException(String S) {
        super(S);
    }
}