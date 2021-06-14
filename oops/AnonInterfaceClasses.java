package oops;

public class AnonInterfaceClasses {
    public static void main(String[] args) {
        emp e = new emp() {
            @Override
            public void display() {
                System.out.println("I am the professor");
            }

            @Override
            public void sample() {
                System.out.println("I am a sample/test method");
            }
        };

        e.display();
        e.sample();
    }
}

interface emp {
    void display();
    void sample();
}

// class prof implements emp {
// @Override
// public void display() {
// System.out.println("I am the professor");
// }
// }
