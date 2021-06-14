package intro;

import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        boolean lucky = false;

        for (int i = 0; i < 5; i++) {
            n = sc.nextInt();
            if (n == 13) {
                System.out.println("Lucky winner");
                lucky = true;
                break;
            }
        }

        if (!lucky) {
            System.out.println("You are unlucky");
        }

        sc.close();
    }
}
