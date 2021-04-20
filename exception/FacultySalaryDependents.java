package exception;

import java.util.Scanner;

public class FacultySalaryDependents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Faculty f1 = new Faculty("123", "Professor", "Harley", "667", "31-10-1940"); // Line (*)
            Faculty f2 = new Faculty("456", "Associate Professor", "Sheldon", "9823758374", "23-02-1945");
            Faculty f3 = new Faculty("789", "Assistant Professor", "Leonard", "9784781723", "19-09-1950");
            Faculty f4 = new Faculty("101", "TRA", "", "", "");

            System.out.print("\nEnter faculty id: ");
            String id = input.nextLine();

            if (f1.getID().equals(id)) {
                f1.display();
            } else if (f2.getID().equals(id)) {
                f2.display();
            } else if (f3.getID().equals(id)) {
                f3.display();
            } else if (f4.getID().equals(id)) {
                f4.display();
            } else {
                System.out.println("Invalid id");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}

class Dependent {
    String dName;
    String dPhone;
    String dDOB;

    Dependent(String name, String phone, String dob) throws PhoneFormatException {
        if (phone.length() != 10) {
            throw new PhoneFormatException("Mobile number must be 10 digits");
        }
        dName = name;
        dPhone = phone;
        dDOB = dob;
    }

    public void display() {
        System.out.println("Name: " + dName);
        System.out.println("Phone: " + dPhone);
        System.out.println("DOB: " + dDOB);
    }
}

class Faculty {
    String id;
    float sal;
    String des;
    Dependent d;

    Faculty(String id, String des, String dname, String dphone, String dDOB) throws PhoneFormatException {
        this.id = id;
        this.des = des;
        this.sal = this.calc_sal();
        if (this.des.equals("TRA")) {
            d = null;
        } else {
            d = new Dependent(dname, dphone, dDOB);
        }
    }

    public String getID() {
        return id;
    }

    public void display() {
        System.out.println("Salary: Rs. " + sal);
        if (d == null) {
            return;
        }
        System.out.println("Dependent details: ");
        d.display();
    }

    public float calc_sal() throws ArithmeticException {
        float ans = 0;
        if (this.des.equals("Professor")) {
            ans = 150000;
            ans += 0.3 * ans;
        } else if (this.des.equals("Associate Professor")) {
            ans = 120000;
            ans += 0.2 * ans;
        } else if (this.des.equals("Assistant Professor")) {
            ans = 100000;
            ans += 0.1 * ans;
        } else if (this.des.equals("TRA")) {
            ans = 20000;
        }

        return ans;
    }
}

class PhoneFormatException extends Exception {
    private static final long serialVersionUID = 1L;

    PhoneFormatException(String s) {
        super(s);
    }
}