import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        System.out.print("Sum of digits of " + n + " is: ");
        int sum = 0, digit;

        while (n > 0) {
            digit = n % 10;
            sum += digit;
            n = n / 10;
        }

        System.out.println(sum);

        sc.close();
    }
}
