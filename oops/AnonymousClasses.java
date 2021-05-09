package oops;

public class AnonymousClasses {
    public static void main(String[] args) {
        // The line below does not create an object of type employee (as abstract
        // classes cannot be instantiated), rather creates an object of an anonymous
        // class. Also note the braces are after new employee(), and not like Runnable
        // i.e., like new employee({...})
        // Since this class is nested within the AnonClasses, it can also be called an
        // anonynous inner/nested class

        employee e = new employee() {
            @Override
            public void display() {
                System.out.println("I am the professor");
            }
        };

        e.display();
    }
}

abstract class employee {
    public abstract void display();
}

// class professor extends employee {
// @Override
// public void display() {
// System.out.println("I am the professor");
// }
// }