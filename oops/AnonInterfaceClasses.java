package oops;

public class AnonInterfaceClasses {
    public static void main(String[] args) {
        emp e = new emp() {
            @Override
            public void display() {
                System.out.println("I am the professor");
            }
        };

        e.display();
    }
}

interface emp {
    void display();
}

// class prof implements emp {
// @Override
// public void display() {
// System.out.println("I am the professor");
// }
// }
