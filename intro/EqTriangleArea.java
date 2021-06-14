package intro;

import java.util.Scanner;
import java.lang.Math;

public class EqTriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side of triangle: ");

        double side = input.nextDouble();
        double area = (Math.sqrt(3) / 4) * side * side;

        System.out.println("The area is: " + area + " square units");

        input.close();
    }
}
