/*
    > Interface contain only abstract methods. the methods are abstract and public by default.
    > Interface cannot be instantiated
    > Interface cannot have constructors
    > Interface can contain only static and final variables that are public
    > A class should implement all the methods in an interface
    > A class can implement many interfaces
    > An interface can inherit multiple other interfaces

    If a class implements an interface, this class has a realization relationship to the interface

*/

package interfaces;

public class interfaceintro {
    public static void main(String[] args) {
        ReserveButton rb = new ReserveButton();
        CancellationButton cb = new CancellationButton();

        rb.onClick();
        rb.display();

        cb.onClick();
        cb.display();

    }
}

interface Button {
    void setButtonColor();

    void setButtonText();

    void onClick();

    /*
     * In a typical design based on abstractions, where an interface has one or
     * multiple implementations, if one or more methods are added to the interface,
     * all the implementations will be forced to implement them too. Otherwise, the
     * design will just break down.
     * 
     * Default interface methods are an efficient way to deal with this issue. They
     * allow us to add new methods to an interface that are automatically available
     * in the implementations. Thus, there's no need to modify the implementing
     * classes.
     * 
     * It is not mandatory to override a default method, but it can be done
     */
    default void testmethod() {
        System.out.println("This is from test method");
    }
}

interface ThreeDButton extends Button {
    void location(int x, int y, int z);
}

interface TwoDButton extends Button {
    void location(int x, int y);
}

class ReserveButton implements TwoDButton, ThreeDButton {
    String color;
    String text;

    @Override
    public void setButtonColor() {
        color = "Blue";
    }

    @Override
    public void setButtonText() {
        text = "Reserve Ticket";
    }

    @Override
    public void onClick() {
        System.out.println("Ticket Reservation Successful");
        // How to invoke the default method?
        TwoDButton.super.testmethod(); // or ThreeDButton.super.testmethod(), or both;
    }

    @Override
    public void location(int x, int y) {
        System.out.println("2D Location: (" + x + ", " + y + ")");
    }

    @Override
    public void location(int x, int y, int z) {
        System.out.println("3D Location: (" + x + ", " + y + ", " + z + ")");
    }

    public void display() {
        setButtonColor();
        setButtonText();
        System.out.println("Button Color: " + color);
        System.out.println("Button Text: " + text);
        location(23, 34);
        location(1, 2, 3);
    }
}

class CancellationButton implements TwoDButton, ThreeDButton {
    String color;
    String text;

    @Override
    public void setButtonColor() {
        color = "Red";
    }

    @Override
    public void setButtonText() {
        text = "Cancel Ticket";
    }

    @Override
    public void onClick() {
        System.out.println("Ticket Cancellation Successful");
        // How to invoke the default method?
        ThreeDButton.super.testmethod(); // or TwoDButton.super.testmethod(), or both;
    }

    @Override
    public void location(int x, int y) {
        System.out.println("2D Location: (" + x + ", " + y + ")");
    }

    @Override
    public void location(int x, int y, int z) {
        System.out.println("3D Location: (" + x + ", " + y + ", " + z + ")");
    }

    public void display() {
        setButtonColor();
        setButtonText();
        System.out.println("Button Color: " + color);
        System.out.println("Button Text: " + text);
        location(123, 134);
        location(221, 222, 223);
    }
}