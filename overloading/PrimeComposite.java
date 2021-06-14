package overloading;

import java.util.Scanner;

public class PrimeComposite {
    public static void main(String[] args) {
        System.out.println("Length is: " + args.length);
        main();
    }

    public static void main() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the size of array: ");
        int n = input.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int primeCount = 0;
        int compositeCount = 0;

        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i]))
                primeCount++;

            else
                compositeCount++;
        }

        System.out.println("There are " + primeCount + " prime numbers and " + compositeCount
                + " composite numbers in the given array");

        input.close();
    }

    public static boolean isPrime(int num) {
        boolean res = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
