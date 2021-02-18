package intro;

import java.util.Scanner;

public class OddEvenPrime {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        int count_odd = 0, count_even = 0, count_prime = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit % 2 == 0) {
                count_even += 1;
            }

            else {
                count_odd += 1;
            }

            if (digit == 2 || digit == 3 || digit == 5 || digit == 7)
            {
                count_prime += 1;
            }

            n = n/10;
        }

        System.out.println("The number of even digits is " + count_even);
        System.out.println("The number of odd digits is " + count_odd);
        System.out.println("The number of prime digits is " + count_prime);

        sc.close();
    }
}
