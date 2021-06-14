/*
Code a java program such that it outputs the area of a parallelogram with breadth B and height H. You should read the variables from the standard input.

If B <= 0 or H <= 0, the output should be "java.lang.Exception: Breadth and height must be positive" without quotes.
*/

package oops;

import java.util.*;

public class StaticInit {
    static int B;
    static int H;
    static boolean flag;

    static {
        System.out.println("In static init block");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter breadth and height of parallelogram:");
        B = sc.nextInt();
        H = sc.nextInt();
        flag = true;
        if (B <= 0 || H <= 0) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        sc.close();
    }

    public static void main(String[] args) {
        System.out.println("In main method");
        if (flag) {
            int area = B * H;
            System.out.println("Area of parallelogram = " + area);
        }
    }
}
