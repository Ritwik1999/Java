package demo;

public class StaticNestedClassDemo {
    public static void main(String[] args) {

        // static method in static nested class, nested class object not needed
        faculty.eligible_leave.display_leavedetails();

        // non static method in static nested class, nested class object required
        faculty.eligible_leave obj1 = new faculty.eligible_leave();
        obj1.display_var();
    }
}

class faculty {
    private String name;
    private String empid;
    private static int count = 1;

    public faculty(String name, String empid) {
        this.name = name;
        this.empid = empid;
    }

    public void display_facultydetails() {
        System.out.println(name + empid);
    }

    // the info stored in below class is common for all faculties, hence declared
    // static (called static nested class)
    // No instance of faculty required to access this class
    public static class eligible_leave {
        public static int el = 12;
        public static int ml = 20;
        public static int cl = 10;
        public int var1;

        public eligible_leave() {
            var1 = 1;
        }

        public void display_var() {
            System.out.println(var1);
        }

        public static void display_leavedetails() {
            System.out.println("The number of EL is: " + el);
            System.out.println("The number of ML is: " + ml);
            System.out.println("The number of CL is: " + cl);
            // System.out.println(name); // Cannot access non static member of enclosing
            // class
            System.out.println(count);
        }

        public void test_method() {
            // Cannot access non static member of enclosing class
            // System.out.println(name);
        }
    }
}