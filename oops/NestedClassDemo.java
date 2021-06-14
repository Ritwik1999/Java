package oops;

public class NestedClassDemo {
    public static void main(String[] args) {
        // create object for outer class
        outer outobj = new outer();
        // creating an object for the nested class using the outer class object
        outer.nested nestedobj = outobj.new nested();
        nestedobj.display();
    }
}

class outer {

    public String var1;
    private String var2;
    protected String var3;
    public static int count = 1;

    public outer() {
        var1 = "test1";
        var2 = "test2";
        var3 = "test3";
    }

    public class nested {

        // Since nested class is associated with an object of outer class, nested
        // (non-static) classes cannot have static members
        // A non-static nested class is also known as inner class
        public String nestedvar;

        public nested() {
            nestedvar = "nestedvalue";
        }

        public void display() {
            System.out.println(var1 + var2 + var3 + nestedvar + " " + count);
        }
    }

    // outer class cannot access any data members of nested class, no matter what.
}
