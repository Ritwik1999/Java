/*
    > Interface contain only abstract methods. the methods are abstract and public by default.
    > Interface cannot be instantiated
    > Interface cannot have constructors
    > Interface can contain only static and final variables that are public
    > A class should implement all the methods in an interface
    > A class can implement many interfaces
    > An interface can inherit multiple other interfaces

    If a class implements an interface, this class has a realization relationship to the interface

    // todo: final keyword explanation
*/

package interfaces;

public class interfaceintro {
    public static void main(String[] args) {
        ReserveButton rb = new ReserveButton();
        CancellationButton cb = new CancellationButton();

        rb.onClick();
        cb.onClick();
    }
}

interface Button {
    void setButtonColor();

    void setButtonText();

    void onClick();

    // Say the method below is defined after deploying the system.
    // The problem is that now all classes that implement this interface have to be
    // changed
    // Solution: Use default keyword to be able to define a method body
    // It is not mandatory to override a default method, but it can be done
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

    }

    @Override
    public void location(int x, int y, int z) {

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

    }

    @Override
    public void location(int x, int y, int z) {

    }
}