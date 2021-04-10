package exception;

import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Shape {
    abstract void compute_area() throws ArithmeticException;
}

abstract class TwoDimensionalShape extends Shape {
    abstract void getLocation(int x, int y);
}

abstract class ThreeDimensionalShape extends Shape {
    abstract void getLocation(int x, int y, int z);
}

class Circle extends TwoDimensionalShape {
    double radius;

    Circle(Scanner input) throws InputMismatchException {
        System.out.print("Enter the radius of circle: ");
        radius = input.nextDouble();
    }

    @Override
    void compute_area() {
        double ans = Math.PI * radius * radius;
        System.out.println("Area of circle is: " + ans + " sq. units");
    }

    @Override
    void getLocation(int x, int y) {
        System.out.println("Circle's centre is at: " + "(" + x + ", " + y + ")");
    }
}

class Square extends TwoDimensionalShape {
    double side;

    Square(Scanner input) throws InputMismatchException {
        System.out.print("Enter the side of sqaure: ");
        side = input.nextDouble();
    }

    @Override
    void compute_area() {
        double ans = side * side;
        System.out.println("Area of square is: " + ans + " sq. units");
    }

    @Override
    void getLocation(int x, int y) {
        System.out.println("Square's centre is at: " + "(" + x + ", " + y + ")");
    }
}

class Cube extends ThreeDimensionalShape {
    double side;

    Cube(Scanner input) throws InputMismatchException {
        System.out.print("Enter the side of cube: ");
        side = input.nextDouble();
    }

    @Override
    void compute_area() {
        double ans = 6 * side * side;
        System.out.println("Surface area of cube is: " + ans + " sq. units");
    }

    @Override
    void getLocation(int x, int y, int z) {
        System.out.println("Cube's centre is at: " + "(" + x + ", " + y + ", " + z + ")");
    }
}

class Sphere extends ThreeDimensionalShape {
    double radius;

    Sphere(Scanner input) throws InputMismatchException {
        System.out.print("Enter the radius of sphere: ");
        radius = input.nextDouble();
    }

    @Override
    void compute_area() {
        double ans = 4 * Math.PI * radius;
        System.out.println("Surface area of sphere is: " + ans + " sq. units");
    }

    @Override
    void getLocation(int x, int y, int z) {
        System.out.println("Sphere's centre is at: " + "(" + x + ", " + y + ", " + z + ")");
    }
}

public class ShapesException {
    public static void main(String[] args) throws NullPointerException, IndexOutOfBoundsException {
        Scanner input = new Scanner(System.in);
        Shape shapes[] = new Shape[4];
        System.out.println();

        try {
            shapes[0] = new Circle(input);
            shapes[1] = new Square(input);
            shapes[2] = new Cube(input);
            shapes[3] = new Sphere(input);

            for (int i = 0; i < shapes.length; i++) {
                shapes[i].compute_area();
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