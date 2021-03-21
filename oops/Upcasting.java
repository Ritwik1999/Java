package oops;

import java.lang.Math;

abstract class Shape {
    abstract void compute_volume();
}

class Sphere extends Shape {
    double radius;

    Sphere(double r) {
        radius = r;
    }

    @Override
    void compute_volume() {
        double volume = (4 / 3) * (Math.PI) * Math.pow(radius, 3);
        System.out.println("Volume of sphere is: " + volume);
    }
}

class Cylinder extends Shape {
    double radius;
    double height;

    Cylinder(double r, double h) {
        radius = r;
        height = h;
    }

    @Override
    void compute_volume() {
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("Volume of cylinder is: " + volume);
    }
}

class Cone extends Shape {
    double radius;
    double height;

    Cone(double r, double h) {
        radius = r;
        height = h;
    }

    @Override
    void compute_volume() {
        double volume = Math.PI * Math.pow(radius, 2) * height;
        volume /= 3;
        System.out.println("Volume of cone is: " + volume);
    }
}

class Cube extends Shape {
    double side;

    Cube(double a) {
        side = a;
    }

    @Override
    void compute_volume() {
        double volume = Math.pow(side, 3);
        System.out.println("Volume of cube is: " + volume);
    }
}

public class Upcasting {
    public static void main(String[] args) {
        Shape shapes[] = new Shape[4];

        shapes[0] = new Sphere(7);
        shapes[1] = new Cylinder(7, 21);
        shapes[2] = new Cone(4, 7);
        shapes[3] = new Cube(5);

        System.out.println();
        for (int i = 0; i < shapes.length; i++)
        {
            shapes[i].compute_volume();
        }
        System.out.println();
    }
}