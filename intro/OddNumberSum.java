package intro;

import java.util.Scanner;

public class OddNumberSum {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        int oddsum = 0;
        
        for (int i = 0; i < 5; i++)
        {
            n = sc.nextInt();
            if (n % 2 == 0)
            {
                continue;
            }

            oddsum += n;
        }

        System.out.println("The sum is: " + oddsum);

        sc.close();
    }
}
