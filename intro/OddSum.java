package intro;

import java.util.Scanner;

public class OddSum {

    static int revNum(int num) {
        int n = 0;
        while (num > 0) {
            n = (n * 10) + (num % 10);
            num = num / 10;
        }

        return n;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        int sumRevSum = n + revNum(n);
        System.out.println(sumRevSum);

        if (sumRevSum % 2 != 0) {
            System.out.println("Odd sum");
        }

        else {
            System.out.println("No odd sum");
        }

        sc.close();
    }
}
