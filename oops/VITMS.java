package oops;

class Student {
    String name;
    String regno;

    Student(String name, String regno) {
        this.name = name;
        this.regno = regno;
    }

    public void display() {
        System.out.println(name + " " + regno);
    }
}

class Faculty {
    String name;
    String empid;

    Faculty(String name, String empid) {
        this.name = name;
        this.empid = empid;
    }

    public void display() {
        System.out.println(name + " " + empid);
    }
}

class Hostel {
    String blockName;
    char blockLabel;
    int studentCount;
    char type;

    Hostel(String name, char label, int count, char type) {
        blockName = name;
        blockLabel = label;
        studentCount = count;
        this.type = type;
    }

    public void display() {
        System.out.println(blockName + " (" + blockLabel + ") " + studentCount + " " + type + " students");
    }
}

class Building {
    String name;
    String offices[];

    Building(String name, String schools[]) {
        this.name = name;
        offices = new String[schools.length];

        for (int i = 0; i < schools.length; i++) {
            offices[i] = schools[i];
        }
    }

    public void display() {
        System.out.println(name + " has " + String.join(", ", offices) + " offices");
    }
}

class Mess {
    String name;
    String blocks[];
    boolean isSpecial;

    Mess(String name, String blocks[], boolean isSpecial) {
        this.name = name;
        this.isSpecial = isSpecial;
        this.blocks = new String[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            this.blocks[i] = blocks[i];
        }
    }

    public void display() {
        System.out.println(name + " " + String.join(", ", blocks) + " " + "Special Mess? " + isSpecial);
    }
}

class GPA {
    double gpas[];
    boolean isExemptedFromAttendance = false;
    double cgpa;

    GPA(double points[]) {
        gpas = new double[points.length];

        for (int i = 0; i < points.length; i++) {
            gpas[i] = points[i];
        }

        compute_cgpa();
    }

    public void compute_cgpa() {
        double ans = 0;

        for (int i = 0; i < gpas.length; i++) {
            ans += gpas[i];
        }

        ans /= gpas.length;

        cgpa = ans;

        if (cgpa >= 9) {
            isExemptedFromAttendance = true;
        }
    }

    public void display() {
        System.out.println("CGPA: " + cgpa);
        System.out.println("Can Bunk Classes? " + isExemptedFromAttendance);
    }
}

class PAT {
    int noOfCompanies;
    double avgPackage;

    PAT(int count, double amount) {
        noOfCompanies = count;
        avgPackage = amount;
    }

    public void display() {
        System.out.println("Maximum companies visited so far: " + noOfCompanies);
        System.out.println("Average CTC: " + avgPackage);
    }
}

class SoftSkills {
    String vendorName;
    String vendorEmail;

    SoftSkills(String name, String email) {
        vendorEmail = email;
        vendorName = name;
    }

    public void display() {
        System.out.println(vendorName + " " + vendorEmail);
    }
}

class VITCourse {
    String name;
    String code;
    String offeredBy;

    VITCourse(String name, String code, String school) {
        this.name = name;
        this.code = code;
        offeredBy = school;
    }

    public void display() {
        System.out.println(name + " (" + code + ") " + "School: " + offeredBy);
    }
}

class Programme {
    String name;
    int duration;

    Programme(String name, int years) {
        this.name = name;
        duration = years;
    }

    public void display() {
        System.out.println(name + ", " + duration + " years");
    }
}

public class VITMS {
    public static void main(String[] args) {
        System.out.println();
        new Student("Ritwik Neema", "18BCE2166").display();
        new Faculty("XYZ", "12345").display();
        new Hostel("Dr. Sarvepalli Radharkrishnan Block", 'K', 900, 'M').display();
        new Building("Silver Jubilee Tower", new String[] {"SCOPE", "SITE"}).display();
        new Mess("Darling", new String[] {"M", "N", "P"}, true).display();
        new GPA(new double[] {9.23, 8.9, 8.5, 9.44, 8.87}).display();
        new PAT(855, 650000).display();
        new SoftSkills("SMART", "contact@smart.com").display();
        new VITCourse("Java Programming", "CSE1007", "SCOPE").display();
        new Programme("Bachelor of Technology", 4).display();
        System.out.println();
    }
}