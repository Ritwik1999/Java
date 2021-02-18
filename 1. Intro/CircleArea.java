import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        float radius;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = sc.nextFloat();

        float area = ((22/7)*radius*radius);

        System.out.println("The area is: " + area + " square units");

        sc.close();
    }
}
